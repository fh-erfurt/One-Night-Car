package de.onenightcar.model.person;

import de.onenightcar.util.AbstractDatabaseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Entity;
import java.time.LocalDateTime;

/** Represents a PaymentMethod
 * @author OneNightCar
 * @version 2.0
 * @since 1.0
 */

@Entity
public class PaymentMethod extends AbstractDatabaseEntity {

    /* /////////////////////Attributes///////////////////////// */

    static Logger log = LoggerFactory.getLogger(PaymentMethod.class);


    private String cardNumber;
    private CardType cardType;
    private LocalDateTime validThrough;
    private String CCV;

    /** Creates a PaymentMethod with specified PaymentMethod.
     * @param cardNumber PaymentMethod’s Card Number
     * @param cardType PaymentMethod’s Card Type
     * @param validThrough PaymentMethod’s Date (Until when the Card is Valid)
     * @param CCV PaymentMethod’s CCV (Security Code on the back)
     */
    public PaymentMethod(String cardNumber, CardType cardType, LocalDateTime validThrough, String CCV){
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
        this.validThrough = LocalDateTime.of(2020,01,31,00,00);
        this.CCV = "999";
    }

    /* /////////////////////Getter/Setters/////////////////////////// */

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
//        if (cardNumber.length()==19) {
//            this.cardNumber = cardNumber;
//            log.info("Set Card number to ", cardNumber);
//        }
//        else if (cardNumber.length() < 19) {
//            log.error("Card number is to short");
//            log.info(String.valueOf(cardNumber));
//        }
//        else {
//            log.error("Card number is to long");
//            log.info(String.valueOf(cardNumber));
//        }

        try {
            if (cardNumber.length() > 19){
                throw new Exception("Card number to long.");
            }
            else if (cardNumber.length() < 19) {
                throw new Exception("Card number to short.");
            }
            else {
                this.cardNumber = cardNumber;
                log.info("Changed card number.");
                log.info(String.valueOf(cardNumber));
            }

        }
        catch(Exception e){
            System.out.print(e + "Card number couldn't be set!");
            log.error("Card number couldn't be set to ");
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
        log.info("Card type set to ", cardType);
    }

    /** Gets the PaymentMethod Valid Through.
     * @return A Gregorian Calendar representing the PaymentMethod Valid Through
     */
    public LocalDateTime getValidThrough(){
        return this.validThrough;
    }

    /** Sets the PaymentMethod Valid Through.
     * @param validThrough A Gregorian Calendar containing the PaymentMethod Valid Through
     */
    public void setValidThrough(LocalDateTime validThrough){
        this.validThrough = validThrough;
        log.info("Valid through set to ");
        log.info(String.valueOf(validThrough));
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
        log.info("CCV set to ", CCV);
    }

    /* /////////////////////Enums/////////////////////////// */

    public enum CardType{
        DEBIT,
        CREDIT
    }

    /* /////////////////////Overrides/////////////////////////// */

    @Override
    public String toString() {
        return "Card Number: '" + this.cardNumber + "', " +
               "Card Type: '" + this.cardType + "', " +
               "Valid Through: '" + this.validThrough + "', " +
               "CCC" + this.CCV + "'";
    }

}
