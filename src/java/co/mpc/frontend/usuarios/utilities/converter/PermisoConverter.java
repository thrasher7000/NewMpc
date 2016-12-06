package co.mpc.frontend.usuarios.utilities.converter;

import co.mpc.backend.persistence.model.entities.Permiso;
import co.mpc.frontend.utilities.converters.AbstractConverter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Andres
 */
@FacesConverter ( forClass = Permiso.class)
public class PermisoConverter extends AbstractConverter{

    public PermisoConverter() {
        this.nameManagedBean = "conductorMangedBean";
    }
    
}
