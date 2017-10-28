/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Integrador.Persistence;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eliaslc
 */
@Entity
@Table(name = "RETIRO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Retiro.findAll", query = "SELECT r FROM Retiro r")
    , @NamedQuery(name = "Retiro.findByIdRetiro", query = "SELECT r FROM Retiro r WHERE r.idRetiro = :idRetiro")
    , @NamedQuery(name = "Retiro.findByMonto", query = "SELECT r FROM Retiro r WHERE r.monto = :monto")
    , @NamedQuery(name = "Retiro.findByFechaHora", query = "SELECT r FROM Retiro r WHERE r.fechaHora = :fechaHora")})
public class Retiro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_RETIRO")
    private Integer idRetiro;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MONTO")
    private Double monto;
    @Basic(optional = false)
    @Column(name = "FECHA_HORA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;
    @JoinColumn(name = "ID_CUENTA", referencedColumnName = "ID_CUENTA")
    @ManyToOne
    private CuentaAlumno idCuenta;
    @JoinColumn(name = "ID_PADRE", referencedColumnName = "ID_PADRE")
    @ManyToOne
    private Padres idPadre;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuarios idUsuario;

    public Retiro() {
    }

    public Retiro(Integer idRetiro) {
        this.idRetiro = idRetiro;
    }

    public Retiro(Integer idRetiro, Date fechaHora) {
        this.idRetiro = idRetiro;
        this.fechaHora = fechaHora;
    }

    public Integer getIdRetiro() {
        return idRetiro;
    }

    public void setIdRetiro(Integer idRetiro) {
        this.idRetiro = idRetiro;
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

    public CuentaAlumno getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(CuentaAlumno idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Padres getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(Padres idPadre) {
        this.idPadre = idPadre;
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
        hash += (idRetiro != null ? idRetiro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Retiro)) {
            return false;
        }
        Retiro other = (Retiro) object;
        if ((this.idRetiro == null && other.idRetiro != null) || (this.idRetiro != null && !this.idRetiro.equals(other.idRetiro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Integrador.Persistence.Retiro[ idRetiro=" + idRetiro + " ]";
    }
    
}
