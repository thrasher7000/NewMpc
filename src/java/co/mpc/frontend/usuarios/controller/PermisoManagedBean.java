/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.frontend.usuarios.controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author SENA
 */
@Named(value = "permisoManagedBean")
@SessionScoped
public class PermisoManagedBean implements Serializable {

    /**
     * Creates a new instance of PermisoManagedBean
     */
    public PermisoManagedBean() {
    }
    
}
