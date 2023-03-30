package com.muhammet.repository;

import com.muhammet.repository.entity.YazarKitap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IYazarKitapRepository extends JpaRepository<YazarKitap,Long> {
}
