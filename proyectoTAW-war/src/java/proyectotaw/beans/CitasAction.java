/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectotaw.beans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import proyectotaw.ejb.TcitasFacadeLocal;
import proyectotaw.ejb.TusersFacadeLocal;
import proyectotaw.entity.Talert;
import proyectotaw.entity.Tcitas;
import proyectotaw.entity.Tusers;

/**
 *
 * @author D
 */
@Named(value = "CitasAction")
@ViewScoped
@ManagedBean
public class CitasAction {
    @EJB
    private TusersFacadeLocal tusersFacade;
    @EJB
    private TcitasFacadeLocal tcitasFacade;

    
    private List<Talert> listaAlertas;
    private Date fecha;
    private String description;
    private boolean important;
    private Tusers paciente;
    private String nuhsaPaciente;

    public String getNuhsaPaciente() {
        return nuhsaPaciente;
    }

    public void setNuhsaPaciente(String nuhsaPaciente) {
        this.nuhsaPaciente = nuhsaPaciente;
    }

    
    public List<Talert> getListaAlertas() {
        return listaAlertas;
    }

    public void setListaAlertas(List<Talert> listaAlertas) {
        this.listaAlertas = listaAlertas;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isImportant() {
        return important;
    }

    public void setImportant(boolean important) {
        this.important = important;
    }

    public Tusers getPaciente() {
        return paciente;
    }

    public void setPaciente(Tusers paciente) {
        this.paciente = paciente;
    }
    
    public void crearCita() throws IOException{
        Tcitas cita = new Tcitas();
        List<Tusers> users = new ArrayList<>();
        
        Tusers paciente;
        paciente=tusersFacade.findByNuhsa(nuhsaPaciente);
        
        cita.setDate(fecha);
        cita.setDescription(description);
        cita.setImportant(important);
        
        users.add(paciente);
        
         HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
         
        users.add((Tusers) session.getAttribute("user"));
       
        cita.setTusersCollection(users);
        tcitasFacade.create(cita);
        
        FacesContext.getCurrentInstance().getExternalContext().redirect("menuM.jsp");
    }
    
    
    
    

    public CitasAction() {
    }
    
}
