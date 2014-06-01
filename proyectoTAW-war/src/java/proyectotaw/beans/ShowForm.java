/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectotaw.beans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import proyectotaw.ejb.TmessagesFacadeLocal;
import proyectotaw.entity.Tmessages;

/**
 *
 * @author Fco Javier
 */
@Named(value = "showForm")
@SessionScoped
@ManagedBean
public class ShowForm {
    @EJB
    private TmessagesFacadeLocal tmessagesFacade;
    private List<Tmessages> forms;
    private Tmessages mensaje;

    @PostConstruct
    public void create(){
        forms = new ArrayList<>(tmessagesFacade.findByReceiverRol(0));
    }
    
    public String outcome(){
        FacesContext fc = FacesContext.getCurrentInstance();
        this.mensaje = tmessagesFacade.findByTitle(obtenerMensaje(fc));
        
        return "showFormContent";
    }
    
    public List<Tmessages> getForms() {
            return forms;
    }
    
    public void borrarMensaje(){
        tmessagesFacade.remove(mensaje);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("showForms.jsf");
        } catch (IOException ex) {
            Logger.getLogger(ShowForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String obtenerMensaje(FacesContext fc) {
        return fc.getExternalContext().getRequestParameterMap().get("mensaje");
    }

    public Tmessages getMensaje() {
        return mensaje;
    }
    
    
}
