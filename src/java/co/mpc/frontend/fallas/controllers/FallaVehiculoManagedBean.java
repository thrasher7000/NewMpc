/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.frontend.fallas.controllers;

import co.mpc.backend.persistence.model.entities.FallaVehiculo;
import co.mpc.backend.persistence.model.facades.FallaVehiculoFacadeLocal;
import co.mpc.frontend.controllers.IManagedBean;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author Andres
 */
@Named(value = "fallaVehiculoManagedBean")
@SessionScoped
public class FallaVehiculoManagedBean implements Serializable, IManagedBean<FallaVehiculo>{

    private FallaVehiculo fallaVehiculoa;
    @EJB private FallaVehiculoFacadeLocal fallaVehiculoaFacadeLocal;
    
    public FallaVehiculoManagedBean() {
    }
    
    @PostConstruct
    public void init(){
        fallaVehiculoa = new FallaVehiculo();
    }

    @Override
    public FallaVehiculo getObjetoByKey(Integer id) {
        return fallaVehiculoaFacadeLocal.find(id);
    }
    
    public FallaVehiculo getFallaVehiculo() {
        return fallaVehiculoa;
    }

    public void setFallaVehiculo(FallaVehiculo fallaVehiculoa) {
        this.fallaVehiculoa = fallaVehiculoa;
    }

    
    public void registrarFallaVehiculo(){
        fallaVehiculoaFacadeLocal.create(fallaVehiculoa);
    }
    
    public void eliminarFallaVehiculo(){
        fallaVehiculoaFacadeLocal.remove(fallaVehiculoa);
    }
    
    public List<FallaVehiculo> listaTiposFallas(){
        return fallaVehiculoaFacadeLocal.findAll();
    }
    
    public void editarFallaVehiculo(FallaVehiculo to){
        fallaVehiculoaFacadeLocal.edit(to);
    }
}
