package com.example.rediswebapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class RedisController {

    @Autowired
    private RedisService redisService;

    // Méthode pour la racine
    @GetMapping("/")
    public String root() {
        return "Bienvenue sur l'application Redis Web!";
    }

    // Méthode pour ajouter une donnée
    @PostMapping("/add")
    public String addData(@RequestParam String key, @RequestParam String value) {
        return redisService.addData(key, value);
    }

    // Méthode pour récupérer toutes les données
    @GetMapping("/get")
    public Map<String, String> getAllData() {
        return redisService.getAllData();
    }

    // Méthode pour mettre à jour une donnée
    @PutMapping("/update")
    public String updateData(@RequestParam String key, @RequestParam String value) {
        return redisService.updateData(key, value);
    }

    // Méthode pour supprimer une donnée
    @DeleteMapping("/delete")
    public String deleteData(@RequestParam String key) {
        return redisService.deleteData(key);
    }
}
