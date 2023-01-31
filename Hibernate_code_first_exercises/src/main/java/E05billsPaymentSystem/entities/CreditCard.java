package E05billsPaymentSystem.entities;

import net.bytebuddy.implementation.bind.annotation.Default;

import javax.persistence.*;
import java.time.Month;
import java.time.Year;

@Entity
@DiscriminatorValue(value = "credit_Card")
public class CreditCard extends BillingDetail {
    private static final String TYPE = "CREDIT_CARD";
    @Enumerated(EnumType.STRING)
    private CardType type;

    @Column(name = "expiration_month")
    private int expirationMonth;

    @Column(name = "expiration_year")
    private Year expirationYear;

    public CreditCard() {
        super();
    }

    public CreditCard(String number, CardType type, int expirationMonth, Year expirationYear) {
        super(TYPE, number);
        this.type = type;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
    }

    public int getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(int expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public Year getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(Year expirationYear) {
        this.expirationYear = expirationYear;
    }
}
