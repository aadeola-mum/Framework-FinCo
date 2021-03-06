package creditcard.account;

import framework.user.AbstractUser;

public class BronzeCreditCardAccount extends AbstractCreditCardAccount {

    private final double monthly_interest = 0.1;
    private final double minimum_payment = 0.14;

    public BronzeCreditCardAccount(String accountNumber, double accountBalance, AbstractUser user) {
        super(accountNumber, accountBalance, user);
    }

    public BronzeCreditCardAccount(String accountNumber, AbstractUser user) {
        super(accountNumber,0.0, user);
    }

    @Override
    public double getNewMonthlyBalance() {
        //TODO
        return 0;
    }

    @Override
    public String generateMonthlyBillingReport() {
        String report = super.generateMonthlyBillingReport();
        double previous = this.getLastMonthBalance();
        double charges = this.getTotalMonthlyCharges();
        double credits = this.getTotalMonthlyCredits();
        double newBalance = (previous - credits + charges + (this.minimum_payment * (previous - credits)));

        report += "New balance              : $" + newBalance + System.lineSeparator();
        report += "Total due                : $" + this.minimum_payment * newBalance;

        return report;
    }
}
