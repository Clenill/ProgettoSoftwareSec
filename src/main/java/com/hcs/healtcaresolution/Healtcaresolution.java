package com.hcs.healtcaresolution;

import com.hcs.healtcaresolution.model.RaccoltaDati;
import javax.swing.JFrame;

public class Healtcaresolution {

    public static void main(String[] args) {
        // Creazione e connessione al db
        // Ricordati di chiudere connessione e statement
        RaccoltaDati.creazioneDatabase(); // metodo static della classe RaccoltaDati
        
        // Creazione e configurazione finestra principale
        JFrame frame = new JFrame("HealtCare Solution");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Istanza di Home
        PaginaBenvenuto schermataBenvenuto = new PaginaBenvenuto();
        
        frame.getContentPane().add(schermataBenvenuto);
        // Adatta le dimensioni del frame al componente
        frame.setSize(450, 700);
        // Centra la finestra sullo schermo
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
