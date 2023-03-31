package com.muhammet.service;

import com.muhammet.dto.request.SaveYayineviRequestDto;
import com.muhammet.mapper.IYayineviMapper;
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

    public void save(SaveYayineviRequestDto dto){
    //        Yayinevi yayinevi = new Yayinevi();
//        yayinevi.setAd(dto.getAd());
//        yayinevi.setAdres(dto.getAdres());
//        yayinevi.setTelefon(dto.getTelefon());
//        save(yayinevi);
//        Yayinevi yayinevi = Yayinevi.builder()
//                .ad(dto.getAd())
//                .adres(dto.getAdres())
//                .telefon(dto.getTelefon())
//                .build();
//        save(yayinevi);
//        Yayinevi yayinevi = IYayineviMapper
//                                .INSTANCE
//                                .toYayinevi(dto);
//        save(yayinevi);
         save(IYayineviMapper.INSTANCE.toYayinevi(dto));
    }
}
