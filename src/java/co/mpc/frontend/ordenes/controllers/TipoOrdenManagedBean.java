/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.frontend.ordenes.controllers;

import co.mpc.backend.persistence.model.entities.TipoOrden;
import co.mpc.backend.persistence.model.facades.TipoOrdenFacadeLocal;
import co.mpc.frontend.controllers.IManagedBean;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author Juank
 */
@Named(value = "tipoOrdenManagedBean")
@SessionScoped
public class TipoOrdenManagedBean implements Serializable, IManagedBean<TipoOrden> {
    
    private TipoOrden tipoOrden;
    @EJB
    private TipoOrdenFacadeLocal tOFL;
    
    public TipoOrdenManagedBean() {
    }
    
    @PostConstruct
    public void init() {
        tipoOrden = new TipoOrden();
    }
    
    @Override
    public TipoOrden getObjetoByKey(Integer id) {
        return tOFL.find(id);
    }
    
    public TipoOrden getTipoOrden() {
        return tipoOrden;
    }
    
    public void setTipoOrden(TipoOrden tipoOrden) {
        this.tipoOrden = tipoOrden;
    }
    
    public void registrarTipoOrden() {
        tOFL.create(tipoOrden);
    }
    
    public void eliminarTipoOrden() {
        tOFL.remove(tipoOrden);
    }
    
    public List<TipoOrden> listarTipoOrden() {
        return tOFL.findAll();
    }
    
}
