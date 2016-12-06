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
@Table(name = "estados_usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoUsuario.findAll", query = "SELECT e FROM EstadoUsuario e"),
    @NamedQuery(name = "EstadoUsuario.findByIdEstadoUsuario", query = "SELECT e FROM EstadoUsuario e WHERE e.idEstadoUsuario = :idEstadoUsuario"),
    @NamedQuery(name = "EstadoUsuario.findByNombreEstadoUsuario", query = "SELECT e FROM EstadoUsuario e WHERE e.nombreEstadoUsuario = :nombreEstadoUsuario")})
public class EstadoUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado_usuario")
    private Integer idEstadoUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre_estado_usuario")
    private String nombreEstadoUsuario;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcion_estado_usuario")
    private String descripcionEstadoUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoUsuario", fetch = FetchType.LAZY)
    private Collection<Usuario> usuarioCollection;

    public EstadoUsuario() {
    }

    public EstadoUsuario(Integer idEstadoUsuario) {
        this.idEstadoUsuario = idEstadoUsuario;
    }

    public EstadoUsuario(Integer idEstadoUsuario, String nombreEstadoUsuario, String descripcionEstadoUsuario) {
        this.idEstadoUsuario = idEstadoUsuario;
        this.nombreEstadoUsuario = nombreEstadoUsuario;
        this.descripcionEstadoUsuario = descripcionEstadoUsuario;
    }

    public Integer getIdEstadoUsuario() {
        return idEstadoUsuario;
    }

    public void setIdEstadoUsuario(Integer idEstadoUsuario) {
        this.idEstadoUsuario = idEstadoUsuario;
    }

    public String getNombreEstadoUsuario() {
        return nombreEstadoUsuario;
    }

    public void setNombreEstadoUsuario(String nombreEstadoUsuario) {
        this.nombreEstadoUsuario = nombreEstadoUsuario;
    }

    public String getDescripcionEstadoUsuario() {
        return descripcionEstadoUsuario;
    }

    public void setDescripcionEstadoUsuario(String descripcionEstadoUsuario) {
        this.descripcionEstadoUsuario = descripcionEstadoUsuario;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoUsuario != null ? idEstadoUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoUsuario)) {
            return false;
        }
        EstadoUsuario other = (EstadoUsuario) object;
        if ((this.idEstadoUsuario == null && other.idEstadoUsuario != null) || (this.idEstadoUsuario != null && !this.idEstadoUsuario.equals(other.idEstadoUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mpc.backend.persistence.model.entities.EstadoUsuario[ idEstadoUsuario=" + idEstadoUsuario + " ]";
    }
    
}
