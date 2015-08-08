/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cec.usuario.managerbean;

import com.cec.usuario.modelo.ErpUsuario;
import com.cec.usuario.negocio.UsuarioFacade;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



/**
 * Clase para administrar el formulario de login
 * @author FDL
 */

//1 indicar que va a ser un managed bean
@ManagedBean
//2 indicar el alcance del bean, cuanto tiempo duran los datos
@SessionScoped
public class LoginBean {
    //3 atributos que se van a modificar/manipular en el formulario
    private String txt_nombre_usuario;
    private String txt_clave_usuario;

    //administrar negocio
    @EJB
    private UsuarioFacade adminUsuario;
    
    public LoginBean() {
    }

    
    //4 getters 6 setters segun corresponda
    /**
     * @return the txt_nombre_usuario
     */
    public String getTxt_nombre_usuario() {
        return txt_nombre_usuario;
    }

    /**
     * @param txt_nombre_usuario the txt_nombre_usuario to set
     */
    public void setTxt_nombre_usuario(String txt_nombre_usuario) {
        this.txt_nombre_usuario = txt_nombre_usuario;
    }

    /**
     * @return the txt_clave_usuario
     */
    public String getTxt_clave_usuario() {
        return txt_clave_usuario;
    }

    /**
     * @param txt_clave_usuario the txt_clave_usuario to set
     */
    public void setTxt_clave_usuario(String txt_clave_usuario) {
        this.txt_clave_usuario = txt_clave_usuario;
    }

    public LoginBean(String txt_nombre_usuario, String txt_clave_usuario) {
        this.txt_nombre_usuario = txt_nombre_usuario;
        this.txt_clave_usuario = txt_clave_usuario;
    }
    
   //metodo para validar usuario
    public String validarUsuario(){
        // return null significa que se queda en el misma página
        
        if (this.getTxt_nombre_usuario().equals("fdruan")) {
            
            try {
                ErpUsuario erpUsuario=adminUsuario.validarUsuario(txt_nombre_usuario, txt_clave_usuario);
                return "principal";
            } catch (Exception ex) {
                Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
                //mensjae a pantalla
                 return null;
            }
        }
        else{
             return null;
        }
    }
    
    
}
