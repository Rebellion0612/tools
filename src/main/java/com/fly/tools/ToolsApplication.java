package com.fly.tools;

import com.fly.tools.map.MapConvert;
import com.fly.tools.map.MapDto;
import com.fly.tools.map.MapVo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class ToolsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToolsApplication.class, args);
        MapVo vo = new MapVo();
        vo.setAge(11);
        vo.setAddFriendRate(13);
        vo.setNext(new BigDecimal(12.4));
        MapDto mapDto = MapConvert.INSTANCE.voToDto(vo);
        System.out.println(mapDto);
    }

}
