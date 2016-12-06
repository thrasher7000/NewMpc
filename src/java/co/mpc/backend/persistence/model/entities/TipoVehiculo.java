/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.backend.persistence.model.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author SENA
 */
@Entity
@Table(name = "tipos_vehiculos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoVehiculo.findAll", query = "SELECT t FROM TipoVehiculo t"),
    @NamedQuery(name = "TipoVehiculo.findByIdTipoVehiculos", query = "SELECT t FROM TipoVehiculo t WHERE t.idTipoVehiculos = :idTipoVehiculos"),
    @NamedQuery(name = "TipoVehiculo.findByNombreTipoVehiculo", query = "SELECT t FROM TipoVehiculo t WHERE t.nombreTipoVehiculo = :nombreTipoVehiculo")})
public class TipoVehiculo implements Serializable, IDTO {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_vehiculos")
    private Integer idTipoVehiculos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 33)
    @Column(name = "nombre_tipo_vehiculo")
    private String nombreTipoVehiculo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoVehiculo", fetch = FetchType.LAZY)
    private Collection<CategoriaLicencia> categoriaLicenciaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoVehiculo", fetch = FetchType.LAZY)
    private Collection<Vehiculo> vehiculoCollection;

    public TipoVehiculo() {
    }

    public TipoVehiculo(Integer idTipoVehiculos) {
        this.idTipoVehiculos = idTipoVehiculos;
    }

    public TipoVehiculo(Integer idTipoVehiculos, String nombreTipoVehiculo) {
        this.idTipoVehiculos = idTipoVehiculos;
        this.nombreTipoVehiculo = nombreTipoVehiculo;
    }

    public Integer getIdTipoVehiculos() {
        return idTipoVehiculos;
    }

    public void setIdTipoVehiculos(Integer idTipoVehiculos) {
        this.idTipoVehiculos = idTipoVehiculos;
    }

    public String getNombreTipoVehiculo() {
        return nombreTipoVehiculo;
    }

    public void setNombreTipoVehiculo(String nombreTipoVehiculo) {
        this.nombreTipoVehiculo = nombreTipoVehiculo;
    }

    @XmlTransient
    public Collection<CategoriaLicencia> getCategoriaLicenciaCollection() {
        return categoriaLicenciaCollection;
    }

    public void setCategoriaLicenciaCollection(Collection<CategoriaLicencia> categoriaLicenciaCollection) {
        this.categoriaLicenciaCollection = categoriaLicenciaCollection;
    }

    @XmlTransient
    public Collection<Vehiculo> getVehiculoCollection() {
        return vehiculoCollection;
    }

    public void setVehiculoCollection(Collection<Vehiculo> vehiculoCollection) {
        this.vehiculoCollection = vehiculoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoVehiculos != null ? idTipoVehiculos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoVehiculo)) {
            return false;
        }
        TipoVehiculo other = (TipoVehiculo) object;
        if ((this.idTipoVehiculos == null && other.idTipoVehiculos != null) || (this.idTipoVehiculos != null && !this.idTipoVehiculos.equals(other.idTipoVehiculos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mpc.backend.persistence.model.entities.TipoVehiculo[ idTipoVehiculos=" + idTipoVehiculos + " ]";
    }

    @Override
    public String getPrimaryKey() {
        return idTipoVehiculos.toString();
    }
    
}
