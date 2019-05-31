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
import com.caresyntax.scheduling.app.service.ApplicationService;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Nandom Gusen
 */
@Controller
public class ApplicationController {

    @Autowired
    ApplicationService service;

    @ApiOperation(value = "Get Request Url for getting List of Patients ID and return to Patient View")
    @GetMapping("/")
    public String index(ModelMap model) {
        model.addAttribute("patientList", service.getPatientRepository().findAll());
        return "patient";
    }

    @ApiOperation(value = "Get Request URL to add-patient page return to add-patient View")
    @GetMapping("/patient/add")
    public String goToAddPatients(ModelMap model) {
        model.addAttribute("patient", new Patient());
        return "addPatient";
    }

    @ApiOperation(value = "Get Request URL to view Patient page and return patient View")
    @GetMapping("/patient/view")
    public String goToPatients(ModelMap model) {
        model.addAttribute("patientList", service.getPatientRepository().findAll());
        return "patient";
    }

    @ApiOperation(value = "Post Request URL to create new Doctor")
    @PostMapping("/doctor")
    public String saveDoctor(@ModelAttribute("doctor") Doctor request, ModelMap model) {
        if (request != null) {
            Doctor savedObject = service.getDoctorRepository().save(request);
            model.addAttribute("doctor", new Doctor());
        }
        return "doctor";
    }

    @ApiOperation(value = "Get Request URL to get Doctor by ID")
    @GetMapping("/doctor/{id}")
    public String findDoctorById(@PathVariable("id") long id, ModelMap model) {
        Optional<Doctor> doctor = service.getDoctorRepository().findById(id);
        if (doctor.isPresent()) {
            model.addAttribute("doctor", doctor.get());
            return "doctor";
        }
        model.addAttribute("doctor", new Doctor());
        return "doctor";
    }

    @ApiOperation(value = "Get Request URL to get List of Doctors")
    @GetMapping("/doctor")
    public String findAllDoctors(ModelMap model) {
        List<Doctor> doctorList = service.getDoctorRepository().findAll();
        model.addAttribute("doctorList", doctorList);
        return "doctor";
    }

    @ApiOperation(value = "Delete Request URL to delete doctor by ID")
    @DeleteMapping("/doctor/{id}")
    public String deleteDoctorById(@PathVariable("id") long id, ModelMap model) {
        Optional<Doctor> doctor = service.getDoctorRepository().findById(id);
        if (doctor.isPresent()) {
            service.getDoctorRepository().delete(doctor.get());
            model.addAttribute("doctor", new Doctor());
        }
        model.addAttribute("doctor", new Doctor());
        return "doctor";
    }

    @ApiOperation(value = "Post Request URL to create new Patient")
    @PostMapping("/patient")
    public String savePatient(@Valid @ModelAttribute("patient") Patient request, BindingResult bindingResult, ModelMap model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("alertType", "alert-danger");
            model.addAttribute("status", "You cannot submit Empty Request");
            return "addPatient";
        }
        Patient savedObject = service.getPatientRepository().save(request);
        model.addAttribute("status", "New Patient Saved Successfully");
        model.addAttribute("alertType", "alert-success");
        model.addAttribute("patient", new Patient());
        return "addPatient";

    }

    @ApiOperation(value = "Get Request URL to get Patient by ID")
    @GetMapping("/patient/{id}")
    public String findPatientById(@PathVariable("id") long id, ModelMap model) {
        Optional<Patient> patient = service.getPatientRepository().findById(id);
        if (patient.isPresent()) {
            model.addAttribute("patient", patient.get());
            return "patient";
        }
        model.addAttribute("patient", new Doctor());
        return "patient";
    }

    @ApiOperation(value = "Get Request URL to list of Patients and return the list to patient View")
    @GetMapping("/patient")
    public String findAllPatients(ModelMap model) {
        List<Patient> patientList = service.getPatientRepository().findAll();
        model.addAttribute("patientList", patientList);
        return "patient";
    }

    @ApiOperation(value = "Get Request URL to edit Patient and return to addPatient View")
    @GetMapping("/patient/edit/{id}")
    public String editPatientById(@PathVariable("id") long id, ModelMap model) {
        Optional<Patient> patient = service.getPatientRepository().findById(id);
//        if (patient.isPresent()) {
        model.addAttribute("patient", patient.get());
//        }
//        model.addAttribute("patient", new Patient());
        return "addPatient";
    }

    @ApiOperation(value = "Get Request URL to delete Patient and return to Patient View")
    @GetMapping("/patient/delete/{id}")
    public String deletePatientById(@PathVariable("id") long id, ModelMap model) {
        Optional<Patient> patient = service.getPatientRepository().findById(id);
        if (patient.isPresent()) {
            service.getPatientRepository().delete(patient.get());
            model.addAttribute("patientList", service.getPatientRepository().findAll());
        }
        model.addAttribute("patientList", service.getPatientRepository().findAll());
        return "patient";
    }

    @ApiOperation(value = "Get Request URL to create new Room and return to room View")
    @PostMapping("/room")
    public String saveRoom(@ModelAttribute("room") Room request, ModelMap model) {
        if (request != null) {
            Room savedObject = service.getRoomRepository().save(request);
            model.addAttribute("room", new Room());
        }
        return "room";
    }

    @ApiOperation(value = "Get Request URL to get Room by ID and return to room View")
    @GetMapping("/room/{id}")
    public String findRoomById(@PathVariable("id") long id, ModelMap model) {
        Optional<Room> room = service.getRoomRepository().findById(id);
        if (room.isPresent()) {
            model.addAttribute("room", room.get());
            return "room";
        }
        model.addAttribute("room", new Doctor());
        return "room";
    }

    @ApiOperation(value = "Get Request URL to get list of Rooms and return to room View")
    @GetMapping("/room")
    public String findAllRooms(ModelMap model) {
        List<Room> roomList = service.getRoomRepository().findAll();
        model.addAttribute("roomList", roomList);
        return "room";
    }

    @ApiOperation(value = "Get Request URL to get delete Rooms and return to room View")
    @DeleteMapping("/room/{id}")
    public String deleteRoomById(@PathVariable("id") long id, ModelMap model) {
        Optional<Room> room = service.getRoomRepository().findById(id);
        if (room.isPresent()) {
            service.getRoomRepository().delete(room.get());
            model.addAttribute("room", new Room());
        }
        model.addAttribute("room", new Room());
        return "room";
    }

    @ApiOperation(value = "Post Request URL to schedule a Patient and return to Schedule View")
    @PostMapping("/study")
    public String saveStudy(@ModelAttribute("study") Study request, ModelMap model) {
        if (request != null) {
            Study savedObject = service.getStudyRepository().save(request);
            model.addAttribute("study", new Room());
        }
        return "study";
    }

    @ApiOperation(value = "Get Request URL to get a Scheduled Patient by ID and return to Schedule View")
    @GetMapping("/study/{id}")
    public String findStudyById(@PathVariable("id") long id, ModelMap model) {
        Optional<Study> study = service.getStudyRepository().findById(id);
        if (study.isPresent()) {
            model.addAttribute("study", study.get());
            return "study";
        }
        model.addAttribute("study", new Study());
        return "study";
    }

    @ApiOperation(value = "Get Request URL to get list of Schedules")
    @GetMapping("/study")
    public String findAllStudy(ModelMap model) {
        List<Study> studyList = service.getStudyRepository().findAll();
        model.addAttribute("studyList", studyList);
        return "study";
    }

    @ApiOperation(value = "Get Request URL to delete a schedule")
    @DeleteMapping("/study/{id}")
    public String deleteStudyById(@PathVariable("id") long id, ModelMap model) {
        Optional<Study> study = service.getStudyRepository().findById(id);
        if (study.isPresent()) {
            service.getStudyRepository().delete(study.get());
            model.addAttribute("study", new Study());
        }
        model.addAttribute("study", new Study());
        return "study";
    }

}
