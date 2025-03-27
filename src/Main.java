import domain.entities.*;
import domain.usecase.ConvertProductFromUnloading;
import domain.usecase.GetProductsFromUnloading;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\morgu\\Desktop\\Проектики\\IDEA\\SmartShopper";
        String filename = "Чеки.json";
        List<ProductsFromUnloading> products = GetProductsFromUnloading.getProductsFromUnloading(path, filename);
        Wrapper wrapper = ConvertProductFromUnloading.convertProductFromUnloading(products);


        for (Price p : wrapper.getPrices().getAllPrices()){
            System.out.println("-------------------------------------------------");
            System.out.println(p);
        }

        //System.out.println(wrapper.getPrices().getById(8));

        //System.out.println(wrapper.getProducts().getAllProducts());
        //System.out.println(products.getFirst());

        /*List<Shop> shops = wrapper.getShops().getAllShops();
        for (Shop s : shops){
            System.out.println(s);
        }*/
    }
}