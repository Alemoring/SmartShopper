package domain.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Price {
    private static int nextId = 1;
    private int id;
    private int price; // в копейках за шт. кг.
    private long dateOfPurchase; // unix TimeStamp
    private Product product;
    private Shop shop;

    public Price(int price, long dateOfPurchase, Product product, Shop shop) {
        this.id = -1;
        this.price = price;
        this.dateOfPurchase = dateOfPurchase;
        this.product = product;
        product.addPrice(this);
        this.shop = shop;
        shop.addPrice(this);
    }

    public Price(int price){
        this.price = price;
    }

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Price{" +
                "id=" + id +
                ", price=" + price +
                ", dateOfPurchase='" + dateOfPurchase + '\'' +
                ", idProduct=" + product.getId() +
                ", idShop=" + shop.getId() +
                ", \n" + product +
                ", \n" + shop +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price1 = (Price) o;
        return price == price1.price;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(price);
    }
}
