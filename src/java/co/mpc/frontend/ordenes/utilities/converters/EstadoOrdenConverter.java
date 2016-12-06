/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.frontend.ordenes.utilities.converters;

import co.mpc.backend.persistence.model.entities.EstadoOrden;
import co.mpc.frontend.utilities.converters.AbstractConverter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Juank
 */
@FacesConverter(forClass = EstadoOrden.class)
public class EstadoOrdenConverter extends AbstractConverter {

    public EstadoOrdenConverter() {
        this.nameManagedBean = "estadoOrdenManagedBean";
    }

}
