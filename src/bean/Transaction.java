package bean;

/**
 * Created by Thibault on 30/01/2017.
 */
public class Transaction implements Comparable<Transaction> {
    private int id;
    private int idDonnee;
    private int arrivee;
    private int echeance;

    public Transaction(int id, int idDonnee, int arrivee, int echeance) {

        this.id = id;
        this.idDonnee = idDonnee;
        this.arrivee = arrivee;
        this.echeance = echeance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEcheance() {
        return echeance;
    }

    public void setEcheance(int echeance) {
        this.echeance = echeance;
    }

    public int getArrivee() {
        return arrivee;
    }

    public void setArrivee(int arrivee) {
        this.arrivee = arrivee;
    }

    public int getIdDonnee() {
        return idDonnee;
    }

    public void setIdDonnee(int idDonnee) {
        this.idDonnee = idDonnee;
    }

    @Override
    public String toString() {
        return "Transaction n°" + id + " crée en " + arrivee + " avec une échéance de " + echeance;
    }

    @Override
    public int compareTo(Transaction t) {
        if(this.echeance < t.echeance) return -1;
        else if(this.echeance == t.echeance) return 0;
        else return 1;
    }
}
