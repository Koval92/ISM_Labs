package client_tier;

import library.Panel_util;
import sub_business_tier.TFacade;

public class Client {
   static TFacade facade = new TFacade();

    static public TFacade getFacade() {
        return facade; }

    static public void setFacade(TFacade facade) {
        Client.facade = facade; }
    
    public static void main(String[] args) {
       java.awt.EventQueue.invokeLater(() -> {
           Panel_util.createAndShowGUI();
       });
    } 
}
