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
@Table(name = "componentes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Componente.findAll", query = "SELECT c FROM Componente c"),
    @NamedQuery(name = "Componente.findByIdComponente", query = "SELECT c FROM Componente c WHERE c.idComponente = :idComponente"),
    @NamedQuery(name = "Componente.findByNombreComponente", query = "SELECT c FROM Componente c WHERE c.nombreComponente = :nombreComponente"),
    @NamedQuery(name = "Componente.findByVidaUtil", query = "SELECT c FROM Componente c WHERE c.vidaUtil = :vidaUtil"),
    @NamedQuery(name = "Componente.findBySeguimiento", query = "SELECT c FROM Componente c WHERE c.seguimiento = :seguimiento")})
public class Componente implements Serializable, IDTO {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_componente")
    private Integer idComponente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nombre_componente")
    private String nombreComponente;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcion_componente")
    private String descripcionComponente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vida_util")
    private int vidaUtil;
    @Basic(optional = false)
    @NotNull
    @Column(name = "seguimiento")
    private int seguimiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idComponente", fetch = FetchType.LAZY)
    private Collection<ComponenteVehiculo> componenteVehiculoCollection;

    public Componente() {
    }

    public Componente(Integer idComponente) {
        this.idComponente = idComponente;
    }

    public Componente(Integer idComponente, String nombreComponente, String descripcionComponente, int vidaUtil, int seguimiento) {
        this.idComponente = idComponente;
        this.nombreComponente = nombreComponente;
        this.descripcionComponente = descripcionComponente;
        this.vidaUtil = vidaUtil;
        this.seguimiento = seguimiento;
    }

    public Integer getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(Integer idComponente) {
        this.idComponente = idComponente;
    }

    public String getNombreComponente() {
        return nombreComponente;
    }

    public void setNombreComponente(String nombreComponente) {
        this.nombreComponente = nombreComponente;
    }

    public String getDescripcionComponente() {
        return descripcionComponente;
    }

    public void setDescripcionComponente(String descripcionComponente) {
        this.descripcionComponente = descripcionComponente;
    }

    public int getVidaUtil() {
        return vidaUtil;
    }

    public void setVidaUtil(int vidaUtil) {
        this.vidaUtil = vidaUtil;
    }

    public int getSeguimiento() {
        return seguimiento;
    }

    public void setSeguimiento(int seguimiento) {
        this.seguimiento = seguimiento;
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
        hash += (idComponente != null ? idComponente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Componente)) {
            return false;
        }
        Componente other = (Componente) object;
        if ((this.idComponente == null && other.idComponente != null) || (this.idComponente != null && !this.idComponente.equals(other.idComponente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mpc.backend.persistence.model.entities.Componente[ idComponente=" + idComponente + " ]";
    }

    @Override
    public String getPrimaryKey() {
        return idComponente.toString();
    }
    
}
