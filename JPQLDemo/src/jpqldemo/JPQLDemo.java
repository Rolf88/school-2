/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpqldemo;

import JPQLLogic.JPQLLogic;
import entity.Customer;
import entity.Employee;
import entity.JPQL_Order;
import entity.Office;
import java.util.Random;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author RolfMoikjær
 */
public class JPQLDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPQLDemoPU");

        Random random = new Random();
        int employeeNumb = random.nextInt(9999999);

        try (JPQLLogic jpqlLogic = new JPQLLogic(emf)) {

            Employee employee = new Employee();
            employee.setCustomerList(null);
            employee.setEmail("kalkunhansen@yahoo.com");
            employee.setEmployeeList(null);
            employee.setEmployeeNumber(employeeNumb);
            employee.setExtension("123");
            employee.setFirstName("Rolf");
            employee.setJobTitle("Boss");
            employee.setLastName("Bossen");
            employee.setOfficeCode(new Office("5"));
            employee.setReportsTo(null);

            jpqlLogic.createEmployee(employee);

            Customer customer = new Customer();
            customer.setAddressLine1("rugparken");
            customer.setAddressLine2("ruggården");
            customer.setCity("NYC");
            customer.setContactFirstName("hanne");
            customer.setContactLastName("bøge");
            customer.setCountry("danmark");
            customer.setCreditLimit(25.00);
            customer.setCustomerName("johan");
            customer.setCustomerNumber(103);
            customer.setJPQLOrderList(null);
            customer.setPaymentList(null);
            customer.setPhone("45854596");
            customer.setPostalCode("2750");
            customer.setSalesRepEmployeeNumber(employee);
            customer.setState("Nevada");

            jpqlLogic.updateCustomer(customer);

            Long ec = jpqlLogic.getEmployeCount();
            System.out.println(ec);

            for (Customer customer1 : jpqlLogic.getCustomerInCity("NYC")) {
                System.out.println(customer1.getCustomerName());
            }
            
            jpqlLogic.getEmployeMaxCustomers();
            
            for (JPQL_Order order : jpqlLogic.getOrdersOnHold()) {
                System.out.println(order.getOrderNumber());
            }
            
            for (JPQL_Order order1 : jpqlLogic.getOrdersOnHold(144)) {
                System.out.println(order1.getOrderNumber());
            }

        }

    }

}
