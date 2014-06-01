/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectotaw.ejb;

import java.util.List;
import javax.ejb.Local;
import proyectotaw.entity.Tmessages;

/**
 *
 * @author Alberto
 */
@Local
public interface TmessagesFacadeLocal {

    void create(Tmessages tmessages);

    void edit(Tmessages tmessages);

    void remove(Tmessages tmessages);

    Tmessages find(Object id);

    List<Tmessages> findAll();

    List<Tmessages> findRange(int[] range);
    
    List<Tmessages> findByReceiverRol(int rol);
    
    Tmessages findByTitle(String title);
    
    int count();

    
}
