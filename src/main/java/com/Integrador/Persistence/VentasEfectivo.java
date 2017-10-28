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
@Table(name = "VENTAS_EFECTIVO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VentasEfectivo.findAll", query = "SELECT v FROM VentasEfectivo v")
    , @NamedQuery(name = "VentasEfectivo.findByIdVenta", query = "SELECT v FROM VentasEfectivo v WHERE v.idVenta = :idVenta")
    , @NamedQuery(name = "VentasEfectivo.findByMonto", query = "SELECT v FROM VentasEfectivo v WHERE v.monto = :monto")
    , @NamedQuery(name = "VentasEfectivo.findByFechaHora", query = "SELECT v FROM VentasEfectivo v WHERE v.fechaHora = :fechaHora")})
public class VentasEfectivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_VENTA")
    private Integer idVenta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MONTO")
    private Double monto;
    @Basic(optional = false)
    @Column(name = "FECHA_HORA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuarios idUsuario;

    public VentasEfectivo() {
    }

    public VentasEfectivo(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public VentasEfectivo(Integer idVenta, Date fechaHora) {
        this.idVenta = idVenta;
        this.fechaHora = fechaHora;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
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

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVenta != null ? idVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentasEfectivo)) {
            return false;
        }
        VentasEfectivo other = (VentasEfectivo) object;
        if ((this.idVenta == null && other.idVenta != null) || (this.idVenta != null && !this.idVenta.equals(other.idVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Integrador.Persistence.VentasEfectivo[ idVenta=" + idVenta + " ]";
    }
    
}
