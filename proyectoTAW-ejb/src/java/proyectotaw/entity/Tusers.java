/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotaw.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alberto
 */
@Entity
@Table(name = "tusers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tusers.findAll", query = "SELECT t FROM Tusers t"),
    @NamedQuery(name = "Tusers.findById", query = "SELECT t FROM Tusers t WHERE t.id = :id"),
    @NamedQuery(name = "Tusers.findByUsername", query = "SELECT t FROM Tusers t WHERE t.username = :username"),
    @NamedQuery(name = "Tusers.findByPassword", query = "SELECT t FROM Tusers t WHERE t.password = :password")})
public class Tusers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "password")
    private String password;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tusers")
    private Tpatientinfo tpatientinfo;
    @JoinColumn(name = "rol", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Troles rol;

    public Tusers() {
    }

    public Tusers(Integer id) {
        this.id = id;
    }

    public Tusers(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Tpatientinfo getTpatientinfo() {
        return tpatientinfo;
    }

    public void setTpatientinfo(Tpatientinfo tpatientinfo) {
        this.tpatientinfo = tpatientinfo;
    }

    public Troles getRol() {
        return rol;
    }

    public void setRol(Troles rol) {
        this.rol = rol;
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
        if (!(object instanceof Tusers)) {
            return false;
        }
        Tusers other = (Tusers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyectotaw.entity.Tusers[ id=" + id + " ]";
    }
    
}
