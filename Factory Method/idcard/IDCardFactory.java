package idcard;

import framework.Factory;
import framework.Product;

import java.util.Hashtable;

public class IDCardFactory extends Factory {
    private Hashtable database = new Hashtable();
    private int serial = 100;

    @Override
    protected synchronized Product createProduct(String owner) {
        return new IDCard(owner, serial++);
    }

    @Override
    protected void registerProduct(Product product) {
        IDCard card = (IDCard)product;
        database.put(card.getSerial(), card.getOwner());
    }

    public Hashtable getDatabase() {
        return database;
    }
}
