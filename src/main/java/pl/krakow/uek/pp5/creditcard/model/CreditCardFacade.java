package pl.krakow.uek.pp5.creditcard.model;

public class CreditCardFacade {
    public void withdraw(WithdrawCommand withdrawCommand) {
        CreditCard loaded = storage.load(withdrawCommand.getCreditCardNumber());

        loaded.withdraw(withdrawCommand.getAmount());

        storage.add(loaded)
    }
}
