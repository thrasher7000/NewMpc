package co.mpc.frontend.usuarios.controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import java.util.List;
import co.mpc.backend.persistence.model.entities.EstadoUsuario;
import co.mpc.backend.persistence.model.facades.EstadoUsuarioFacadeLocal;
import co.mpc.frontend.controllers.IManagedBean;
/**
 *
 * @author Miguel Angel Rivera Niño
 */
@Named(value = "estadoUsuarioManagedBean")
@SessionScoped
public class EstadoUsuarioManagedBean implements Serializable, IManagedBean<EstadoUsuario>{
    private EstadoUsuario estadoUsuario;
    @EJB private EstadoUsuarioFacadeLocal estadoUsuarioFacadeLocal;
    public EstadoUsuarioManagedBean() {
    }
    @PostConstruct
    public void init(){
        estadoUsuario = new EstadoUsuario();
    }
    @Override
    public EstadoUsuario getObjetoByKey(Integer id) {
        return estadoUsuarioFacadeLocal.find(id);
    }

    public EstadoUsuario getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(EstadoUsuario estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }
    public void registrarEstadoUsuario(){
        estadoUsuarioFacadeLocal.create(estadoUsuario);
    }
    public void eliminarEstadoUsuario(EstadoUsuario e){
        estadoUsuarioFacadeLocal.remove(estadoUsuario);
    }
    public List<EstadoUsuario> listarEstadoUsuario(){
        return estadoUsuarioFacadeLocal.findAll();
    }
    public void editarEstadoUsuario(EstadoUsuario e){
        estadoUsuarioFacadeLocal.edit(e);
    }
}
