package co.mpc.frontend.vehiculos.controllers;

import co.mpc.backend.persistence.model.entities.EstadoComponente;
import co.mpc.backend.persistence.model.facades.EstadoComponenteFacadeLocal;
import co.mpc.frontend.controllers.IManagedBean;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Brayan Mendez
 */

@Named(value = "estadoComponentesManagedBean")
@SessionScoped
public class EstadoComponenteManagedBean implements Serializable, IManagedBean<EstadoComponente> {


    private EstadoComponente estadoComponente;

    
    @EJB private EstadoComponenteFacadeLocal estadoComponentefacadelocal;

    
    public EstadoComponenteManagedBean() {
    }
    
    @PostConstruct
    public void init(){
        estadoComponente = new EstadoComponente();
    }
    

    @Override
    public EstadoComponente getObjetoByKey(Integer id) {
        return estadoComponentefacadelocal.find(id);
    }
    
    public EstadoComponente getEstadoComponente() {
        return estadoComponente;
    }

    public void setEstadoComponente(EstadoComponente estadoComponente) {
        this.estadoComponente = estadoComponente;
    }

   
    
   // Metodos
    public void registrarEstadoComponente(){       
        estadoComponentefacadelocal.create(estadoComponente);
    }
    
    public void eliminarEstadoComponente(EstadoComponente ec){
        estadoComponentefacadelocal.remove(ec);
    }
    
    public List<EstadoComponente> listaEstadoComponentes(){
        return estadoComponentefacadelocal.findAll();
    }
    
    public void editarEstadoComponente(EstadoComponente ec){
        estadoComponentefacadelocal.edit(ec);
    }

    
}
