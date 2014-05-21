/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectotaw.beans;

import java.util.Collection;
import javax.ejb.EJB;
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
    private String description;
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Tinfoextra> getInfoExtra() {
        return infoExtra;
    }

    public void setInfoExtra(Collection<Tinfoextra> infoExtra) {
        this.infoExtra = infoExtra;
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
            System.out.println("A");
            user = tusersFacade.findByNuhsa(nuhsa); 
            if(user !=null)
            {
            System.out.println("A");
                infoExtra=user.getTinfoextraCollection();
            }
        }
    }

    public void addInfoExtra()
    {
        if (user == null || description == null) return;
        Tinfoextra t=new Tinfoextra();
        t.setDescription(description);
        t.setType(0);
        t.setUserId(user);
        infoExtra.add(t);
        tinfoextraFacade.create(t);
        tusersFacade.edit(user);
    }
    
    public void modifyInfo(){
        if (user == null) return;
        tusersFacade.edit(user);
    }
    
    public void deleteInfoExtra(Tinfoextra t)
    {
        if (user == null || description == null) return;
        infoExtra.remove(t);
        tinfoextraFacade.remove(t);
        tusersFacade.edit(user);
    }
}
