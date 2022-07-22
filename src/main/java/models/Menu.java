package models;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {

    private final static List<Product> listOfProducts = new ArrayList<>();
    private final static List<User> listOfUsers = new ArrayList<>();
    private final HashMap<User, List<Product>> orders = new HashMap<>();
    private final HashMap<Product, List<User>> productStatistic = new HashMap<>();


    public  void removeUser(User user){
        orders.remove(user);
        listOfUsers.remove(user);
        for(Map.Entry<Product,List<User>> entry :productStatistic.entrySet()){
            entry.getValue().remove(user);
        }
    }
    public void removeProduct(Product product){
        listOfProducts.remove(product);
        productStatistic.remove(product);
        for(Map.Entry<User, List<Product>>entry: orders.entrySet()){
            entry.getValue().remove(product);
        }
    }

    public static void addProduct(Product product) {
        listOfProducts.add(product);
    }

    public static void addUsers(User user) {
        listOfUsers.add(user);
    }

    public void showListOfUsers() {
        for (User user : listOfUsers) {
            System.out.println(user);
        }
    }

    public void showListOfProducts() {
        for (Product product : listOfProducts) {
            System.out.println(product);
        }
    }

    private User searchUser(int id) {
        User currentUser = null;
        for (User user : listOfUsers) {
            if (id == user.getId()) {
                currentUser = user;
                break;
            }
        }
        return currentUser;
    }

    private Product searchProduct(int id) {
        Product currentProduct = null;
        for (Product product : listOfProducts) {
            if (id == product.getId()) {
                currentProduct = product;
                break;
            }
        }
        return currentProduct;
    }

    public void ableToBuy(int userId, int productId)  {
        User user = searchUser(userId);
        Product product = searchProduct(productId);
        if (user.getAmountOfMoney() < product.getPrice()) {
            try {
                throw new Exception("Not enough money!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            user.setAmountOfMoney(user.getAmountOfMoney() - product.getPrice());
            System.out.println("Successful purchase, have a Good Day!");
            if (orders.containsKey(user)) {
                orders.get(user).add(product);
            } else {
                orders.put(user, new ArrayList<>());
                orders.get(user).add(product);
            }
            if (productStatistic.containsKey(product)) {
                productStatistic.get(product).add(user);
            } else {
                productStatistic.put(product, new ArrayList<>());
                productStatistic.get(product).add(user);
            }
        }
    }

    public void showUserOrders(int userId) {
        if (!orders.containsKey(searchUser(userId)))
            return;

        List<Product> list = orders.get(searchUser(userId));
        for (Product product : list) {
            System.out.println(product);
        }
    }

    public void showOrdersWithProduct(int productId) {
        if (!productStatistic.containsKey(searchProduct(productId)))
            return;

        List<User> list = productStatistic.get(searchProduct(productId));
        for (User user : list) {
            System.out.println(user);
        }
    }

}
