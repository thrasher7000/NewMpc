package co.mpc.frontend.vehiculos.controllers;

import co.mpc.backend.persistence.model.entities.Conductor;
import co.mpc.backend.persistence.model.entities.TipoVehiculo;
import co.mpc.backend.persistence.model.entities.Vehiculo;
import co.mpc.backend.persistence.model.facades.ConductorFacadeLocal;
import co.mpc.backend.persistence.model.facades.TipoVehiculoFacadeLocal;
import co.mpc.backend.persistence.model.facades.VehiculoFacadeLocal;
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

@Named(value = "vehiculosManagedBean")
@SessionScoped
public class VehiculoManagedBean implements Serializable, IManagedBean<Vehiculo> {


    private Vehiculo vehiculo;
    private Conductor conductor;
    private TipoVehiculo tipoVehiculo;
    
    @EJB private VehiculoFacadeLocal vehiculofacadelocal;
    @EJB private ConductorFacadeLocal conductorFacadeLocal;
    @EJB private TipoVehiculoFacadeLocal tipoVehiculoFacadeLocal;
    
    public VehiculoManagedBean() {
    }
    
    @PostConstruct
    public void init(){
        vehiculo = new Vehiculo();
        conductor = new Conductor();
        tipoVehiculo = new TipoVehiculo();
    }
    

    @Override
    public Vehiculo getObjetoByKey(Integer id) {
        return vehiculofacadelocal.find(id);
    }
    
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }
    
    
    
   // Metodos
    public void registrarVehiculo(){       
        vehiculofacadelocal.create(vehiculo);
    }
    
    public void eliminarVehiculo(Vehiculo v){
        vehiculofacadelocal.remove(v);
    }
    
    public List<Vehiculo> listaVehiculos(){
        return vehiculofacadelocal.findAll();
    }
    
    public void editarVehiculo(Vehiculo v){
        vehiculofacadelocal.edit(v);
    }

    
}
