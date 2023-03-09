package com.example.fitxplore.controller;

import com.example.fitxplore.dao.TrainerRepository;
import com.example.fitxplore.entity.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/trainer")
public class TrainerController {
    @Autowired
    TrainerRepository trainerRepository;
    @RequestMapping("/dashboard")
    public String dashboard(Model model, Principal principal){
        String trainerUsername = principal.getName();
       Trainer trainer=trainerRepository.getTrainerByUserName(trainerUsername);
       model.addAttribute("trainer",trainer);
       return "trainer_dashboard";
    }
}