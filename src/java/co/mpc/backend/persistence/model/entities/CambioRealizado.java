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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SENA
 */
@Entity
@Table(name = "cambios_realizados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CambioRealizado.findAll", query = "SELECT c FROM CambioRealizado c"),
    @NamedQuery(name = "CambioRealizado.findByIdCambioRealizado", query = "SELECT c FROM CambioRealizado c WHERE c.idCambioRealizado = :idCambioRealizado"),
    @NamedQuery(name = "CambioRealizado.findByCostoComponenteUnitario", query = "SELECT c FROM CambioRealizado c WHERE c.costoComponenteUnitario = :costoComponenteUnitario")})
public class CambioRealizado implements Serializable, IDTO {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cambio_realizado")
    private Integer idCambioRealizado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo_componente_unitario")
    private double costoComponenteUnitario;
    @JoinColumn(name = "id_componente_vehiculo", referencedColumnName = "id_componente_vehiculo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ComponenteVehiculo idComponenteVehiculo;
    @JoinColumn(name = "id_mantenimiento", referencedColumnName = "id_mantenimiento")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Mantenimiento idMantenimiento;
    @JoinColumn(name = "id_tipo_falla", referencedColumnName = "id_tipo_falla")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoFalla idTipoFalla;

    public CambioRealizado() {
    }

    public CambioRealizado(Integer idCambioRealizado) {
        this.idCambioRealizado = idCambioRealizado;
    }

    public CambioRealizado(Integer idCambioRealizado, double costoComponenteUnitario) {
        this.idCambioRealizado = idCambioRealizado;
        this.costoComponenteUnitario = costoComponenteUnitario;
    }

    public Integer getIdCambioRealizado() {
        return idCambioRealizado;
    }

    public void setIdCambioRealizado(Integer idCambioRealizado) {
        this.idCambioRealizado = idCambioRealizado;
    }

    public double getCostoComponenteUnitario() {
        return costoComponenteUnitario;
    }

    public void setCostoComponenteUnitario(double costoComponenteUnitario) {
        this.costoComponenteUnitario = costoComponenteUnitario;
    }

    public ComponenteVehiculo getIdComponenteVehiculo() {
        return idComponenteVehiculo;
    }

    public void setIdComponenteVehiculo(ComponenteVehiculo idComponenteVehiculo) {
        this.idComponenteVehiculo = idComponenteVehiculo;
    }

    public Mantenimiento getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(Mantenimiento idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    public TipoFalla getIdTipoFalla() {
        return idTipoFalla;
    }

    public void setIdTipoFalla(TipoFalla idTipoFalla) {
        this.idTipoFalla = idTipoFalla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCambioRealizado != null ? idCambioRealizado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CambioRealizado)) {
            return false;
        }
        CambioRealizado other = (CambioRealizado) object;
        if ((this.idCambioRealizado == null && other.idCambioRealizado != null) || (this.idCambioRealizado != null && !this.idCambioRealizado.equals(other.idCambioRealizado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mpc.backend.persistence.model.entities.CambioRealizado[ idCambioRealizado=" + idCambioRealizado + " ]";
    }

    @Override
    public String getPrimaryKey() {
        return idCambioRealizado.toString();
    }
    
}
