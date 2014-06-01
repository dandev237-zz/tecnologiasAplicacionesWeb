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
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
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
@ViewScoped
@ManagedBean
public class ShowForm {
    @EJB
    private TmessagesFacadeLocal tmessagesFacade;
    private List<Tmessages> forms = extractForms();

    public List<Tmessages> getForms() {
            return forms;
    }
    
    public List<Tmessages> extractForms(){
        List<Tmessages> allMessages = tmessagesFacade.findAll();
        List<Tmessages> forms = new ArrayList<Tmessages>();
        
        for(int i=0;i<allMessages.size();i++){
            if(allMessages.get(i).getUserId().getRol().getId()==0){
                forms.add(allMessages.get(i));
            }
        }
        
        return forms;
    }
}
