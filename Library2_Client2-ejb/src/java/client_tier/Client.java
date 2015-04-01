/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_tier;

import business_tier.FacadeRemote;
import javax.ejb.EJB;
import library.Panel_util;

public class Client {

    @EJB
    private static FacadeRemote facade;

    public static FacadeRemote getFacade() {
        return facade;
    }

    public static void setFacade(FacadeRemote facade) {
        Client.facade = facade;
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Panel_util.createAndShowGUI();
            }
        });
    }

}
