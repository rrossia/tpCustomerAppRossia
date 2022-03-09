/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tpcustomerapprossia.managedbeans;

import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import mg.itu.tpcustomerapprossia.entities.Customer;
import mg.itu.tpcustomerapprossia.session.CustomerManager;

/**
 *
 * @author Rossia
 */
@Named(value = "customerMBean")
@ViewScoped
public class CustomerMBean implements Serializable {
    private List<Customer> customerList;
        /**
     * Creates a new instance of CustomerMBean
     */
    public CustomerMBean() {
    }
    @EJB
    private CustomerManager customerManager;
    /**
     * Retourne la liste des clients pour affichage dans une DataTable
     *
     * @return
     */
    public List<Customer> getCustomers() {
        if (customerList == null) {
            customerList = customerManager.getAllCustomers();
        }

        return customerList;
    }



}
