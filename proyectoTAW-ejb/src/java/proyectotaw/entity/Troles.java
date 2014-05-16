/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectotaw.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alberto
 */
@Entity
@Table(name = "troles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Troles.findAll", query = "SELECT t FROM Troles t"),
    @NamedQuery(name = "Troles.findById", query = "SELECT t FROM Troles t WHERE t.id = :id"),
    @NamedQuery(name = "Troles.findByName", query = "SELECT t FROM Troles t WHERE t.name = :name")})
public class Troles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rol")
    private Collection<Tusers> tusersCollection;

    public Troles() {
    }

    public Troles(Integer id) {
        this.id = id;
    }

    public Troles(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Tusers> getTusersCollection() {
        return tusersCollection;
    }

    public void setTusersCollection(Collection<Tusers> tusersCollection) {
        this.tusersCollection = tusersCollection;
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
        if (!(object instanceof Troles)) {
            return false;
        }
        Troles other = (Troles) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyectotaw.entity.Troles[ id=" + id + " ]";
    }
    
}
