package com.github.fardz1nho.ecochips.repositories;

import com.github.fardz1nho.ecochips.entities.ParticipacionReto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IParticipacionRetoRepository extends JpaRepository<ParticipacionReto, Integer> {
}
