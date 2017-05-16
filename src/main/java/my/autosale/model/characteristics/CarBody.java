package my.autosale.model.characteristics;

import javax.persistence.*;

/**
 * Created by Nikol on 1/29/2017.
 */
@Entity
@Table(name="ref_carbody")
public class CarBody {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "car_body")
    private String carBody;

    public CarBody(String carBody) {
        this.carBody = carBody;
    }

    public CarBody() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarBody() {
        return carBody;
    }

    public void setCarBody(String carBody) {
        this.carBody = carBody;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarBody that = (CarBody) o;

        if (id != that.id) return false;
        if (carBody != null ? !carBody.equals(that.carBody) : that.carBody != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (carBody != null ? carBody.hashCode() : 0);
        return result;
    }
}
