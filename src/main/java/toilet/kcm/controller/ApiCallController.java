package toilet.kcm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ApiCallController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String ApiCallTest(Model model) throws UnsupportedEncodingException {
        //1. Map 형태로 데이터 전송 하기.
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("aa", "123");
        model.addAllAttributes(dataMap);
        //2. 데이터 전송하기.
        model.addAttribute("hello","Thymeleaf Call Test.");

        //API Connection Setting
        /* * * * * * * * * *
        * API 환경 또는 API 호출 조건에 따라 인증키가 적용되는 방식이 다를 수 있습니다.
        * 포털에서 제공되는 Encoding/Decoding 된 인증키를 적용하면서 구동되는 키를 사용하시기 바랍니다.
        * 향후 포털에서 더 명확한 정보를 제공하기 위해 노력하겠습니다.
        * * * * * * * * * * */
        /* Data Information
        * 1. KEY
        * ENCODING : Bbz7LkVXSe738w8odDA8b%2BXdz6NlskGH%2BakED8G4xonkDxXzjbQn%2B6kUWWiFNE8roPiAHxn48KqUqnXE61mnXQ%3D%3D
        * DECODING : Bbz7LkVXSe738w8odDA8b+Xdz6NlskGH+akED8G4xonkDxXzjbQn+6kUWWiFNE8roPiAHxn48KqUqnXE61mnXQ==
        * 2. Call Url
        * http://api.data.go.kr/openapi/tn_pubr_public_toilet_api
        *
        * */

        //TODO : properties 셋팅을 통해 API Key 형태 체크
        String[][] keyType = {
                {"1", "E"},
                {"2", "D"}
        };

        //TODO: properties 파일에서 key data 가져오기로 변경하기.
        String key = "";
        String testKey = "";
        if(keyType[0][1].equals("PROPERTIES_KEY_TYPE")){
            key = "Bbz7LkVXSe738w8odDA8b%2BXdz6NlskGH%2BakED8G4xonkDxXzjbQn%2B6kUWWiFNE8roPiAHxn48KqUqnXE61mnXQ%3D%3D";
            key = URLDecoder.decode(key, "utf-8");
        }else{
            key = "Bbz7LkVXSe738w8odDA8b+Xdz6NlskGH+akED8G4xonkDxXzjbQn+6kUWWiFNE8roPiAHxn48KqUqnXE61mnXQ==";
        }

        //TEST KEY Setting
        testKey = "Bbz7LkVXSe738w8odDA8b%2BXdz6NlskGH%2BakED8G4xonkDxXzjbQn%2B6kUWWiFNE8roPiAHxn48KqUqnXE61mnXQ%3D%3D";
        //testKey = URLDecoder.decode(testKey, "utf-8");

        StringBuffer result = new StringBuffer();


        try {
            String apiUrl = "http://api.data.go.kr/openapi/tn_pubr_public_toilet_api?" +
                    "serviceKey="+ testKey +
                    "&type=json" +
                    "&pageNo=1" +
                    "&numOfRows=10"
                    ;

            System.out.println("apiURL :::: >>>" + apiUrl);

            URL url = new URL(apiUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("Content-type", "application/json");

            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));

            String returnLine;

            if(urlConnection.getResponseCode() >= 200 && urlConnection.getResponseCode() <= 300) {
                br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            } else {
                br = new BufferedReader(new InputStreamReader(urlConnection.getErrorStream()));
            }

            while ((returnLine = br.readLine()) != null){
                result.append(returnLine).append("\n");
            }

            model.addAttribute("result", result);

            br.close();
            urlConnection.disconnect();
        }catch (Exception e){
            e.printStackTrace();
        }


        return "/index";
    }

}
