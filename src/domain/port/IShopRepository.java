package domain.port;

import domain.entities.Shop;

import java.util.List;

public interface IShopRepository {
    void add(Shop product);
    Shop getById(int id);
    List<Shop> searchByName(String name);
    List<Shop> getAllShops();
    int indexOf(Shop shop);
}
