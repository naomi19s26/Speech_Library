/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.speechlibrary.speech_library.model;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 *
 * @author aisos
 */
@Entity
public class Speech {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long speechId; 

    private String authorName;
    private String content;
    private LocalDate speechDate;
    @ElementCollection
    private Set<String> keywords;

    public Speech() {
    }

    public Speech(String authorName, String content, Set<String> keywords, LocalDate speechDate) {
        this.authorName = authorName;
        this.content = content;
        this.keywords = keywords;
        this.speechDate = speechDate;
    }

    public Long getId() {
        return speechId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getContent() {
        return content;
    }

    public LocalDate getSpeechDate() {
        return speechDate;
    }

    public Set<String> getKeyWords() {
        return keywords;
    }

    public void setId(Long id) {
        this.speechId = id;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSpeechDate(LocalDate speechDate) {
        this.speechDate = speechDate;
    }

    public void setKeyWords(Set<String> keywords) {
        this.keywords = keywords;
    }
}
