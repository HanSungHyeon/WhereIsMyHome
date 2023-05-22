package com.whereismyhome.houseinfo.mapper;

import com.whereismyhome.houseinfo.dto.ChartDataDto;
import com.whereismyhome.houseinfo.dto.HouseInfoResponseDto;
import com.whereismyhome.houseinfo.dto.HouseResponseDto;
import com.whereismyhome.houseinfo.entity.HouseInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HouseInfoMapper {
    @Mapping(source = "dongCode.sidoName", target = "sidoName")
    @Mapping(source = "dongCode.gugunName", target = "gugunName")
    @Mapping(source = "dongCode.dongName", target = "dongName")
    HouseInfoResponseDto infoToInfoResponseDto(HouseInfo houseInfo);


    List<ChartDataDto> chartDataListToChartDataDtos(List<Object[]> chartDataList);

    default ChartDataDto objectToChartData(Object[] objects) {
        return ChartDataDto.builder()
                .gugunName(String.valueOf(objects[0]))
                .markCount((long) objects[1])
                .viewCount((long) objects[2])
                .dealAmount((long) objects[3]).build();
    }
}