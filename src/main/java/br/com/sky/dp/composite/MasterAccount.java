package br.com.sky.dp.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite class that holds multiple accounts
 */
public class MasterAccount implements Account {

    private final List<Account> accounts;

    public MasterAccount() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account acc) {
        this.accounts.add(acc);
    }

    public void removeAccount(Account acc) {
        this.accounts.remove(acc);
    }

    @Override
    public float getBalance() {
        return accounts.stream().map(Account::getBalance).reduce(0f, Float::sum);
    }
}
