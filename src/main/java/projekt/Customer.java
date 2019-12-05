package projekt;

import java.util.Date;

public class Customer extends Person {
    private CustomerType customerType;
    private enum CustomerType{
        NEWUSER,
        REGULARUSER,
        SUPERUSER;
    };
    private int cardNumber;
    private String cardType;
    private String placeOfIssue;


    /* /////////////////////Methods/////////////////////////// */
    public void signUp(String surname, String firstName, String ZIP, String street, String houseNumber, Date dateOfBirth, int cardNumber, String cardType, String placeOfIssue){

    }
    public Customer(String surname, String firstName, String ZIP, String street, String houseNumber, Date dateOfBirth,CustomerType customerType, int cardNumber, String cardType, String placeOfIssue){
        super.surname = surname;
        super.firstName = firstName;
        super.ZIP = ZIP;
        super.street = street;
        super.houseNumber = houseNumber;
        super.dateOfBirth = dateOfBirth;
        this.customerType = customerType;
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.placeOfIssue = placeOfIssue;
    }






}
