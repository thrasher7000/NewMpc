/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.frontend.usuarios.utilities.converter;

import co.mpc.backend.persistence.model.entities.Conductor;
import co.mpc.frontend.utilities.converters.AbstractConverter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Andres
 */
@FacesConverter ( forClass = Conductor.class)
public class ConductorConverter extends AbstractConverter{

    public ConductorConverter() {
        this.nameManagedBean = "conductorMangedBean";
    }
    
}
