/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cec.usuario.negocio;

import com.cec.usuario.modelo.UserRol;
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
 * Clase para administrar las operaciones de roles de usuario
 *
 * @author FDL
 */
@Stateless
public class RolFacade {

    //llamar al administrador de persistencia
    @PersistenceContext(unitName = "user_app-ejbPU")
    private EntityManager manejador;


    public List<UserRol> buscarTodos(){
        CriteriaBuilder criteriaBuilder=manejador.getCriteriaBuilder();
        CriteriaQuery<UserRol> criteriaQuery= criteriaBuilder.createQuery(UserRol.class);
        Root<UserRol> userRol=criteriaQuery.from(UserRol.class);
        criteriaQuery.select(userRol);
        TypedQuery<UserRol> typedQuery=manejador.createQuery(criteriaQuery);
        List<UserRol> todosUsuarios=typedQuery.getResultList();
        return todosUsuarios;
    }
    
    public UserRol buscarRolPorId(Integer idRol){
        UserRol userRol = manejador.find(UserRol.class, idRol);
        return userRol;
    }
}
