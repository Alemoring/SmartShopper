package data.repository.inmemory;

import domain.entities.Product;
import domain.entities.Shop;
import domain.port.IShopRepository;

import java.util.*;

public class InMemoryShopRepository implements IShopRepository {
    private int nextID = 1;
    private Map<Integer, Shop> shops = new HashMap<>();
    @Override
    public void add(Shop shop) {
        if(shop.getId() == -1){
            shop.setId(nextID++);
        }
        shops.put(shop.getId(), shop);
    }

    @Override
    public Shop getById(int id) {
        return shops.get(id);
    }

    @Override
    public List<Shop> searchByName(String name) {
        List<Shop> shs = new ArrayList<>();
        for (int i = 1; i < shops.size()+1; i++){
            if (Objects.equals(shops.get(i).getName(), name)){
                shs.add(shops.get(i));
            }
        }
        return shs;
    }

    @Override
    public List<Shop> getAllShops() {
        List<Shop> shs = new ArrayList<>();
        for (int i = 1; i < shops.size()+1; i++){
            shs.add(shops.get(i));
        }
        return shs;
    }

    @Override
    public int indexOf(Shop shop) {
        for (int i = 1; i < shops.size()+1; i++){
            if (shop.equals(shops.get(i))){
                return i;
            }
        }
        return -1;
    }
}
