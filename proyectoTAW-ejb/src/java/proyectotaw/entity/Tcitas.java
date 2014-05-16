/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectotaw.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alberto
 */
@Entity
@Table(name = "tcitas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tcitas.findAll", query = "SELECT t FROM Tcitas t"),
    @NamedQuery(name = "Tcitas.findById", query = "SELECT t FROM Tcitas t WHERE t.id = :id"),
    @NamedQuery(name = "Tcitas.findByDate", query = "SELECT t FROM Tcitas t WHERE t.date = :date"),
    @NamedQuery(name = "Tcitas.findByImportant", query = "SELECT t FROM Tcitas t WHERE t.important = :important")})
public class Tcitas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "important")
    private boolean important;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "tuserDate", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tusers tuserDate;

    public Tcitas() {
    }

    public Tcitas(Integer id) {
        this.id = id;
    }

    public Tcitas(Integer id, Date date, boolean important) {
        this.id = id;
        this.date = date;
        this.important = important;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean getImportant() {
        return important;
    }

    public void setImportant(boolean important) {
        this.important = important;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Tusers getTuserDate() {
        return tuserDate;
    }

    public void setTuserDate(Tusers tuserDate) {
        this.tuserDate = tuserDate;
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
        if (!(object instanceof Tcitas)) {
            return false;
        }
        Tcitas other = (Tcitas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyectotaw.entity.Tcitas[ id=" + id + " ]";
    }
    
}
