package com.muhammet.repository;

import com.muhammet.repository.entity.Yayinevi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IYayineviRepository extends JpaRepository<Yayinevi,Long> {
}
