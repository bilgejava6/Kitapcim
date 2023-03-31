package com.muhammet.service;

import com.muhammet.repository.IYazarKitapRepository;
import com.muhammet.repository.entity.YazarKitap;
import com.muhammet.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class YazarKitapService  extends ServiceManager<YazarKitap,Long> {
    private final IYazarKitapRepository repository;
    public YazarKitapService(IYazarKitapRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public void save(Long yazarId,Long kitapId){
        save(YazarKitap.builder()
                .yazarid(yazarId)
                .kitapid(kitapId)
                .build());
    }
}
