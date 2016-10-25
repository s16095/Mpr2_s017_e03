package domain;


public class Money implements Expression {

    int amount;
    protected Currency currency;

    public Money() {

    }


    public int getAmount() {
        return amount;
    }

    public Money(int amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Money dollar(int amount) {
        return new Money(amount, Currency.USD);
    }

    public static Money franc(int amount) {
        return new Money(amount, Currency.CHF);
    }

    public Money times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }


    public boolean equals(Object other) {
        Money money = (Money) other;
        return money.amount == this.amount
                && money.currency.equals(this.currency);
    }

    public Currency currency() {
        return this.currency;
    }

    public Sum plus(Expression five) {
        return new Sum(this, five);
    }

    public Money reduce(Currency currency) {
        return this;
    }

    public Money reduce(Bank bank, Currency currency) {
        return this;
    }

}
