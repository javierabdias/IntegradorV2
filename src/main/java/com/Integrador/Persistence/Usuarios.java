/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Integrador.Persistence;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author eliaslc
 */
@Entity
@Table(name = "USUARIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")
    , @NamedQuery(name = "Usuarios.findByIdUsuario", query = "SELECT u FROM Usuarios u WHERE u.idUsuario = :idUsuario")
    , @NamedQuery(name = "Usuarios.findByContrasena", query = "SELECT u FROM Usuarios u WHERE u.contrasena = :contrasena")
    , @NamedQuery(name = "Usuarios.findByTipoUsuario", query = "SELECT u FROM Usuarios u WHERE u.tipoUsuario = :tipoUsuario")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_USUARIO")
    private Integer idUsuario;
    @Column(name = "CONTRASENA")
    private String contrasena;
    @Column(name = "TIPO_USUARIO")
    private String tipoUsuario;
    @ManyToMany(mappedBy = "usuariosCollection")
    private Collection<Telefono> telefonoCollection;
    @OneToMany(mappedBy = "idUsuario")
    private Collection<Retiro> retiroCollection;
    @JoinColumn(name = "ID_PERSONA", referencedColumnName = "ID_PERSONA")
    @ManyToOne
    private Personas idPersona;
    @JoinColumn(name = "ID_DIRECCION", referencedColumnName = "ID_DIRECCION")
    @ManyToOne
    private Direccion idDireccion;
    @OneToMany(mappedBy = "idUsuario")
    private Collection<VentasTarjeta> ventasTarjetaCollection;
    @OneToMany(mappedBy = "idUsuario")
    private Collection<Deposito> depositoCollection;
    @OneToMany(mappedBy = "idUsuario")
    private Collection<VentasEfectivo> ventasEfectivoCollection;

    public Usuarios() {
    }

    public Usuarios(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @XmlTransient
    public Collection<Telefono> getTelefonoCollection() {
        return telefonoCollection;
    }

    public void setTelefonoCollection(Collection<Telefono> telefonoCollection) {
        this.telefonoCollection = telefonoCollection;
    }

    @XmlTransient
    public Collection<Retiro> getRetiroCollection() {
        return retiroCollection;
    }

    public void setRetiroCollection(Collection<Retiro> retiroCollection) {
        this.retiroCollection = retiroCollection;
    }

    public Personas getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Personas idPersona) {
        this.idPersona = idPersona;
    }

    public Direccion getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Direccion idDireccion) {
        this.idDireccion = idDireccion;
    }

    @XmlTransient
    public Collection<VentasTarjeta> getVentasTarjetaCollection() {
        return ventasTarjetaCollection;
    }

    public void setVentasTarjetaCollection(Collection<VentasTarjeta> ventasTarjetaCollection) {
        this.ventasTarjetaCollection = ventasTarjetaCollection;
    }

    @XmlTransient
    public Collection<Deposito> getDepositoCollection() {
        return depositoCollection;
    }

    public void setDepositoCollection(Collection<Deposito> depositoCollection) {
        this.depositoCollection = depositoCollection;
    }

    @XmlTransient
    public Collection<VentasEfectivo> getVentasEfectivoCollection() {
        return ventasEfectivoCollection;
    }

    public void setVentasEfectivoCollection(Collection<VentasEfectivo> ventasEfectivoCollection) {
        this.ventasEfectivoCollection = ventasEfectivoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Integrador.Persistence.Usuarios[ idUsuario=" + idUsuario + " ]";
    }
    
}
