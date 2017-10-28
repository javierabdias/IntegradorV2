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
import javax.persistence.JoinTable;
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
@Table(name = "PADRES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Padres.findAll", query = "SELECT p FROM Padres p")
    , @NamedQuery(name = "Padres.findByIdPadre", query = "SELECT p FROM Padres p WHERE p.idPadre = :idPadre")
    , @NamedQuery(name = "Padres.findByContrasena", query = "SELECT p FROM Padres p WHERE p.contrasena = :contrasena")
    , @NamedQuery(name = "Padres.findByCorreo", query = "SELECT p FROM Padres p WHERE p.correo = :correo")})
public class Padres implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PADRE")
    private Integer idPadre;
    @Column(name = "CONTRASENA")
    private String contrasena;
    @Column(name = "CORREO")
    private String correo;
    @JoinTable(name = "PADRES_ALUMNOS", joinColumns = {
        @JoinColumn(name = "ID_PADRE", referencedColumnName = "ID_PADRE")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_ALUMNO", referencedColumnName = "ID_ALUMNO")})
    @ManyToMany
    private Collection<Alumnos> alumnosCollection;
    @ManyToMany(mappedBy = "padresCollection")
    private Collection<Telefono> telefonoCollection;
    @OneToMany(mappedBy = "idPadre")
    private Collection<Retiro> retiroCollection;
    @JoinColumn(name = "ID_PERSONA", referencedColumnName = "ID_PERSONA")
    @ManyToOne
    private Personas idPersona;
    @JoinColumn(name = "ID_DIRECCION", referencedColumnName = "ID_DIRECCION")
    @ManyToOne
    private Direccion idDireccion;

    public Padres() {
    }

    public Padres(Integer idPadre) {
        this.idPadre = idPadre;
    }

    public Integer getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(Integer idPadre) {
        this.idPadre = idPadre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @XmlTransient
    public Collection<Alumnos> getAlumnosCollection() {
        return alumnosCollection;
    }

    public void setAlumnosCollection(Collection<Alumnos> alumnosCollection) {
        this.alumnosCollection = alumnosCollection;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPadre != null ? idPadre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Padres)) {
            return false;
        }
        Padres other = (Padres) object;
        if ((this.idPadre == null && other.idPadre != null) || (this.idPadre != null && !this.idPadre.equals(other.idPadre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Integrador.Persistence.Padres[ idPadre=" + idPadre + " ]";
    }
    
}
