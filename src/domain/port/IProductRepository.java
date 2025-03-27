package domain.port;

import domain.entities.Product;

import java.util.List;

public interface IProductRepository {
    void add(Product product);
    Product getById(int id);
    List<Product> searchByName(String name);
    List<Product> getAllProducts();
}
