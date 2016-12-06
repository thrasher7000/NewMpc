package co.mpc.frontend.usuarios.utilities.converter;

import co.mpc.backend.persistence.model.entities.Rol;
import co.mpc.frontend.utilities.converters.AbstractConverter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Andres
 */
@FacesConverter ( forClass = Rol.class)
public class RolConverter extends AbstractConverter{

    public RolConverter() {
        this.nameManagedBean = "conductorMangedBean";
    }
    
}
