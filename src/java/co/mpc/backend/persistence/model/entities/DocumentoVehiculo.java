/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.backend.persistence.model.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SENA
 */
@Entity
@Table(name = "documentos_vehiculos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocumentoVehiculo.findAll", query = "SELECT d FROM DocumentoVehiculo d"),
    @NamedQuery(name = "DocumentoVehiculo.findByIdDocumentoVehiculo", query = "SELECT d FROM DocumentoVehiculo d WHERE d.idDocumentoVehiculo = :idDocumentoVehiculo"),
    @NamedQuery(name = "DocumentoVehiculo.findByNombreDocumento", query = "SELECT d FROM DocumentoVehiculo d WHERE d.nombreDocumento = :nombreDocumento"),
    @NamedQuery(name = "DocumentoVehiculo.findByFechaAdquisicion", query = "SELECT d FROM DocumentoVehiculo d WHERE d.fechaAdquisicion = :fechaAdquisicion"),
    @NamedQuery(name = "DocumentoVehiculo.findByFechaVencimiento", query = "SELECT d FROM DocumentoVehiculo d WHERE d.fechaVencimiento = :fechaVencimiento")})
public class DocumentoVehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_documento_vehiculo")
    private Integer idDocumentoVehiculo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_documento")
    private String nombreDocumento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_adquisicion")
    @Temporal(TemporalType.DATE)
    private Date fechaAdquisicion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_vencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "documento_adjunto")
    private byte[] documentoAdjunto;
    @JoinColumn(name = "id_estado_documento", referencedColumnName = "id_estados_documentos")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstadoDocumento idEstadoDocumento;
    @JoinColumn(name = "id_tipo_documento", referencedColumnName = "id_tipo_documento")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoDocumento idTipoDocumento;
    @JoinColumn(name = "id_vehiculo", referencedColumnName = "id_vehiculo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Vehiculo idVehiculo;

    public DocumentoVehiculo() {
    }

    public DocumentoVehiculo(Integer idDocumentoVehiculo) {
        this.idDocumentoVehiculo = idDocumentoVehiculo;
    }

    public DocumentoVehiculo(Integer idDocumentoVehiculo, String nombreDocumento, Date fechaAdquisicion, Date fechaVencimiento, byte[] documentoAdjunto) {
        this.idDocumentoVehiculo = idDocumentoVehiculo;
        this.nombreDocumento = nombreDocumento;
        this.fechaAdquisicion = fechaAdquisicion;
        this.fechaVencimiento = fechaVencimiento;
        this.documentoAdjunto = documentoAdjunto;
    }

    public Integer getIdDocumentoVehiculo() {
        return idDocumentoVehiculo;
    }

    public void setIdDocumentoVehiculo(Integer idDocumentoVehiculo) {
        this.idDocumentoVehiculo = idDocumentoVehiculo;
    }

    public String getNombreDocumento() {
        return nombreDocumento;
    }

    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }

    public Date getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(Date fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public byte[] getDocumentoAdjunto() {
        return documentoAdjunto;
    }

    public void setDocumentoAdjunto(byte[] documentoAdjunto) {
        this.documentoAdjunto = documentoAdjunto;
    }

    public EstadoDocumento getIdEstadoDocumento() {
        return idEstadoDocumento;
    }

    public void setIdEstadoDocumento(EstadoDocumento idEstadoDocumento) {
        this.idEstadoDocumento = idEstadoDocumento;
    }

    public TipoDocumento getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(TipoDocumento idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public Vehiculo getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Vehiculo idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDocumentoVehiculo != null ? idDocumentoVehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentoVehiculo)) {
            return false;
        }
        DocumentoVehiculo other = (DocumentoVehiculo) object;
        if ((this.idDocumentoVehiculo == null && other.idDocumentoVehiculo != null) || (this.idDocumentoVehiculo != null && !this.idDocumentoVehiculo.equals(other.idDocumentoVehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mpc.backend.persistence.model.entities.DocumentoVehiculo[ idDocumentoVehiculo=" + idDocumentoVehiculo + " ]";
    }
    
}
