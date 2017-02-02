package bean;

/**
 * Created by Thibault on 26/01/2017.
 */
public class DonneeTR extends Donnee {

    private long estampille;
    private int dureeValid;
    private boolean isReadable;
    private boolean isMisAJour;
    private int cptUpdate;
    private int tempsUpdate;

    public DonneeTR(int id, long estampille, int dureeValid, boolean isReadable, int tempsUpdate) {

        super(id);
        this.estampille = estampille;
        this.dureeValid = dureeValid;
        this.isReadable = isReadable;
        this.isMisAJour = false;
        this.tempsUpdate = tempsUpdate;
        this.cptUpdate=0;
    }

    public boolean isMisAJour() {
        return isMisAJour;
    }

    public void setMisAJour(boolean misAJour) {
        isMisAJour = misAJour;
    }

    public long getEstampille() {
        return estampille;
    }

    public void setEstampille(long estampille) {
        this.estampille = estampille;
    }

    public int getDureeValid() {
        return dureeValid;
    }

    public void setDureeValid(int dureeValid) {
        this.dureeValid = dureeValid;
    }

    public boolean isReadable() {
        return isReadable;
    }

    public void setReadable(boolean readable) {
        isReadable = readable;
    }

    public int getCptUpdate() {
        return cptUpdate;
    }

    public void setCptUpdate(int cptUpdate) {
        this.cptUpdate = cptUpdate;
    }

    public int getTempsUpdate() {
        return tempsUpdate;
    }

    public void setTempsUpdate(int tempsUpdate) {
        this.tempsUpdate = tempsUpdate;
    }

    @Override
    public String toString() {
        return "DonneeTR{" +
                "id=" + id +
                ", estampille=" + estampille +
                ", dureeValid=" + dureeValid +
                ", isReadable=" + isReadable +
                '}';
    }

    public boolean verouiller(){
        if(isReadable){
            isReadable=!isReadable;
            return true;
        }
        else return false;
    }

    public boolean deverouiller(){
        if(!isReadable){
            isReadable=!isReadable;
            return true;
        }
        else return false;
    }

    public int getEcheance(){
        return (int) (dureeValid+estampille);
    }
}
