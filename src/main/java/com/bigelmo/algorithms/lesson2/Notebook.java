package com.bigelmo.algorithms.lesson2;

public class Notebook {

    private Integer price;
    private final Integer ram;
    private final String maker;

    public Notebook(Integer price, Integer ram, String maker) {
        this.price = price;
        this.ram = ram;
        this.maker = maker;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getRam() {
        return ram;
    }

    public String getMaker() {
        return maker;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "{" +
                "price=" + price +
                ", ram=" + ram +
                ", maker='" + maker + '\'' +
                '}';
    }
}
