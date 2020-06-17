package de.onenightcar.model.person;

import de.onenightcar.util.AbstractDatabaseEntity;

import javax.persistence.Entity;
import java.util.GregorianCalendar;

/** Represents a PaymentMethod
 * @author OneNightCar
 * @version 1.0
 * @since 1.0
 */

@Entity
public class PaymentMethod extends AbstractDatabaseEntity {

    /* /////////////////////Attributes///////////////////////// */

    private String cardNumber;
    private CardType cardType;
    private GregorianCalendar validThrough;
    private String CCV;

    /** Creates a PaymentMethod with specified PaymentMethod.
     * @param cardNumber PaymentMethod’s Card Number
     * @param cardType PaymentMethod’s Card Type
     * @param validThrough PaymentMethod’s Date (Until when the Card is Valid)
     * @param CCV PaymentMethod’s CCV (Security Code on the back)
     */
    public PaymentMethod(String cardNumber, CardType cardType, GregorianCalendar validThrough, String CCV){
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.validThrough = validThrough;
        this.CCV = CCV;
    }

    /** Creates a PaymentMethod with default Values.
     * It is used to increment speed of UnitTests.
     */
    public PaymentMethod(){
        this.cardNumber = "0000 0000 0000 0000";
        this.cardType = CardType.CREDIT;
        this.validThrough = new GregorianCalendar(2025,GregorianCalendar.DECEMBER,31);
        this.CCV = "999";
    }

    /* /////////////////////Methods/////////////////////////// */

    /** Gets the PaymentMethod Card Number.
     * @return A string representing the PaymentMethod Card Number
     */
    public String getCardNumber(){
        return this.cardNumber;
    }

    /** Sets the PaymentMethod Card Number.
     * @param cardNumber A String containing the PaymentMethod Card Number
     */
    public void setCardNumber(String cardNumber){
        try {
            this.cardNumber = cardNumber;
        }
        catch(Exception e){
            System.out.print("Card number couldn't be set!");
        }
    }

    /** Gets the PaymentMethod Card Type.
     * @return A CardType representing the PaymentMethod Card Type
     */
    public CardType getCardType(){
        return this.cardType;
    }

    /** Sets the PaymentMethod Card Type.
     * @param cardType A CardType containing the PaymentMethod Card Type
     */
    public void setCardType(CardType cardType){
        this.cardType = cardType;
    }

    /** Gets the PaymentMethod Valid Through.
     * @return A Gregorian Calendar representing the PaymentMethod Valid Through
     */
    public GregorianCalendar getValidThrough(){
        return this.validThrough;
    }

    /** Sets the PaymentMethod Valid Through.
     * @param validThrough A Gregorian Calendar containing the PaymentMethod Valid Through
     */
    public void setValidThrough(GregorianCalendar validThrough){
        this.validThrough = validThrough;
    }

    /** Gets the PaymentMethod CCV.
     * @return A string representing the PaymentMethod CCV
     */
    public String getCCV(){
        return this.CCV;
    }

    /** Sets the PaymentMethod CCV.
     * @param CCV A String containing the PaymentMethod CCV
     */
    public void setCCV(String CCV){
        this.CCV = CCV;
    }

    @Override
    public String toString() {
        return "Card Number: '" + this.cardNumber + "', " +
               "Card Type: '" + this.cardType + "', " +
               "Valid Through: '" + this.validThrough + "', " +
               "CCC" + this.CCV + "'";
    }


    public enum CardType{
        DEBIT,
        CREDIT
    }
}
