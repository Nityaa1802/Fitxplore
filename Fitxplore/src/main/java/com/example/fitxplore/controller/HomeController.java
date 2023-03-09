
package com.example.fitxplore.controller;

import com.example.fitxplore.dao.ClientRepository;
import com.example.fitxplore.dao.PaymentRepository;
import com.example.fitxplore.dao.SubscriberRepository;
import com.example.fitxplore.dao.TrainerRepository;
import com.example.fitxplore.entity.Client;
import com.example.fitxplore.entity.Payment;

import com.example.fitxplore.entity.Trainer;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;


@Controller

public class HomeController {


    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private TrainerRepository trainerRepository;
    @Autowired
    private SubscriberRepository subscriberRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/create_order")
    @ResponseBody
    public String createOrder(@RequestBody Map<String, Object> data, Principal principle) throws RazorpayException {

        System.out.println(data);
        int amt = Integer.parseInt(data.get("amount").toString());
        var client = new RazorpayClient("rzp_test_mCj3ZjeKW2JCw5", "OOJNT7TSSUdfvFDrgkBfB1XU");
        JSONObject ob = new JSONObject();
        ob.put("amount", amt * 100);
        ob.put("currency", "INR");
        ob.put("receipt", "txn_235425");

        // Creating new Order
        Order order = client.Orders.create(ob);
        System.out.println(order);

        // save order in database
        com.example.fitxplore.entity.Payment payment = new com.example.fitxplore.entity.Payment();
        payment.setAmount(order.get("amount") + "");
        payment.setOrderId(order.get("id"));
        payment.setPaymentId(null);
        payment.setStatus("created");

        this.paymentRepository.save(payment);

        return order.toString();
    }

    @PostMapping("/update_order")
    public ResponseEntity<?> updateOrder(@RequestBody Map<String, Object> data) {
        Payment payment = this.paymentRepository.findByOrderId(data.get("order_id").toString());
        payment.setPaymentId(data.get("payment_id").toString());
        payment.setStatus(data.get("id_status").toString());
        paymentRepository.save(payment);

        System.out.println(data);
        return ResponseEntity.ok(Map.of("msg", "updated"));
    }

    @PostMapping("/update_entries_trainer")
    public String updateEntries(@RequestBody Map<String, Object> data) {
        System.out.println(data);
        Trainer trainer = this.trainerRepository.getTrainerByUserName(data.get("username").toString());
        trainer.setRole("ROLE_TRAINER");
        trainerRepository.save(trainer);
//      Trainer trainer=new Trainer();
//      trainer.setUserName(subscriber.getUserName());
//      trainerRepository.save(trainer);
        System.out.println(trainer);
        return "getFit";
    }

    @PostMapping("/update_entries_client")
    public String updateEntriesClient(@RequestBody Map<String, Object> data) {
        System.out.println(data);

        Client client = this.clientRepository.getClientByUserName(data.get("username").toString());
        client.setRole("ROLE_CLIENT");
        clientRepository.save(client);
//      Trainer trainer=new Trainer();
//      trainer.setUserName(subscriber.getUserName());
//      trainerRepository.save(trainer);
        System.out.println(client);
        return "getFit";
    }

    @GetMapping("/subscribeTrainer")
    public String subscribeTrainer() {

        return "subscribeTrainer";
    }

    @GetMapping("/subscribeClient")
    public String subscribeClient() {
        return "subscribeClient";
    }


    @GetMapping("/start")
    public String Main() {
        return "getFit";
    }


    @PostMapping("/clientRegister")
    @ResponseBody
    public String clientSubscriber(@RequestBody Map<String, Object> data) {

        Client client = new Client();
        client.setName(data.get("name").toString());
        client.setUserName(data.get("username").toString());
        client.setPassword(passwordEncoder.encode(data.get("password").toString()));
        client.setEmail(data.get("email").toString());
        clientRepository.save(client);
        System.out.println(client);

        return "getFit";
    }

    @PostMapping("/trainerRegister")
    @ResponseBody
    public String registerTrainer(@RequestBody Map<String, Object> data) {

        Trainer trainer = new Trainer();
        trainer.setName(data.get("name").toString());
        trainer.setUserName(data.get("username").toString());
        trainer.setPassword(passwordEncoder.encode(data.get("password").toString()));
        trainer.setEmail(data.get("email").toString());
//  subscriberRepository.save(trainer);
        trainerRepository.save(trainer);
        System.out.println(trainer);
        return "getFit";
    }
}