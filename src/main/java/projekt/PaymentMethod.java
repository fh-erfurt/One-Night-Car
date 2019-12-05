package projekt;

import java.util.concurrent.atomic.AtomicInteger;

public class PaymentMethod {
    private int paymentID;
    private static AtomicInteger atomicInteger = new AtomicInteger(0); // paymentId auto increment
    private int cardNumber;
    private String cardType;
    private String placeOfIssue;

    public void PaymentMethod(int cardNumber, String cardType, String placeOfIssue){
        this.paymentID =  atomicInteger.incrementAndGet();
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.placeOfIssue = placeOfIssue;
    }

    public int getPaymentID(){
        return this.paymentID;
    }
    public int getCardNumber(){
        return this.cardNumber;
    }
    public String getCardType(){
        return this.cardType;
    }
    public String getPlaceOfIssue(){
        return this.placeOfIssue;
    }


    public  void setCardNumber(int number){
        cardNumber = number;

    }
    public  void setCardType(String type){
        cardType = type;

    }
    public void setPlaceOfIssue(String issuePlace){
        placeOfIssue= issuePlace;

    }
}
