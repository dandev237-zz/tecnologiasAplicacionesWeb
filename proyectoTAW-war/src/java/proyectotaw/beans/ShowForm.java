/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotaw.beans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
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
    
    private String title;
    private String description;
    private boolean mostrar;

    @PostConstruct
    public void create() {
        forms = new ArrayList<>(tmessagesFacade.findByReceiverRol(0));
        mostrar = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitleAndDescription(Tmessages mensaje) {
        title = mensaje.getTitle();
        description = mensaje.getDescription();
        mostrar = true;
    }
    

    public String getDescription() {
        return description;
    }

    public boolean isMostrar() {
        return mostrar;
    }
    
    public List<Tmessages> getForms() {
        return forms;
    }

    public void borrarMensaje() {
        Tmessages mensaje = tmessagesFacade.findByTitle(title).get(0);
        tmessagesFacade.remove(mensaje);
        forms.remove(mensaje);
        mostrar = false;
    }

}
