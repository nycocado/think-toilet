package pt.iade.ei.thinktoilet.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "toilet")
public class Toilet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cla_id")
    private int id;

    @ManyToOne
    @JoinColumn(
            name = "toil_city_id",
            referencedColumnName = "city_id",
            nullable = false
    )
    private City city;

    @ManyToOne
    @JoinColumn(
            name = "toil_acs_id",
            referencedColumnName = "acs_id",
            nullable = false
    )
    private Access access;

    @Column(name = "toil_name")
    private String name;

    @Column(name = "toil_lat")
    private double latitude;

    @Column(name = "toil_long")
    private double longitude;

    @Column(name = "toil_address")
    private String address;

    @Column(name = "toil_mapsid")
    private String mapsid;

    @Column(name = "toil_cdate")
    private LocalDate cdate;

    @Column(name = "toil_image")
    private String image;

    public Toilet() {
    }

    public int getId() {
        return id;
    }

    public City getCity() {
        return city;
    }

    public Access getAccess() {
        return access;
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getAddress() {
        return address;
    }

    public String getMapsid() {
        return mapsid;
    }

    public LocalDate getCdate() {
        return cdate;
    }

    public String getImage() {
        return image;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setAccess(Access access) {
        this.access = access;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMapsid(String mapsid) {
        this.mapsid = mapsid;
    }

    public void setCdate(LocalDate cdate) {
        this.cdate = cdate;
    }

    public void setImage(String image) {
        this.image = image;
    }
}