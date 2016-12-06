/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.frontend.fallas.controllers;

import co.mpc.backend.persistence.model.entities.CategoriaLicencia;
import co.mpc.backend.persistence.model.facades.CategoriaLicenciaFacadeLocal;
import co.mpc.frontend.controllers.IManagedBean;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author Andres
 */
@Named(value = "categoriaLicenciaManagedBean")
@SessionScoped
public class CategoriaLicenciaManagedBean implements Serializable, IManagedBean<CategoriaLicencia> {

    private CategoriaLicencia categoriaLicencia;
    @EJB private CategoriaLicenciaFacadeLocal categoriaLicenciaFacadeLocal;
    
    public CategoriaLicenciaManagedBean() {
    }
    
    @PostConstruct
    public void init(){
        categoriaLicencia = new CategoriaLicencia();
    }

    @Override
    public CategoriaLicencia getObjetoByKey(Integer id) {
        return categoriaLicenciaFacadeLocal.find(id);
    }
    
    public CategoriaLicencia getCategoriaLicencia() {
        return categoriaLicencia;
    }

    public void setCategoriaLicencia(CategoriaLicencia categoriaLicencia) {
        this.categoriaLicencia = categoriaLicencia;
    }

    
    public void registrarCategoriaLicencia(){
        categoriaLicenciaFacadeLocal.create(categoriaLicencia);
    }
    
    public void eliminarCategoriaLicencia(){
        categoriaLicenciaFacadeLocal.remove(categoriaLicencia);
    }
    
    public List<CategoriaLicencia> listaTiposFallas(){
        return categoriaLicenciaFacadeLocal.findAll();
    }
    
    public void editarCategoriaLicencia(CategoriaLicencia to){
        categoriaLicenciaFacadeLocal.edit(to);
    }
}
