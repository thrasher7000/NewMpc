/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.backend.persistence.model.facades;

import co.mpc.backend.persistence.model.entities.EstadoDocumento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author SENA
 */
@Local
public interface EstadoDocumentoFacadeLocal {

    void create(EstadoDocumento estadoDocumento);

    void edit(EstadoDocumento estadoDocumento);

    void remove(EstadoDocumento estadoDocumento);

    EstadoDocumento find(Object id);

    List<EstadoDocumento> findAll();

    List<EstadoDocumento> findRange(int[] range);

    int count();
    
}
