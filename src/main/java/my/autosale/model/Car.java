package my.autosale.model;

import javax.persistence.*;

/**
 * Created by Nikol on 1/30/2017.
 */
@Entity
@Table(name = "car")
public class Car {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="owner_info_id")
    OwnerInfo ownerInfo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="maker_info_id")
    MakerInfo makerInfo;

    public Car() {
    }

    public Car(MakerInfo makerInfo, OwnerInfo ownerInfo) {
        this.makerInfo = makerInfo;
        this.ownerInfo = ownerInfo;
    }

    public OwnerInfo getOwnerInfo() {
        return ownerInfo;
    }

    public void setOwnerInfo(OwnerInfo ownerinfo) {
        this.ownerInfo = ownerinfo;
    }

    public MakerInfo getMakerInfo() {
        return makerInfo;
    }

    public void setMakerInfo(MakerInfo makerinfo) {
        this.makerInfo = makerinfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car that = (Car) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
