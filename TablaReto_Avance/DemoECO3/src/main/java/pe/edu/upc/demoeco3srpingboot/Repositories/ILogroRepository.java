package com.github.fardz1nho.ecochips.repositories;

import com.github.fardz1nho.ecochips.entities.Logro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILogroRepository extends JpaRepository<Logro, Integer> {
}
