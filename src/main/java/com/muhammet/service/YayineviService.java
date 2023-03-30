package com.muhammet.service;

import com.muhammet.repository.IYayineviRepository;
import com.muhammet.repository.entity.Yayinevi;
import com.muhammet.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class YayineviService extends ServiceManager<Yayinevi,Long> {
    private final IYayineviRepository repository;

    public YayineviService(IYayineviRepository repository){
        super(repository);
        this.repository=repository;
    }
}
