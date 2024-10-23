/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotteria;

import java.util.Random;

/**
 *
 * @author monica ciuchetti
 */
public class Estrazione extends Thread {
    // attributi
    int n;
    private int numeri[][];
    private int vincitori[] = new int[3];
    private boolean verifica = false;
    private Random random = new Random();
    private int contawin = 0;
    
    //temporaneo
    // int numero = 3;
    /**
     * 
     * Metodo costruttore
     * @param numero 
     */   
    public Estrazione(int numero) {
        // popolamento matrice numeri estratti
        
        this.n = numero;
        
        this.numeri = new int[n][n];
        
        for (int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                numeri[i][j] = random.nextInt( 0, 100);
            }

        }
        
        
        // inizializzazione array vincitori

       }

    /**
    * 
    * Metodo per visualizzare la matrice dei numeri estratti
    */
    public void stampaMatrice() {
       // stampa matrice dei numeri estratti
       
       System.out.println("Matrice dei numeri vincenti: ");
       for (int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(numeri[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    /**
    * 
    * Metodo per visualizzare i vincitori dell'estrazione
    */

    /**
    * 
    * Metodo per verificare il numero scelto dal giocatore e determinare i vincitori
    */
    public void verifica(int numero, int idGiocatore) {

        for (int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                
                if(numero==numeri[i][j]){
               //System.out.println("Complimenti giocatore " + idGiocatore + " hai vinto scegliendo il numero " + numero +"!");
               if(contawin<3){
                   vincitori[contawin] = idGiocatore;
                   contawin++;
               }

               verifica=true;
               }
            }
        }
        if(verifica==false){
            System.out.println("Che peccato giocatore " + idGiocatore + " il numero " + numero +" non era vincente!");
        }
        
        
        
        /*
           if(numero==this.numero){
               System.out.println("Complimenti giocatore " + idGiocatore + " hai vinto scegliendo il numero " + numero +"!");
               
           } else {
               System.out.println("Che peccato giocatore " + idGiocatore + " il numero " + numero +" non era vincente!");
           }*/
    }
    
        
    public void stampaVincitori() {
        
        
        for(int i=0; i<3; i++){
              if(vincitori[i] !=0){
                  System.out.println("Complimenti giocatore "+ vincitori[i]+ " hai vinto!");
              }
            }
        }

    

    /**
    * 
    * Metodo per eseguire il thread
    */
    public void run() {
        // stampa iniziale
        // estrazione dei numeri
        // stampa matrice
        stampaMatrice();
        // stampa finale
    }
}


