package com.muhammet.mapper;

import com.muhammet.dto.request.SaveKitapRequestDto;
import com.muhammet.repository.entity.Kitap;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface IKitapMapper {
    IKitapMapper INSTANCE = Mappers.getMapper(IKitapMapper.class);

    Kitap toKitap(final SaveKitapRequestDto dto);
}
