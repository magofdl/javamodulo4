/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cec.usuario.managerbean;

import com.cec.usuario.modelo.ErpUsuario;
import com.cec.usuario.negocio.UsuarioFacade;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

/**
 * Clasea pra adminsitrar la pantalla de admin usaurio
 * @author CEC
 */

@ManagedBean
@RequestScoped
public class AdminUsuarioBean {
    
    private List<SelectItem> listRoles;
    private List<ErpUsuario> listaUsuarios;
   
    @EJB
    private UsuarioFacade adminUsuario; 

    public AdminUsuarioBean() {
        //siempre se deben iniciailizar las listas 
        this.listRoles=new ArrayList<>();
    }

    public List<SelectItem> getListRoles() {
        return listRoles;
    }

    public void setListRoles(List<SelectItem> listRoles) {
        this.listRoles = listRoles;
    }

    public List<ErpUsuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<ErpUsuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    /**
     * Metodo para cargar usuarios
     */
    private void cargarUsuarios(){
        this.listaUsuarios=adminUsuario.buscarTodos();
    }
    
    /*callbacks son tipos de metodos en jee se usan para ejcutar operaciones ssbre EJB 
    como pre o post procesadores de forma automatica una vez que el objeto que lo contenga
    se haya creado
    */
    @PostConstruct
    public void inicializar(){
        cargarUsuarios();
    }
}
