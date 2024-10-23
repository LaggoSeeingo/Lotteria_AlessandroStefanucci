/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotteria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author monica ciuchetti
 */
public class Giocatore extends Thread{
    // attributi
    private int idGiocatore;
    private String nomeGiocatore;
    private Estrazione estrazione;

    /**
    * 
    * Metodo costruttore
    * @param idGiocatore codice del giocatore
    * @param estrazione riferimento dell'oggetto Estrazione
    * @param nomeGiocatore
    */
    public Giocatore(int idGiocatore, String nomeGiocatore, Estrazione estrazione) {
       // inizializzazione attributi
       this.idGiocatore = idGiocatore;
       this.nomeGiocatore = nomeGiocatore;
       this.estrazione = estrazione;
    }

    /**
    * 
    * Metodo per eseguire il thread
    */
    public void run() {
       
        // scelta del numero da giocare
        int numeroScelto = 0;
        
        System.out.println("Giocatore " + this.idGiocatore + " inserisci il tuo numero!");
        // Scanner scanner = new Scanner(System.in);
        
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        
        try { 
            numeroScelto = Integer.parseInt(br.readLine());
        } catch (IOException ex) {
            Logger.getLogger(Giocatore.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore nell'inserimento del numero ");
        }
        
        
        System.out.println("Inizio estrazione per il giocatore "+idGiocatore);
        for(int i = 10; i>0; i--){
           System.out.println(i);
           
                   
        try {
            this.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Giocatore.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore nello sleep");
        }
        
        }

        
       // verifica del risultato
       estrazione.verifica(numeroScelto, idGiocatore);
       
       // stampa fine verifica
       // System.out.println("Numero verificato");
       
    }
}
