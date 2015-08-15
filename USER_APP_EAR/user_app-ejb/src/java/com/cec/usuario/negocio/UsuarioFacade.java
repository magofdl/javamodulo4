/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cec.usuario.negocio;

import com.cec.usuario.modelo.ErpUsuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Clase para administrar las operaciones de usuario
 *
 * @author FDL
 */
@Stateless
public class UsuarioFacade {

    //llamar al administrador de persistencia
    @PersistenceContext(unitName = "user_app-ejbPU")
    private EntityManager manejador;

    /**
     * Método para validar el usuario
     *
     * @param nombreUsuario
     * @param claveUsuario
     * @return
     * @throws Exception
     */
    public ErpUsuario validarUsuario(String nombreUsuario, String claveUsuario) throws Exception {

        Query query;
        query = manejador.createQuery("SELECT usu  FROM ErpUsuario usu where usu.usuUsuario=:param_usuario AND usu.usuClave=:param_clave");

        query.setParameter("param_usuario", nombreUsuario);
        query.setParameter("param_clave", claveUsuario);
        ErpUsuario erpUsuario = (ErpUsuario) query.getSingleResult();
        return erpUsuario;
    }

    /**
     * Metodo para guardar un usuario
     *
     * @param erpUsuario
     * @return
     * @throws Exception
     */
    public String guardarUsuario(ErpUsuario erpUsuario) throws Exception {
        manejador.persist(erpUsuario);//guarda automaticamente a la base con commit automatico
        return "registro guardado correctamente";
    }

    /**
     * Metodo para actualizar un usuario
     *
     * @param erpUsuario
     * @return
     * @throws Exception
     */
    public String actualizarUsuario(ErpUsuario erpUsuario) throws Exception {
        manejador.merge(erpUsuario);//actualiza automaticamente a la base con commit automatico
        return "registro actualizado correctamente";
    }

    /**
     * Metodo para eliminar un usuario
     *
     * @param erpUsuario
     * @return
     * @throws Exception
     */
    public String eliminarUsuario(ErpUsuario erpUsuario) throws Exception {
         manejador.remove(erpUsuario);//elimina automaticamente a la base con commit automatico al salir del metodo
        return "registro eliminado correctamente";
    }
    
    public List<ErpUsuario> buscarTodos(){
        CriteriaBuilder criteriaBuilder=manejador.getCriteriaBuilder();
        CriteriaQuery<ErpUsuario> criteriaQuery= criteriaBuilder.createQuery(ErpUsuario.class);
        Root<ErpUsuario> erpusuario=criteriaQuery.from(ErpUsuario.class);
        criteriaQuery.select(erpusuario);
        TypedQuery<ErpUsuario> typedQuery=manejador.createQuery(criteriaQuery);
        List<ErpUsuario> todosUsuarios=typedQuery.getResultList();
        return todosUsuarios;
    }
}
