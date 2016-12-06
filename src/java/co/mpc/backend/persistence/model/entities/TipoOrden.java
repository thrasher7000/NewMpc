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
import javax.persistence.Lob;
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
@Table(name = "tipos_ordenes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoOrden.findAll", query = "SELECT t FROM TipoOrden t"),
    @NamedQuery(name = "TipoOrden.findByIdTipoOrden", query = "SELECT t FROM TipoOrden t WHERE t.idTipoOrden = :idTipoOrden"),
    @NamedQuery(name = "TipoOrden.findByNombreTipoOrden", query = "SELECT t FROM TipoOrden t WHERE t.nombreTipoOrden = :nombreTipoOrden")})
public class TipoOrden implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_orden")
    private Integer idTipoOrden;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nombre_tipo_orden")
    private String nombreTipoOrden;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcion_tipo_orden")
    private String descripcionTipoOrden;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoOrden", fetch = FetchType.LAZY)
    private Collection<Orden> ordenCollection;

    public TipoOrden() {
    }

    public TipoOrden(Integer idTipoOrden) {
        this.idTipoOrden = idTipoOrden;
    }

    public TipoOrden(Integer idTipoOrden, String nombreTipoOrden, String descripcionTipoOrden) {
        this.idTipoOrden = idTipoOrden;
        this.nombreTipoOrden = nombreTipoOrden;
        this.descripcionTipoOrden = descripcionTipoOrden;
    }

    public Integer getIdTipoOrden() {
        return idTipoOrden;
    }

    public void setIdTipoOrden(Integer idTipoOrden) {
        this.idTipoOrden = idTipoOrden;
    }

    public String getNombreTipoOrden() {
        return nombreTipoOrden;
    }

    public void setNombreTipoOrden(String nombreTipoOrden) {
        this.nombreTipoOrden = nombreTipoOrden;
    }

    public String getDescripcionTipoOrden() {
        return descripcionTipoOrden;
    }

    public void setDescripcionTipoOrden(String descripcionTipoOrden) {
        this.descripcionTipoOrden = descripcionTipoOrden;
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
        hash += (idTipoOrden != null ? idTipoOrden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoOrden)) {
            return false;
        }
        TipoOrden other = (TipoOrden) object;
        if ((this.idTipoOrden == null && other.idTipoOrden != null) || (this.idTipoOrden != null && !this.idTipoOrden.equals(other.idTipoOrden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mpc.backend.persistence.model.entities.TipoOrden[ idTipoOrden=" + idTipoOrden + " ]";
    }
    
}
