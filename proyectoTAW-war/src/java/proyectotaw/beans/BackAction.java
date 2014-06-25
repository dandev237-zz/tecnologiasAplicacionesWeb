/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectotaw.beans;

import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;

/**
 *
 * @author Alberto
 */
@Named(value = "backAction")
@Dependent
public class BackAction {

    /**
     * Creates a new instance of BackAction
     */
    public BackAction() {
    }
    
    public void goToMenu() throws IOException{
        FacesContext.getCurrentInstance().getExternalContext().redirect("menu");
    }
}
