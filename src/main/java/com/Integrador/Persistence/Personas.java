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
@Table(name = "PERSONAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personas.findAll", query = "SELECT p FROM Personas p")
    , @NamedQuery(name = "Personas.findByIdPersona", query = "SELECT p FROM Personas p WHERE p.idPersona = :idPersona")
    , @NamedQuery(name = "Personas.findByNombre", query = "SELECT p FROM Personas p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Personas.findByApePaterno", query = "SELECT p FROM Personas p WHERE p.apePaterno = :apePaterno")
    , @NamedQuery(name = "Personas.findByApeMaterno", query = "SELECT p FROM Personas p WHERE p.apeMaterno = :apeMaterno")
    , @NamedQuery(name = "Personas.findByEdad", query = "SELECT p FROM Personas p WHERE p.edad = :edad")
    , @NamedQuery(name = "Personas.findBySexo", query = "SELECT p FROM Personas p WHERE p.sexo = :sexo")})
public class Personas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PERSONA")
    private Integer idPersona;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "APE_PATERNO")
    private String apePaterno;
    @Column(name = "APE_MATERNO")
    private String apeMaterno;
    @Column(name = "EDAD")
    private Integer edad;
    @Column(name = "SEXO")
    private String sexo;
    @JoinTable(name = "PERSONA_DEPOSITO", joinColumns = {
        @JoinColumn(name = "ID_PERSONA", referencedColumnName = "ID_PERSONA")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_DEPOSITO", referencedColumnName = "ID_DEPOSITO")})
    @ManyToMany
    private Collection<Deposito> depositoCollection;
    @OneToMany(mappedBy = "idPersona")
    private Collection<Usuarios> usuariosCollection;
    @OneToMany(mappedBy = "idPersona")
    private Collection<Alumnos> alumnosCollection;
    @OneToMany(mappedBy = "idPersona")
    private Collection<Padres> padresCollection;

    public Personas() {
    }

    public Personas(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApePaterno() {
        return apePaterno;
    }

    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }

    public String getApeMaterno() {
        return apeMaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @XmlTransient
    public Collection<Deposito> getDepositoCollection() {
        return depositoCollection;
    }

    public void setDepositoCollection(Collection<Deposito> depositoCollection) {
        this.depositoCollection = depositoCollection;
    }

    @XmlTransient
    public Collection<Usuarios> getUsuariosCollection() {
        return usuariosCollection;
    }

    public void setUsuariosCollection(Collection<Usuarios> usuariosCollection) {
        this.usuariosCollection = usuariosCollection;
    }

    @XmlTransient
    public Collection<Alumnos> getAlumnosCollection() {
        return alumnosCollection;
    }

    public void setAlumnosCollection(Collection<Alumnos> alumnosCollection) {
        this.alumnosCollection = alumnosCollection;
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
        hash += (idPersona != null ? idPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personas)) {
            return false;
        }
        Personas other = (Personas) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Integrador.Persistence.Personas[ idPersona=" + idPersona + " ]";
    }
    
}
