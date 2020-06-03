package de.onenightcar.domain.model.person;

import java.util.ArrayList;

/** Represents the PersonManager
 * @author OneNightCar
 * @version 1.0
 * @since 1.0
 */

public class PersonManager {

    /* /////////////////////Attributes///////////////////////// */

    public ArrayList<Customer> customers;
    public ArrayList<Employee> employees;
    private int customerCounter;
    private int employeeCounter;

    /* /////////////////////Methods/////////////////////////// */

    /**
     * Creates a PersonManager with empty lists and the initial counter = 1.
     */

    public PersonManager(){
        this.customers = new ArrayList<Customer>();
        this.employees = new ArrayList<Employee>();
        this.customerCounter = 1;
        this.employeeCounter = 1;
    }

    /**
     * returns the current counter an increments 1 for next ID
     * @return an int value which is used to create the IDs from Customers
     */

    public int getAndIncrementCustomerCounter(){
        int oldCustomerCounter = this.customerCounter;
        this.customerCounter++;
        return oldCustomerCounter;
    }

    /**
     * returns the current counter an increments 1 for next ID
     * @return an int value which is used to create the IDs from Employees
     */

    public int getAndIncrementEmployeeCounter(){
        int oldEmployeeCounter = this.employeeCounter;
        this.employeeCounter++;
        return oldEmployeeCounter;
    }



    /**
     * Get the current Index of a Customer in the customer List
     * @param customer a Customer representing which Customer needs to be searched
     * @return an int value representing the Index on List
     * If Customer could not be found, returns -1
     */
    public int getCustomerIndexInCustomerList(Customer customer) {
        for (int indexInList = 0; indexInList < customers.size(); indexInList++) {
            if (customers.get(indexInList) == customer) {
                return indexInList;
            }
        }
        return -1;
    }

    /**
     * Get the current Index of a Employee in the employees List
     * @param employee a Employee representing which Employee needs to be searched
     * @return an int value representing the Index on List
     * If Customer could not be found, returns -1
     */
    public int getEmployeeIndexInEmployeeList(Employee employee) {
        for (int indexInList = 0; indexInList < employees.size(); indexInList++) {
            if (employees.get(indexInList) == employee) {
                return indexInList;
            }
        }
        return -1;
    }

    /**
     * Removes a Customer from the customers list
     * @param customer a Customer which is going to be deleted from the list
     */
    public void removeCustomerFromCustomers(Customer customer){
        this.customers.remove(getCustomerIndexInCustomerList(customer));
    }

    /**
     * Removes a Employee from the employees list
     * @param employee a Employee which is going to be deleted from the list
     */
    public void removeEmployeeFromEmployees(Employee employee){
        this.employees.remove(getEmployeeIndexInEmployeeList(employee));
    }

}
