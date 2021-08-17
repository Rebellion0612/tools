package com.fly.tools.util;

import org.assertj.core.util.Lists;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author：zhangpengfei
 * @since：2021/8/17
 */
public class ListUtil {

    /**
     * 拆分集合
     *
     * @param list
     * @param num  拆分小集合数量
     * @param <T>
     * @return
     */
    public static <T> List<List<T>> splitList(List<T> list, Integer num) {
        if (CollectionUtils.isEmpty(list)) {
            return Lists.newArrayList();
        }
        int size = list.size() % num == 0 ? list.size() / num : list.size() / num + 1;
        List<List<T>> result = Lists.newArrayList();
        Stream.iterate(0, s -> s + 1)
                .limit(size)
                .forEach(s -> {
                    int end = (s + 1) * num;
                    result.add(list.subList(s * num, Math.min(end, list.size())));
                });

        return result;
    }
}
