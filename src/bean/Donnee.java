package bean;

/**
 * Created by Thibault on 26/01/2017.
 */
public class Donnee {
    protected int id;

    public Donnee(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    @Override
    public String toString() {
        return "Donnee{" +
                "id=" + id +
                '}';
    }
}
