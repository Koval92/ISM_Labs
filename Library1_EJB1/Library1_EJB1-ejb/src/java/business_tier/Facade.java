/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business_tier;

import java.util.ArrayList;
import javax.ejb.Stateless;
import sub_business_tier.TFacade;

@Stateless
public class Facade implements FacadeRemote {
    TFacade facade = new TFacade();
    @Override
    public Object[][] gettitle_books() {
        return facade.gettitle_books(); }
    @Override
    public String add_title_book(String data[]) {
        return facade.add_title_book(data); }
    @Override
    public ArrayList<String> add_book(String data1[], String data2[]) {
        return facade.add_book(data1, data2); }
    @Override
    public ArrayList<String> Search_title_book(String data[]) {
        return facade.Search_title_book(data); }
    @Override
    public String Search_accessible_book(String data1[], Object data2) {
        return facade.Search_accessible_book(data1, data2); }
    @Override
    public ArrayList<String> add_client(String[] data) {
        return facade.add_client(data);
    }
    @Override
    public Object[][] getClientsTable() {
        return facade.getClientsTable();
    }
    @Override
    public ArrayList<String> add_loan(String[] clientData, String[] titleBookData) {
        return facade.add_loan(clientData, titleBookData);
    }
    @Override
    public ArrayList<String> searchClientsLoans(String[] data) {
        return facade.searchClientsLoans(data);
    }
}
