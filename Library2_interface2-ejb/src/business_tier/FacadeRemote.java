/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business_tier;

import java.util.ArrayList;
import javax.ejb.Remote;

/**
 *
 * @author Michal
 */
@Remote
public interface FacadeRemote {
    public Object[][] gettitle_books();
    public String add_title_book(String data[]);
    public ArrayList<String> add_book(String data1[], String data2[]);
    public ArrayList<String> Search_title_book(String data[]);
    public String Search_accessible_book(String data1[], Object data2);
    
    public void init();
    public void update_titles() throws Exception;
    public void update_books() throws Exception;
    public void update_data() throws Exception;
    public void add_titles() throws Exception;
    public void add_books() throws Exception;
    public ArrayList<ArrayList<String>> titles() throws Exception;
}
