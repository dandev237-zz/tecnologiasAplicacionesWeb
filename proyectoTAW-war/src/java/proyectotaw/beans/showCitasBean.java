/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectotaw.beans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import proyectotaw.ejb.TcitasFacadeLocal;
import proyectotaw.ejb.TusersFacadeLocal;
import proyectotaw.entity.Tcitas;
import proyectotaw.entity.Tusers;

/**
 *
 * @author Fco Javier
 */
@Named(value = "showCitasBean")
@RequestScoped
@ManagedBean
public class showCitasBean {
    @EJB
    private TusersFacadeLocal tusersFacade;
    @EJB
    private TcitasFacadeLocal tcitasFacade;   
    List<Tcitas> citas;
    boolean medico;
    String nuhsa;
    
    @PostConstruct
    public void create(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Tusers user = (Tusers) session.getAttribute("user");
        medico = user.getRol().getId() == 0;
    }

    public boolean isMedico() {
        return medico;
    }

    public void setMedico(boolean medico) {
        this.medico = medico;
    }

    public String getNuhsa() {
        return nuhsa;
    }

    public void setNuhsa(String nuhsa) {
        this.nuhsa = nuhsa;
    }

    public List<Tcitas> getCitas() {
        return citas;
    }
    
    public void mostrarCitas(){
        Tusers paciente = tusersFacade.findByNuhsa(nuhsa);
        citas = new ArrayList<>(paciente.getTcitasCollection());
    }
    
    /**
     * Creates a new instance of showCitasBean
     */
    public showCitasBean() {
        
    }
    
}
