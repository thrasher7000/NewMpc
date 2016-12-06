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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author SENA
 */
@Entity
@Table(name = "mantenimientos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mantenimiento.findAll", query = "SELECT m FROM Mantenimiento m"),
    @NamedQuery(name = "Mantenimiento.findByIdMantenimiento", query = "SELECT m FROM Mantenimiento m WHERE m.idMantenimiento = :idMantenimiento"),
    @NamedQuery(name = "Mantenimiento.findByFechaEntregaMantenimiento", query = "SELECT m FROM Mantenimiento m WHERE m.fechaEntregaMantenimiento = :fechaEntregaMantenimiento"),
    @NamedQuery(name = "Mantenimiento.findByCostoMantenimiento", query = "SELECT m FROM Mantenimiento m WHERE m.costoMantenimiento = :costoMantenimiento")})
public class Mantenimiento implements Serializable, IDTO {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mantenimiento")
    private Integer idMantenimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_entrega_mantenimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaEntregaMantenimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo_mantenimiento")
    private double costoMantenimiento;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcion_mantenimiento")
    private String descripcionMantenimiento;
    @Lob
    @Column(name = "documento_adjunto")
    private byte[] documentoAdjunto;
    @JoinColumn(name = "id_orden_mantenimiento", referencedColumnName = "id_orden")
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Orden idOrdenMantenimiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMantenimiento", fetch = FetchType.LAZY)
    private Collection<CambioRealizado> cambioRealizadoCollection;

    public Mantenimiento() {
    }

    public Mantenimiento(Integer idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    public Mantenimiento(Integer idMantenimiento, Date fechaEntregaMantenimiento, double costoMantenimiento, String descripcionMantenimiento) {
        this.idMantenimiento = idMantenimiento;
        this.fechaEntregaMantenimiento = fechaEntregaMantenimiento;
        this.costoMantenimiento = costoMantenimiento;
        this.descripcionMantenimiento = descripcionMantenimiento;
    }

    public Integer getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(Integer idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    public Date getFechaEntregaMantenimiento() {
        return fechaEntregaMantenimiento;
    }

    public void setFechaEntregaMantenimiento(Date fechaEntregaMantenimiento) {
        this.fechaEntregaMantenimiento = fechaEntregaMantenimiento;
    }

    public double getCostoMantenimiento() {
        return costoMantenimiento;
    }

    public void setCostoMantenimiento(double costoMantenimiento) {
        this.costoMantenimiento = costoMantenimiento;
    }

    public String getDescripcionMantenimiento() {
        return descripcionMantenimiento;
    }

    public void setDescripcionMantenimiento(String descripcionMantenimiento) {
        this.descripcionMantenimiento = descripcionMantenimiento;
    }

    public byte[] getDocumentoAdjunto() {
        return documentoAdjunto;
    }

    public void setDocumentoAdjunto(byte[] documentoAdjunto) {
        this.documentoAdjunto = documentoAdjunto;
    }

    public Orden getIdOrdenMantenimiento() {
        return idOrdenMantenimiento;
    }

    public void setIdOrdenMantenimiento(Orden idOrdenMantenimiento) {
        this.idOrdenMantenimiento = idOrdenMantenimiento;
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
        hash += (idMantenimiento != null ? idMantenimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mantenimiento)) {
            return false;
        }
        Mantenimiento other = (Mantenimiento) object;
        if ((this.idMantenimiento == null && other.idMantenimiento != null) || (this.idMantenimiento != null && !this.idMantenimiento.equals(other.idMantenimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mpc.backend.persistence.model.entities.Mantenimiento[ idMantenimiento=" + idMantenimiento + " ]";
    }

    @Override
    public String getPrimaryKey() {
        return idMantenimiento.toString();
    }
    
}
