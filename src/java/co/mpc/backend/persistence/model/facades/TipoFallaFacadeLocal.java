/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.backend.persistence.model.facades;

import co.mpc.backend.persistence.model.entities.TipoFalla;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author SENA
 */
@Local
public interface TipoFallaFacadeLocal {

    void create(TipoFalla tipoFalla);

    void edit(TipoFalla tipoFalla);

    void remove(TipoFalla tipoFalla);

    TipoFalla find(Object id);

    List<TipoFalla> findAll();

    List<TipoFalla> findRange(int[] range);

    int count();
    
}
