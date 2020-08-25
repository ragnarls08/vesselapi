package dev.raggi.repositories;

import dev.raggi.models.Vessel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IVesselRepository extends JpaRepository<Vessel, Long>
{
    Vessel findByName(String Name);
}

