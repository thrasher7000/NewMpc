package co.mpc.frontend.vehiculos.controllers;

import co.mpc.backend.persistence.model.entities.TipoDocumento;
import co.mpc.backend.persistence.model.facades.TipoDocumentoFacadeLocal;
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
@Named(value = "tipoDocumentoManagedBean")
@SessionScoped
public class TipoDocumentoManagedBean implements Serializable, IManagedBean {
    
    private TipoDocumento tipoDocumento;
    
    @EJB TipoDocumentoFacadeLocal tipoDocumentoFacadeLocal;

    public TipoDocumentoManagedBean() {
    }
    
    @PostConstruct
    
    public void init(){
        tipoDocumento = new TipoDocumento();
    }

    
    @Override
    public Object getObjetoByKey(Integer id) {
        return tipoDocumentoFacadeLocal.find(id);
    }
    

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
    
    
    // Metodos
    
    public void registrarTipoDocumento(){
        tipoDocumentoFacadeLocal.create(tipoDocumento);
    }
    
    public void elimianrTipoDocumento(TipoDocumento td){
        tipoDocumentoFacadeLocal.remove(td);
    }
    
    public List<TipoDocumento> listaTipoDocumento(){
        return tipoDocumentoFacadeLocal.findAll();
    }
    
    public void editarTipoDocumento(TipoDocumento td){
        tipoDocumentoFacadeLocal.edit(td);
    }
    
    
}
