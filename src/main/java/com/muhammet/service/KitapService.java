package com.muhammet.service;

import com.muhammet.dto.request.SaveKitapRequestDto;
import com.muhammet.mapper.IKitapMapper;
import com.muhammet.repository.IKitapRepository;
import com.muhammet.repository.entity.Kitap;
import com.muhammet.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class KitapService extends ServiceManager<Kitap,Long> {
    private final IKitapRepository repository;
    public KitapService(IKitapRepository repository){
        super(repository);
        this.repository=repository;
    }

    public Kitap save(SaveKitapRequestDto dto){
      return save(IKitapMapper.INSTANCE.toKitap(dto));
    }
}
