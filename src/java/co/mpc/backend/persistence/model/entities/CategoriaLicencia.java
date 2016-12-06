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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "categoria_licencias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoriaLicencia.findAll", query = "SELECT c FROM CategoriaLicencia c"),
    @NamedQuery(name = "CategoriaLicencia.findByIdCategoriaLicencia", query = "SELECT c FROM CategoriaLicencia c WHERE c.idCategoriaLicencia = :idCategoriaLicencia"),
    @NamedQuery(name = "CategoriaLicencia.findByNombreCategoria", query = "SELECT c FROM CategoriaLicencia c WHERE c.nombreCategoria = :nombreCategoria")})
public class CategoriaLicencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_categoria_licencia")
    private Integer idCategoriaLicencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_categoria")
    private String nombreCategoria;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcion_categoria")
    private String descripcionCategoria;
    @JoinColumn(name = "id_tipo_vehiculo", referencedColumnName = "id_tipo_vehiculos")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoVehiculo idTipoVehiculo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategoriaLicencia", fetch = FetchType.LAZY)
    private Collection<Conductor> conductorCollection;

    public CategoriaLicencia() {
    }

    public CategoriaLicencia(Integer idCategoriaLicencia) {
        this.idCategoriaLicencia = idCategoriaLicencia;
    }

    public CategoriaLicencia(Integer idCategoriaLicencia, String nombreCategoria, String descripcionCategoria) {
        this.idCategoriaLicencia = idCategoriaLicencia;
        this.nombreCategoria = nombreCategoria;
        this.descripcionCategoria = descripcionCategoria;
    }

    public Integer getIdCategoriaLicencia() {
        return idCategoriaLicencia;
    }

    public void setIdCategoriaLicencia(Integer idCategoriaLicencia) {
        this.idCategoriaLicencia = idCategoriaLicencia;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getDescripcionCategoria() {
        return descripcionCategoria;
    }

    public void setDescripcionCategoria(String descripcionCategoria) {
        this.descripcionCategoria = descripcionCategoria;
    }

    public TipoVehiculo getIdTipoVehiculo() {
        return idTipoVehiculo;
    }

    public void setIdTipoVehiculo(TipoVehiculo idTipoVehiculo) {
        this.idTipoVehiculo = idTipoVehiculo;
    }

    @XmlTransient
    public Collection<Conductor> getConductorCollection() {
        return conductorCollection;
    }

    public void setConductorCollection(Collection<Conductor> conductorCollection) {
        this.conductorCollection = conductorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoriaLicencia != null ? idCategoriaLicencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaLicencia)) {
            return false;
        }
        CategoriaLicencia other = (CategoriaLicencia) object;
        if ((this.idCategoriaLicencia == null && other.idCategoriaLicencia != null) || (this.idCategoriaLicencia != null && !this.idCategoriaLicencia.equals(other.idCategoriaLicencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mpc.backend.persistence.model.entities.CategoriaLicencia[ idCategoriaLicencia=" + idCategoriaLicencia + " ]";
    }
    
}
