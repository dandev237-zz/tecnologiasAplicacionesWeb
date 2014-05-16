/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectotaw.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import proyectotaw.entity.Troles;

/**
 *
 * @author Alberto
 */
@Stateless
public class TrolesFacade extends AbstractFacade<Troles> implements TrolesFacadeLocal {
    @PersistenceContext(unitName = "proyectoTAW-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TrolesFacade() {
        super(Troles.class);
    }

    @Override
    public Troles findById(int id) {
        return em.createNamedQuery("Troles.findById", Troles.class).getSingleResult();
    }

    @Override
    public Troles findByName(String name) {
        return em.createNamedQuery("Troles.findByName", Troles.class).getSingleResult();
    }
    
}
