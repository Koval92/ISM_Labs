/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration_tier;

import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sub_business_tier.entities.TBook;
import sub_business_tier.entities.TTitle_book;

/**
 *
 * @author Michal
 */
@Stateless
public class TBookFacade extends AbstractFacade<TBook> {
    @PersistenceContext(unitName = "Library2_EJB2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TBookFacade() {
        super(TBook.class);
    }
    
    public TBook[] getTBooks_() { 
        return findAll().toArray(new TBook[0]); 
    }
    
    public void addTBooks(List<TTitle_book> titles) {
        TBook newBook;
        Iterator<TTitle_book> it = titles.iterator();
        while (it.hasNext()) {
            TTitle_book newTitle_book = it.next();
            if (newTitle_book.getId() == null) {
                continue; }
            Iterator<TBook> it_ = newTitle_book.getmBooks().iterator();
            while (it_.hasNext()) {
            newBook = it_.next();
            if (newBook.getId() == null) {
                getEntityManager().persist(newBook); }
            }
        }
    }
    
}
