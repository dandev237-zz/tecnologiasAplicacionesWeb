/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectotaw.ejb;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import proyectotaw.entity.Talert;
import proyectotaw.entity.Tusers;

/**
 *
 * @author Alberto
 */
@Local
public interface TalertFacadeLocal {

    void create(Talert talert);

    void edit(Talert talert);

    void remove(Talert talert);

    Talert find(Object id);

    List<Talert> findAll();

    List<Talert> findRange(int[] range);

    int count();
    
    void insertAlert(boolean important, String description, String title, Tusers user);
}
