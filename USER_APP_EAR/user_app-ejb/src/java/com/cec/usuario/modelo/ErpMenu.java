/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cec.usuario.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "erp_menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpMenu.findAll", query = "SELECT e FROM ErpMenu e"),
    @NamedQuery(name = "ErpMenu.findByMenuId", query = "SELECT e FROM ErpMenu e WHERE e.erpMenuPK.menuId = :menuId"),
    @NamedQuery(name = "ErpMenu.findByMenuNombre", query = "SELECT e FROM ErpMenu e WHERE e.menuNombre = :menuNombre"),
    @NamedQuery(name = "ErpMenu.findByMenuUrl", query = "SELECT e FROM ErpMenu e WHERE e.menuUrl = :menuUrl"),
    @NamedQuery(name = "ErpMenu.findByMenuIdPadre", query = "SELECT e FROM ErpMenu e WHERE e.menuIdPadre = :menuIdPadre"),
    @NamedQuery(name = "ErpMenu.findByMenuGuardar", query = "SELECT e FROM ErpMenu e WHERE e.menuGuardar = :menuGuardar"),
    @NamedQuery(name = "ErpMenu.findByMenuEliminar", query = "SELECT e FROM ErpMenu e WHERE e.menuEliminar = :menuEliminar"),
    @NamedQuery(name = "ErpMenu.findByMenuConsultar", query = "SELECT e FROM ErpMenu e WHERE e.menuConsultar = :menuConsultar"),
    @NamedQuery(name = "ErpMenu.findByErpModuloModId", query = "SELECT e FROM ErpMenu e WHERE e.erpMenuPK.erpModuloModId = :erpModuloModId")})
public class ErpMenu implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ErpMenuPK erpMenuPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "menu_nombre")
    private String menuNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "menu_url")
    private String menuUrl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "menu_id_padre")
    private int menuIdPadre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "menu_guardar")
    private short menuGuardar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "menu_eliminar")
    private short menuEliminar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "menu_consultar")
    private short menuConsultar;
    @JoinTable(name = "rol_menu", joinColumns = {
        @JoinColumn(name = "menu_id", referencedColumnName = "menu_id"),
        @JoinColumn(name = "modulo_id", referencedColumnName = "erp_modulo_mod_id")}, inverseJoinColumns = {
        @JoinColumn(name = "user_rol_id", referencedColumnName = "rol_id")})
    @ManyToMany
    private Collection<UserRol> userRolCollection;
    @JoinColumn(name = "erp_modulo_mod_id", referencedColumnName = "mod_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ErpModulo erpModulo;

    public ErpMenu() {
    }

    public ErpMenu(ErpMenuPK erpMenuPK) {
        this.erpMenuPK = erpMenuPK;
    }

    public ErpMenu(ErpMenuPK erpMenuPK, String menuNombre, String menuUrl, int menuIdPadre, short menuGuardar, short menuEliminar, short menuConsultar) {
        this.erpMenuPK = erpMenuPK;
        this.menuNombre = menuNombre;
        this.menuUrl = menuUrl;
        this.menuIdPadre = menuIdPadre;
        this.menuGuardar = menuGuardar;
        this.menuEliminar = menuEliminar;
        this.menuConsultar = menuConsultar;
    }

    public ErpMenu(int menuId, int erpModuloModId) {
        this.erpMenuPK = new ErpMenuPK(menuId, erpModuloModId);
    }

    public ErpMenuPK getErpMenuPK() {
        return erpMenuPK;
    }

    public void setErpMenuPK(ErpMenuPK erpMenuPK) {
        this.erpMenuPK = erpMenuPK;
    }

    public String getMenuNombre() {
        return menuNombre;
    }

    public void setMenuNombre(String menuNombre) {
        this.menuNombre = menuNombre;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public int getMenuIdPadre() {
        return menuIdPadre;
    }

    public void setMenuIdPadre(int menuIdPadre) {
        this.menuIdPadre = menuIdPadre;
    }

    public short getMenuGuardar() {
        return menuGuardar;
    }

    public void setMenuGuardar(short menuGuardar) {
        this.menuGuardar = menuGuardar;
    }

    public short getMenuEliminar() {
        return menuEliminar;
    }

    public void setMenuEliminar(short menuEliminar) {
        this.menuEliminar = menuEliminar;
    }

    public short getMenuConsultar() {
        return menuConsultar;
    }

    public void setMenuConsultar(short menuConsultar) {
        this.menuConsultar = menuConsultar;
    }

    @XmlTransient
    public Collection<UserRol> getUserRolCollection() {
        return userRolCollection;
    }

    public void setUserRolCollection(Collection<UserRol> userRolCollection) {
        this.userRolCollection = userRolCollection;
    }

    public ErpModulo getErpModulo() {
        return erpModulo;
    }

    public void setErpModulo(ErpModulo erpModulo) {
        this.erpModulo = erpModulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (erpMenuPK != null ? erpMenuPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpMenu)) {
            return false;
        }
        ErpMenu other = (ErpMenu) object;
        if ((this.erpMenuPK == null && other.erpMenuPK != null) || (this.erpMenuPK != null && !this.erpMenuPK.equals(other.erpMenuPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cec.usuario.datos.ErpMenu[ erpMenuPK=" + erpMenuPK + " ]";
    }
    
}
