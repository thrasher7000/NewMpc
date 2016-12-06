/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.backend.persistence.model.facades;

import co.mpc.backend.persistence.model.entities.TipoOrden;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author SENA
 */
@Local
public interface TipoOrdenFacadeLocal {

    void create(TipoOrden tipoOrden);

    void edit(TipoOrden tipoOrden);

    void remove(TipoOrden tipoOrden);

    TipoOrden find(Object id);

    List<TipoOrden> findAll();

    List<TipoOrden> findRange(int[] range);

    int count();
    
}
