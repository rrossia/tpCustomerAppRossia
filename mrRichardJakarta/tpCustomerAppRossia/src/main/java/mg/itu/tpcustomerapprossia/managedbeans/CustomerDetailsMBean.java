/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tpcustomerapprossia.managedbeans;

import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import mg.itu.tpcustomerapprossia.entities.Customer;
import mg.itu.tpcustomerapprossia.entities.DiscountCode;
import mg.itu.tpcustomerapprossia.session.CustomerManager;
import mg.itu.tpcustomerapprossia.session.DiscountCodeManager;

/**
 *
 * @author Rossia
 */
//@Named(value = "customerDetailsMBean")
@Named
@ViewScoped
public class CustomerDetailsMBean implements Serializable {
    private int idCustomer;
    private Customer customer;
    /**
     * Creates a new instance of CustomerDetailsMBean
     */
    @EJB
    private CustomerManager customerManager;

 
    
    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    /**
     * Retourne les détails du client courant (celui dans l'attribut customer de
     * cette classe), qu'on appelle une propriété (property)
     */
    public Customer getDetails() {
        return customer;
    }

    /**
     * Action handler - met à jour dans la base de données les données du client
     * contenu dans la variable d'instance customer.
     *
     * @return la prochaine page à afficher, celle qui affiche la liste des
     * clients.
     */
    public String update() {
        // Modifie la base de données.
        // Il faut affecter à customer.
        customer = customerManager.update(customer);
        return "CustomerList";
    }

    public void loadCustomer() {
        this.customer = customerManager.getCustomer(idCustomer);
    }
    
    /*public CustomerDetailsMBean() {
    }*/
    
      @EJB
  private DiscountCodeManager discountCodeManager;

  /**
   * getter pour la propriété discountCodeConverter.
   */              
  public Converter<DiscountCode> getDiscountCodeConverter() {
    return new Converter<DiscountCode>() {
      /**
       * Convertit une String en DiscountCode.
       *
       * @param value valeur à convertir
       */
      @Override
      public DiscountCode getAsObject(FacesContext context, UIComponent component, String value) {
        return discountCodeManager.findById(value);
      }

      /**
       * Convertit un DiscountCode en String.
       *
       * @param value valeur à convertir
       */
      @Override
      public String getAsString(FacesContext context, UIComponent component, DiscountCode value) {
        return value.getDiscountCode();
      }
    };
  }
  
}
