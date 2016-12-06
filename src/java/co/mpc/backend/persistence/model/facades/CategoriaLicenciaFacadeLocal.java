/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.backend.persistence.model.facades;

import co.mpc.backend.persistence.model.entities.CategoriaLicencia;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author SENA
 */
@Local
public interface CategoriaLicenciaFacadeLocal {

    void create(CategoriaLicencia categoriaLicencia);

    void edit(CategoriaLicencia categoriaLicencia);

    void remove(CategoriaLicencia categoriaLicencia);

    CategoriaLicencia find(Object id);

    List<CategoriaLicencia> findAll();

    List<CategoriaLicencia> findRange(int[] range);

    int count();
    
}
