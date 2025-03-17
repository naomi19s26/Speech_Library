/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.speechlibrary.speech_library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.speechlibrary.speech_library.model.Speech;
import com.speechlibrary.speech_library.service.SpeechService;



/**
 *
 * @author aisos
 */
@RestController
@RequestMapping("/speeches")
public class SpeechController {
    private final SpeechService speechService;

    @Autowired
    public SpeechController(SpeechService speechService){
        this.speechService = speechService;
    }

    @GetMapping("/{id}") 
    public Speech getSpeechById(@PathVariable Long id) { 
        return speechService.getSpeechById(id); 
    } 
      

    @PostMapping
    public Speech createSpeech(@RequestBody Speech speech){
        return speechService.createSpeech(speech);
    }

    @GetMapping
    public List<Speech> getAllSpeeches() { 
        return speechService.getAllSpeeches(); 
    }

    @PutMapping("/{id}")
    public Speech editSpeech(@PathVariable Long id, @RequestBody Speech speech){
        return speechService.editSpeech(id, speech);
    }
    

}
