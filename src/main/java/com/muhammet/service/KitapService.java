package com.muhammet.service;

import com.muhammet.dto.request.SaveKitapRequestDto;
import com.muhammet.mapper.IKitapMapper;
import com.muhammet.repository.IKitapRepository;
import com.muhammet.repository.entity.Kitap;
import com.muhammet.repository.entity.YazarKitap;
import com.muhammet.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class KitapService extends ServiceManager<Kitap,Long> {
    private final IKitapRepository repository;
    private final YazarKitapService yazarKitapService;
    public KitapService(IKitapRepository repository,
                        YazarKitapService yazarKitapService){
        super(repository);
        this.repository=repository;
        this.yazarKitapService = yazarKitapService;
    }

    public Kitap save(SaveKitapRequestDto dto){
      Kitap kitap = save(IKitapMapper.INSTANCE.toKitap(dto));
        /**
         * 1. Kitap hangi yazar ya da yazarlara ait?
         */
        Long yazarid =  dto.getYazarids().get(0);
        YazarKitap yazarKitap = YazarKitap.builder()
                .yazarid(yazarid)
                .kitapid(kitap.getId())
                .build();
        yazarKitapService.save(yazarKitap);
      return kitap;
    }
}
