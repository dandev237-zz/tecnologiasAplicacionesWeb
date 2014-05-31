/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectotaw.beans;

import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import proyectotaw.ejb.TmessagesFacadeLocal;
import proyectotaw.ejb.TusersFacadeLocal;
import proyectotaw.entity.Tmessages;
import proyectotaw.entity.Tusers;

/**
 *
 * @author Fco Javier
 */
@Named(value = "formAction")
@Dependent
public class FormAction {
    @EJB
    private TusersFacadeLocal tusersFacade;
    @EJB
    private TmessagesFacadeLocal tmessagesFacade;
    private String title;
    private String description;
    private boolean anom;

    public boolean isAnom() {
        return anom;
    }

    public void setAnom(boolean anom) {
        this.anom = anom;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
   
    public void sendForm(){
        List<Tusers> allUsers = tusersFacade.findAll();
        Random rnd = new Random();
        Tusers admin;
        do{
            admin = allUsers.get(rnd.nextInt(allUsers.get(allUsers.size()-1).getRol().getId()));
        }while(admin.getRol().getId()!=0);
        
        Tmessages message = new Tmessages();
        message.setTitle(title);
        message.setUserId(admin);
        message.setDescription(description);
        if(this.isAnom()){
            message.setSender("Anónimo");
        }else{
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            Tusers sender = (Tusers) session.getAttribute("user");
            message.setSender(sender.getName());
        }
        tmessagesFacade.create(message);
    }
}
