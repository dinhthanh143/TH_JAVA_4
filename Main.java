import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ProductRepository pr = new ProductRepository();

        pr.add(new ElectronicProduct("001", "Tu lanh", 3400000, 8));
        pr.add(new ElectronicProduct("002", "Dieu hoa", 6700000, 16));
        pr.add(new FoodProduct("003", "Coca", 10000, 2));
        pr.add(new FoodProduct("004", "Pepsi", 12000, 3));
        pr.add(new FoodProduct("005", "Dr Pepper", 3000, 4));
        pr.add(new FoodProduct("006", "Wagyu", 600000, 10));

        System.out.println("DANH SACH SAN PHAM:");
        for (Object obj : pr.findAll()) {
            Product x = (Product) obj;
            x.displayInfo();
            System.out.println("Thanh tien: " + x.calculateFinalPrice());
            System.out.println("------------------------");
        }

        System.out.println("\nTIM KIEM SAN PHAM ID 001:");
        Product found = (Product) pr.findById("001");
        if (found != null) {
            found.displayInfo();
        } else {
            System.out.println("Khong tim thay!");
        }

        Collections.sort(pr.list, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return Double.compare(p1.getPrice(), p2.getPrice());
            }
        });

        System.out.println("\nDANH SACH SAU KHI SAP XEP GIA TANG DAN:");
        for (Product x : pr.list) {
            System.out.println(x.getName() + " - Gia: " + x.getPrice());
        }

        Map<String, Integer> report = new HashMap<>();
        for (Product x : pr.list) {
            String type = x.getClass().getSimpleName();
            report.put(type, report.getOrDefault(type, 0) + 1);
        }

        System.out.println("\nTHONG KE SO LUONG THEO LOAI:");
        for (Map.Entry<String, Integer> entry : report.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}