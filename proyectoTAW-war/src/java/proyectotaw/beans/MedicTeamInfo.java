/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectotaw.beans;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import proyectotaw.ejb.TusersFacadeLocal;
import proyectotaw.entity.Tusers;

/**
 *
 * @author Fco Javier
 */
@Named(value = "medicTeamInfo")
@Dependent
public class MedicTeamInfo {
    @EJB
    private TusersFacadeLocal tusersFacade;
    List<Tusers> medics = new ArrayList<>(((Tusers) 
            ((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false))
                    .getAttribute("user")).getTusersCollection()); 

    public List<Tusers> getMedics() {
        return medics;
    }

    public void setMedics(List<Tusers> medics) {
        this.medics = medics;
    }

    /**
     * Creates a new instance of MedicTeamInfo
     */
    public MedicTeamInfo() {
    }
    
    
    
}
