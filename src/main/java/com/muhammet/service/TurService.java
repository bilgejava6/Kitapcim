package com.muhammet.service;

import com.muhammet.repository.ITurRepository;
import com.muhammet.repository.entity.Tur;
import com.muhammet.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TurService  extends ServiceManager<Tur,Long> {
    private final ITurRepository repository;
    public TurService(ITurRepository repository) {
        super(repository);
        this.repository = repository;
    }

    /**
     * Tür adı benzersiz olmalı bu uygulama için,
     * Roman, ROMAN, roman
     * @param turAdi
     */
    public void save(String turAdi){
        Optional<Tur> tur = repository
                                .findOptionalByAdIgnoreCase(turAdi);
        if(tur.isEmpty())
            save(Tur.builder().ad(turAdi).build());
    }
}
