package com.spring.mvc;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class HttpRequestTest {

    @Test
    public void requestTest() throws Exception{
        // 요청보낼 URL 지정
        URL url = new URL("https://redtea.kr/");
        // 지정된 URL로 요청하기
        URLConnection con = url.openConnection();

        // 들어온 결과물을 한 줄 한 줄 콘솔에 출력
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream())))
        {
            String line;
            while((line = in.readLine()) != null){
                System.out.println(line);
            }
        }


    }

}
