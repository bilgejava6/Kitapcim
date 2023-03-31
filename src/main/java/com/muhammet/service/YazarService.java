package com.muhammet.service;

import com.muhammet.dto.request.SaveYazarRequestDto;
import com.muhammet.mapper.IYazarMapper;
import com.muhammet.repository.IYazarRepository;
import com.muhammet.repository.entity.Yazar;
import com.muhammet.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class YazarService extends ServiceManager<Yazar,Long> {
    private final IYazarRepository repository;
    public YazarService(IYazarRepository repository){
        super(repository);
        this.repository=repository;
    }

    public void save(SaveYazarRequestDto dto){
        Optional<Yazar> yazar = repository.findOptionalByAdIgnoreCase(dto.getAd());
        if(yazar.isEmpty())
            //repository.save(Yazar.builder().ad(dto.getAd()).biyografi(dto.getBiyografi()).build());
            save(IYazarMapper.INSTANCE.toYazar(dto));
    }
}
