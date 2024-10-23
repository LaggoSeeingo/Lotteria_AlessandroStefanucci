/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotteria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;


/**
 *
 * @author monica ciuchetti
 */
public class Lotteria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Avvio gioco
        
        System.out.println("Il gioco inizia!");
        System.out.println("\n");
        
        int numero = 0;
        // Scelta del numero dei numeri da estrarre
        
        System.out.println("Quanto vuoi che sia grande la matrice? inserisci un numero n (matrice nxn) ");
        // Scanner scanner = new Scanner(System.in);
        
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        
        try {
             numero = Integer.parseInt(br.readLine()); 
        } catch (IOException ex) {
            Logger.getLogger(Lotteria.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore nell'inserimento del numero ");
        }
        
                
        // Istanza ed avvio del thread Estrazione
        Estrazione e = new Estrazione(numero);
        // Istanza di alcuni thread Giocatore
        Giocatore g1 = new Giocatore(1, "Puttone", e);
        Giocatore g2 = new Giocatore(2, "Gradassi", e);
        Giocatore g3 = new Giocatore(3, "Piero", e);
        Giocatore g4 = new Giocatore(4, "Andrew", e);
        
        // Avvio dei thread Giocatori
       
        e.start();
        
        try {
            e.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Lotteria.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        g1.start();
        g2.start();
        g3.start();
        g4.start();
        
        try {
            g1.join();
            g2.join();
            g3.join();
            g4.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Lotteria.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore nel join");
        }
        
        e.stampaVincitori();
        // Comunicazione fine gioco
        System.out.println("\n");
        System.out.println("Fine del gioco, inserire un altro gettone per giocare.");

    }
}
   