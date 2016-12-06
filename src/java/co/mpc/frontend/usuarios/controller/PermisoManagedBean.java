package co.mpc.frontend.usuarios.controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import java.util.List;
import javax.ejb.EJB;
import co.mpc.frontend.controllers.IManagedBean;
import co.mpc.backend.persistence.model.entities.Permiso;
import co.mpc.backend.persistence.model.facades.PermisoFacadeLocal;

/**
 *
 * @author Miguel Angel Rivera Niño
 */
@Named(value = "permisoManagedBean")
@SessionScoped
public class PermisoManagedBean implements Serializable ,IManagedBean<Permiso> {
    private Permiso permiso;
    @EJB private PermisoFacadeLocal permisoFacadeLocal;
    public PermisoManagedBean() {
    }
    @PostConstruct
    public void init(){
        permiso = new Permiso();
    }
    @Override
    public Permiso getObjetoByKey(Integer id) {
        return permisoFacadeLocal.find(id);
    }

    public Permiso getPermiso() {
        return permiso;
    }

    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }
    public void registrarPermiso(){
        permisoFacadeLocal.create(permiso);
    }
    public void eliminarPermiso(Permiso p){
        permisoFacadeLocal.remove(permiso);
    }
    public List<Permiso> listarPermisos(Permiso p){
        return permisoFacadeLocal.findAll();
    }
    public void actualizarPermiso(){
        permisoFacadeLocal.edit(permiso);
    }
}
