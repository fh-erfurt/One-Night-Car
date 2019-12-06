package projekt;

import java.util.Date;

public class Customer extends Person {

    /* /////////////////////Attributes///////////////////////// */

    private CustomerType customerType;
    private enum CustomerType{
        NEWUSER,
        REGULARUSER,
        SUPERUSER;
    };
    private int cardNumber;
    private CardType cardType;
    private enum CardType{
        CREDITCARD,
        DEPITCARD;
    }
    private String placeOfIssue;


    /* /////////////////////Methods/////////////////////////// */

    public Customer(String surname, String firstName, String ZIP, String street, String houseNumber, Date dateOfBirth,CustomerType customerType, int cardNumber, CardType cardType, String placeOfIssue){
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

    public void modifyPaymentMethod(int cardNumber, CardType cardType, String placeOfIssue){
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.placeOfIssue = placeOfIssue;
    }

    public boolean customerNeedHelp(){
        Employee.employeeHelpsCustomer(this.personID);
        return true;
    }








}
