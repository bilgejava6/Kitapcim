package com.muhammet.mapper;

import com.muhammet.dto.request.SaveYayineviRequestDto;
import com.muhammet.repository.entity.Yayinevi;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface IYayineviMapper {
    IYayineviMapper INSTANCE = Mappers.getMapper(IYayineviMapper.class);

    Yayinevi toYayinevi(final SaveYayineviRequestDto dto);

}
