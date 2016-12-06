/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.frontend.ordenes.controllers;

import co.mpc.backend.persistence.model.entities.EstadoOrden;
import co.mpc.backend.persistence.model.facades.EstadoOrdenFacadeLocal;
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
@Named(value = "estadoOrdenManagedBean")
@SessionScoped
public class EstadoOrdenManagedBean implements Serializable, IManagedBean<EstadoOrden> {
    
    private EstadoOrden estadoOrden;
    @EJB
    private EstadoOrdenFacadeLocal estadoOFL;
    
    public EstadoOrdenManagedBean() {
    }
    
    @PostConstruct
    public void init() {
        estadoOrden = new EstadoOrden();
    }
    
    @Override
    public EstadoOrden getObjetoByKey(Integer id) {
        return estadoOFL.find(id);
    }
    
    public EstadoOrden getEstadoOrden() {
        return estadoOrden;
    }
    
    public void setEstadoOrden(EstadoOrden estadoOrden) {
        this.estadoOrden = estadoOrden;
    }
    
    public void registrarEstadoOrden() {
        estadoOFL.create(estadoOrden);
    }
    
    public void eliminarEstadoOrden() {
        estadoOFL.remove(estadoOrden);
    }
    
    public List<EstadoOrden> listarEstadosOrden() {
        return estadoOFL.findAll();
    }
    
}
