package co.mpc.frontend.usuarios.controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import java.util.List;
import javax.ejb.EJB;
import co.mpc.backend.persistence.model.entities.Usuario;
import co.mpc.backend.persistence.model.facades.UsuarioFacadeLocal;
import co.mpc.frontend.controllers.IManagedBean;

@Named(value = "usuarioManagedBean")
@SessionScoped
public class UsuarioManagedBean implements Serializable,IManagedBean<Usuario> {
    private Usuario usuario;
    @EJB UsuarioFacadeLocal usuarioFacadeLocal;
    public UsuarioManagedBean() {
    }
    @PostConstruct
    public void init(){
        usuario = new Usuario();
    }
    @Override
    public Usuario getObjetoByKey(Integer id) {
        return usuarioFacadeLocal.find(id);
    }
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public void registrarUsuario(){
        usuarioFacadeLocal.create(usuario);
    }
    public void eliminarUsuario(Usuario u){
        usuarioFacadeLocal.remove(u);
    }
    public List<Usuario> ListarUsuario(){
        return usuarioFacadeLocal.findAll();
    }
    public String redireccionar(Usuario u){
        usuario = u;
        return "";
    }
    public void editarUsuario(){
        usuarioFacadeLocal.edit(usuario);
    } 
}
