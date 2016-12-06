/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.frontend.ordenes.controllers;

import co.mpc.backend.persistence.model.entities.CambioRealizado;
import co.mpc.backend.persistence.model.facades.CambioRealizadoFacadeLocal;
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
@Named(value = "cambiosRealizadosManagedBean")
@SessionScoped
public class CambioRealizadoManagedBean implements Serializable, IManagedBean<CambioRealizado> {

    /**
     * Creates a new instance of CambiosRealizadosManagedBean
     */
    private CambioRealizado cambioRealizado;
    @EJB
    private CambioRealizadoFacadeLocal cambioRealizadoFL;

    public CambioRealizadoManagedBean() {
    }

    @PostConstruct
    public void init() {
        cambioRealizado = new CambioRealizado();
    }

    @Override
    public CambioRealizado getObjetoByKey(Integer id) {
        return cambioRealizadoFL.find(id);
    }

    public CambioRealizado getCambioRealizado() {
        return cambioRealizado;
    }

    public void setCambioRealizado(CambioRealizado cambioRealizado) {
        this.cambioRealizado = cambioRealizado;
    }

    public void registrarCambioRealizado() {
        cambioRealizadoFL.create(cambioRealizado);
    }

    public void eliminarCambioRealizado() {
        cambioRealizadoFL.remove(cambioRealizado);
    }

    public List<CambioRealizado> listarCambioRealizado() {
        return cambioRealizadoFL.findAll();
    }

}
