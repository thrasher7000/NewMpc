package co.mpc.frontend.usuarios.controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable; 
import co.mpc.backend.persistence.model.entities.Rol;
import co.mpc.backend.persistence.model.facades.RolFacadeLocal;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import co.mpc.frontend.controllers.IManagedBean;
import java.util.List;

/**
 *
 * @author Miguel Angel Rivera Niño
 */
@Named(value = "rolManagedBean")
@SessionScoped
public class RolManagedBean implements Serializable,IManagedBean<Rol>{
    private Rol rol;
    @EJB private RolFacadeLocal rolFacadeLocal;
    public RolManagedBean() {
    }
    @PostConstruct
    public void init(){
        rol = new Rol();
    }
    @Override
    public Rol getObjetoByKey(Integer id) {
       return rolFacadeLocal.find(id);
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    public void registrarRol(){
        rolFacadeLocal.create(rol);
    }
    public void eliminarRol(Rol r){
         rolFacadeLocal.remove(r);
    }
    public List<Rol> listarRoles(){
        return rolFacadeLocal.findAll();
    }
    public void editarRol(Rol r){ 
        rolFacadeLocal.edit(rol);
    }
}
