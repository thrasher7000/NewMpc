/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.backend.persistence.model.entities;

import java.io.Serializable;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SENA
 */
@Entity
@Table(name = "fallas_vehiculos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FallaVehiculo.findAll", query = "SELECT f FROM FallaVehiculo f"),
    @NamedQuery(name = "FallaVehiculo.findByIdFallaVehiculo", query = "SELECT f FROM FallaVehiculo f WHERE f.idFallaVehiculo = :idFallaVehiculo")})
public class FallaVehiculo implements Serializable, IDTO{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_falla_vehiculo")
    private Integer idFallaVehiculo;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "id_conductor_falla", referencedColumnName = "id_usuario_conductor")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Conductor idConductorFalla;
    @JoinColumn(name = "id_tipo_falla", referencedColumnName = "id_tipo_falla")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoFalla idTipoFalla;
    @JoinColumn(name = "id_vehiculo_falla", referencedColumnName = "id_vehiculo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Vehiculo idVehiculoFalla;

    public FallaVehiculo() {
    }

    public FallaVehiculo(Integer idFallaVehiculo) {
        this.idFallaVehiculo = idFallaVehiculo;
    }

    public FallaVehiculo(Integer idFallaVehiculo, String descripcion) {
        this.idFallaVehiculo = idFallaVehiculo;
        this.descripcion = descripcion;
    }

    public Integer getIdFallaVehiculo() {
        return idFallaVehiculo;
    }

    public void setIdFallaVehiculo(Integer idFallaVehiculo) {
        this.idFallaVehiculo = idFallaVehiculo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Conductor getIdConductorFalla() {
        return idConductorFalla;
    }

    public void setIdConductorFalla(Conductor idConductorFalla) {
        this.idConductorFalla = idConductorFalla;
    }

    public TipoFalla getIdTipoFalla() {
        return idTipoFalla;
    }

    public void setIdTipoFalla(TipoFalla idTipoFalla) {
        this.idTipoFalla = idTipoFalla;
    }

    public Vehiculo getIdVehiculoFalla() {
        return idVehiculoFalla;
    }

    public void setIdVehiculoFalla(Vehiculo idVehiculoFalla) {
        this.idVehiculoFalla = idVehiculoFalla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFallaVehiculo != null ? idFallaVehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FallaVehiculo)) {
            return false;
        }
        FallaVehiculo other = (FallaVehiculo) object;
        if ((this.idFallaVehiculo == null && other.idFallaVehiculo != null) || (this.idFallaVehiculo != null && !this.idFallaVehiculo.equals(other.idFallaVehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mpc.backend.persistence.model.entities.FallaVehiculo[ idFallaVehiculo=" + idFallaVehiculo + " ]";
    }
    
    @Override
    public String getPrimaryKey(){
        return idFallaVehiculo.toString();
    }
}
