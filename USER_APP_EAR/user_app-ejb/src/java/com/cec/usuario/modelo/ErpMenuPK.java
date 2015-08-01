/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cec.usuario.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author CEC
 */
@Embeddable
public class ErpMenuPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "menu_id")
    private int menuId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "erp_modulo_mod_id")
    private int erpModuloModId;

    public ErpMenuPK() {
    }

    public ErpMenuPK(int menuId, int erpModuloModId) {
        this.menuId = menuId;
        this.erpModuloModId = erpModuloModId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getErpModuloModId() {
        return erpModuloModId;
    }

    public void setErpModuloModId(int erpModuloModId) {
        this.erpModuloModId = erpModuloModId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) menuId;
        hash += (int) erpModuloModId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpMenuPK)) {
            return false;
        }
        ErpMenuPK other = (ErpMenuPK) object;
        if (this.menuId != other.menuId) {
            return false;
        }
        if (this.erpModuloModId != other.erpModuloModId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cec.usuario.datos.ErpMenuPK[ menuId=" + menuId + ", erpModuloModId=" + erpModuloModId + " ]";
    }
    
}
