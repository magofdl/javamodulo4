/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cec.usuario.negocio;

import com.cec.usuario.modelo.ErpUsuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Clase para administrar las operaciones de usuario
 * @author FDL
 */

@Stateless
public class UsuarioFacade {
    
    //llamar al administrador de persistencia
    @PersistenceContext(unitName = "user_app-ejbPU")
    private EntityManager manejador;
    
    /**
     * Método para validar el usuario
     * @param nombreUsuario
     * @param claveUsuario
     * @return
     * @throws Exception 
     */
    public ErpUsuario validarUsuario(String nombreUsuario, String claveUsuario) throws Exception{
        
        Query query;
        query = manejador.createQuery("SELECT usu  FROM ErpUsuario usu where usu.usu_usuario :param_usuario AND usu.usu_clav :param_clave");
        
        query.setParameter("param_usuario",nombreUsuario );
        query.setParameter("param_clave",claveUsuario );
        ErpUsuario erpUsuario=(ErpUsuario) query.getSingleResult();
        return erpUsuario;
    }
    
    /**
     * Metodo para guardar un usuario
     * @param erpUsuario
     * @return
     * @throws Exception 
     */
    public String guardarUsuario(ErpUsuario erpUsuario)throws Exception{
        return null;
    }
    
    /**
     *  Metodo para actualizar un usuario
     * @param erpUsuario
     * @return
     * @throws Exception 
     */
     public String actualizarUsuario(ErpUsuario erpUsuario)throws Exception{
        return null;
    }
     
     /**
      *  Metodo para eliminar un usuario
      * @param erpUsuario
      * @return
      * @throws Exception 
      */
     public String eliminarUsuario(ErpUsuario erpUsuario)throws Exception{
        return null;
    }
}
