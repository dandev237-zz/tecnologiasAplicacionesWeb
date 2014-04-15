/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotaw.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alberto
 */
@Entity
@Table(name = "tpatientinfo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tpatientinfo.findAll", query = "SELECT t FROM Tpatientinfo t"),
    @NamedQuery(name = "Tpatientinfo.findById", query = "SELECT t FROM Tpatientinfo t WHERE t.id = :id"),
    @NamedQuery(name = "Tpatientinfo.findByIdPatient", query = "SELECT t FROM Tpatientinfo t WHERE t.idPatient = :idPatient"),
    @NamedQuery(name = "Tpatientinfo.findByIdMedic", query = "SELECT t FROM Tpatientinfo t WHERE t.idMedic = :idMedic"),
    @NamedQuery(name = "Tpatientinfo.findByIdInfo", query = "SELECT t FROM Tpatientinfo t WHERE t.idInfo = :idInfo")})
public class Tpatientinfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_patient")
    private int idPatient;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_medic")
    private int idMedic;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_info")
    private int idInfo;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Tinfo tinfo;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Tusers tusers;

    public Tpatientinfo() {
    }

    public Tpatientinfo(Integer id) {
        this.id = id;
    }

    public Tpatientinfo(Integer id, int idPatient, int idMedic, int idInfo) {
        this.id = id;
        this.idPatient = idPatient;
        this.idMedic = idMedic;
        this.idInfo = idInfo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    public int getIdMedic() {
        return idMedic;
    }

    public void setIdMedic(int idMedic) {
        this.idMedic = idMedic;
    }

    public int getIdInfo() {
        return idInfo;
    }

    public void setIdInfo(int idInfo) {
        this.idInfo = idInfo;
    }

    public Tinfo getTinfo() {
        return tinfo;
    }

    public void setTinfo(Tinfo tinfo) {
        this.tinfo = tinfo;
    }

    public Tusers getTusers() {
        return tusers;
    }

    public void setTusers(Tusers tusers) {
        this.tusers = tusers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tpatientinfo)) {
            return false;
        }
        Tpatientinfo other = (Tpatientinfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyectotaw.entity.Tpatientinfo[ id=" + id + " ]";
    }
    
}
