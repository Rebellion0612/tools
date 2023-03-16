package com.fly.tools.map;

import java.util.List;

/**
 *
 */
public interface VoDtoBaseConvertor<VO, DTO> {

    /**
     * vo对象转dto对象
     *
     * @param vo
     * @return
     */
    DTO voToDto(VO vo);

    /**
     * vo对象转dto对象list
     *
     * @param voList
     * @return
     */
    List<DTO> voToDtoList(List<VO> voList);

    /**
     * dto对象转vo对象
     *
     * @param dto
     * @return
     */
    VO dtoToVo(DTO dto);

    /**
     * dto对象转vo对象list
     *
     * @param dtoList
     * @return
     */
    List<VO> dtoToVoList(List<DTO> dtoList);
}

