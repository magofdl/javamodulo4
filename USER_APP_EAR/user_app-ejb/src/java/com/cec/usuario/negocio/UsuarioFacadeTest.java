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
import session.AbstractFacade;

/**
 *
 * @author magofdl
 */
@Stateless
public class UsuarioFacadeTest  extends AbstractFacade<ErpUsuario>  {

    //llamar al administrador de persistencia
    @PersistenceContext(unitName = "user_app-ejbPU")
    private EntityManager manejador;
    
    public UsuarioFacadeTest(Class<ErpUsuario> entityClass) {
        super(entityClass);
    }

    public UsuarioFacadeTest() {
        super(ErpUsuario.class);
    }

    
    @Override
    protected EntityManager getEntityManager() {
        return manejador;
    }
    
}


