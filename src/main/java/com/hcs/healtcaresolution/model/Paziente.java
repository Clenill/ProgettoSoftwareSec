/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*package com.hcs.healtcaresolution.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;


@Entity
@Table(name="paziente")
public class Paziente {
    
    @Id
    @Column(name = "idpaziente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPaziente;
    
    @Column(name = "nomepaziente", nullable = false)
    private String nomePaziente;
    
    @Column(name="cognomepaziente", nullable = false)
    private String cognomePaziente;
    
    @Column(name="datadinascita", nullable = false)
    private LocalDate localDate;
    
    @Column(name="luogodinascita", nullable = false)
    private String luogoNascita;
    
    @Column(name="parolaingresso", nullable = false)
    private String parolaingresso;
   
    public Paziente(){
        
    }
    
    public Paziente(int idPaziente, String nomePaziente, String cognomePaziente){
        this.idPaziente = idPaziente;
        this.nomePaziente = nomePaziente;
        this.cognomePaziente = cognomePaziente;
    }
    
    //Getter e Setter
    
    public void setIdPaziente(int idPaziente){
        this.idPaziente = idPaziente;
    }
    public int getIdPaziente(){
        return idPaziente;
    }
    
    public void setNomePaziente(String nomePaziente){
        this.nomePaziente = nomePaziente;
    }
    public String getNomePaziente(){
        return nomePaziente;
    }
    public void setCognomePaziente(String cognomePaziente){
        this.cognomePaziente = cognomePaziente;
    }
    public String getCognomePaziente(){
        return cognomePaziente;
    }
    
    
}
*/