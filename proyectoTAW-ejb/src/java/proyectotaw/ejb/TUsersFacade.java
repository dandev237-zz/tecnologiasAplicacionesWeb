/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectotaw.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import proyectotaw.entity.TUsers;

/**
 *
 * @author infernage
 */
@Stateless
public class TUsersFacade extends AbstractFacade<TUsers> {
    @PersistenceContext(unitName = "proyectoTAW-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TUsersFacade() {
        super(TUsers.class);
    }
    
    public TUsers findById(int id){
        return em.createNamedQuery("TUsers.findById", TUsers.class).getSingleResult();
    }
    
    public TUsers findByUsername(String username){
        return em.createNamedQuery("TUsers.findByUsername", TUsers.class).getSingleResult();
    }
}
