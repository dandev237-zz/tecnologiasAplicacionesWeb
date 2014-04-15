/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotaw.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import proyectotaw.entity.Tinfo;

/**
 *
 * @author Alberto
 */
@Stateless
public class TinfoFacade extends AbstractFacade<Tinfo> {
    @PersistenceContext(unitName = "proyectoTAW-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TinfoFacade() {
        super(Tinfo.class);
    }
    
}
