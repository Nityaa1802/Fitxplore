package com.example.fitxplore.controller;

import com.example.fitxplore.dao.ClientRepository;
import com.example.fitxplore.dao.TrainerRepository;
import com.example.fitxplore.model.Client;
import com.example.fitxplore.model.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class HomeController {
    @Autowired
    private TrainerRepository trainerRepository;
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/test")
    @ResponseBody  // yeh annotation hum jb lagate h jb hume method m koi string return krni hoti h koi html krni hoti h toh nh lagte
    public String text(){
        Trainer trainer=new Trainer();
        trainer.setUserName("Nityaa1802");
        trainer.setFirstName("Nitya");
        trainer.setLastName("Agarwal");
        trainerRepository.save(trainer);

        return "JAI MATA DII !!!!!";
    }

    @GetMapping("/trainerInput" )
    public String trainerInput(Model model){

        model.addAttribute("title","Trainer Input Details");
        model.addAttribute("trainer",new Trainer());
        return "trainerInput";
    }

    @PostMapping("/trainerRegister")
    @ResponseBody
    public String registerTrainer(@ModelAttribute("trainer") Trainer trainer,Model model){

        Trainer result = this.trainerRepository.save(trainer);
        model.addAttribute("trainer",result);
        System.out.println(result);

        return "Trainer Registered";
    }
      @GetMapping("/clientInput")

        public String clientInput(Model model){
          Client client=new Client();
          model.addAttribute("title","Client Input Details");
          model.addAttribute("client",new Client());
          return "clientInput";
        }

        @PostMapping("/clientRegister")
        @ResponseBody
        public String registerClient(Model model,@ModelAttribute("client")Client client){
        Client  result=this.clientRepository.save(client);
        model.addAttribute("client",result);
        return "Client Registered";
        }
}
