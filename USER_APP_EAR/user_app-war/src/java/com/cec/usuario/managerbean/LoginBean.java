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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;



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
         Logger.getLogger(LoginBean.class.getName()).log(Level.INFO, null, "validarUsuario");
            try {
                ErpUsuario erpUsuario=adminUsuario.validarUsuario(txt_nombre_usuario, txt_clave_usuario);
                if (erpUsuario!=null) {
                    Logger.getLogger(LoginBean.class.getName()).log(Level.INFO, null, erpUsuario.getUsuApellido());
                }
                return "principal";
            } catch (Exception ex) {
                Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
                //pasos para emitir mensaje a  pantalla
                //0 Crear componente de pantalla
                //1 crear mensaje
                FacesMessage facesMessage = new FacesMessage();
                //2 crear severity
                facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
                //3 setear el mensaje
                facesMessage.setSummary("Credenciales incorrectas");
                //4 cargar a pantalla
                //FacesContext conoce todo el conextsto jsf
                FacesContext.getCurrentInstance().addMessage("resultadoLogin", facesMessage);
                //5
                 return null;
            }
    }
    
    
}
