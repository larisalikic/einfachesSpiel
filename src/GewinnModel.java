import java.util.Random;

/**
 * Model des Zahlen-Gewinnspiels.
 * Speichert die Punkte und die Zahlen der aktuellen Runde, ermittelt die
 * Computerzahl und berechnet das Rundenergebnis. Der Spieler startet mit
 * 30 Punkten, bei 100 oder mehr hat er gewonnen, bei 0 oder weniger verloren.
 *
 * @author Larisa Likic
 * @version 21.9.2026
 */


public class GewinnModel {

    private int gesamtPunkte;
    private int spielerZahl;
    private int computerZahl;
    private int rundenErgebnis;

    public GewinnModel() {
        gesamtPunkte = 30;
    }

    public int getGesamtPunkte() {
        return gesamtPunkte;
    }

    public int getComputerZahl() {
        return computerZahl;
    }

    public int getRundenErgebnis() {
        return rundenErgebnis;
    }

    public void berechneComputerZahl(){
        Random random = new Random();
        computerZahl = random.nextInt(9) + 1;
    }

    public void berechneRunde(int spielerZahl) {
        this.spielerZahl = spielerZahl;

        if (spielerZahl == computerZahl) {
            rundenErgebnis = 20;
        } else if (spielerZahl == computerZahl + 1 || spielerZahl == computerZahl - 1) {
            rundenErgebnis = 5;
        } else {
            rundenErgebnis = -10;
        }

        gesamtPunkte += rundenErgebnis;
    }

    public boolean hatGewonnen(){
        return gesamtPunkte >= 100;
    }

    public boolean hatVerloren(){
        return gesamtPunkte <= 0;
    }


}
