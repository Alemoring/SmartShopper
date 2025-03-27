package domain.usecase;

import data.repository.inmemory.InMemoryPriceRepository;
import data.repository.inmemory.InMemoryProductRepository;
import data.repository.inmemory.InMemoryShopRepository;
import domain.entities.*;
import domain.port.IPriceRepository;
import domain.port.IProductRepository;
import domain.port.IShopRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 *
 * Изменить параметр isWeight
 *
 * */

public class ConvertProductFromUnloading {
    public static Wrapper convertProductFromUnloading(List<ProductsFromUnloading> productsFromUnloadings) throws IOException {
        Wrapper wrapper = new Wrapper();
        IProductRepository products = new InMemoryProductRepository();
        IShopRepository shops = new InMemoryShopRepository();
        IPriceRepository prices = new InMemoryPriceRepository();
        for (ProductsFromUnloading pU : productsFromUnloadings){
            Shop s = new Shop(pU.getRetailPlace(), pU.getRetailPlaceAddress());
            Product p = new Product(pU.getName(), pU.getFiscalSign(), true);

            int indexShopBySearch = shops.indexOf(s);
            int indexProductBySearch = products.getAllProducts().indexOf(p);
            int indexPriceBySearch = prices.indexOf(new Price(pU.getPrice()));

            if (indexShopBySearch == -1){
                shops.add(s);
            }
            if (indexProductBySearch == -1){
                products.add(p);
            }
            if (indexPriceBySearch == -1 || indexShopBySearch == -1 || indexProductBySearch == -1){
                Price pr;
                if (indexShopBySearch != -1 && indexProductBySearch != -1){
                    pr = new Price(pU.getPrice(), pU.getDateTime(), products.getById(indexProductBySearch),
                            shops.getById(indexShopBySearch));
                } else if (indexShopBySearch != -1 && indexProductBySearch == -1) {
                    pr = new Price(pU.getPrice(), pU.getDateTime(), p, shops.getById(indexShopBySearch));
                } else if (indexShopBySearch == -1 && indexProductBySearch != -1) {
                    pr = new Price(pU.getPrice(), pU.getDateTime(), products.getById(indexProductBySearch), s);
                } else {
                    pr = new Price(pU.getPrice(), pU.getDateTime(), p, s);
                }
                prices.add(pr);
            }
        }
        wrapper.setPrices(prices);
        wrapper.setProducts(products);
        wrapper.setShops(shops);
        return wrapper;
    }
}
