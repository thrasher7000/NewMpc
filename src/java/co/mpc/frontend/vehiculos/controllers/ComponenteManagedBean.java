package co.mpc.frontend.vehiculos.controllers;

import co.mpc.backend.persistence.model.entities.Componente;
import co.mpc.backend.persistence.model.facades.ComponenteFacadeLocal;
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

@Named(value = "componenteManagedBean")
@SessionScoped
public class ComponenteManagedBean implements Serializable, IManagedBean<Componente>{


    
    private Componente componente;
    
    @EJB
    
    private ComponenteFacadeLocal componenteFacadeLocal;
    
    public ComponenteManagedBean() {
    }
    
    @PostConstruct
    public void init(){
        componente = new Componente(); 
    }
    
    
    @Override
    public Componente getObjetoByKey(Integer id) {
        return componenteFacadeLocal.find(id);
    }
    

    public Componente getComponente() {
        return componente;
    }

    public void setComponente(Componente componente) {
        this.componente = componente;
    }
    
    
    // Metodos
    public void registrarComponente(){
        componenteFacadeLocal.create(componente);
    }
    
    public void eliminarComponente(Componente c){
        componenteFacadeLocal.remove(c);
    }
    
    public List<Componente> listaComponente(){
        return componenteFacadeLocal.findAll();
    }
    
    public void editarComponente(Componente c){
        componenteFacadeLocal.edit(c);
    }
    
}
