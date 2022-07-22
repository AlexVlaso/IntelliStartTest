package models;

public class Product {
    public Product(int id, String name, double price) {
        this.id = id;
        Name = name;
        this.price = price;
        Menu.addProduct(this);
    }

    private final int id;
    private  String Name;
    private double price;

    public int getId() {
        return id;
    }



    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", price=" + price +
                '}';
    }
}
