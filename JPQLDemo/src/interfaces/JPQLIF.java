/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entity.Customer;
import entity.Employee;
import entity.JPQL_Order;
import java.util.List;

/**
 *
 * @author RolfMoikjær
 */
public interface JPQLIF {

    public Employee createEmployee(Employee employee);

    public Customer updateCustomer(Customer cust);

    public Long getEmployeCount();

    public List<Customer> getCustomerInCity(String city);

    public Employee getEmployeMaxCustomers();

    public List<JPQL_Order> getOrdersOnHold();

    public List<JPQL_Order> getOrdersOnHold(int customerNumber);
}
