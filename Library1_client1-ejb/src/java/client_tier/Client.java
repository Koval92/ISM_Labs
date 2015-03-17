package client_tier;

import business_tier.FacadeRemote;
import javax.ejb.EJB;
import library.Panel_util;

public class Client {
    @EJB
    private static FacadeRemote facade;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
        Panel_util.createAndShowGUI();
        }
});
    }
    
    public static FacadeRemote getFacade() {
        return facade;
    }

    public static void setFacade(FacadeRemote facade) {
        Client.facade = facade;
    }
}
