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
@Table(name = "tmessages")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tmessages.findAll", query = "SELECT t FROM Tmessages t"),
    @NamedQuery(name = "Tmessages.findById", query = "SELECT t FROM Tmessages t WHERE t.id = :id"),
    @NamedQuery(name = "Tmessages.findByTitle", query = "SELECT t FROM Tmessages t WHERE t.title = :title"),
    @NamedQuery(name = "Tmessages.findBySender", query = "SELECT t FROM Tmessages t WHERE t.sender = :sender")})
public class Tmessages implements Serializable {
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
    @Size(min = 1, max = 45)
    @Column(name = "sender")
    private String sender;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "userId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tusers userId;

    public Tmessages() {
    }

    public Tmessages(Integer id) {
        this.id = id;
    }

    public Tmessages(Integer id, String title, String sender) {
        this.id = id;
        this.title = title;
        this.sender = sender;
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

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
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
        if (!(object instanceof Tmessages)) {
            return false;
        }
        Tmessages other = (Tmessages) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyectotaw.entity.Tmessages[ id=" + id + " ]";
    }
    
}
