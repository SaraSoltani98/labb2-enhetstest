package se.iths.sara.labb2enhetstest.service;

import org.springframework.stereotype.Service;
import se.iths.sara.labb2enhetstest.component.AccountComponent;
import se.iths.sara.labb2enhetstest.exception.InsufficientFundsException;
import se.iths.sara.labb2enhetstest.exception.InvalidAmountException;
import se.iths.sara.labb2enhetstest.exception.MaxWithdrawalExceededException;

@Service
public class ATMService {
    private static final int MAX_WITHDRAWAL = 1000;  //max 1000 kr per uttag som kan inte ändras(final=fast)
    private final AccountComponent accountComponent;  //koppling till kontot

    public ATMService(AccountComponent accountComponent) {
        this.accountComponent = accountComponent;
    }

    public void deposit(int amount) {
        if (amount <= 0) {
            throw new InvalidAmountException();
        }
        accountComponent.deposit(amount);
    }

    public void withdraw(int amount) {
        if (amount <= 0) {
            throw new InvalidAmountException();
        }
        if (amount > MAX_WITHDRAWAL) {
            throw new MaxWithdrawalExceededException();
        }

        int currentBalance = accountComponent.getBalance();
        if (amount > currentBalance) {
            throw new InsufficientFundsException("Otillräckligt saldo");
        }

        accountComponent.withdraw(amount);
    }

    public int getBalance() {
        return accountComponent.getBalance();
    }

}
