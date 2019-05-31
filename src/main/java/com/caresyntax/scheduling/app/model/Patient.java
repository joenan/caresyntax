/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caresyntax.scheduling.app.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Nandom Gusen
 */
@Entity
public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "patient_id")
    private Long patientId;

    @NotNull(message = "Name cannot be empty. Name is a required field")
    @Column(name = "name")
    private String name;

    @Column(name = "sex")
    private String sex;

    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
    private List<Study> studyList;

    public Patient() {
    }

    public Patient(String name, String sex, Date dateOfBirth) {
        this.name = name;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
    }
    
    

    public Patient(Long patientId) {
        this.patientId = patientId;
    }

    public Patient(Long patientId, String name) {
        this.patientId = patientId;
        this.name = name;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Study> getStudyList() {
        return studyList;
    }

    public void setStudyList(List<Study> studyList) {
        this.studyList = studyList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patientId != null ? patientId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patient)) {
            return false;
        }
        Patient other = (Patient) object;
        if ((this.patientId == null && other.patientId != null) || (this.patientId != null && !this.patientId.equals(other.patientId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.caresyntax.scheduling.app.model.Patient[ patientId=" + patientId + " ]";
    }

}
