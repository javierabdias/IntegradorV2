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
@Table(name = "DIRECCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Direccion.findAll", query = "SELECT d FROM Direccion d")
    , @NamedQuery(name = "Direccion.findByIdDireccion", query = "SELECT d FROM Direccion d WHERE d.idDireccion = :idDireccion")
    , @NamedQuery(name = "Direccion.findByCalle", query = "SELECT d FROM Direccion d WHERE d.calle = :calle")
    , @NamedQuery(name = "Direccion.findByColonia", query = "SELECT d FROM Direccion d WHERE d.colonia = :colonia")
    , @NamedQuery(name = "Direccion.findByMza", query = "SELECT d FROM Direccion d WHERE d.mza = :mza")
    , @NamedQuery(name = "Direccion.findByLte", query = "SELECT d FROM Direccion d WHERE d.lte = :lte")})
public class Direccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_DIRECCION")
    private Integer idDireccion;
    @Column(name = "CALLE")
    private String calle;
    @Column(name = "COLONIA")
    private String colonia;
    @Column(name = "MZA")
    private String mza;
    @Column(name = "LTE")
    private String lte;
    @OneToMany(mappedBy = "idDireccion")
    private Collection<Usuarios> usuariosCollection;
    @OneToMany(mappedBy = "idDireccion")
    private Collection<Padres> padresCollection;

    public Direccion() {
    }

    public Direccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public Integer getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getMza() {
        return mza;
    }

    public void setMza(String mza) {
        this.mza = mza;
    }

    public String getLte() {
        return lte;
    }

    public void setLte(String lte) {
        this.lte = lte;
    }

    @XmlTransient
    public Collection<Usuarios> getUsuariosCollection() {
        return usuariosCollection;
    }

    public void setUsuariosCollection(Collection<Usuarios> usuariosCollection) {
        this.usuariosCollection = usuariosCollection;
    }

    @XmlTransient
    public Collection<Padres> getPadresCollection() {
        return padresCollection;
    }

    public void setPadresCollection(Collection<Padres> padresCollection) {
        this.padresCollection = padresCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDireccion != null ? idDireccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Direccion)) {
            return false;
        }
        Direccion other = (Direccion) object;
        if ((this.idDireccion == null && other.idDireccion != null) || (this.idDireccion != null && !this.idDireccion.equals(other.idDireccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Integrador.Persistence.Direccion[ idDireccion=" + idDireccion + " ]";
    }
    
}
