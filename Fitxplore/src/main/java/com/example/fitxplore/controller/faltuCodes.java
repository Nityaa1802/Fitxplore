package com.example.fitxplore.controller;

import com.example.fitxplore.dao.TrainerRepository;
import com.example.fitxplore.entity.Trainer;
import com.example.fitxplore.helper.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLIntegrityConstraintViolationException;

public class faltuCodes {


    private TrainerRepository trainerRepository;
    @PostMapping("/trainerRegister")

    @ResponseBody
    public String registerTrainer(@Valid @ModelAttribute("trainer") Trainer trainer, BindingResult bindingResult, @RequestParam("immmage") MultipartFile file, Model model, HttpSession session)throws SQLIntegrityConstraintViolationException {

        if(bindingResult.hasErrors()){
            model.addAttribute("trainer",trainer);
            System.out.println(bindingResult.getAllErrors());
            return "base";
        }


        try{

            if(file.isEmpty()){
                System.out.println("file is empty");
            }
            else {
                trainer.setImage(file.getOriginalFilename());
                File savedFile = new ClassPathResource("/static/img").getFile();
                Path path = Paths.get(savedFile.getAbsolutePath() + File.separator + file.getOriginalFilename());
                Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Image is uploaded");
            }
            Trainer result = this.trainerRepository.save(trainer);
            System.out.println(trainer.toString());
            model.addAttribute("trainer",trainer);
            session.setAttribute("message",new Messages("Pay now","alert-success"));
            return "Form Completed";


        }
        catch (DuplicateKeyException ex){
            ex.printStackTrace();
            model.addAttribute("trainer",trainer);
            session.setAttribute("message",new Messages("Username Already exist"+ex.getMessage(),"alert-danger"));
            return "trainerInput";
        }




        catch (Exception e){
            e.printStackTrace();
            model.addAttribute("trainer",trainer);
            session.setAttribute("message",new Messages("Something Went Wrong!!!","alert-danger"));
            return "trainerInput";
        }


    }
    @GetMapping("/trainerInput" )
    public String trainerInput(Model model){

        model.addAttribute("title","Trainer Input Details");
        model.addAttribute("trainer",new Trainer());
        return "trainerInput";
    }
}
