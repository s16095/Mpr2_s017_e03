package domain;

import domain.model.Currency;

public interface Expression {

    Money reduce(Bank bank, Currency currency);

    Expression plus(Expression money);

    Expression times(int multiplier);

}
