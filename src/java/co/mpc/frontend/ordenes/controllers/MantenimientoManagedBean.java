/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.frontend.ordenes.controllers;

import co.mpc.backend.persistence.model.entities.Mantenimiento;
import co.mpc.backend.persistence.model.facades.MantenimientoFacadeLocal;
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
@Named(value = "mantenimientoManagedBean")
@SessionScoped
public class MantenimientoManagedBean implements Serializable, IManagedBean<Mantenimiento> {

    private Mantenimiento mantenimiento;
    @EJB
    private MantenimientoFacadeLocal mantenimientoFL;

    public MantenimientoManagedBean() {

    }

    @PostConstruct
    public void init() {
        mantenimiento = new Mantenimiento();
    }

    @Override
    public Mantenimiento getObjetoByKey(Integer id) {
        return mantenimientoFL.find(id);
    }

    public Mantenimiento getMantenimiento() {
        return mantenimiento;
    }

    public void setMantenimiento(Mantenimiento mantenimiento) {
        this.mantenimiento = mantenimiento;
    }
    
    public void registrarMantenimiento(){
        mantenimientoFL.create(mantenimiento);
    }
    public void eliminarMantenimiento(){
        mantenimientoFL.remove(mantenimiento);
    }
    
    public List<Mantenimiento> listarMantenimiento(){
        return mantenimientoFL.findAll();
    }

}
