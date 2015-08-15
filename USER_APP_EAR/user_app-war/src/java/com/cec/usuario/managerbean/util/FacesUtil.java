/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cec.usuario.managerbean.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 * Clase para administrar las utilidades de JSF
 *
 * @author CEC
 */
public class FacesUtil {

    /**
     * Metodo para añadir un mensaje a pantalla
     *
     * @param tipoError
     * @param mensaje
     */
    public static void addMessage(int tipoError, String mensaje) {

        FacesMessage facesMessage = new FacesMessage();
       
        
        if (tipoError==1) {
             facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
        }
        else if (tipoError==2) {
             facesMessage.setSeverity(FacesMessage.SEVERITY_WARN);
        }
        else if (tipoError==3) {
             facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
        }
        
        facesMessage.setSummary(mensaje);
        FacesContext.getCurrentInstance().addMessage("resultado", facesMessage);

    }

    /**
     * Metodo para recuperar un parametro 
     * @param nombreParametro
     * @return 
     */
    public static Object recuperarParametro(String nombreParametro){
        FacesContext facesContext = FacesContext.getCurrentInstance();//todo de la pantalla actual
        ExternalContext externalContext =facesContext.getExternalContext();//del servlet
        return externalContext.getRequestParameterMap().get(nombreParametro);//recuperar parametro
    }
}
