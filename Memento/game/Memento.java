package game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Memento implements Serializable {
    int money;
    ArrayList fruits;

    Memento(int money) {
        this.money = money;
        this.fruits = new ArrayList();
    }

    public int getMoney() {
        return money;
    }

    List getFruits() {
        return (List) fruits.clone();
    }

    void addFruit(String fruit) {
        fruits.add(fruit);
    }
}