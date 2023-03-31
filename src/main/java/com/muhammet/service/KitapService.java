package com.muhammet.service;

import com.muhammet.dto.request.SaveKitapRequestDto;
import com.muhammet.mapper.IKitapMapper;
import com.muhammet.repository.IKitapRepository;
import com.muhammet.repository.entity.Kitap;
import com.muhammet.repository.entity.TurKitap;
import com.muhammet.repository.entity.YazarKitap;
import com.muhammet.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class KitapService extends ServiceManager<Kitap,Long> {
    private final IKitapRepository repository;
    private final YazarKitapService yazarKitapService;
    private final TurKitapService turKitapService;
    public KitapService(IKitapRepository repository,
                        YazarKitapService yazarKitapService,
                        TurKitapService turKitapService){
        super(repository);
        this.repository=repository;
        this.yazarKitapService = yazarKitapService;
        this.turKitapService = turKitapService;
    }

    public Kitap save(SaveKitapRequestDto dto){
      Kitap kitap = save(IKitapMapper.INSTANCE.toKitap(dto));
        /**
         * 1. Kitap hangi yazar ya da yazarlara ait?
         */
        /**
         * List<Long> yazarlist = [1,4,2]
         * yazarlist.get(0) = 1
         * yazarlist.get(1) = 4
         * yazarlist.get(2) = 2
         */
//        Long yazarid =  dto.getYazarids().get(0); // Burada bize bir listes geliyor. bu nedenle ilk kaydı almak için get(0) diyorum.
        /**
         * for
         * foreach
         * while
         * do while
         * forEach(x->{}) bir listenin içindkei değeri alyans olarak tanımladığımız
         * değere atayarak loop yapmamızı sağlar.
         */
        dto.getYazarids().forEach(yazarid ->{
            yazarKitapService.save(yazarid,kitap.getId());
        });

        /**
         * 2. Kitabun hangi tür ya da türlere ait olduğunu belirtiyoruz.
         */
        dto.getTurids().forEach(turid->{
            turKitapService.save(turid,kitap.getId());
        });

      return kitap;
    }
}
