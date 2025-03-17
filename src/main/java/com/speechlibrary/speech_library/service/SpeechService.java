/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.speechlibrary.speech_library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.speechlibrary.speech_library.model.Speech;
import com.speechlibrary.speech_library.repository.SpeechRepository;
 
 /**
  *
  * @author aisos
  */
 @Service
 public class SpeechService {
     private final  SpeechRepository speechRepository;
     
     @Autowired
     public SpeechService(SpeechRepository speechRepository){
         this.speechRepository = speechRepository;
     }
 
     public Speech createSpeech(Speech speech){
         return speechRepository.save(speech);
     }

     public List<Speech> getAllSpeeches(){
        return speechRepository.findAll();
     }

     public Speech getSpeechById(Long id){
        return speechRepository.findById(id).orElse(null);
     }

     public Speech editSpeech(Long id, Speech updated_speech){
        Speech requested_speech = getSpeechById(id);
        if(requested_speech != null){
            System.out.println("Updating author name to: " + updated_speech.getAuthorName());
            if(updated_speech.getAuthorName() != null){
                requested_speech.setAuthorName(updated_speech.getAuthorName());
            }
            if(updated_speech.getContent() != null){
                requested_speech.setContent(updated_speech.getContent());
            }
            if(updated_speech.getKeyWords() != null){
                requested_speech.setKeyWords(updated_speech.getKeyWords());
            }
            if(updated_speech.getSpeechDate() != null){
                requested_speech.setSpeechDate(updated_speech.getSpeechDate());
            }
            return speechRepository.save(requested_speech);
        }
        else {
            throw new RuntimeException("Speech not found with id: " + id);
        }
     }

 }
 