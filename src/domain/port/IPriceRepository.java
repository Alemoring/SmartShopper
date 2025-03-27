package domain.port;

import domain.entities.Price;

import java.util.List;

public interface IPriceRepository {
    void add(Price price);
    Price getById(int id);
    //List<Price> searchByName(String name);
    List<Price> getAllPrices();
    int indexOf(Price price);
}
