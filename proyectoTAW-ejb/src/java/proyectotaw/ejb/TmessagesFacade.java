/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectotaw.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import proyectotaw.entity.Tmessages;

/**
 *
 * @author Alberto
 */
@Stateless
public class TmessagesFacade extends AbstractFacade<Tmessages> implements TmessagesFacadeLocal {
    @PersistenceContext(unitName = "proyectoTAW-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TmessagesFacade() {
        super(Tmessages.class);
    }
    
   
    
}
