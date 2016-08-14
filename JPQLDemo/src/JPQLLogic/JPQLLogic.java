/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPQLLogic;

import entity.Customer;
import entity.Employee;
import entity.JPQL_Order;
import interfaces.JPQLIF;
import java.io.Closeable;
import java.util.Comparator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author RolfMoikjær
 */
public class JPQLLogic implements JPQLIF, Closeable {

    private final EntityManager entityManager;

    public JPQLLogic(EntityManagerFactory factory) {
        this.entityManager = factory.createEntityManager();
        this.entityManager.getTransaction().begin();
    }

    @Override
    public Employee createEmployee(Employee employee) {

        this.entityManager.persist(employee);

        return employee;
    }

    @Override
    public Customer updateCustomer(Customer cust) {
        this.entityManager.merge(cust);

        return cust;
    }

    @Override
    public Long getEmployeCount() {
        Query query = this.entityManager.createQuery("SELECT COUNT(e.employeeNumber)FROM Employee e");

        return (Long)query.getSingleResult();
    }

    @Override
    public List<Customer> getCustomerInCity(String city) {
        Query query = this.entityManager.createNamedQuery("Customer.findByCity");
        List<Customer> customerList;
        query.setParameter("city", city);
        customerList = query.getResultList();

        return customerList;
    }

    @Override
    public Employee getEmployeMaxCustomers() {
        Query query = this.entityManager.createNamedQuery("Employee.findAll");
        List<Employee> employeeList;
        employeeList = query.getResultList();
        employeeList.sort(new Comparator<Employee>() {

            @Override
            public int compare(Employee e1, Employee e2) {
                int s1 = e1.getCustomerList().size();
                int s2 = e2.getCustomerList().size();
                if (s1 == s2) {
                    return 0;
                }
                if (s2 < s1) {
                    return -1;
                }
                return 1;
            }
        });
        System.out.println(employeeList.get(0).getFirstName());
        return employeeList.get(0);
    }

    @Override
    public List<JPQL_Order> getOrdersOnHold() {
        Query query = this.entityManager.createNamedQuery("JPQL_Order.findByStatus");
        List<JPQL_Order> orders;
        query.setParameter("status", "On Hold");
        orders = query.getResultList();
        
        return orders;
    }

    @Override
    public List<JPQL_Order> getOrdersOnHold(int customerNumber) {
        Query query = this.entityManager.createQuery("SELECT j FROM JPQL_Order j WHERE j.status = 'On Hold' AND j.customerNumber.customerNumber = :customerNumber");
        List<JPQL_Order> orders;
        query.setParameter("customerNumber", customerNumber);
        orders = query.getResultList();
        
        return orders;
    
    }

    @Override
    public void close() {
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }

}
