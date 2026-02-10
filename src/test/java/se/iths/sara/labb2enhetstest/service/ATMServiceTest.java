package se.iths.sara.labb2enhetstest.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import se.iths.sara.labb2enhetstest.component.AccountComponent;
import se.iths.sara.labb2enhetstest.exception.InsufficientFundsException;
import se.iths.sara.labb2enhetstest.exception.InvalidAmountException;
import se.iths.sara.labb2enhetstest.exception.MaxWithdrawalExceededException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ATMServiceTest {

    @Mock
    private AccountComponent accountComponent;

    @InjectMocks
    private ATMService atmService;

    @Test
    void depositShouldThrowWhenAmountIsZero() {
        assertThrows(InvalidAmountException.class, () -> atmService.deposit(0));
    }

    @Test
    void depositShouldThrowWhenAmountIsNegative() {
        assertThrows(InvalidAmountException.class, () -> atmService.deposit(-1));
    }

    @Test
    void depositShouldCallAccountComponentDeposit() {
        atmService.deposit(10);
        verify(accountComponent).deposit(10);
    }

    @Test
    void withdrawOverLimitShouldThrow() {
        assertThrows(MaxWithdrawalExceededException.class, () -> atmService.withdraw(2000));
    }

    @Test
    void withdrawShouldSucceedWhenBalanceIsSufficient() {
        when(accountComponent.getBalance()).thenReturn(1000);

        atmService.withdraw(500);

        verify(accountComponent).withdraw(500);
    }

    @Test
    void withdrawShouldNotCheckBalanceWhenAmountExceedsMax() {
        assertThrows(MaxWithdrawalExceededException.class, () -> atmService.withdraw(5000));

        verify(accountComponent, never()).getBalance();
        verify(accountComponent, never()).withdraw(anyInt());
    }

    @Test
    void withdrawShouldFailWhenBalanceIsInsufficient() {
        when(accountComponent.getBalance()).thenReturn(100);

        assertThrows(InsufficientFundsException.class, () -> atmService.withdraw(200));

        // bevisa att inget uttag görs när saldot inte räcker
        verify(accountComponent, never()).withdraw(200);
    }
}
