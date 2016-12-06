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
@Table(name = "estados_ordenes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoOrden.findAll", query = "SELECT e FROM EstadoOrden e"),
    @NamedQuery(name = "EstadoOrden.findByIdEstadoOrden", query = "SELECT e FROM EstadoOrden e WHERE e.idEstadoOrden = :idEstadoOrden"),
    @NamedQuery(name = "EstadoOrden.findByNombreEstadoOrden", query = "SELECT e FROM EstadoOrden e WHERE e.nombreEstadoOrden = :nombreEstadoOrden")})
public class EstadoOrden implements Serializable, IDTO {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado_orden")
    private Integer idEstadoOrden;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_estado_orden")
    private String nombreEstadoOrden;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoOrden", fetch = FetchType.LAZY)
    private Collection<Orden> ordenCollection;

    public EstadoOrden() {
    }

    public EstadoOrden(Integer idEstadoOrden) {
        this.idEstadoOrden = idEstadoOrden;
    }

    public EstadoOrden(Integer idEstadoOrden, String nombreEstadoOrden) {
        this.idEstadoOrden = idEstadoOrden;
        this.nombreEstadoOrden = nombreEstadoOrden;
    }

    public Integer getIdEstadoOrden() {
        return idEstadoOrden;
    }

    public void setIdEstadoOrden(Integer idEstadoOrden) {
        this.idEstadoOrden = idEstadoOrden;
    }

    public String getNombreEstadoOrden() {
        return nombreEstadoOrden;
    }

    public void setNombreEstadoOrden(String nombreEstadoOrden) {
        this.nombreEstadoOrden = nombreEstadoOrden;
    }

    @XmlTransient
    public Collection<Orden> getOrdenCollection() {
        return ordenCollection;
    }

    public void setOrdenCollection(Collection<Orden> ordenCollection) {
        this.ordenCollection = ordenCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoOrden != null ? idEstadoOrden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoOrden)) {
            return false;
        }
        EstadoOrden other = (EstadoOrden) object;
        if ((this.idEstadoOrden == null && other.idEstadoOrden != null) || (this.idEstadoOrden != null && !this.idEstadoOrden.equals(other.idEstadoOrden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mpc.backend.persistence.model.entities.EstadoOrden[ idEstadoOrden=" + idEstadoOrden + " ]";
    }

    @Override
    public String getPrimaryKey() {
        return idEstadoOrden.toString();
    }
    
}
