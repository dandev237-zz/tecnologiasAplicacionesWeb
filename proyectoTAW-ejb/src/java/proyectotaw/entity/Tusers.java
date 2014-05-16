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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tusers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tusers.findAll", query = "SELECT t FROM Tusers t"),
    @NamedQuery(name = "Tusers.findById", query = "SELECT t FROM Tusers t WHERE t.id = :id"),
    @NamedQuery(name = "Tusers.findByDni", query = "SELECT t FROM Tusers t WHERE t.dni = :dni"),
    @NamedQuery(name = "Tusers.findByPassword", query = "SELECT t FROM Tusers t WHERE t.password = :password"),
    @NamedQuery(name = "Tusers.findByNuhsa", query = "SELECT t FROM Tusers t WHERE t.nuhsa = :nuhsa"),
    @NamedQuery(name = "Tusers.findByName", query = "SELECT t FROM Tusers t WHERE t.name = :name"),
    @NamedQuery(name = "Tusers.findByAddress", query = "SELECT t FROM Tusers t WHERE t.address = :address")})
public class Tusers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "dni")
    private String dni;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nuhsa")
    private String nuhsa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "address")
    private String address;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Tinfoextra> tinfoextraCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tuserDate")
    private Collection<Tcitas> tcitasCollection;
    @OneToMany(mappedBy = "medicTeam")
    private Collection<Tusers> tusersCollection;
    @JoinColumn(name = "medicTeam", referencedColumnName = "id")
    @ManyToOne
    private Tusers medicTeam;
    @JoinColumn(name = "rol", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Troles rol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tuserAlert")
    private Collection<Talert> talertCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Tmessages> tmessagesCollection;

    public Tusers() {
    }

    public Tusers(Integer id) {
        this.id = id;
    }

    public Tusers(Integer id, String dni, String password, String nuhsa, String name) {
        this.id = id;
        this.dni = dni;
        this.password = password;
        this.nuhsa = nuhsa;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNuhsa() {
        return nuhsa;
    }

    public void setNuhsa(String nuhsa) {
        this.nuhsa = nuhsa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @XmlTransient
    public Collection<Tinfoextra> getTinfoextraCollection() {
        return tinfoextraCollection;
    }

    public void setTinfoextraCollection(Collection<Tinfoextra> tinfoextraCollection) {
        this.tinfoextraCollection = tinfoextraCollection;
    }

    @XmlTransient
    public Collection<Tcitas> getTcitasCollection() {
        return tcitasCollection;
    }

    public void setTcitasCollection(Collection<Tcitas> tcitasCollection) {
        this.tcitasCollection = tcitasCollection;
    }

    @XmlTransient
    public Collection<Tusers> getTusersCollection() {
        return tusersCollection;
    }

    public void setTusersCollection(Collection<Tusers> tusersCollection) {
        this.tusersCollection = tusersCollection;
    }

    public Tusers getMedicTeam() {
        return medicTeam;
    }

    public void setMedicTeam(Tusers medicTeam) {
        this.medicTeam = medicTeam;
    }

    public Troles getRol() {
        return rol;
    }

    public void setRol(Troles rol) {
        this.rol = rol;
    }

    @XmlTransient
    public Collection<Talert> getTalertCollection() {
        return talertCollection;
    }

    public void setTalertCollection(Collection<Talert> talertCollection) {
        this.talertCollection = talertCollection;
    }

    @XmlTransient
    public Collection<Tmessages> getTmessagesCollection() {
        return tmessagesCollection;
    }

    public void setTmessagesCollection(Collection<Tmessages> tmessagesCollection) {
        this.tmessagesCollection = tmessagesCollection;
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
