/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caresyntax.scheduling.app.controller;

import com.caresyntax.scheduling.app.model.Patient;
import com.caresyntax.scheduling.app.model.Study;
import com.caresyntax.scheduling.app.service.ApplicationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Nandom Gusen
 */
@Controller
public class SearchController {

    @Autowired
    ApplicationService service;

    @PostMapping("/patient/search")
    public String prepareSchedule(@RequestParam(value = "search", required = false) String searchValue, ModelMap model) {
        List<Patient> patient = service.getPatientRepository().findBySearchValue(searchValue);
        if (patient.isEmpty()) {
            model.addAttribute("patientList", service.getPatientRepository().findAll());
            return "patient";
        }
        model.addAttribute("patientList", patient);
        return "patient";
    }

}
