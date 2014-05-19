/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotaw.beans;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import proyectotaw.ejb.TusersFacadeLocal;
import proyectotaw.entity.Talert;
import proyectotaw.entity.Tusers;

/**
 *
 * @author Alberto
 */
@Named(value = "modifyAlert")
@ManagedBean
@ViewScoped
public class ModifyAlert {

    @EJB
    private TusersFacadeLocal tusersFacade;
    private String nuhsa;
    private List<Talert> alerts = new ArrayList<>();
    private Tusers user;

    public List<Talert> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<Talert> alerts) {
        this.alerts = alerts;
    }

    public String getNuhsa() {
        return nuhsa;
    }

    public void setNuhsa(String nuhsa) {
        this.nuhsa = nuhsa;
    }

    public void findByNuhsa() {
        if (nuhsa != null) {
            user = tusersFacade.findByNuhsa(nuhsa);
            if (user != null) alerts.addAll(user.getTalertCollection());
        }
    }

    public void save() {
        if (alerts.isEmpty() || user == null){
            findByNuhsa();
        }
        if (!alerts.isEmpty() && user != null){
            user.setTalertCollection(alerts);
            tusersFacade.edit(user);
        }
        alerts.clear();
        user = null;
        nuhsa = null;
    }
}
