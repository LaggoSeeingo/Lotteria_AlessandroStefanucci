<h1 align="center">Progetto Lotteria</h1>

<p align="center" style="font-family: monospace">Alessandro Stefanucci <a href="https://github.com/LaggoSeeingo">@LaggoSeeingo</a></p>

## Scopo del Progetto
Si deve realizzare un’applicazione Java multithreading che consenta di estrarre dei numeri random e di memorizzarli poi in una matrice nxn. 
Più giocatori possono scegliere un numero e verificarne la presenza tra i numeri estratti. Solo i primi tre giocatori che indovinano il numero possono vincere il premio corrispondente.


## Classi Utilizzate

### 1. Lotteria
Classe principale che avvia e coordina il gioco:
- Gestisce l'input iniziale della dimensione della matrice
- Istanzia e avvia i thread di Estrazione e dei Giocatori
- Gestisce la sincronizzazione tra i thread

### 2. Estrazione
Thread responsabile della gestione dei numeri della lotteria:
- Crea la matrice dei numeri vincenti di dimensioni nxn 
- Verifica i numeri scelti dai giocatori confrontandoli con la matrice dei numeri vincenti
- Gestisce l'array dei vincitori

#### Dettaglio del metodo verifica()
```java
public void verifica(int numero, int idGiocatore) {
    // Itera attraverso la matrice alla ricerca del numero giocato
    for (int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            // Se trova corrispondenza
            if(numero==numeri[i][j]){
                // Aggiunge il giocatore all'array dei vincitori se c'è ancora posto
                if(contawin<3){
                    vincitori[contawin] = idGiocatore;
                    contawin++;
                }
                verifica=true;
            }
        }
    }
    // Se il numero non viene trovato, notifica il giocatore
    if(verifica==false){
        System.out.println("Che peccato giocatore " + idGiocatore + 
                          " il numero " + numero +" non era vincente!");
    }
}
```
Il metodo:
- Riceve come parametri il numero scelto e l'ID del giocatore
- Cerca il numero in tutta la matrice
- Se trova una corrispondenza e ci sono meno di 3 vincitori, inserisce il giocatore nell'array

### 3. Giocatore
Thread che gestisce il singolo giocatore:
- Permette la scelta del numero al giocatore
- Implementa un countdown prima della verifica 
- Avvia il metodo di verifica della classe estrazione passando i parametri necessari

## Riferimenti alle Librerie
Il progetto utilizza le seguenti librerie Java:
- `java.io.BufferedReader`: Per la gestione dell'input utente
- `java.io.InputStreamReader`: Per la lettura dello stream di input
- `java.util.Random`: Per la generazione di numeri casuali
- `java.util.logging`: Per la gestione dei log e degli errori
- `java.util.Scanner`: Per la gestione dell'input (non utilizzata effettivamente)

## Scenari Alternativi di Funzionamento

### 1. Errori di Input
- **Dimensione matrice non valida**:
  - Gestito tramite try-catch in Lotteria.main()
  - Logging dell'errore
  - Messaggio di errore all'utente

- **Numero giocato non valido**:
  - Gestito tramite try-catch in Giocatore.run()
  - Logging dell'errore
  - Messaggio di errore all'utente

### 2. Errori di Esecuzione
- **Interruzione dei thread**:
  - Gestita tramite try-catch nei metodi join()
  - Logging dell'interruzione
  - Possibile terminazione anticipata del gioco

- **Errori durante il sleep**:
  - Gestiti nel countdown del giocatore
  - Logging dell'errore
  - Il gioco procede senza il delay

## Commento dell'Esecuzione
1. **Fase di Avvio**:
   - Richiesta dimensione matrice
   - Creazione e avvio thread Estrazione
   - Visualizzazione matrice dei numeri vincenti //da modificare

2. **Fase di Gioco**:
   - Avvio parallelo dei 4 giocatori
   - Ogni giocatore inserisce il proprio numero //da modificare
   - Esecuzione del countdown individuale
   - Verifica del numero e notifica del risultato

3. **Fase di Conclusione**:
   - Attesa completamento di tutti i thread
   - Stampa dell'elenco dei vincitori
   - Termine del gioco

