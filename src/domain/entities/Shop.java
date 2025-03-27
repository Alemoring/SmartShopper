package domain.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Shop {
    private static int nextId = 1;
    private int id;
    private String name;
    private String address;
    private float longitude;
    private float lattitude;
    private List<Price> prices = new ArrayList<>();

    public Shop(String name, String address){
        this.id = -1;
        this.name = name;
        this.address = address;
    }

    public void addPrice(Price pr){
        this.prices.add(pr);
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", longitude=" + longitude +
                ", lattitude=" + lattitude +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return Objects.equals(name, shop.name) && Objects.equals(address, shop.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
