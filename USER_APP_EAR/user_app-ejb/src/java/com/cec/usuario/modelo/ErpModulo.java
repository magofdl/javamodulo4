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
@Table(name = "erp_modulo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpModulo.findAll", query = "SELECT e FROM ErpModulo e"),
    @NamedQuery(name = "ErpModulo.findByModId", query = "SELECT e FROM ErpModulo e WHERE e.modId = :modId"),
    @NamedQuery(name = "ErpModulo.findByModNombre", query = "SELECT e FROM ErpModulo e WHERE e.modNombre = :modNombre"),
    @NamedQuery(name = "ErpModulo.findByModDescripcion", query = "SELECT e FROM ErpModulo e WHERE e.modDescripcion = :modDescripcion"),
    @NamedQuery(name = "ErpModulo.findByModContext", query = "SELECT e FROM ErpModulo e WHERE e.modContext = :modContext")})
public class ErpModulo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mod_id")
    private Integer modId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "mod_nombre")
    private String modNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "mod_descripcion")
    private String modDescripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "mod_context")
    private String modContext;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "erpModulo")
    private Collection<ErpMenu> erpMenuCollection;

    public ErpModulo() {
    }

    public ErpModulo(Integer modId) {
        this.modId = modId;
    }

    public ErpModulo(Integer modId, String modNombre, String modDescripcion, String modContext) {
        this.modId = modId;
        this.modNombre = modNombre;
        this.modDescripcion = modDescripcion;
        this.modContext = modContext;
    }

    public Integer getModId() {
        return modId;
    }

    public void setModId(Integer modId) {
        this.modId = modId;
    }

    public String getModNombre() {
        return modNombre;
    }

    public void setModNombre(String modNombre) {
        this.modNombre = modNombre;
    }

    public String getModDescripcion() {
        return modDescripcion;
    }

    public void setModDescripcion(String modDescripcion) {
        this.modDescripcion = modDescripcion;
    }

    public String getModContext() {
        return modContext;
    }

    public void setModContext(String modContext) {
        this.modContext = modContext;
    }

    @XmlTransient
    public Collection<ErpMenu> getErpMenuCollection() {
        return erpMenuCollection;
    }

    public void setErpMenuCollection(Collection<ErpMenu> erpMenuCollection) {
        this.erpMenuCollection = erpMenuCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (modId != null ? modId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpModulo)) {
            return false;
        }
        ErpModulo other = (ErpModulo) object;
        if ((this.modId == null && other.modId != null) || (this.modId != null && !this.modId.equals(other.modId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cec.usuario.datos.ErpModulo[ modId=" + modId + " ]";
    }
    
}
