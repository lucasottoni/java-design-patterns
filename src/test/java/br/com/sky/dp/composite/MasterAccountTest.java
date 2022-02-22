package br.com.sky.dp.composite;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MasterAccountTest {

    @Test
    public void testSingleAccount() {
        MasterAccount masterAccount = new MasterAccount();

        DepositAccount account = new DepositAccount("123123", 99f);
        masterAccount.addAccount(account);

        assertEquals(99f, masterAccount.getBalance());
    }

    @Test
    public void testMultipleAccount() {
        MasterAccount masterAccount = new MasterAccount();

        DepositAccount depositAccount = new DepositAccount("123123", 99f);
        masterAccount.addAccount(depositAccount);
        SavingsAccount savingsAccount = new SavingsAccount("918312", 57.2f);
        masterAccount.addAccount(savingsAccount);

        assertEquals(156.2f, masterAccount.getBalance());
    }

    @Test
    public void testTreeAccount() {
        MasterAccount masterAccount1 = new MasterAccount();

        DepositAccount depositAccount = new DepositAccount("123123", 99f);
        masterAccount1.addAccount(depositAccount);
        SavingsAccount savingsAccount = new SavingsAccount("918312", 57.2f);
        masterAccount1.addAccount(savingsAccount);

        MasterAccount masterAccount2 = new MasterAccount();

        DepositAccount depositAccount2 = new DepositAccount("123123", 100f);
        masterAccount1.addAccount(depositAccount2);
        SavingsAccount savingsAccount2 = new SavingsAccount("918312", 200f);
        masterAccount1.addAccount(savingsAccount2);

        MasterAccount masterAccount = new MasterAccount();
        masterAccount.addAccount(masterAccount1);
        masterAccount.addAccount(masterAccount2);

        assertEquals(456.2f, masterAccount.getBalance());
    }
}
