package co.mpc.frontend.usuarios.utilities.converter;

import co.mpc.backend.persistence.model.entities.RolPermiso;
import co.mpc.frontend.utilities.converters.AbstractConverter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Andres
 */
@FacesConverter ( forClass = RolPermiso.class)
public class RolPermisoConverter extends AbstractConverter{

    public RolPermisoConverter() {
        this.nameManagedBean = "conductorMangedBean";
    }
    
}
