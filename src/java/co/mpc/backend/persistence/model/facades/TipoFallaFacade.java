/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.backend.persistence.model.facades;

import co.mpc.backend.persistence.model.entities.TipoFalla;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author SENA
 */
@Stateless
public class TipoFallaFacade extends AbstractFacade<TipoFalla> implements TipoFallaFacadeLocal {

    @PersistenceContext(unitName = "NewMpcPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoFallaFacade() {
        super(TipoFalla.class);
    }
    
}
