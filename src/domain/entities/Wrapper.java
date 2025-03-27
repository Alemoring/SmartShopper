package domain.entities;

import data.repository.inmemory.InMemoryProductRepository;
import domain.port.IPriceRepository;
import domain.port.IProductRepository;
import domain.port.IShopRepository;

import java.util.ArrayList;

public class Wrapper{
    private IProductRepository products;
    private IShopRepository shops;
    private IPriceRepository prices;

    public IProductRepository getProducts() {
        return products;
    }

    public void setProducts(IProductRepository products) {
        this.products = products;
    }

    public IShopRepository getShops() {
        return shops;
    }

    public void setShops(IShopRepository shops) {
        this.shops = shops;
    }

    public IPriceRepository getPrices() {
        return prices;
    }

    public void setPrices(IPriceRepository prices) {
        this.prices = prices;
    }
}
