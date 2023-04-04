package com.muhammet.service;

import com.muhammet.dto.request.SaveKitapRequestDto;
import com.muhammet.dto.response.FindByYazarAdiResponseDto;
import com.muhammet.mapper.IKitapMapper;
import com.muhammet.repository.IKitapRepository;
import com.muhammet.repository.entity.Kitap;
import com.muhammet.repository.entity.Yazar;
import com.muhammet.repository.entity.YazarKitap;
import com.muhammet.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KitapService extends ServiceManager<Kitap,Long> {
    private final IKitapRepository repository;
    private final YazarService yazarService;
    private final YazarKitapService yazarKitapService;
    private final TurKitapService turKitapService;
    public KitapService(IKitapRepository repository,
                        YazarKitapService yazarKitapService,
                        TurKitapService turKitapService,
                        YazarService yazarService){
        super(repository);
        this.repository=repository;
        this.yazarKitapService = yazarKitapService;
        this.turKitapService = turKitapService;
        this.yazarService = yazarService;
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

    public List<FindByYazarAdiResponseDto> findByYazarAdi(String yazarAdi){
        List<FindByYazarAdiResponseDto> result = new ArrayList<>();
        /**
         * 1. Yazar adından arama yaparak eşleşen kayıtları listeliyoruz.
         */
         List<Yazar> yazarList = yazarService.findAllByAdContaining(yazarAdi);
         yazarList.forEach(yazar->{
             /**
              * 2. Yazarların kitaplarını bulmak için Yazar-Kitap tablosunda
              * arama yapacağız. Yazar id sinden yazarkitap listesini çekiyoruz.
              * bunun içinden kitaplara ait id listeli geliyor.
              */
             List<Long> kitapids = yazarKitapService.getAllByYazarid(yazar.getId());
             /**
              * 3. Kitap idleri verilen liste kullanılarak kitap tablosundaki ilgili tüm kayıtlar listelenir.
              * burada işlem yapılan kod. Select * from kitap where id in(1,3,56,7); // şeklindedir.
              */
             List<Kitap> kitapList = repository.findAllById(kitapids);
             /**
              * 4. yazar ve kitaplarının bilgileri DTO içine girilerek bir liste haline getirilmelidir.
              */
             FindByYazarAdiResponseDto dto = FindByYazarAdiResponseDto.builder()
                     .yazarAdi(yazar.getAd())
                     .kitapList(kitapList)
                     .build();
             result.add(dto);
         });
        return result;
    }
}
