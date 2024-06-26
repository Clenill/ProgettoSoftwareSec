/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.hcs.healtcaresolution;

import com.hcs.healtcaresolution.model.RaccoltaDati;
import javax.swing.*;

/**
 *
 * @author Sheppard
 */
public class Healtcaresolution {

    public static void main(String[] args) {
        //Creazione e connessione al db
        //ricordati di chiudere connessione e statemant 
        //i metodi statici sono risolti a compile-time
        RaccoltaDati.creazioneDatabase();//metodo static della classe RaccoltaDati
        
        //Creazione e configurazione finestra principale
        JFrame frame = new JFrame("HealtCare Solution");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Istanza di Home
        PaginaBenvenuto schermataBenvenuto = new PaginaBenvenuto();
        
        frame.getContentPane().add(schermataBenvenuto);
        //adatta le dimensioni del frame al componente
        //frame.pack();//non funziona bene 
        frame.setSize(450, 700);
        //centra la finestra sullo schermo
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        
    }
}

