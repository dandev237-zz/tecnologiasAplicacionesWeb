/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectotaw.beans;

import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import proyectotaw.ejb.TinfoextraFacadeLocal;
import proyectotaw.ejb.TusersFacadeLocal;
import proyectotaw.entity.Tinfoextra;
import proyectotaw.entity.Tusers;

/**
 *
 * @author Alberto
 */
@Named(value = "modifyGeneralPatientInfo")
@ManagedBean
@ViewScoped
public class ModifyGeneralPatientInfo {
    @EJB
    private TinfoextraFacadeLocal tinfoextraFacade;
    @EJB
    private TusersFacadeLocal tusersFacade;
    private String nuhsa;
    private Tusers user;
    private Collection<Tinfoextra> infoExtra;
    private String descripcionTemporal;

    public String getDescripcionTemporal() {
        return descripcionTemporal;
    }

    public void setDescripcionTemporal(String descripcionTemporal) {
        this.descripcionTemporal = descripcionTemporal;
    }

    public Collection<Tinfoextra> getInfoExtra() {
        return infoExtra;
    }

    public void setInfoExtra(Collection<Tinfoextra> infoExtra) {
        this.infoExtra = infoExtra;
    }

    public void addInfoExtra()
    {
        Tinfoextra t=new Tinfoextra();
        t.setDescription(descripcionTemporal);
        t.setType(0);
        t.setUserId(user);
        tinfoextraFacade.create(t);
        infoExtra.add(t);
    }
    
    public void deleteInfoExtra(Tinfoextra t)
    {
        infoExtra.remove(t);
        tinfoextraFacade.remove(t);
    }
    
    public String getNuhsa() {
        return nuhsa;
       
    }

    public void setNuhsa(String nuhsa) {
        this.nuhsa = nuhsa;
    }

    public Tusers getUser() {
        return user;
    }

    public void setUser(Tusers user) {
        this.user = user;
    }  
    
    public void findByNuhsa() {
        if (nuhsa != null) {
            user = tusersFacade.findByNuhsa(nuhsa); 
            if(user !=null)
            {
                infoExtra=user.getTinfoextraCollection();
            }
        }
    }
    
    /**
     * Creates a new instance of ModifyGeneralPatientInfo
     */
    public ModifyGeneralPatientInfo() {
    }
    
}
