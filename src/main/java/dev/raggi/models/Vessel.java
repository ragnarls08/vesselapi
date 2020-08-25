package dev.raggi.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Vessel
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String country;

    @OneToMany
    private List<Position> positions = new ArrayList<>();

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        positions = positions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
