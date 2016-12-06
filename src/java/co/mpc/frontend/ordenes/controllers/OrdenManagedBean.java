/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.frontend.ordenes.controllers;

import co.mpc.backend.persistence.model.entities.Orden;
import co.mpc.backend.persistence.model.entities.TipoOrden;
import co.mpc.backend.persistence.model.facades.OrdenFacadeLocal;
import co.mpc.frontend.controllers.IManagedBean;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Juank
 */
@Named(value = "ordenManagedBean")
@SessionScoped
public class OrdenManagedBean implements Serializable, IManagedBean<Orden> {

    private Orden orden;
    private TipoOrden tipoO;
    @EJB
    private OrdenFacadeLocal ordenFL;

    public OrdenManagedBean() {

    }

    @PostConstruct
    public void init() {
        orden = new Orden();
    }

    @Override
    public Orden getObjetoByKey(Integer id) {
        return ordenFL.find(id);
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public void registrarOrden() {
        ordenFL.create(orden);
    }
    public void eliminarOrden(){
        ordenFL.remove(orden);
    }

}
