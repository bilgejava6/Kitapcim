package com.muhammet.repository;

import com.muhammet.repository.entity.Tur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ITurRepository extends JpaRepository<Tur,Long> {
    /**
     * Tür adının sorulanarak veritabanında olup
     * olmadığına bakılır.
     * @param ad -> tür adının giriniz
     * @return -> Ootional olarak bulunan tür döndürülür.
     */
    Optional<Tur> findOptionalByAdIgnoreCase(String ad);
}
