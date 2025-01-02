package com.example.rediswebapp;

import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

@Service
public class RedisService {

    private final Jedis jedis;

    public RedisService() {
        // Connexion à Redis sur localhost (vous pouvez modifier l'adresse et le port si nécessaire)
        this.jedis = new Jedis("localhost", 6379);
    }

    // Ajouter une donnée (clé-valeur) dans Redis
    public String addData(String key, String value) {
        jedis.set(key, value);
        return "Donnée ajoutée avec succès!";
    }

    // Récupérer toutes les données stockées dans Redis
    public Map<String, String> getAllData() {
        Map<String, String> data = new HashMap<>();
        for (String key : jedis.keys("*")) {
            data.put(key, jedis.get(key));
        }
        return data;
    }

    // Mettre à jour une donnée dans Redis
    public String updateData(String key, String value) {
        if (jedis.exists(key)) {
            jedis.set(key, value);
            return "Donnée mise à jour avec succès!";
        }
        return "Clé non trouvée!";
    }

    // Supprimer une donnée dans Redis
    public String deleteData(String key) {
        if (jedis.exists(key)) {
            jedis.del(key);
            return "Donnée supprimée avec succès!";
        }
        return "Clé non trouvée!";
    }
}
