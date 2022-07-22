package market;

import models.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Menu menu = new Menu();
        Product product1 = new Product(1,"smartphone",550);
        Product product2 = new Product(2,"laptop",1200);
        Product product3 = new Product(3,"TV",750);

        User user1 = new User(1,"Vlasov","Alex",3000);
        User user2 = new User(2,"Ivanov","Sergey",1500);
        User user3 = new User(3,"Ponomarenko","Max",2000);

    }
}
