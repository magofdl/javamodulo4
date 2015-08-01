/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cec.usuario.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author CEC
 */
@Entity
@Table(name = "erp_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpUsuario.findAll", query = "SELECT e FROM ErpUsuario e"),
    @NamedQuery(name = "ErpUsuario.findByUsuId", query = "SELECT e FROM ErpUsuario e WHERE e.usuId = :usuId"),
    @NamedQuery(name = "ErpUsuario.findByUsuNombre", query = "SELECT e FROM ErpUsuario e WHERE e.usuNombre = :usuNombre"),
    @NamedQuery(name = "ErpUsuario.findByUsuApellido", query = "SELECT e FROM ErpUsuario e WHERE e.usuApellido = :usuApellido"),
    @NamedQuery(name = "ErpUsuario.findByUsuClave", query = "SELECT e FROM ErpUsuario e WHERE e.usuClave = :usuClave"),
    @NamedQuery(name = "ErpUsuario.findByUsuCedula", query = "SELECT e FROM ErpUsuario e WHERE e.usuCedula = :usuCedula"),
    @NamedQuery(name = "ErpUsuario.findByUsuUsuario", query = "SELECT e FROM ErpUsuario e WHERE e.usuUsuario = :usuUsuario"),
    @NamedQuery(name = "ErpUsuario.findByUsuCorreo", query = "SELECT e FROM ErpUsuario e WHERE e.usuCorreo = :usuCorreo")})
public class ErpUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "usu_id")
    private Integer usuId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "usu_nombre")
    private String usuNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "usu_apellido")
    private String usuApellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "usu_clave")
    private String usuClave;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "usu_cedula")
    private String usuCedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "usu_usuario")
    private String usuUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "usu_correo")
    private String usuCorreo;
    @JoinColumn(name = "user_rol_rol_id", referencedColumnName = "rol_id")
    @ManyToOne(optional = false)
    private UserRol userRolRolId;

    public ErpUsuario() {
    }

    public ErpUsuario(Integer usuId) {
        this.usuId = usuId;
    }

    public ErpUsuario(Integer usuId, String usuNombre, String usuApellido, String usuClave, String usuCedula, String usuUsuario, String usuCorreo) {
        this.usuId = usuId;
        this.usuNombre = usuNombre;
        this.usuApellido = usuApellido;
        this.usuClave = usuClave;
        this.usuCedula = usuCedula;
        this.usuUsuario = usuUsuario;
        this.usuCorreo = usuCorreo;
    }

    public Integer getUsuId() {
        return usuId;
    }

    public void setUsuId(Integer usuId) {
        this.usuId = usuId;
    }

    public String getUsuNombre() {
        return usuNombre;
    }

    public void setUsuNombre(String usuNombre) {
        this.usuNombre = usuNombre;
    }

    public String getUsuApellido() {
        return usuApellido;
    }

    public void setUsuApellido(String usuApellido) {
        this.usuApellido = usuApellido;
    }

    public String getUsuClave() {
        return usuClave;
    }

    public void setUsuClave(String usuClave) {
        this.usuClave = usuClave;
    }

    public String getUsuCedula() {
        return usuCedula;
    }

    public void setUsuCedula(String usuCedula) {
        this.usuCedula = usuCedula;
    }

    public String getUsuUsuario() {
        return usuUsuario;
    }

    public void setUsuUsuario(String usuUsuario) {
        this.usuUsuario = usuUsuario;
    }

    public String getUsuCorreo() {
        return usuCorreo;
    }

    public void setUsuCorreo(String usuCorreo) {
        this.usuCorreo = usuCorreo;
    }

    public UserRol getUserRolRolId() {
        return userRolRolId;
    }

    public void setUserRolRolId(UserRol userRolRolId) {
        this.userRolRolId = userRolRolId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuId != null ? usuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpUsuario)) {
            return false;
        }
        ErpUsuario other = (ErpUsuario) object;
        if ((this.usuId == null && other.usuId != null) || (this.usuId != null && !this.usuId.equals(other.usuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cec.usuario.datos.ErpUsuario[ usuId=" + usuId + " ]";
    }
    
}
