package com.piData.emlak.repository;

import com.piData.emlak.entity.model.Musteri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusteriRepository extends JpaRepository<Musteri,Long> {


    List<Musteri> getAllBy();

    Musteri findByTelCep (String val);
}
