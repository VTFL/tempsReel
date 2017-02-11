package main;

/**
 * Created by Thibault on 30/01/2017.
 */
public class main {

    public static void main(String[] args) {
        //TODO : Lancement interface graphique pour les paramètres de début


        //TODO : Lancement de la simulation avec les paramètres
        Simulation s = new Simulation(10,5,20,15,1,3,1,1,5.0,300);
        System.out.println(s.lancer());
    }
}
