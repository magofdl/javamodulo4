/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cec.usuario.managerbean;

import com.cec.usuario.modelo.ErpUsuario;
import com.cec.usuario.modelo.UserRol;
import com.cec.usuario.negocio.RolFacade;
import com.cec.usuario.negocio.UsuarioFacade;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

/**
 * Clasea pra adminsitrar la pantalla de admin usaurio
 *
 * @author CEC
 */
@ManagedBean
@RequestScoped
public class AdminUsuarioBean {

    private List<SelectItem> listRoles;
    private List<ErpUsuario> listaUsuarios;
    private Integer idRol;
    //segundo tipo de enlace porque son muchos campos
    private ErpUsuario usuario;
    
    
    @EJB
    private UsuarioFacade adminUsuario;
    
    @EJB
    private RolFacade adminRoles;

    public AdminUsuarioBean() {
        //siempre se deben iniciailizar las listas 
        this.listRoles = new ArrayList<>();
        this.usuario= new ErpUsuario();
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

    public ErpUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(ErpUsuario usuario) {
        this.usuario = usuario;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }
    
    

    /**
     * Metodo para cargar usuarios
     */
    private void cargarUsuarios() {
        Logger.getLogger(AdminUsuarioBean.class.getName()).log(Level.INFO, "cargar usuarios");
        this.listaUsuarios = adminUsuario.buscarTodos();
    }

      /**
     * Metodo para cargar roles
     */
    private void cargarRoles() {
        Logger.getLogger(AdminUsuarioBean.class.getName()).log(Level.INFO, "cargar usuarios");
        this.listRoles.clear();
        for (UserRol rolTmp : adminRoles.buscarTodos()) {
            this.listRoles.add(new SelectItem(rolTmp.getRolId(), rolTmp.getRolNombre()));
        }
        this.listaUsuarios = adminUsuario.buscarTodos();
    }
    
    /**
     * Metodo para guardar usuarios
     * @return 
     */
    public String guardarUsuario() {
        try {
            Logger.getLogger(AdminUsuarioBean.class.getName()).log(Level.INFO, "guardar usuario");
            
            //
            UserRol userRol=adminRoles.buscarRolPorId(this.idRol);
            this.usuario.setUserRolRolId(userRol);
            adminUsuario.guardarUsuario(this.usuario);
            
            String mensaje="Usuario guardado correctamente";
            //actualizar la lista de usuarios
            cargarUsuarios();
            //mostrar el mensaje
            
            return null;
        } catch (Exception ex) {
            Logger.getLogger(AdminUsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Metodo para nuevo usuario
     * @return 
     */
    public String nuevoUsuario() {
        Logger.getLogger(AdminUsuarioBean.class.getName()).log(Level.INFO, "nuevo usuario");
        this.usuario = new ErpUsuario();
        this.idRol = 0;
        return null;
    }

    /**
     * Metodo para eliminar usuarios
     * @return 
     */
    public String eliminarUsuario() {
         try {
            Logger.getLogger(AdminUsuarioBean.class.getName()).log(Level.INFO, "eliminar usuario");
            adminUsuario.eliminarUsuario(this.usuario);
            String mensaje="Usuario eliminado correctamente";
            //actualizar la lista de usuarios
            cargarUsuarios();
            //mostrar el mensaje
            
            return null;
        } catch (Exception ex) {
            Logger.getLogger(AdminUsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
      /**
     * Metodo para editar/cargar usuario
     * @return 
     */
    public String editarUsuario() {
        Logger.getLogger(AdminUsuarioBean.class.getName()).log(Level.INFO, "nuevo usuario");
        return null;
    }

    /*callbacks son tipos de metodos en jee se usan para ejcutar operaciones ssbre EJB 
     como pre o post procesadores de forma automatica una vez que el objeto que lo contenga
     se haya creado
     */
    @PostConstruct
    public void inicializar() {
        Logger.getLogger(AdminUsuarioBean.class.getName()).log(Level.INFO, "inicializar");
        cargarUsuarios();
        cargarRoles();
    }
}
