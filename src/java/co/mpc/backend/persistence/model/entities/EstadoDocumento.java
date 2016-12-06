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
@Table(name = "estados_documentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoDocumento.findAll", query = "SELECT e FROM EstadoDocumento e"),
    @NamedQuery(name = "EstadoDocumento.findByIdEstadosDocumentos", query = "SELECT e FROM EstadoDocumento e WHERE e.idEstadosDocumentos = :idEstadosDocumentos"),
    @NamedQuery(name = "EstadoDocumento.findByNombreEstadoDocumento", query = "SELECT e FROM EstadoDocumento e WHERE e.nombreEstadoDocumento = :nombreEstadoDocumento")})
public class EstadoDocumento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estados_documentos")
    private Integer idEstadosDocumentos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nombre_estado_documento")
    private String nombreEstadoDocumento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoDocumento", fetch = FetchType.LAZY)
    private Collection<DocumentoVehiculo> documentoVehiculoCollection;

    public EstadoDocumento() {
    }

    public EstadoDocumento(Integer idEstadosDocumentos) {
        this.idEstadosDocumentos = idEstadosDocumentos;
    }

    public EstadoDocumento(Integer idEstadosDocumentos, String nombreEstadoDocumento) {
        this.idEstadosDocumentos = idEstadosDocumentos;
        this.nombreEstadoDocumento = nombreEstadoDocumento;
    }

    public Integer getIdEstadosDocumentos() {
        return idEstadosDocumentos;
    }

    public void setIdEstadosDocumentos(Integer idEstadosDocumentos) {
        this.idEstadosDocumentos = idEstadosDocumentos;
    }

    public String getNombreEstadoDocumento() {
        return nombreEstadoDocumento;
    }

    public void setNombreEstadoDocumento(String nombreEstadoDocumento) {
        this.nombreEstadoDocumento = nombreEstadoDocumento;
    }

    @XmlTransient
    public Collection<DocumentoVehiculo> getDocumentoVehiculoCollection() {
        return documentoVehiculoCollection;
    }

    public void setDocumentoVehiculoCollection(Collection<DocumentoVehiculo> documentoVehiculoCollection) {
        this.documentoVehiculoCollection = documentoVehiculoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadosDocumentos != null ? idEstadosDocumentos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoDocumento)) {
            return false;
        }
        EstadoDocumento other = (EstadoDocumento) object;
        if ((this.idEstadosDocumentos == null && other.idEstadosDocumentos != null) || (this.idEstadosDocumentos != null && !this.idEstadosDocumentos.equals(other.idEstadosDocumentos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mpc.backend.persistence.model.entities.EstadoDocumento[ idEstadosDocumentos=" + idEstadosDocumentos + " ]";
    }
    
}
