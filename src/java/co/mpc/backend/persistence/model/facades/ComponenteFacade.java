/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.backend.persistence.model.facades;

import co.mpc.backend.persistence.model.entities.Componente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author SENA
 */
@Stateless
public class ComponenteFacade extends AbstractFacade<Componente> implements ComponenteFacadeLocal {

    @PersistenceContext(unitName = "NewMpcPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComponenteFacade() {
        super(Componente.class);
    }
    
}
