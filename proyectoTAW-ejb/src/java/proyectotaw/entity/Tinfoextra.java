/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectotaw.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alberto
 */
@Entity
@Table(name = "tinfoextra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tinfoextra.findByUserId", query = "SELECT t FROM Tinfoextra t WHERE t.userId.id = :id"),
    @NamedQuery(name = "Tinfoextra.findAll", query = "SELECT t FROM Tinfoextra t"),
    @NamedQuery(name = "Tinfoextra.findById", query = "SELECT t FROM Tinfoextra t WHERE t.id = :id"),
    @NamedQuery(name = "Tinfoextra.findByType", query = "SELECT t FROM Tinfoextra t WHERE t.type = :type"),
    @NamedQuery(name = "Tinfoextra.findByDescription", query = "SELECT t FROM Tinfoextra t WHERE t.description = :description")})
public class Tinfoextra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "type")
    private int type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "userId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tusers userId;

    public Tinfoextra() {
    }

    public Tinfoextra(Integer id) {
        this.id = id;
    }

    public Tinfoextra(Integer id, int type, String description) {
        this.id = id;
        this.type = type;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Tusers getUserId() {
        return userId;
    }

    public void setUserId(Tusers userId) {
        this.userId = userId;
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
        if (!(object instanceof Tinfoextra)) {
            return false;
        }
        Tinfoextra other = (Tinfoextra) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyectotaw.entity.Tinfoextra[ id=" + id + " ]";
    }
    
}
