/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.frontend.usuarios.controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import co.mpc.frontend.controllers.IManagedBean;
import co.mpc.backend.persistence.model.entities.RolPermiso;
import co.mpc.backend.persistence.model.facades.RolPermisoFacadeLocal;
import co.mpc.backend.persistence.model.entities.Rol;
import co.mpc.backend.persistence.model.entities.Permiso;
import javax.annotation.PostConstruct;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Miguel Angel Rivera Niño
 */
@Named(value = "rolPermisoManagedBean")
@SessionScoped
public class RolPermisoManagedBean implements Serializable, IManagedBean<RolPermiso> {
    private RolPermiso rolPermiso;
    private Rol rol;
    private Permiso permiso;
    @EJB RolPermisoFacadeLocal rolPermisoFacadeLocal;
    public RolPermisoManagedBean() {
    }
    @PostConstruct
    public void init(){
        rolPermiso = new RolPermiso();
        rol = new Rol();
        permiso = new Permiso();
    }
    @Override
    public RolPermiso getObjetoByKey(Integer id) {
        return rolPermisoFacadeLocal.find(id);
    }

    public RolPermiso getRolPermiso() {
        return rolPermiso;
    }

    public void setRolPermiso(RolPermiso rolPermiso) {
        this.rolPermiso = rolPermiso;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Permiso getPermiso() {
        return permiso;
    }

    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }
    public void registrarRolPermiso(){
        rolPermisoFacadeLocal.create(rolPermiso);
    }
    public void eliminarRolPermiso(RolPermiso r){
        rolPermisoFacadeLocal.remove(r);
    }
    public List <RolPermiso> listarPermiso(){
        return rolPermisoFacadeLocal.findAll();
    }
    public void editarPermisoRol(RolPermiso p){
        rolPermisoFacadeLocal.edit(p);
    }
}
