package co.mpc.frontend.vehiculos.controllers;

import co.mpc.backend.persistence.model.entities.TipoVehiculo;
import co.mpc.backend.persistence.model.facades.TipoVehiculoFacadeLocal;
import co.mpc.frontend.controllers.IManagedBean;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Brayan Mendez
 */

@Named(value = "tipoVehiculoManagedBean")
@SessionScoped
public class TipoVehiculoManagedBean implements Serializable, IManagedBean<TipoVehiculo>{


    
    private TipoVehiculo tipoVehiculo;
    
    @EJB
    
    private TipoVehiculoFacadeLocal tipoVehiculoFacadeLocal;
    
    public TipoVehiculoManagedBean() {
    }
    
    @PostConstruct
    public void init(){
        tipoVehiculo = new TipoVehiculo(); 
    }
    
    
    @Override
    public TipoVehiculo getObjetoByKey(Integer id) {
        return tipoVehiculoFacadeLocal.find(id);
    }
    

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }
    
    
    // Metodos
    public void registrarTipoVehiculo(){
        tipoVehiculoFacadeLocal.create(tipoVehiculo);
    }
    
    public void eliminarTipoVehiculo(TipoVehiculo tv){
        tipoVehiculoFacadeLocal.remove(tv);
    }
    
    public List<TipoVehiculo> listaTipoVehiculo(){
        return tipoVehiculoFacadeLocal.findAll();
    }
    
    public void editarTipoVehiculo(TipoVehiculo tv){
        tipoVehiculoFacadeLocal.edit(tv);
    }
    
}
