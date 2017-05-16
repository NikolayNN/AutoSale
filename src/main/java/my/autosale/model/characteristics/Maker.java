package my.autosale.model.characteristics;

import javax.persistence.*;

/**
 * Created by Nikol on 1/29/2017.
 */
@Entity
@Table(name="ref_maker")
public class Maker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "maker")
    private String maker;

    public Maker(String maker) {
        this.maker = maker;
    }

    public Maker() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Maker that = (Maker) o;

        if (id != that.id) return false;
        if (maker != null ? !maker.equals(that.maker) : that.maker != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (maker != null ? maker.hashCode() : 0);
        return result;
    }
}
