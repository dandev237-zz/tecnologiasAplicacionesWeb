/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectotaw.ejb;

import java.util.List;
import javax.ejb.Local;
import proyectotaw.entity.Tcitas;

/**
 *
 * @author Alberto
 */
@Local
public interface TcitasFacadeLocal {

    void create(Tcitas tcitas);

    void edit(Tcitas tcitas);

    void remove(Tcitas tcitas);

    Tcitas find(Object id);

    List<Tcitas> findAll();

    List<Tcitas> findRange(int[] range);

    int count();
    
    List<Tcitas> findByUserId(int id);
}
