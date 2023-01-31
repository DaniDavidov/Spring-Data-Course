package E05billsPaymentSystem.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "bank_account")
public class BankAccount extends BillingDetail {
    private static final String TYPE = "BANK_ACCOUNT";
    @Column(name = "bank_name", nullable = false)
    private String bankName;
    @Column(name = "swift_code", nullable = false)
    private String swiftCode;

    public BankAccount() {
        super();
    }

    public BankAccount(String number, String bankName, String swiftCode) {
        super(TYPE, number);
        this.bankName = bankName;
        this.swiftCode = swiftCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }
}
