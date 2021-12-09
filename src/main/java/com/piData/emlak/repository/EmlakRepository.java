package com.piData.emlak.repository;

import com.piData.emlak.entity.model.Emlak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmlakRepository extends JpaRepository<Emlak,Long> {


}
