/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Integrador.Persistence;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author eliaslc
 */
@Entity
@Table(name = "DEPOSITO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Deposito.findAll", query = "SELECT d FROM Deposito d")
    , @NamedQuery(name = "Deposito.findByIdDeposito", query = "SELECT d FROM Deposito d WHERE d.idDeposito = :idDeposito")
    , @NamedQuery(name = "Deposito.findByMonto", query = "SELECT d FROM Deposito d WHERE d.monto = :monto")
    , @NamedQuery(name = "Deposito.findByFechaHora", query = "SELECT d FROM Deposito d WHERE d.fechaHora = :fechaHora")})
public class Deposito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_DEPOSITO")
    private Integer idDeposito;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MONTO")
    private Double monto;
    @Basic(optional = false)
    @Column(name = "FECHA_HORA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;
    @ManyToMany(mappedBy = "depositoCollection")
    private Collection<Personas> personasCollection;
    @JoinColumn(name = "ID_CUENTA", referencedColumnName = "ID_CUENTA")
    @ManyToOne
    private CuentaAlumno idCuenta;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuarios idUsuario;

    public Deposito() {
    }

    public Deposito(Integer idDeposito) {
        this.idDeposito = idDeposito;
    }

    public Deposito(Integer idDeposito, Date fechaHora) {
        this.idDeposito = idDeposito;
        this.fechaHora = fechaHora;
    }

    public Integer getIdDeposito() {
        return idDeposito;
    }

    public void setIdDeposito(Integer idDeposito) {
        this.idDeposito = idDeposito;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    @XmlTransient
    public Collection<Personas> getPersonasCollection() {
        return personasCollection;
    }

    public void setPersonasCollection(Collection<Personas> personasCollection) {
        this.personasCollection = personasCollection;
    }

    public CuentaAlumno getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(CuentaAlumno idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDeposito != null ? idDeposito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deposito)) {
            return false;
        }
        Deposito other = (Deposito) object;
        if ((this.idDeposito == null && other.idDeposito != null) || (this.idDeposito != null && !this.idDeposito.equals(other.idDeposito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Integrador.Persistence.Deposito[ idDeposito=" + idDeposito + " ]";
    }
    
}
