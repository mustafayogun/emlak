package com.piData.emlak.repository;

import com.piData.emlak.entity.model.Isletme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IsletmeRepository extends JpaRepository<Isletme,Long> {

    Isletme getByVergiNo(String val);

    List<Isletme> getAllBy();
}
