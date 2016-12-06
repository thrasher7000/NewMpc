/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.frontend.vehiculos.controllers;

import co.mpc.backend.persistence.model.entities.Conductor;
import co.mpc.backend.persistence.model.entities.Vehiculo;
import co.mpc.backend.persistence.model.facades.VehiculoFacadeLocal;
import co.mpc.frontend.controllers.IManagedBean;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author SENA
 */
@Named(value = "vehiculosManagedBean")
@Dependent
public class VehiculosManagedBean implements Serializable, IManagedBean<Vehiculo> {

    public VehiculosManagedBean() {
    }

    private Vehiculo vehiculo;
    private Conductor conductor;
    
    @EJB
    
    private VehiculoFacadeLocal vehiculofacadelocal;
    
    @PostConstruct
    public void init(){
        vehiculo = new Vehiculo();
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    
    
    @Override
    public Vehiculo getObjetoByKey(Integer id) {
        return vehiculofacadelocal.find(id);
    }
    
    public void registrarVehiculo(){
        
    }

    
}
