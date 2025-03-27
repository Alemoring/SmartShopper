package domain.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Product {
    private int id;
    private String name;
    private String fiscalSign;
    private boolean isWeight;
    private short quality;
    private String comment;
    private List<Price> prices = new ArrayList<>();

    public Product(){}

    public Product(String name, String fiscalSign, boolean isWeight) {
        this.id = -1;
        this.name = name;
        this.fiscalSign = fiscalSign;
        this.isWeight = isWeight;
    }

    public void addPrice(Price pr){
        this.prices.add(pr);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFiscalSign() {
        return fiscalSign;
    }

    public void setFiscalSign(String fiscalSign) {
        this.fiscalSign = fiscalSign;
    }

    public boolean isWeight() {
        return isWeight;
    }

    public void setWeight(boolean weight) {
        isWeight = weight;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fiscalSign='" + fiscalSign + '\'' +
                ", isWeight=" + isWeight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return isWeight == product.isWeight && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, isWeight);
    }
}
