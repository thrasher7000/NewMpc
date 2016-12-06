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
@Table(name = "estados_componentes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoComponente.findAll", query = "SELECT e FROM EstadoComponente e"),
    @NamedQuery(name = "EstadoComponente.findByIdEstadoComponente", query = "SELECT e FROM EstadoComponente e WHERE e.idEstadoComponente = :idEstadoComponente"),
    @NamedQuery(name = "EstadoComponente.findByNombreEstadoComponente", query = "SELECT e FROM EstadoComponente e WHERE e.nombreEstadoComponente = :nombreEstadoComponente")})
public class EstadoComponente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado_componente")
    private Integer idEstadoComponente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nombre_estado_componente")
    private String nombreEstadoComponente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoComponente", fetch = FetchType.LAZY)
    private Collection<ComponenteVehiculo> componenteVehiculoCollection;

    public EstadoComponente() {
    }

    public EstadoComponente(Integer idEstadoComponente) {
        this.idEstadoComponente = idEstadoComponente;
    }

    public EstadoComponente(Integer idEstadoComponente, String nombreEstadoComponente) {
        this.idEstadoComponente = idEstadoComponente;
        this.nombreEstadoComponente = nombreEstadoComponente;
    }

    public Integer getIdEstadoComponente() {
        return idEstadoComponente;
    }

    public void setIdEstadoComponente(Integer idEstadoComponente) {
        this.idEstadoComponente = idEstadoComponente;
    }

    public String getNombreEstadoComponente() {
        return nombreEstadoComponente;
    }

    public void setNombreEstadoComponente(String nombreEstadoComponente) {
        this.nombreEstadoComponente = nombreEstadoComponente;
    }

    @XmlTransient
    public Collection<ComponenteVehiculo> getComponenteVehiculoCollection() {
        return componenteVehiculoCollection;
    }

    public void setComponenteVehiculoCollection(Collection<ComponenteVehiculo> componenteVehiculoCollection) {
        this.componenteVehiculoCollection = componenteVehiculoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoComponente != null ? idEstadoComponente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoComponente)) {
            return false;
        }
        EstadoComponente other = (EstadoComponente) object;
        if ((this.idEstadoComponente == null && other.idEstadoComponente != null) || (this.idEstadoComponente != null && !this.idEstadoComponente.equals(other.idEstadoComponente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mpc.backend.persistence.model.entities.EstadoComponente[ idEstadoComponente=" + idEstadoComponente + " ]";
    }
    
}
