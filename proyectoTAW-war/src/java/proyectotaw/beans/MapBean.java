/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectotaw.beans;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author Alberto
 */
@ManagedBean(name = "mapView")
public class MapBean implements Serializable{

    private MapModel model;

    public MapModel getModel() {
        return model;
    }

    public void setModel(MapModel model) {
        this.model = model;
    }
    
    /**
     * Creates a new instance of MapBean
     */
    public MapBean() {
    }
    
    @PostConstruct
    public void init(){
        model = new DefaultMapModel();
        model.addOverlay(new Marker(new LatLng(36.718582, -4.477851), "Hospital"));
    }
    
}
