package data.repository.inmemory;

import domain.entities.Product;
import domain.port.IProductRepository;

import java.util.*;

public class InMemoryProductRepository implements IProductRepository {
    private Map<Integer, Product> products = new HashMap<>();
    private int nextID = 1;
    @Override
    public void add(Product product) {
        if (product.getId() == -1){
            product.setId(nextID++);
        }
        products.put(product.getId(), product);
    }

    @Override
    public Product getById(int id) {
        return products.get(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> prs = new ArrayList<>();
        for (int i = 1; i < products.size()+1; i++){
            if (Objects.equals(products.get(i).getName().toLowerCase(), name.toLowerCase())){
                prs.add(products.get(i));
            }
        }
        return prs;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> prs = new ArrayList<>();
        for (int i = 1; i < products.size()+1; i++){
            prs.add(products.get(i));
        }
        return prs;
    }
}
