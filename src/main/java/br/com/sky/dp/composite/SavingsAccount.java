package br.com.sky.dp.composite;

public class SavingsAccount implements Account {
    private String number;
    private float balance;

    public SavingsAccount(String number, float balance) {
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
