package fr.maxime.entity;

import fr.maxime.interfaces.OldPaymentGateway;

public class PaymentAdapter implements OldPaymentGateway {
    private NewPaymentProcessor paymentProcessor;
    private String key;
    private double amount;
    public PaymentAdapter() {
        paymentProcessor = new NewPaymentProcessor();
    }
    @Override
    public double makePayment(String accountNumber, double amount) {
        this.paymentProcessor.authenticate(accountNumber);
        this.paymentProcessor.sendPayment(amount);
        return amount;
    }

}
