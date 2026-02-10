package se.iths.sara.labb2enhetstest.component;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountComponentTest {
    private AccountComponent accountComponent;

    @BeforeEach
    public void setUp() {
        accountComponent = new AccountComponent();
    }

    @Test
    void balanceShouldBeZeroFromStart() {
        assertEquals(0, accountComponent.getBalance());
    }

    @Test
    void depositShouldIncreaseBalance() {
        accountComponent.deposit(100);
        assertEquals(100, accountComponent.getBalance());
    }

    @Test
    void withdrawShouldDecreaseBalance() {
        accountComponent.deposit(300);
        accountComponent.withdraw(150);
        assertEquals(150, accountComponent.getBalance());
    }

    @Test
    void depositAndWithdrawShouldResultInCorrectBalance() {
        accountComponent.deposit(200);
        accountComponent.withdraw(100);
        assertEquals(100, accountComponent.getBalance());
    }


}
