package com.fly.tools.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author：zhangpengfei
 * @since：2021/8/17
 */
public class JSONFileUtil {

    /**
     * 读取json文件
     *
     * @param path
     * @return
     */
    public static List<JSONObject> parseJson(String path, String key) {
        try {
            File file = new File(path);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            JSONArray jsonArray = JSONArray.parseArray(JSONObject.parseObject(String.valueOf(stringBuilder)).getString(key));
            List<JSONObject> result = new ArrayList<>();
            for (int i = 0; i < jsonArray.size(); i++) {
                result.add(jsonArray.getJSONObject(i));
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static <T> List<T> parseJson(String path, String listKey, Class<T> clazz, String key) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            JSONArray jsonArray = JSONArray.parseArray(JSONObject.parseObject(String.valueOf(stringBuilder)).getString(listKey));
            List result = new ArrayList<>();
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if (clazz == Long.class) {
                    result.add(jsonObject.getLong(key));
                } else if (clazz == Integer.class) {
                    result.add(jsonObject.getInteger(key));
                } else {
                    result.add(jsonObject.getString(key));
                }
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
