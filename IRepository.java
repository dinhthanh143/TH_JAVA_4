import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface IRepository<T> {
    boolean add(T item);
    boolean removeById(String id);
    T findById(String id);
    List<T> findAll();
}

class ProductRepository  implements IRepository {
    ArrayList<Product> list = new ArrayList<>();
    HashMap<String, Product> map = new HashMap<>();
    @Override
    public boolean add(Object item) {
        if (item instanceof Product){
            Product p = (Product) item;
            list.add(p);
            map.put(p.getId(), p);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeById(String id) {
        for (Object x : list){
            if ( x instanceof Product  && id.equals(((Product) x).getId())){
                list.remove(x);
                map.remove(((Product) x).getId());
                return true;
            }
        }
        return false;
    }

    @Override
    public Object findById(String id) {
        for (Object x : list){
            if ( x instanceof Product  && id.equals(((Product) x).getId())){
                return (Product) x;
            }
        }
        return null;
    }

    @Override
    public List findAll() {
        return List.of(list);
    }


}
