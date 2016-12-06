package co.mpc.frontend.usuarios.controller;

import co.mpc.backend.persistence.model.entities.Conductor;
import co.mpc.backend.persistence.model.facades.ConductorFacadeLocal;
import co.mpc.frontend.controllers.IManagedBean;
import co.mpc.backend.persistence.model.entities.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import co.mpc.backend.persistence.model.entities.TipoVehiculo;

/**
 *
 * @author Miguel Angel Rivera Niño
 */

@Named(value = "conductorManagedBean")
@SessionScoped
public class ConductorManagedBean implements Serializable, IManagedBean<Conductor>{

    private Conductor conductor;
    private TipoVehiculo tipovehiculo;
    private Usuario usuario;
    @EJB private ConductorFacadeLocal conductorFacadeLocal;
    
    public ConductorManagedBean() {
    }
    @PostConstruct
    public void init(){
        conductor = new Conductor();
        usuario = new Usuario();
        tipovehiculo = new TipoVehiculo();
    }
    @Override
    public Conductor getObjetoByKey(Integer id) {
        return conductorFacadeLocal.find(id);
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }
     public void registrarConductor(){
        conductorFacadeLocal.create(conductor);
    }
    public void eliminarConductor(Conductor c){
        conductorFacadeLocal.remove(conductor);
    }
    public List<Conductor> listarConductor(){
        return conductorFacadeLocal.findAll();
    }
    public void editarConductor(Conductor e){
        conductorFacadeLocal.edit(conductor);
    }
    
}
