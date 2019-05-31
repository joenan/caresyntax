/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caresyntax.scheduling.app.controller;

import com.caresyntax.scheduling.app.model.Patient;
import com.caresyntax.scheduling.app.model.Study;
import com.caresyntax.scheduling.app.service.ApplicationService;
import com.caresyntax.scheduling.app.service.StatusConstants;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Nandom Gusen
 */
@Controller
public class ScheduleController {

    @Autowired
    ApplicationService service;

    @GetMapping("/prepareSchedule")
    public String prepareSchedule(@RequestParam(value = "scheduleId", required = false) long id, ModelMap model) {
        Optional<Patient> patient = service.getPatientRepository().findById(id);
        if (patient.isPresent()) {
            model.addAttribute("patient", patient.get());
            model.addAttribute("study", new Study());
            return "procedure";
        }
        model.addAttribute("study", new Study());
        return "procedure";
    }

    @PostMapping("/saveSchedule")
    public String saveSchedule(@ModelAttribute("study") Study request, BindingResult bindingResult, @RequestParam(value = "patientName", required = false) String patientName, ModelMap model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("alertType", "alert-danger");
            model.addAttribute("status", "Please fill mandatory fields");
            model.addAttribute("procedure", new Study());
            return "procedure";
        }
        Optional<Patient> patient = service.getPatientRepository().findPatientByName(patientName);
        request.setPatient(patient.get());
        request.setStatus(StatusConstants.PLANNED);
        Study savedObject = service.getStudyRepository().save(request);
        model.addAttribute("status", "Patient has been successfully Scheduled");
        model.addAttribute("alertType", "alert-success");
        model.addAttribute("procedure", new Study());
        return "procedure";
    }

    @GetMapping("/updateStatus")
    public String updateStatusOfProcedure(@RequestParam(value = "statusId", required = false) long id, @RequestParam(value = "statusName", required = false) String status, ModelMap model) {
        Optional<Study> study = service.getStudyRepository().findByPatient_PatientId(id);
        if (study.isPresent()) {
            study.get().setStatus(status);
            Study updatedStudy = service.getStudyRepository().save(study.get());

            model.addAttribute("patientList", service.getPatientRepository().findAll());

            return "patient";
        }
        model.addAttribute("patientList", service.getPatientRepository().findAll());
        return "patient";
    }

}
