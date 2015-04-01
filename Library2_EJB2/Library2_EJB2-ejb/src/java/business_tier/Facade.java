/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business_tier;

import integration_tier.TBookFacade;
import integration_tier.TTitle_bookFacade;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import sub_business_tier.TFacade;
import sub_business_tier.entities.TBook;
import sub_business_tier.entities.TTitle_book;

/**
 *
 * @author Michal
 */
@Stateless
public class Facade implements FacadeRemote {

    @EJB
    private TTitle_bookFacade tTitle_bookFacade;
    @EJB
    private TBookFacade tBookFacade;

    private TTitle_book titles[];
    private TBook books[];

    TFacade facade = new TFacade();

    @PostConstruct
    @Override
    public void init() {
        try {
            update_data();
        } catch (Exception e) {
        }
    }

    @Override
    public Object[][] gettitle_books() {
        return facade.gettitle_books();
    }

    @Override
    public String add_title_book(String data[]) {
        return facade.add_title_book(data);
    }

    @Override
    public ArrayList<String> add_book(String data1[], String data2[]) {
        return facade.add_book(data1, data2);
    }

    @Override
    public ArrayList<String> Search_title_book(String data[]) {
        return facade.Search_title_book(data);
    }

    @Override
    public String Search_accessible_book(String data1[], Object data2) {
        return facade.Search_accessible_book(data1, data2);
    }

    @Override
    public void update_titles() throws Exception {
        titles = tTitle_bookFacade.getTTitle_books_();
    }

    @Override
    public void update_books() throws Exception {
        books = tBookFacade.getTBooks_();
    }

    @Override
    public void update_data() throws Exception {
        update_titles();
        update_books();
        facade.update_data(titles, books);
    }

    @Override
    public void add_titles() throws Exception {
        tTitle_bookFacade.addTTitle_books(facade.getmTitle_books());
    }

    @Override
    public void add_books() throws Exception {
        tBookFacade.addTBooks(facade.getmTitle_books());
    }

    @Override
    public ArrayList<ArrayList<String>> titles() throws Exception {
        List<TTitle_book> help1 = tTitle_bookFacade.findAll();
        ArrayList<ArrayList<String>> help2;
        help2 = new ArrayList();
        for (TTitle_book t : help1) {
            ArrayList<String> help3 = new ArrayList();
            help3.add(t.getPublisher());
            help3.add(t.getISBN());
            help3.add(t.getTitle());
            help3.add(t.getAuthor());
            help3.add(t.getActor());
            help2.add(help3);
        }
        return help2;
    }
}
