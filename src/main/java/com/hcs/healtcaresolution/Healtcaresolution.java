/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.hcs.healtcaresolution;

import javax.swing.*;

/**
 *
 * @author Sheppard
 */
public class Healtcaresolution {

    public static void main(String[] args) {
        //Creazione e configurazione finestra principale
        JFrame frame = new JFrame("HealtCare Solution");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Istanza di Home
        PaginaBenvenuto schermataBenvenuto = new PaginaBenvenuto();
        
        frame.getContentPane().add(schermataBenvenuto);
        //adatta le dimensioni del frame al componente
        //frame.pack();//non funziona bene 
        frame.setSize(400, 500);
        //centra la finestra sullo schermo
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        
    }
}
