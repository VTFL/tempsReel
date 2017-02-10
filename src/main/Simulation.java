package main;

import bean.Donnee;
import bean.DonneeTR;
import bean.Transaction;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by Thibault on 30/01/2017.
 */
public class Simulation {

    private int nbDonneesTR;
    private int validMin;
    private int validMax;
    private int nbDonnees;
    private int tempsUpdateMin;
    private int tempsUpdateMax;
    private ArrayList<DonneeTR> donneesTR;
    private ArrayList<Donnee> donnees;
    private ArrayList<Transaction> transactions;
    private static int ID_DONNEE;
    private static int ID_TRANSACTION;
    private static int NB_TR_FOIRE;
    private static int NB_FOIRE;
    private static int NB;
    private int dureeSimulation = 100;
    private double lambda = 5.0;
    private int lectureClassique = 1;
    private int ecritureClassique = 1;


    public Simulation(int nbDonneesTR, int validMin, int validMax, int nbDonnees, int tempsUpdateMin, int tempsUpdateMax) {
        this.nbDonneesTR = nbDonneesTR;
        this.validMin = validMin;
        this.validMax = validMax;
        this.nbDonnees = nbDonnees;
        this.tempsUpdateMax=tempsUpdateMax;
        this.tempsUpdateMin=tempsUpdateMin;
        this.donneesTR = new ArrayList<DonneeTR>();
        this.donnees = new ArrayList<Donnee>();
        this.transactions = new ArrayList<Transaction>();
        this.ID_DONNEE=0;
        this.ID_TRANSACTION=0;
        this.NB=0;

    }

    public String lancer(){
        donneesTR = creerDonneesTR();
        donnees = creerDonnees();

        double poisson = getPoissonRandom(this.lambda);

        for(int i=0;i<dureeSimulation;i++){

            //Retrait des transactions dépassées
            Collections.sort(transactions);
            for(int j=0;j<transactions.size();j++){
                if(transactions.get(j).getEcheance()<i){
                    transactions.add(new Transaction(ID_TRANSACTION++,transactions.get(j).getIdDonnee(),i,dureeSimulation));
                    if(donneesTR.get(transactions.get(j).getIdDonnee()).isMisAJour()){
                        donneesTR.get(transactions.get(j).getIdDonnee()).setReadable(true);
                        donneesTR.get(transactions.get(j).getIdDonnee()).setMisAJour(false);
                    }
                    transactions.remove(j);
                    j--;
                    NB_TR_FOIRE++;

                }
                else break;
            }

            //Transactions utilisateur selon le procecuss de poisson.
            /*if(i==(int) poisson) {
                poisson = transactionPoisson(i);
            }*/

            //Création des transactions de mise à jour
            for(DonneeTR d : donneesTR){
                if((int)Math.floor(d.getEcheance()*2/3) == i){
                    transactions.add(new Transaction(ID_TRANSACTION++,d.getId(),i,d.getEcheance()));
                    NB++;
                }
            }

            //transaction de mise à jour finie
            if(transactions.size()>0){
                if(donneesTR.get(transactions.get(0).getIdDonnee()).isMisAJour()){
                    if(donneesTR.get(transactions.get(0).getIdDonnee()).getCptUpdate() == donneesTR.get(transactions.get(0).getIdDonnee()).getTempsUpdate()){
                        donneesTR.get(transactions.get(0).getIdDonnee()).setReadable(true);
                        donneesTR.get(transactions.get(0).getIdDonnee()).setMisAJour(false);
                        donneesTR.get(transactions.get(0).getIdDonnee()).setCptUpdate(0);
                        donneesTR.get(transactions.get(0).getIdDonnee()).setEstampille(i);
                        transactions.remove(0);

                        //On execute la prochaine transaction si il y en a une
                        if(transactions.size()>0){
                            donneesTR.get(transactions.get(0).getIdDonnee()).setReadable(false);
                            donneesTR.get(transactions.get(0).getIdDonnee()).setMisAJour(true);
                        }


                    }
                    else{
                        donneesTR.get(transactions.get(0).getIdDonnee()).setCptUpdate( donneesTR.get(transactions.get(0).getIdDonnee()).getCptUpdate()+1);
                    }
                }
                //On traite la prochaine transaction
                else{
                    donneesTR.get(transactions.get(0).getIdDonnee()).setReadable(false);
                    donneesTR.get(transactions.get(0).getIdDonnee()).setMisAJour(true);
                    donneesTR.get(transactions.get(0).getIdDonnee()).setCptUpdate( donneesTR.get(transactions.get(0).getIdDonnee()).getCptUpdate()+1);
                }
            }

        }
        return "Transactions lancées : "+NB+" dont ratées : "+NB_TR_FOIRE;
    }

    private ArrayList<DonneeTR> creerDonneesTR(){
        ArrayList<DonneeTR> aRetourner = new ArrayList<DonneeTR>();
        for(int i=0;i<nbDonneesTR;i++){
            aRetourner.add(new DonneeTR(ID_DONNEE++,0,(int)(Math.random()*validMax+validMin),true,(int)(Math.random()*tempsUpdateMax+tempsUpdateMin)));
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

    private static int getPoissonRandom(double mean) {
        Random r = new Random();
        double L = Math.exp(-mean);
        int k = 0;
        double p = 1.0;
        do {
            p = p * r.nextDouble();
            k++;
        } while (p > L);
        return k - 1;
    }

    private double transactionPoisson(int i) {

        System.out.println("Allow ?");

        //Creation Transaction lecture donnée TR
        int indiceRandom = (int) (Math.random()*(donneesTR.size()-1));
        DonneeTR dtr = donneesTR.get(indiceRandom);
        transactions.add(new Transaction(ID_TRANSACTION++,dtr.getId(),i, dtr.getEcheance()));

        //Creation Transaction lecture donnée
        indiceRandom = (int) (Math.random()*(donnees.size()-1));
        Donnee don = donnees.get(indiceRandom);
        transactions.add(new Transaction(ID_TRANSACTION++,don.getId(),i, lectureClassique));

        //Creation Transaction ecriture donnée
        indiceRandom = (int) (Math.random()*(donnees.size()-1));
        don = donnees.get(indiceRandom);
        transactions.add(new Transaction(ID_TRANSACTION++,don.getId(),i, ecritureClassique));

        return getPoissonRandom(lambda);
    }
}
