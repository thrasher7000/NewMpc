package co.mpc.frontend.usuarios.utilities.converter;

import co.mpc.backend.persistence.model.entities.EstadoUsuario;
import co.mpc.frontend.utilities.converters.AbstractConverter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Andres
 */
@FacesConverter ( forClass = EstadoUsuario.class)
public class EstadoUsuarioConverter extends AbstractConverter{

    public EstadoUsuarioConverter() {
        this.nameManagedBean = "conductorMangedBean";
    }
    
}
