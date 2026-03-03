public abstract class Product {
    private String id;
    private String name;
    private double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    double calculateFinalPrice(){
        return price;
    }

    void displayInfo(){
        System.out.println("===THONG TIN SAN PHAM===");
        System.out.println("ID: "  + id);
        System.out.println("NAME: " + name);
        System.out.println("PRICE: " + price + "VND");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}


class ElectronicProduct extends  Product{
    private int warrantyMonths;

    public ElectronicProduct(String id, String name, double price, int warrantyMonths) {
        super(id, name, price);
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    double calculateFinalPrice() {
        if (warrantyMonths > 12){
            return getPrice() + 1000000;
        }else{
            return getPrice();
        }
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("SO THANG BAO HANH: " + warrantyMonths);

    }
}


class FoodProduct  extends  Product{
    private int discountPercent;

    public FoodProduct(String id, String name, double price, int discountPercent) {
        super(id, name, price);
        this.discountPercent = discountPercent;
    }

    @Override
    double calculateFinalPrice() {
        return getPrice() - (getPrice() * discountPercent/100);
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("PHAN TRAM GIAM GIA: " + discountPercent + "%");

    }
}