package proyectotaw.beans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import proyectotaw.ejb.TmessagesFacadeLocal;
import proyectotaw.ejb.TusersFacadeLocal;
import proyectotaw.entity.Tmessages;
import proyectotaw.entity.Tusers;

/**
 *
 * @author Alberto
 */
@Named(value = "messageAction")
@ViewScoped
@ManagedBean
public class MessageAction {

    @EJB
    private TmessagesFacadeLocal tmessagesFacade;
    @EJB
    private TusersFacadeLocal tusersFacade;
    private String dni;
    private String title;
    private String message;
  

  
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void send() {
        System.out.println("DNI->" + dni);
        Tusers receptor = tusersFacade.findByDni(dni);
        FacesContext context = FacesContext.getCurrentInstance();
        if (receptor != null) {
            Tmessages msg = new Tmessages();
            msg.setDescription(message);
            msg.setTitle(title);
            msg.setUserId(receptor);
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            if (session != null) {
                
                Tusers sender = (Tusers) session.getAttribute("user");
                
                if (sender != null) {
                    msg.setSender(sender.getName() + " - " + sender.getDni());
                    tmessagesFacade.create(msg);
                    
                    context.addMessage(null, new FacesMessage("Mensaje enviado", "Autor: " + msg.getSender()));
                } else context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al enviar mensaje",
                        "Autor no encontrado. ¿Quizás la sesión ha caducado?"));
            } else context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al enviar mensaje",
                    "Sesión no encontrada."));
        } else context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Error al enviar mensaje", "Receptor no encontrado."));
        dni = null;
        message = null;
        title = null;
    }
    
   
    
    
}
