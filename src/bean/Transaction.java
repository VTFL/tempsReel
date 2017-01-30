package bean;

/**
 * Created by Thibault on 30/01/2017.
 */
public class Transaction implements Comparable<Transaction> {
    private int id;
    private int echeance;

    public Transaction(int id, int echeance) {

        this.id = id;
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

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", echeance=" + echeance +
                '}';
    }

    @Override
    public int compareTo(Transaction t) {
        if(this.echeance < t.echeance) return -1;
        else if(this.echeance == t.echeance) return 0;
        else return 1;
    }
}
