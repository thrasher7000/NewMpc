/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.backend.persistence.model.facades;

import co.mpc.backend.persistence.model.entities.RolPermiso;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author SENA
 */
@Local
public interface RolPermisoFacadeLocal {

    void create(RolPermiso rolPermiso);

    void edit(RolPermiso rolPermiso);

    void remove(RolPermiso rolPermiso);

    RolPermiso find(Object id);

    List<RolPermiso> findAll();

    List<RolPermiso> findRange(int[] range);

    int count();
    
}
