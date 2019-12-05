package projekt;

import java.util.Date;

public class Customers extends Persons {
    private enum customerType{
        newUser,
        regularUser,
        superUser;
    };


    /* /////////////////////Methods/////////////////////////// */
    public void signUp(String surname, String firstName, String ZIP, String street, String housNumber, Date dateOfBirth, int cardNumber, String cardType, String placeOfIssue){
        super.Persons(setSurname(surname), setFirstName(firstName),setZIP(ZIP),setStreet(street),setHousNumber(housNumber),setDateOfBirth(dateOfBirth));
        //PaymentMethod.setCardNumber(cardNumber);
        //PaymentMethod.setCardType(cardType);
        //PaymentMethod.setPlaceOfIssue(placeOfIssue);
    }







}
