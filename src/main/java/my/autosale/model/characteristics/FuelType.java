package my.autosale.model.characteristics;

import javax.persistence.*;

/**
 * Created by Nikol on 1/29/2017.
 */
@Entity
@Table(name="ref_fueltype")
public class FuelType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "fuel_type")
    private String fuelType;

    public FuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public FuelType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FuelType that = (FuelType) o;

        if (id != that.id) return false;
        if (fuelType != null ? !fuelType.equals(that.fuelType) : that.fuelType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fuelType != null ? fuelType.hashCode() : 0);
        return result;
    }
}
