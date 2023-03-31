package com.muhammet.mapper;

import com.muhammet.dto.request.SaveYazarRequestDto;
import com.muhammet.repository.entity.Yazar;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IYazarMapper {
    IYazarMapper INSTANCE = Mappers.getMapper(IYazarMapper.class);

    Yazar toYazar(final SaveYazarRequestDto dto);
}
