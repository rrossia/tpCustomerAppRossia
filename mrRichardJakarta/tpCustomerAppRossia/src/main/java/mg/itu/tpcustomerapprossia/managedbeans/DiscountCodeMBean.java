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
import mg.itu.tpcustomerapprossia.entities.DiscountCode;
import mg.itu.tpcustomerapprossia.session.DiscountCodeManager;

/**
 *
 * @author Rossia
 */
@Named
@ViewScoped
public class DiscountCodeMBean implements Serializable { 
private List<DiscountCode>  discountCodeList;
    /**
     * Creates a new instance of DiscountCodeMBean
     */
     /**
   * Retourne la liste de tous les DiscountCode.
   */

    @EJB
    private DiscountCodeManager discountCodeManager;
  
    
    public List<DiscountCode> getDiscountCodes() {
        discountCodeList=discountCodeManager.getAllDiscountCodes();
        return discountCodeList;
    }
    
}
