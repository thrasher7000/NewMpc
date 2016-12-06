package co.mpc.frontend.vehiculos.controllers;

import co.mpc.backend.persistence.model.entities.EstadoDocumento;
import co.mpc.backend.persistence.model.facades.EstadoDocumentoFacadeLocal;
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
@Named(value = "estadoDocumentoManagedBean")
@SessionScoped
public class EstadoDocumentoManagedBean implements Serializable, IManagedBean {

    EstadoDocumento estadoDocumento;
    
    @EJB
    
    EstadoDocumentoFacadeLocal estadoDocumentoFacadeLocal;
    
    public EstadoDocumentoManagedBean() {
    }
    
    @PostConstruct
    
    public void init(){
        estadoDocumento = new EstadoDocumento();
    }
    

    @Override
    public Object getObjetoByKey(Integer id) {
        return estadoDocumentoFacadeLocal.find(id);
    }

    public EstadoDocumento getEstadoDocumento() {
        return estadoDocumento;
    }

    public void setEstadoDocumento(EstadoDocumento estadoDocumento) {
        this.estadoDocumento = estadoDocumento;
    }
    
    
    // Metodo
    
    public void registrarEstadoDocumento(){
        estadoDocumentoFacadeLocal.create(estadoDocumento);
    }
    
    public void eliminarEstadoDocumento(EstadoDocumento ed){
        estadoDocumentoFacadeLocal.remove(ed);
    }
    
    public List<EstadoDocumento> listaEstadoDocumento(){
        return estadoDocumentoFacadeLocal.findAll();
    }
    
    public void editarEstadoDocumento(EstadoDocumento ed){
        estadoDocumentoFacadeLocal.edit(ed);
    }
}
