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
import proyectotaw.entity.Tinfoextra;
import proyectotaw.entity.Tusers;

/**
 *
 * @author Alberto
 */
@Stateless
public class TinfoextraFacade extends AbstractFacade<Tinfoextra> implements TinfoextraFacadeLocal {
    @PersistenceContext(unitName = "proyectoTAW-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TinfoextraFacade() {
        super(Tinfoextra.class);
    }

    @Override
    public List<Tinfoextra> findByUserId(Tusers user) {
        return em.createNamedQuery("Tinfoextra.findByUserId", Tinfoextra.class)
                .setParameter("id", user.getId()).getResultList();
    }
    
}
