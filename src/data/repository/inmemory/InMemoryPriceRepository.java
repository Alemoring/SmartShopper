package data.repository.inmemory;

import domain.entities.Price;
import domain.port.IPriceRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryPriceRepository implements IPriceRepository {
    private int nextID = 1;
    private Map<Integer, Price> prices = new HashMap<>();
    @Override
    public void add(Price price) {
        if (price.getId() == -1){
            price.setId(nextID++);
        }
        prices.put(price.getId(), price);
    }

    @Override
    public Price getById(int id) {
        return prices.get(id);
    }

    @Override
    public List<Price> getAllPrices() {
        List<Price> prs = new ArrayList<>();
        for (int i = 1; i < prices.size()+1; i++){
            prs.add(prices.get(i));
        }
        return prs;
    }

    @Override
    public int indexOf(Price price) {
        for (int i = 1; i < prices.size()+1; i++){
            if (price.equals(prices.get(i))){
                return i;
            }
        }
        return -1;
    }
}
