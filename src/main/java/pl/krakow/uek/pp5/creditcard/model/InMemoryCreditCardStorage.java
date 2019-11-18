package pl.krakow.uek.pp5.creditcard.model;

import java.util.HashMap;

public class InMemoryCreditCardStorage {
    public InMemoryCreditCardStorage() {
        this.cards = new HashMap<String, CreditCard>();
    }
    public void add(CreditCard cc) {
        this.cards.put(cc.cardNumber, cc);
    }

    public CreditCard load(String creditCardNumber) {
        return this.cards.get(creditCardNumber);
    }
}
