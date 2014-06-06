/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectotaw.ejb;

import java.util.List;
import javax.ejb.Local;
import proyectotaw.entity.Tusers;

/**
 *
 * @author Fco Javier
 */
@Local
public interface TusersFacadeLocal {

    void create(Tusers tusers);

    void edit(Tusers tusers);

    void remove(Tusers tusers);

    Tusers find(Object id);

    List<Tusers> findAll();

    List<Tusers> findRange(int[] range);

    int count();
    
    public Tusers findById(int id);
    
    public List<Tusers> findByPassword(String password);
    
    public Tusers findByNuhsa(String nuhsa);
    
    public List<Tusers> findByName(String name);
    
    public Tusers findByDni(String dni);
    
    public List<Tusers> findByAddress(String address);
}
