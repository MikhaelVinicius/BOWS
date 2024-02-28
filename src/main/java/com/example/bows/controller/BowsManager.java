package com.example.bows.controller;

import java.util.HashMap;
import java.util.Map;

import com.example.bows.model.Bows;

public class BowsManager {

	private Map<String, Map<Bows,Long>> bows;
	
	public BowsManager(){
		this.bows = new HashMap<>();
	}	
	
	public BowsManager(Map<String,Map<Bows,Long>> bows) {
		this.bows = bows;
	}
	
	public Map<String,Map<Bows,Long>> getBows(){
		return bows;
	}
	
	public Map<Bows, Long> getBow(String email){
		return bows.get(email);
	}
	
	public void addBow(String email, Bows bow) {
        Map<Bows,Long> especie = bows.get(email);
        if (especie == null) {
            especie = new HashMap<>();
            bows.put(email, especie);
        }
        especie.put(bow, especie.getOrDefault(bow, (long) 0) + 1);
    }
	
	
	
	
	
}
