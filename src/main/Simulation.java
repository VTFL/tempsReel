package main;

import bean.Donnee;
import bean.DonneeTR;
import bean.Transaction;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Thibault on 30/01/2017.
 */
public class Simulation {

    private int nbDonneesTR;
    private int validMin;
    private int validMax;
    private int nbDonnees;
    private ArrayList<DonneeTR> donneesTR;
    private ArrayList<Donnee> donnees;
    private ArrayList<Transaction> transactions;
    private static int ID_DONNEE;
    private static int NB_TR_FOIRE;


    public Simulation(int nbDonneesTR, int validMin, int validMax, int nbDonnees) {
        this.nbDonneesTR = nbDonneesTR;
        this.validMin = validMin;
        this.validMax = validMax;
        this.nbDonnees = nbDonnees;
        this.donneesTR = new ArrayList<DonneeTR>();
        this.donnees = new ArrayList<Donnee>();
        this.transactions = new ArrayList<Transaction>();
        this.ID_DONNEE=0;

    }

    public void lancer(){
        donneesTR = creerDonneesTR();
        donnees = creerDonnees();
        //TODO : Traitement des transactions avec la file

    }

    private ArrayList<DonneeTR> creerDonneesTR(){
        ArrayList<DonneeTR> aRetourner = new ArrayList<DonneeTR>();
        for(int i=0;i<nbDonneesTR;i++){
            aRetourner.add(new DonneeTR(ID_DONNEE++,0,(int)(Math.random()*validMax+validMin),true));
        }
        ID_DONNEE=0;
        return aRetourner;
    }
    private ArrayList<Donnee> creerDonnees(){
        ArrayList<Donnee> aRetourner = new ArrayList<Donnee>();
        for(int i=0;i<nbDonnees;i++){
            aRetourner.add(new Donnee(ID_DONNEE++));
        }
        return aRetourner;
    }

    //TODO méthode ajouterOperation
    private void ajouterOperation(int nbTransaction, int tempsLectureTR, int tempsLecture, int tempsEcriture){

    }
}
