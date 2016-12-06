/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.backend.persistence.model.facades;

import co.mpc.backend.persistence.model.entities.FallaVehiculo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author SENA
 */
@Local
public interface FallaVehiculoFacadeLocal {

    void create(FallaVehiculo fallaVehiculo);

    void edit(FallaVehiculo fallaVehiculo);

    void remove(FallaVehiculo fallaVehiculo);

    FallaVehiculo find(Object id);

    List<FallaVehiculo> findAll();

    List<FallaVehiculo> findRange(int[] range);

    int count();
    
}
