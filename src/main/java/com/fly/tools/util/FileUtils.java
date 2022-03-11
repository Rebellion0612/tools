package com.fly.tools.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;

public class FileUtils {


    /**
     * 根据网络路径 建立连接 下载图片
     * @param imgUrl 路径
     * @return 字节数组
     * @throws IOException  IO异常
     */
    public static byte[] downloadFile(String imgUrl) throws IOException {
        URL url = null;
        InputStream inputStream = null;
        ByteArrayOutputStream outputStream = null;
        HttpURLConnection httpUrl = null;
        try {
            url = new URL(imgUrl);
            httpUrl = (HttpURLConnection) url.openConnection();
            httpUrl.connect();
            inputStream = httpUrl.getInputStream();
            outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
            }
            return outputStream.toByteArray();
        } catch (Exception e) {
            throw e;
        } finally {
            if (Objects.nonNull(inputStream)) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (Objects.nonNull(outputStream)) {
                try {
                    outputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (Objects.nonNull(httpUrl)) {
                httpUrl.disconnect();
            }
        }

    }
}