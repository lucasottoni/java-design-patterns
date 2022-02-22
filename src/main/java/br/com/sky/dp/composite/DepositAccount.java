package br.com.sky.dp.composite;

public class DepositAccount implements Account {
    private String number;
    private float balance;

    public DepositAccount(String number, float balance) {
        this.number = number;
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public float getBalance() {
        return this.balance;
    }
}