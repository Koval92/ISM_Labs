/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration_tier;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sub_business_tier.entities.TTitle_book;

/**
 *
 * @author Michal
 */
@Stateless
public class TTitle_bookFacade extends AbstractFacade<TTitle_book> {
    @PersistenceContext(unitName = "Library2_EJB2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TTitle_bookFacade() {
        super(TTitle_book.class);
    }
    
}
