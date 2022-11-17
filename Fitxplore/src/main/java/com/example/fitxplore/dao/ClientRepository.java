package com.example.fitxplore.dao;

import com.example.fitxplore.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,String > {
}
