/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.backend.persistence.model.facades;

import co.mpc.backend.persistence.model.entities.DocumentoVehiculo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author SENA
 */
@Local
public interface DocumentoVehiculoFacadeLocal {

    void create(DocumentoVehiculo documentoVehiculo);

    void edit(DocumentoVehiculo documentoVehiculo);

    void remove(DocumentoVehiculo documentoVehiculo);

    DocumentoVehiculo find(Object id);

    List<DocumentoVehiculo> findAll();

    List<DocumentoVehiculo> findRange(int[] range);

    int count();
    
}
