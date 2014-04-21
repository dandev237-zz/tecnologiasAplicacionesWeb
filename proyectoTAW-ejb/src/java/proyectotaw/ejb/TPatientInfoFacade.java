/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectotaw.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import proyectotaw.entity.TPatientInfo;

/**
 *
 * @author infernage
 */
@Stateless
public class TPatientInfoFacade extends AbstractFacade<TPatientInfo> {
    @PersistenceContext(unitName = "proyectoTAW-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TPatientInfoFacade() {
        super(TPatientInfo.class);
    }
    
}
