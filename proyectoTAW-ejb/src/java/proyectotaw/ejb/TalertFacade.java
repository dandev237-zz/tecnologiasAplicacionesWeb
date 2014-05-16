/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectotaw.ejb;

import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import proyectotaw.entity.Talert;
import proyectotaw.entity.Tusers;

/**
 *
 * @author Alberto
 */
@Stateless
public class TalertFacade extends AbstractFacade<Talert> implements TalertFacadeLocal {
    @PersistenceContext(unitName = "proyectoTAW-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TalertFacade() {
        super(Talert.class);
    }

    @Override
    public void insertAlert(boolean important, String description, String title, Tusers user) {
        em.getTransaction().begin();
        Talert alert = new Talert();
        alert.setTitle(title);
        alert.setDescription(description);
        alert.setImportant(important);
        alert.setTuserAlert(user);
        create(alert);
        em.getTransaction().commit();
    }
    
}
