/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.backend.persistence.model.facades;

import co.mpc.backend.persistence.model.entities.ComponenteVehiculo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author SENA
 */
@Local
public interface ComponenteVehiculoFacadeLocal {

    void create(ComponenteVehiculo componenteVehiculo);

    void edit(ComponenteVehiculo componenteVehiculo);

    void remove(ComponenteVehiculo componenteVehiculo);

    ComponenteVehiculo find(Object id);

    List<ComponenteVehiculo> findAll();

    List<ComponenteVehiculo> findRange(int[] range);

    int count();
    
}
