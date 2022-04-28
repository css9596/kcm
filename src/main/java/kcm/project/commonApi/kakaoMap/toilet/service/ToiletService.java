package kcm.project.commonApi.kakaoMap.toilet.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Service
public class ToiletService {

    @Value("${commonApiKey.toilet.encode}")
    private String encKey;

    @Value("${commonApiKey.toilet.decode}")
    private String decKey;

    public StringBuffer getToiletData(){

        StringBuffer result = new StringBuffer();

        try {
            String apiUrl = "http://api.data.go.kr/openapi/tn_pubr_public_toilet_api?" +
                    "serviceKey="+ encKey +
                    "&type=json" +
                    "&pageNo=1" +
                    "&numOfRows=10"
                    ;

            System.out.println("apiURL :::: >>>" + apiUrl);

            URL url = new URL(apiUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("Content-type", "application/json");

            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), StandardCharsets.UTF_8));

            String returnLine;

            if(urlConnection.getResponseCode() >= 200 && urlConnection.getResponseCode() <= 300) {
                br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            } else {
                br = new BufferedReader(new InputStreamReader(urlConnection.getErrorStream()));
            }

            while ((returnLine = br.readLine()) != null){
                result.append(returnLine).append("\n");
            }

            br.close();
            urlConnection.disconnect();
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;

    }


}
