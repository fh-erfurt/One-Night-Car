package projekt;

import java.util.GregorianCalendar;

public class Customer extends Person {

    /* /////////////////////Attributes///////////////////////// */

    private int customerID;
    protected CustomerType customerType;
    protected enum CustomerType{
        NEWUSER,
        REGULARUSER,
        SUPERUSER;
    };
    protected String cardNumber;
    protected CardType cardType;
    protected enum CardType{
        CREDITCARD,
        DEBITCARD;
    }
    private GregorianCalendar validThrough;      //needed to do Online transactions
    private String CCV;             //code on the back of Cards


    /* /////////////////////Methods/////////////////////////// */

    public Customer(String surname, String firstName, String ZIP, String street,
                    String houseNumber, GregorianCalendar dateOfBirth,CustomerType customerType,
                    String cardNumber, CardType cardType, GregorianCalendar validThrough, String CCV,
                    List list){
        customerID = list.getSizeOfCustomers();            //Creates a running counter of Rentals in list
        list.customers.add(this);                          //Adds the new customer to the global list
        super.surname = surname;
        super.firstName = firstName;
        super.ZIP = ZIP;
        super.street = street;
        super.houseNumber = houseNumber;
        super.dateOfBirth = dateOfBirth;
        this.customerType = customerType;
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.validThrough = validThrough;
        this.CCV = CCV;
    }

    public void modifyPaymentMethod(String cardNumber, CardType cardType, GregorianCalendar validThrough, String CCV){
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.validThrough = validThrough;
        this.CCV = CCV;
    }

    public boolean customerNeedHelp(){
        Employee.employeeHelpsCustomer(this.customerID);
        return true;
    }

    public Car getCarFromRental (Rental rental, List list){
        for (int i = 0; i <= list.getSizeOfCars(); i++){
            if(rental.getCarID() == list.getCarIDFromCars(i)){
                return list.returnCarWithIndex(i);
            }
        }
        System.out.println("Sorry! Car from this Rental could not be found!");
        return null;
    }

    public void customerDamagesCar(Rental rental, List list){
        if(getCarFromRental(rental, list) != null){

            getCarFromRental(rental, list).changeCarState(Car.State.DAMAGED);
        }
    }

    public String getCardNumber() { return this.cardNumber; }








}
