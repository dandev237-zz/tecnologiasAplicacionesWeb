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
import proyectotaw.entity.Tcitas;

/**
 *
 * @author Alberto
 */
@Stateless
public class TcitasFacade extends AbstractFacade<Tcitas> implements TcitasFacadeLocal {
    @PersistenceContext(unitName = "proyectoTAW-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TcitasFacade() {
        super(Tcitas.class);
    }

    @Override
    public List<Tcitas> findByUserId(int id) {
        return em.createNamedQuery("Tcitas.findByUserId", Tcitas.class).setParameter("id", id)
                .getResultList();
    }

    @Override
    public Tcitas findById(int id) {
        return em.createNamedQuery("Tcitas.findById", Tcitas.class).setParameter("id", id)
                .getSingleResult();
    }
    
}
