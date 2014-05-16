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
import proyectotaw.entity.Tusers;

/**
 *
 * @author Alberto
 */
@Stateless
public class TusersFacade extends AbstractFacade<Tusers> implements TusersFacadeLocal {
    @PersistenceContext(unitName = "proyectoTAW-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TusersFacade() {
        super(Tusers.class);
    }

    @Override
    public Tusers findById(int id){
        return em.createNamedQuery("Tusers.findById", Tusers.class).setParameter("id", id)
                .getSingleResult();
    }
    
    @Override
    public List<Tusers> findByPassword(String password){
        return em.createNamedQuery("Tusers.findByPassword", Tusers.class)
                .setParameter("password", password).getResultList();
    }
    
    @Override
    public Tusers findByNuhsa(String nuhsa){
        return em.createNamedQuery("Tusers.findByNuhsa", Tusers.class).setParameter("nuhsa", nuhsa)
                .getSingleResult();
    }
    
    @Override
    public List<Tusers> findByName(String name){
        return em.createNamedQuery("Tusers.findByName", Tusers.class).setParameter("name", name)
                .getResultList();
    }
    
    @Override
    public Tusers findByDni(String dni){
        return em.createNamedQuery("Tusers.findByDni", Tusers.class).setParameter("dni", dni)
                .getSingleResult();
    }
    
    @Override
    public List<Tusers> findByAddress(String address){
        return em.createNamedQuery("Tusers.findByAddress", Tusers.class).setParameter("address", address)
                .getResultList();
    }
}
