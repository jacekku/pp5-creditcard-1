package pl.krakow.uek.pp5.creditcard.model;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CreditCardTest {

    public static final int LIMIT = 10000;

    @Test
    public void itAllowAssignCreditToCard() {
        //Arrange / Given
        CreditCard card = new CreditCard("1234-5678");
        //Act / When
        card.assignLimit(BigDecimal.valueOf(LIMIT));
        //Assert / Then
        Assert.assertTrue(card.getLimit().equals(BigDecimal.valueOf(LIMIT)));
    }
    @Test
    public void creditBelowGeneralLimitIsNotPossible() {
        //Arrange
        CreditCard card = new CreditCard("1234-5678");
        //Act
        //Assert
        try {
            card.assignLimit(BigDecimal.valueOf(50));
            Assert.fail("exception");
        } catch (CreditBelowLimitException e) {
            Assert.assertTrue(true);
        }
    }
    @Test
    public void withdrawFromCard(){
        CreditCard card = new CreditCard("1234-5678");
        card.assignLimit(BigDecimal.valueOf(1000));
        card.withdraw(BigDecimal.valueOf(500));
        Assert.assertEquals(BigDecimal.valueOf(500), card.getCurrentBalance());
    }


    @Test(expected = NotEnoughMoneyException.class)
    public void denyWithdrawBelowBalance() {
        CreditCard card = new CreditCard("1234-5678");
        card.assignLimit(BigDecimal.valueOf(1000));

        card.withdraw(BigDecimal.valueOf(600));
        card.withdraw(BigDecimal.valueOf(600));
    }
}