/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectotaw.ejb;

import java.util.List;
import javax.ejb.Local;
import proyectotaw.entity.Tinfoextra;
import proyectotaw.entity.Tusers;

/**
 *
 * @author Alberto
 */
@Local
public interface TinfoextraFacadeLocal {

    void create(Tinfoextra tinfoextra);

    void edit(Tinfoextra tinfoextra);

    void remove(Tinfoextra tinfoextra);

    Tinfoextra find(Object id);

    List<Tinfoextra> findAll();

    List<Tinfoextra> findRange(int[] range);

    int count();
    
    List<Tinfoextra> findByUserId(Tusers user);
}
