package com.fly.tools.map;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author：zhangpengfei
 * @since：2023/3/16
 */
@Mapper
public interface MapConvert extends VoDtoBaseConvertor<MapVo, MapDto>{
    MapConvert INSTANCE = Mappers.getMapper(MapConvert.class);
}
