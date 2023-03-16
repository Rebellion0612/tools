package com.fly.tools.map;

import lombok.*;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * @author：zhangpengfei
 * @since：2023/3/16
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MapVo {

    private BigDecimal next;

    private Integer addFriendRate;

    private Integer age;
}
