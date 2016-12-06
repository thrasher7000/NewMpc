package co.mpc.frontend.fallas.controllers;

import co.mpc.backend.persistence.model.entities.TipoFalla;
import co.mpc.backend.persistence.model.facades.TipoFallaFacadeLocal;
import co.mpc.frontend.controllers.IManagedBean;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author Pablo Andres Ramirez
 */
@Named(value = "tipoFallaManagedBean")
@SessionScoped
public class TipoFallaManagedBean implements Serializable, IManagedBean<TipoFalla> {

    private TipoFalla tipoFalla;
    @EJB private TipoFallaFacadeLocal tipoFallaFacadeLocal;
    
    public TipoFallaManagedBean() {
    }
    
    @PostConstruct
    public void init(){
        tipoFalla = new TipoFalla();
    }

    @Override
    public TipoFalla getObjetoByKey(Integer id) {
        return tipoFallaFacadeLocal.find(id);
    }
    
    public TipoFalla getTipoFalla() {
        return tipoFalla;
    }

    public void setTipoFalla(TipoFalla tipoFalla) {
        this.tipoFalla = tipoFalla;
    }

    
    public void registrarTipoFalla(){
        tipoFallaFacadeLocal.create(tipoFalla);
    }
    
    public void eliminarTipoFalla(){
        tipoFallaFacadeLocal.remove(tipoFalla);
    }
    
    public List<TipoFalla> listaTiposFallas(){
        return tipoFallaFacadeLocal.findAll();
    }
    
    public void editarTipoFalla(TipoFalla to){
        tipoFallaFacadeLocal.edit(to);
    }
    
}
