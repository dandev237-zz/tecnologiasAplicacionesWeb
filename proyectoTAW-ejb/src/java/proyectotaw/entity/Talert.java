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
import javax.persistence.Lob;
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
@Table(name = "talert")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Talert.findAll", query = "SELECT t FROM Talert t"),
    @NamedQuery(name = "Talert.findById", query = "SELECT t FROM Talert t WHERE t.id = :id"),
    @NamedQuery(name = "Talert.findByTitle", query = "SELECT t FROM Talert t WHERE t.title = :title"),
    @NamedQuery(name = "Talert.findByImportant", query = "SELECT t FROM Talert t WHERE t.important = :important")})
public class Talert implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Column(name = "important")
    private boolean important;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "tuserAlert", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tusers tuserAlert;

    public Talert() {
    }

    public Talert(Integer id) {
        this.id = id;
    }

    public Talert(Integer id, String title, boolean important) {
        this.id = id;
        this.title = title;
        this.important = important;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Tusers getTuserAlert() {
        return tuserAlert;
    }

    public void setTuserAlert(Tusers tuserAlert) {
        this.tuserAlert = tuserAlert;
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
        if (!(object instanceof Talert)) {
            return false;
        }
        Talert other = (Talert) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyectotaw.entity.Talert[ id=" + id + " ]";
    }
    
}
