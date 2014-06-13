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
@Named(value = "ShowCitasPacienteBean")
@RequestScoped
@ManagedBean
public class ShowCitasPacienteBean {
    @EJB
    private TusersFacadeLocal tusersFacade;
    @EJB
    private TcitasFacadeLocal tcitasFacade;
    
    String nuhsa;
    Tusers paciente;
    ArrayList<Tcitas> citas;

    public ArrayList<Tcitas> getCitas() {
        return citas;
    }

    public void setCitas(ArrayList<Tcitas> citas) {
        this.citas = citas;
    }

    public Tusers getPaciente() {
        return paciente;
    }

    public void setPaciente(Tusers paciente) {
        this.paciente = paciente;
    }
    
    
    
    @PostConstruct
    public void create(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        paciente = (Tusers) session.getAttribute("user");
        citas = new ArrayList<>();
        List<Tcitas> auxCitas;
        auxCitas = tcitasFacade.findAll();
        for(Tcitas c: auxCitas){
            for(Tusers u: c.getTusersCollection()){
                if(u == paciente){
                    citas.add(c);
                }
            }
        }
    }
    
    public String getNuhsa() {
        return nuhsa;
    }

    public void setNuhsa(String nuhsa) {
        this.nuhsa = nuhsa;
    }
    
    public Tusers showMedico (Tcitas cita){
        Tusers medico = new Tusers();
        for( Tusers u: cita.getTusersCollection()){
            if(u.getRol().getId() != 2){
                medico = u;
            }
        }
        return medico;
    }
}
