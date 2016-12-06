/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.frontend.ordenes.controllers;

import co.mpc.backend.persistence.model.entities.EstadoOrden;
import co.mpc.backend.persistence.model.entities.Orden;
import co.mpc.backend.persistence.model.entities.TipoOrden;
import co.mpc.backend.persistence.model.entities.Usuario;
import co.mpc.backend.persistence.model.entities.Vehiculo;
import co.mpc.backend.persistence.model.facades.OrdenFacadeLocal;
import co.mpc.backend.persistence.model.facades.TipoOrdenFacadeLocal;
import co.mpc.frontend.controllers.IManagedBean;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Hector Quintero
 */
@Named(value = "ordenManagedBean")
@SessionScoped
public class OrdenManagedBean implements Serializable, IManagedBean<Orden> {

    private Orden orden;
    private TipoOrden tipoOrden;
    private Usuario usuario;
    private Vehiculo vehiculo;
    private EstadoOrden estadoOrden;

    @EJB
    private OrdenFacadeLocal ordenFL;

    public OrdenManagedBean() {

    }

    @PostConstruct
    public void init() {
        orden = new Orden();
        tipoOrden = new TipoOrden();
        usuario = new Usuario();
        vehiculo = new Vehiculo();
        estadoOrden = new EstadoOrden();
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

    public TipoOrden getTipoOrden() {
        return tipoOrden;
    }

    public void setTipoOrden(TipoOrden tipoOrden) {
        this.tipoOrden = tipoOrden;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public EstadoOrden getEstadoOrden() {
        return estadoOrden;
    }

    public void setEstadoOrden(EstadoOrden estadoOrden) {
        this.estadoOrden = estadoOrden;
    }
    

    public void registrarOrden() {
        ordenFL.create(orden);
    }

    public void eliminarOrden() {
        ordenFL.remove(orden);
    }
    
    public List<Orden> listarOrden(){
        return ordenFL.findAll();
    }

}
