package com.muhammet.repository;

import com.muhammet.repository.entity.Yazar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IYazarRepository extends JpaRepository<Yazar,Long> {

    Optional<Yazar> findOptionalByAdIgnoreCase(String ad);

    List<Yazar> findAllByAdContaining(String ad);
}
