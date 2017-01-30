package bean;

/**
 * Created by Thibault on 26/01/2017.
 */
public class DonneeTR extends Donnee {

    private long estampille;
    private int dureeValid;
    private boolean isReadable;

    public DonneeTR(int id, long estampille, int dureeValid, boolean isReadable) {

        super(id);
        this.estampille = estampille;
        this.dureeValid = dureeValid;
        this.isReadable = isReadable;
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
}
