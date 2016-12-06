/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.backend.persistence.model.facades;

import co.mpc.backend.persistence.model.entities.Mantenimiento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author SENA
 */
@Local
public interface MantenimientoFacadeLocal {

    void create(Mantenimiento mantenimiento);

    void edit(Mantenimiento mantenimiento);

    void remove(Mantenimiento mantenimiento);

    Mantenimiento find(Object id);

    List<Mantenimiento> findAll();

    List<Mantenimiento> findRange(int[] range);

    int count();
    
}
