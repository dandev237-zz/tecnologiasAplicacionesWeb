/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectotaw.ejb;

import java.util.List;
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

    @Override
    public List<Tmessages> findByReceiverRol(int rol) {
        return em.createNamedQuery("Tmessages.findByReceiverRol", Tmessages.class).setParameter("rol", rol).getResultList();
    }

    @Override
    public Tmessages findByTitle(String title) {
        return em.createNamedQuery("Tmessages.findByTitle", Tmessages.class).setParameter("title", title)
                .getSingleResult();
    }
    
}
