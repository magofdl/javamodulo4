/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cec.usuario.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
 * @author CEC
 */
@Entity
@Table(name = "user_rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserRol.findAll", query = "SELECT u FROM UserRol u"),
    @NamedQuery(name = "UserRol.findByRolId", query = "SELECT u FROM UserRol u WHERE u.rolId = :rolId"),
    @NamedQuery(name = "UserRol.findByRolNombre", query = "SELECT u FROM UserRol u WHERE u.rolNombre = :rolNombre"),
    @NamedQuery(name = "UserRol.findByRolDescripcion", query = "SELECT u FROM UserRol u WHERE u.rolDescripcion = :rolDescripcion")})
public class UserRol implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rol_id")
    private Integer rolId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "rol_nombre")
    private String rolNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "rol_descripcion")
    private String rolDescripcion;
    @ManyToMany(mappedBy = "userRolCollection")
    private Collection<ErpMenu> erpMenuCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userRolRolId")
    private Collection<ErpUsuario> erpUsuarioCollection;

    public UserRol() {
    }

    public UserRol(Integer rolId) {
        this.rolId = rolId;
    }

    public UserRol(Integer rolId, String rolNombre, String rolDescripcion) {
        this.rolId = rolId;
        this.rolNombre = rolNombre;
        this.rolDescripcion = rolDescripcion;
    }

    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

    public String getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(String rolNombre) {
        this.rolNombre = rolNombre;
    }

    public String getRolDescripcion() {
        return rolDescripcion;
    }

    public void setRolDescripcion(String rolDescripcion) {
        this.rolDescripcion = rolDescripcion;
    }

    @XmlTransient
    public Collection<ErpMenu> getErpMenuCollection() {
        return erpMenuCollection;
    }

    public void setErpMenuCollection(Collection<ErpMenu> erpMenuCollection) {
        this.erpMenuCollection = erpMenuCollection;
    }

    @XmlTransient
    public Collection<ErpUsuario> getErpUsuarioCollection() {
        return erpUsuarioCollection;
    }

    public void setErpUsuarioCollection(Collection<ErpUsuario> erpUsuarioCollection) {
        this.erpUsuarioCollection = erpUsuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolId != null ? rolId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserRol)) {
            return false;
        }
        UserRol other = (UserRol) object;
        if ((this.rolId == null && other.rolId != null) || (this.rolId != null && !this.rolId.equals(other.rolId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cec.usuario.datos.UserRol[ rolId=" + rolId + " ]";
    }
    
}
