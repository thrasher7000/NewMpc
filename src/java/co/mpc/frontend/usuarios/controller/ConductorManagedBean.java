package co.mpc.frontend.usuarios.controller;

import co.mpc.backend.persistence.model.entities.Conductor;
import co.mpc.backend.persistence.model.facades.ConductorFacadeLocal;
import co.mpc.frontend.controllers.IManagedBean;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author Pablo Ramirez
 */

@Named(value = "conductorManagedBean")
@SessionScoped
public class ConductorManagedBean implements Serializable, IManagedBean<Conductor>{

    private Conductor conductor;
    @EJB private ConductorFacadeLocal conductorFacadeLocal;
    
    public ConductorManagedBean() {
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
    
}
