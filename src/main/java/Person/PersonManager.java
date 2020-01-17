package Person;

import java.util.ArrayList;

/** Represents the PersonManager
 * @author OneNightCar
 * @version 1.0
 * @since 1.0
 */

public class PersonManager {
    public ArrayList<Customer> customers;
    public ArrayList<Employee> employees;
    private int customerCounter;
    private int employeeCounter;

    public PersonManager(){
        this.customers = new ArrayList<Customer>();
        this.employees = new ArrayList<Employee>();
        this.customerCounter = 1;
        this.employeeCounter = 1;
    }

    public int getAndIncrementCustomerCounter(){
        int oldCustomerCounter = this.customerCounter;
        this.customerCounter++;
        return oldCustomerCounter;
    }

    public int getAndIncrementEmployeeCounter(){
        int oldEmployeeCounter = this.employeeCounter;
        this.employeeCounter++;
        return oldEmployeeCounter;
    }

}
