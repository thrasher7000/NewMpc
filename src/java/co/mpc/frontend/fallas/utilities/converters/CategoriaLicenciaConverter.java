/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.frontend.fallas.utilities.converters;

import co.mpc.backend.persistence.model.entities.CategoriaLicencia;
import co.mpc.frontend.utilities.converters.AbstractConverter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Andres
 */
@FacesConverter( forClass = CategoriaLicencia.class)
public class CategoriaLicenciaConverter extends AbstractConverter {
    public CategoriaLicenciaConverter(){
        this.nameManagedBean = "categoriaLicenciaManagedBean";
    }
}
