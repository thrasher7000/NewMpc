/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.backend.persistence.model.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author SENA
 */
@Entity
@Table(name = "componentes_vehiculos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComponenteVehiculo.findAll", query = "SELECT c FROM ComponenteVehiculo c"),
    @NamedQuery(name = "ComponenteVehiculo.findByIdComponenteVehiculo", query = "SELECT c FROM ComponenteVehiculo c WHERE c.idComponenteVehiculo = :idComponenteVehiculo"),
    @NamedQuery(name = "ComponenteVehiculo.findByFechaAdquisicion", query = "SELECT c FROM ComponenteVehiculo c WHERE c.fechaAdquisicion = :fechaAdquisicion"),
    @NamedQuery(name = "ComponenteVehiculo.findByUltimaFechaCambio", query = "SELECT c FROM ComponenteVehiculo c WHERE c.ultimaFechaCambio = :ultimaFechaCambio")})
public class ComponenteVehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_componente_vehiculo")
    private Integer idComponenteVehiculo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_adquisicion")
    @Temporal(TemporalType.DATE)
    private Date fechaAdquisicion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ultima_fecha_cambio")
    @Temporal(TemporalType.DATE)
    private Date ultimaFechaCambio;
    @JoinColumn(name = "id_componente", referencedColumnName = "id_componente")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Componente idComponente;
    @JoinColumn(name = "id_estado_componente", referencedColumnName = "id_estado_componente")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstadoComponente idEstadoComponente;
    @JoinColumn(name = "id_vehiculo", referencedColumnName = "id_vehiculo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Vehiculo idVehiculo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idComponenteVehiculo", fetch = FetchType.LAZY)
    private Collection<CambioRealizado> cambioRealizadoCollection;

    public ComponenteVehiculo() {
    }

    public ComponenteVehiculo(Integer idComponenteVehiculo) {
        this.idComponenteVehiculo = idComponenteVehiculo;
    }

    public ComponenteVehiculo(Integer idComponenteVehiculo, Date fechaAdquisicion, Date ultimaFechaCambio) {
        this.idComponenteVehiculo = idComponenteVehiculo;
        this.fechaAdquisicion = fechaAdquisicion;
        this.ultimaFechaCambio = ultimaFechaCambio;
    }

    public Integer getIdComponenteVehiculo() {
        return idComponenteVehiculo;
    }

    public void setIdComponenteVehiculo(Integer idComponenteVehiculo) {
        this.idComponenteVehiculo = idComponenteVehiculo;
    }

    public Date getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(Date fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public Date getUltimaFechaCambio() {
        return ultimaFechaCambio;
    }

    public void setUltimaFechaCambio(Date ultimaFechaCambio) {
        this.ultimaFechaCambio = ultimaFechaCambio;
    }

    public Componente getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(Componente idComponente) {
        this.idComponente = idComponente;
    }

    public EstadoComponente getIdEstadoComponente() {
        return idEstadoComponente;
    }

    public void setIdEstadoComponente(EstadoComponente idEstadoComponente) {
        this.idEstadoComponente = idEstadoComponente;
    }

    public Vehiculo getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Vehiculo idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    @XmlTransient
    public Collection<CambioRealizado> getCambioRealizadoCollection() {
        return cambioRealizadoCollection;
    }

    public void setCambioRealizadoCollection(Collection<CambioRealizado> cambioRealizadoCollection) {
        this.cambioRealizadoCollection = cambioRealizadoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComponenteVehiculo != null ? idComponenteVehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComponenteVehiculo)) {
            return false;
        }
        ComponenteVehiculo other = (ComponenteVehiculo) object;
        if ((this.idComponenteVehiculo == null && other.idComponenteVehiculo != null) || (this.idComponenteVehiculo != null && !this.idComponenteVehiculo.equals(other.idComponenteVehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mpc.backend.persistence.model.entities.ComponenteVehiculo[ idComponenteVehiculo=" + idComponenteVehiculo + " ]";
    }
    
}
