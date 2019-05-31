/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caresyntax.scheduling.app.controller;

import com.caresyntax.scheduling.app.model.Doctor;
import com.caresyntax.scheduling.app.model.Patient;
import com.caresyntax.scheduling.app.model.Room;
import com.caresyntax.scheduling.app.model.Study;
import com.caresyntax.scheduling.app.service.ApiResponse;
import com.caresyntax.scheduling.app.service.ApplicationService;
import com.caresyntax.scheduling.app.service.MessageConstants;
import io.swagger.annotations.ApiOperation;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Nandom Gusen
 */
@ApiOperation(value = "This controller is here should incase you want to Communicate to the backend via RESTFUL Web Services")
@RestController
@RequestMapping("/api/v1/schedule")
public class JsonAPIController {

    @Autowired
    ApplicationService service;

    @ApiOperation(value = "End point for Creating Doctor Object Request")
    @PostMapping("/doctor")
    public ResponseEntity<?> saveDoctor(@RequestBody Doctor request) {
        if (request != null) {
            Doctor savedObject = service.getDoctorRepository().save(request);
            return ResponseEntity.ok(Collections.singletonMap("success", savedObject));
        }
        return ResponseEntity.ok(Collections.singletonMap("Failed", "Empty Fields Not accepted"));
    }

    @ApiOperation(value = "End point getting Doctor by ID")
    @GetMapping("/doctor/{id}")
    public ResponseEntity<?> findDoctorById(@PathVariable("id") long id) {
        return service.getDoctorRepository().findById(id).map(record -> ResponseEntity.ok().body(new ApiResponse<>(MessageConstants.Response, record)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(MessageConstants.Response, MessageConstants.NotFound)));
    }

    @ApiOperation(value = "End point for getting All List of Doctors")
    @GetMapping("/doctor")
    public List<Doctor> findAllDoctors() {
        List<Doctor> doctorList = service.getDoctorRepository().findAll();
        return doctorList;
    }

    @ApiOperation(value = "End point for Deleting Doctor data by ID")
    @DeleteMapping("/doctor/{id}")
    public ResponseEntity<?> deleteDoctorById(@PathVariable("id") long id) {
        return service.getDoctorRepository().findById(id)
                .map(record -> {
                    service.getDoctorRepository().deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("Failed", "No such Record Found")));
    }

    @ApiOperation(value = "End point for Creating new Patient")
    @PostMapping("/patient")
    public ResponseEntity<?> savePatient(@RequestBody Patient request) {
        if (request != null) {
            Patient savedObject = service.getPatientRepository().save(request);
            return ResponseEntity.ok(Collections.singletonMap("success", savedObject));
        }
        return ResponseEntity.ok(Collections.singletonMap("Failed", "Empty Fields Not accepted"));
    }

    @ApiOperation(value = "End point for getting Patient by ID")
    @GetMapping("/patient/{id}")
    public ResponseEntity<?> findPatientById(@PathVariable("id") long id) {
        return service.getPatientRepository().findById(id).map(record -> ResponseEntity.ok().body(new ApiResponse<>(MessageConstants.Response, record)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(MessageConstants.Response, MessageConstants.NotFound)));
    }

    @ApiOperation(value = "End point for getting List of Patient")
    @GetMapping("/patient")
    public List<Patient> findAllPatients() {
        List<Patient> patientList = service.getPatientRepository().findAll();
        return patientList;
    }

    @ApiOperation(value = "End point for deleting Patient by ID")
    @DeleteMapping("/patient/{id}")
    public ResponseEntity<?> deletePatientById(@PathVariable("id") long id) {
        return service.getPatientRepository().findById(id)
                .map(record -> {
                    service.getPatientRepository().deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("Failed", "No such Record Found")));
    }

    @ApiOperation(value = "End point for creating new Room")
    @PostMapping("/room")
    public ResponseEntity<?> saveRoom(@RequestBody Room request) {
        if (request != null) {
            Room savedObject = service.getRoomRepository().save(request);
            return ResponseEntity.ok(Collections.singletonMap("success", savedObject));
        }
        return ResponseEntity.ok(Collections.singletonMap("Failed", "Empty Fields Not accepted"));
    }

    @ApiOperation(value = "End point for getting Room by ID")
    @GetMapping("/room/{id}")
    public ResponseEntity<?> findRoomById(@PathVariable("id") long id) {
        return service.getRoomRepository().findById(id).map(record -> ResponseEntity.ok().body(new ApiResponse<>(MessageConstants.Response, record)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(MessageConstants.Response, MessageConstants.NotFound)));
    }

    @ApiOperation(value = "End point for getting List of Rooms")
    @GetMapping("/room")
    public List<Room> findAllRooms() {
        List<Room> roomList = service.getRoomRepository().findAll();
        return roomList;
    }

    @ApiOperation(value = "End point for getting Room by ID")
    @DeleteMapping("/room/{id}")
    public ResponseEntity<?> deleteRoomById(@PathVariable("id") long id) {
        return service.getRoomRepository().findById(id)
                .map(record -> {
                    service.getRoomRepository().deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("Failed", "No such Record Found")));
    }

    @ApiOperation(value = "End point for creating new Patient Schedule")
    @PostMapping("/study")
    public ResponseEntity<?> saveStudy(@RequestBody Study request) {
        if (request != null) {
            Study savedObject = service.getStudyRepository().save(request);
            return ResponseEntity.ok(Collections.singletonMap("success", savedObject));
        }
        return ResponseEntity.ok(Collections.singletonMap("Failed", "Empty Fields Not accepted"));
    }

    @ApiOperation(value = "End point for getting Schedule by ID")
    @GetMapping("/study/{id}")
    public ResponseEntity<?> findStudyById(@PathVariable("id") long id) {
        return service.getStudyRepository().findById(id).map(record -> ResponseEntity.ok().body(new ApiResponse<>(MessageConstants.Response, record)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(MessageConstants.Response, MessageConstants.NotFound)));
    }

    @ApiOperation(value = "End point for List of Schedules")
    @GetMapping("/study")
    public List<Study> findAllStudy() {
        List<Study> studyList = service.getStudyRepository().findAll();
        return studyList;
    }

    @ApiOperation(value = "End point for deleting Schedule by ID")
    @DeleteMapping("/study/{id}")
    public ResponseEntity<?> deleteStudyById(@PathVariable("id") long id) {
        return service.getStudyRepository().findById(id)
                .map(record -> {
                    service.getStudyRepository().deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("Failed", "No such Record Found")));
    }

}
