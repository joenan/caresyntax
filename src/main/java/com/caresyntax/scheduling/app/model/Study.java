/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caresyntax.scheduling.app.model;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Nandom Gusen
 */
@Entity
public class Study implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "study_id")
    private long studyId;

    @NotNull(message = "Description cannot be empty. Description is a required field")
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @NotNull(message = "Status cannot be empty. Status is a required field")
    @Size(min = 1, max = 11)
    @Column(name = "status")
    private String status;

    @NotNull(message = "Start time cannot be empty. Start time is a required field")
    @Column(name = "planned_start_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date plannedStartTime;

    @Column(name = "estimated_end_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date estimatedEndTime;

    @NotNull
    @JoinColumn(name = "Patient", referencedColumnName = "patient_id")
    @ManyToOne(optional = false)
    private Patient patient;

    public Study() {
    }

    public long getStudyId() {
        return studyId;
    }

    public void setStudyId(long studyId) {
        this.studyId = studyId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getPlannedStartTime() {
        return plannedStartTime;
    }

    public void setPlannedStartTime(Date plannedStartTime) {
        this.plannedStartTime = plannedStartTime;
    }

    public Date getEstimatedEndTime() {
        return estimatedEndTime;
    }

    public void setEstimatedEndTime(Date estimatedEndTime) {
        this.estimatedEndTime = estimatedEndTime;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

 
}
