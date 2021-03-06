/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation_tier;

import business_tier.FacadeRemote;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;


@ManagedBean
@RequestScoped
public class Managed_Bean1 {

    @EJB
    private FacadeRemote facade;

    private DataModel items;

    public Managed_Bean1() {
    }

    public FacadeRemote getFacade() {
        return facade;
    }

    public void setFacade(FacadeRemote facade) {
        this.facade = facade;
    }

    public String store_data() {
        try {
            facade.add_titles();
            facade.add_books();
        } catch (Exception e) {
        }
        return "/faces/index2";
    }

    public String show_data() {
        create_DataModel();
        return "/faces/presentation_tier_view/Show_data";
    }

    public DataModel create_DataModel() {
        try {
            return new ListDataModel(facade.titles());
        } catch (Exception e) {
            System.out.println("Blad");
            return null;
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = create_DataModel();
        }
        return items;
    }

    public void setItems(DataModel items) {
        this.items = items;
    }
}
