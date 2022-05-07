package kcm.project.commonApi.kakaoMap.toilet.controller;

import kcm.project.commonApi.kakaoMap.toilet.service.ToiletService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


/**
 * @author choisungsik
 * @version
 * v1.0 2022.04.23 choisungsik 최초작성
 */
@Slf4j
@Controller
@RequestMapping(value = "/toilet")
public class ToiletController {

    @Resource(name = "toiletService")
    private ToiletService toiletService;

    @Value("${common.config.isReal}")
    private boolean isReal;

    @Value("${kakao.api.map.key}")
    private String kakakoMapKey;

    @Autowired
    HttpSession session;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String ToiletCallMain(Model model){

        /*
        * 기능 구현 List
        * 1. 현재 위치 정보 조회
        * 2. 위치 기반으로 주변 화장실 Location 조회
        * 3. Return
        * */

        System.out.println("toiletMain 인입");
        System.out.println("세션정보 가져오기 ::" + session.getAttribute("userUUid"));

        //변수 초기화
        StringBuffer stringBuffer = new StringBuffer();

        if(isReal)/* 1일 트래픽 최대 발생수 1000번으로 테스트 데이터로 대체. */{
            stringBuffer = toiletService.getToiletData();
        }else {
            stringBuffer
                    .append(
                        "{\"response\":{\"header\":{\"resultCode\":\"00\",\"resultMsg\":\"NORMAL_SERVICE\",\"type\":\"json\"},\"body\":{\"items\":[{\"toiletType\":\"공중화장실\",\"toiletNm\":\"두산3리 약수터입구\",\"rdnmadr\":\"경상북도 영주시 봉현면 테라피로 636\",\"lnmadr\":\"경상북도 영주시 봉현면 오현리 786\",\"unisexToiletYn\":\"Y\",\"menToiletBowlNumber\":\"1\",\"menUrineNumber\":\"1\",\"menHandicapToiletBowlNumber\":\"0\",\"menHandicapUrinalNumber\":\"0\",\"menChildrenToiletBowlNumber\":\"0\",\"menChildrenUrinalNumber\":\"0\",\"ladiesToiletBowlNumber\":\"1\",\"ladiesHandicapToiletBowlNumber\":\"0\",\"ladiesChildrenToiletBowlNumber\":\"0\",\"institutionNm\":\"경상북도 영주시청\",\"phoneNumber\":\"054-639-7609\",\"openTime\":\"연중무휴\",\"installationYear\":\"2007\",\"latitude\":\"36.8711506\",\"longitude\":\"128.5134172\",\"toiletPossType\":\"null\",\"toiletPosiType\":\"null\",\"careSewerageType\":\"null\",\"emgBellYn\":\"null\",\"enterentCctvYn\":\"null\",\"dipersExchgPosi\":\"null\",\"modYear\":\"null\",\"referenceDate\":\"2019-09-20\",\"insttCode\":\"5090000\"},{\"toiletType\":\"공중화장실\",\"toiletNm\":\"노좌3리 쌍마계곡\",\"rdnmadr\":\"\",\"lnmadr\":\"경상북도 영주시 봉현면 노좌리 산 16-1\",\"unisexToiletYn\":\"N\",\"menToiletBowlNumber\":\"1\",\"menUrineNumber\":\"0\",\"menHandicapToiletBowlNumber\":\"0\",\"menHandicapUrinalNumber\":\"0\",\"menChildrenToiletBowlNumber\":\"0\",\"menChildrenUrinalNumber\":\"0\",\"ladiesToiletBowlNumber\":\"0\",\"ladiesHandicapToiletBowlNumber\":\"0\",\"ladiesChildrenToiletBowlNumber\":\"0\",\"institutionNm\":\"경상북도 영주시청\",\"phoneNumber\":\"054-639-7609\",\"openTime\":\"연중무휴\",\"installationYear\":\"2003\",\"latitude\":\"36.8078681\",\"longitude\":\"128.4833862\",\"toiletPossType\":\"null\",\"toiletPosiType\":\"null\",\"careSewerageType\":\"null\",\"emgBellYn\":\"null\",\"enterentCctvYn\":\"null\",\"dipersExchgPosi\":\"null\",\"modYear\":\"null\",\"referenceDate\":\"2019-09-20\",\"insttCode\":\"5090000\"},{\"toiletType\":\"공중화장실\",\"toiletNm\":\"노좌1리 노좌쉼터\",\"rdnmadr\":\"경상북도 영주시 봉현면 소백로 933\",\"lnmadr\":\"경상북도 영주시 봉현면 노좌리 180-2\",\"unisexToiletYn\":\"N\",\"menToiletBowlNumber\":\"1\",\"menUrineNumber\":\"0\",\"menHandicapToiletBowlNumber\":\"0\",\"menHandicapUrinalNumber\":\"0\",\"menChildrenToiletBowlNumber\":\"0\",\"menChildrenUrinalNumber\":\"0\",\"ladiesToiletBowlNumber\":\"0\",\"ladiesHandicapToiletBowlNumber\":\"0\",\"ladiesChildrenToiletBowlNumber\":\"0\",\"institutionNm\":\"경상북도 영주시청\",\"phoneNumber\":\"054-639-7609\",\"openTime\":\"연중무휴\",\"installationYear\":\"2007\",\"latitude\":\"36.7911957\",\"longitude\":\"128.5002098\",\"toiletPossType\":\"null\",\"toiletPosiType\":\"null\",\"careSewerageType\":\"null\",\"emgBellYn\":\"null\",\"enterentCctvYn\":\"null\",\"dipersExchgPosi\":\"null\",\"modYear\":\"null\",\"referenceDate\":\"2019-09-20\",\"insttCode\":\"5090000\"},{\"toiletType\":\"공중화장실\",\"toiletNm\":\"대촌1리 백분교 옆\",\"rdnmadr\":\"\",\"lnmadr\":\"경상북도 영주시 봉현면 대촌리 880-3\",\"unisexToiletYn\":\"Y\",\"menToiletBowlNumber\":\"1\",\"menUrineNumber\":\"0\",\"menHandicapToiletBowlNumber\":\"0\",\"menHandicapUrinalNumber\":\"0\",\"menChildrenToiletBowlNumber\":\"0\",\"menChildrenUrinalNumber\":\"0\",\"ladiesToiletBowlNumber\":\"1\",\"ladiesHandicapToiletBowlNumber\":\"0\",\"ladiesChildrenToiletBowlNumber\":\"0\",\"institutionNm\":\"경상북도 영주시청\",\"phoneNumber\":\"054-639-7609\",\"openTime\":\"연중무휴\",\"installationYear\":\"2004\",\"latitude\":\"36.84560162\",\"longitude\":\"128.5271588\",\"toiletPossType\":\"null\",\"toiletPosiType\":\"null\",\"careSewerageType\":\"null\",\"emgBellYn\":\"null\",\"enterentCctvYn\":\"null\",\"dipersExchgPosi\":\"null\",\"modYear\":\"null\",\"referenceDate\":\"2019-09-20\",\"insttCode\":\"5090000\"},{\"toiletType\":\"공중화장실\",\"toiletNm\":\"순흥면보건지소\",\"rdnmadr\":\"경상북도 영주시 순흥면 순흥로 67\",\"lnmadr\":\"경상북도 영주시 순흥면 읍내리 312\",\"unisexToiletYn\":\"N\",\"menToiletBowlNumber\":\"1\",\"menUrineNumber\":\"1\",\"menHandicapToiletBowlNumber\":\"0\",\"menHandicapUrinalNumber\":\"1\",\"menChildrenToiletBowlNumber\":\"0\",\"menChildrenUrinalNumber\":\"0\",\"ladiesToiletBowlNumber\":\"1\",\"ladiesHandicapToiletBowlNumber\":\"1\",\"ladiesChildrenToiletBowlNumber\":\"0\",\"institutionNm\":\"경상북도 영주시청\",\"phoneNumber\":\"054-633-2044\",\"openTime\":\"연중무휴\",\"installationYear\":\"2013\",\"latitude\":\"36.916047\",\"longitude\":\"128.5749200256\",\"toiletPossType\":\"null\",\"toiletPosiType\":\"null\",\"careSewerageType\":\"null\",\"emgBellYn\":\"null\",\"enterentCctvYn\":\"null\",\"dipersExchgPosi\":\"null\",\"modYear\":\"null\",\"referenceDate\":\"2019-09-20\",\"insttCode\":\"5090000\"},{\"toiletType\":\"공중화장실\",\"toiletNm\":\"순흥면사무소1(본관)\",\"rdnmadr\":\"경상북도 영주시 순흥면 순흥로 67\",\"lnmadr\":\"경상북도 영주시 순흥면 읍내리 314-3\",\"unisexToiletYn\":\"N\",\"menToiletBowlNumber\":\"2\",\"menUrineNumber\":\"3\",\"menHandicapToiletBowlNumber\":\"1\",\"menHandicapUrinalNumber\":\"0\",\"menChildrenToiletBowlNumber\":\"0\",\"menChildrenUrinalNumber\":\"0\",\"ladiesToiletBowlNumber\":\"1\",\"ladiesHandicapToiletBowlNumber\":\"0\",\"ladiesChildrenToiletBowlNumber\":\"0\",\"institutionNm\":\"경상북도 영주시청\",\"phoneNumber\":\"054-633-3003\",\"openTime\":\"연중무휴\",\"installationYear\":\"2091\",\"latitude\":\"36.91605016\",\"longitude\":\"128.5749274\",\"toiletPossType\":\"null\",\"toiletPosiType\":\"null\",\"careSewerageType\":\"null\",\"emgBellYn\":\"null\",\"enterentCctvYn\":\"null\",\"dipersExchgPosi\":\"null\",\"modYear\":\"null\",\"referenceDate\":\"2019-09-20\",\"insttCode\":\"5090000\"},{\"toiletType\":\"공중화장실\",\"toiletNm\":\"순흥면사무소2(주민자치센터)\",\"rdnmadr\":\"경상북도 영주시 순흥면 순흥로 67\",\"lnmadr\":\"경상북도 영주시 순흥면 읍내리 314-3\",\"unisexToiletYn\":\"N\",\"menToiletBowlNumber\":\"1\",\"menUrineNumber\":\"0\",\"menHandicapToiletBowlNumber\":\"0\",\"menHandicapUrinalNumber\":\"0\",\"menChildrenToiletBowlNumber\":\"0\",\"menChildrenUrinalNumber\":\"0\",\"ladiesToiletBowlNumber\":\"0\",\"ladiesHandicapToiletBowlNumber\":\"0\",\"ladiesChildrenToiletBowlNumber\":\"0\",\"institutionNm\":\"경상북도 영주시청\",\"phoneNumber\":\"054-633-3003\",\"openTime\":\"연중무휴\",\"installationYear\":\"2011\",\"latitude\":\"36.91605016\",\"longitude\":\"128.5749274\",\"toiletPossType\":\"null\",\"toiletPosiType\":\"null\",\"careSewerageType\":\"null\",\"emgBellYn\":\"null\",\"enterentCctvYn\":\"null\",\"dipersExchgPosi\":\"null\",\"modYear\":\"null\",\"referenceDate\":\"2019-09-20\",\"insttCode\":\"5090000\"},{\"toiletType\":\"공중화장실\",\"toiletNm\":\"순흥우체국\",\"rdnmadr\":\"경상북도 영주시 순흥면 순흥로55번길 8\",\"lnmadr\":\"경상북도 영주시 순흥면 읍내리 319\",\"unisexToiletYn\":\"N\",\"menToiletBowlNumber\":\"0\",\"menUrineNumber\":\"0\",\"menHandicapToiletBowlNumber\":\"0\",\"menHandicapUrinalNumber\":\"1\",\"menChildrenToiletBowlNumber\":\"0\",\"menChildrenUrinalNumber\":\"0\",\"ladiesToiletBowlNumber\":\"0\",\"ladiesHandicapToiletBowlNumber\":\"1\",\"ladiesChildrenToiletBowlNumber\":\"0\",\"institutionNm\":\"순흥우체국\",\"phoneNumber\":\"054-633-2001\",\"openTime\":\"연중무휴\",\"installationYear\":\"2087\",\"latitude\":\"36.91450933\",\"longitude\":\"128.5753592\",\"toiletPossType\":\"null\",\"toiletPosiType\":\"null\",\"careSewerageType\":\"null\",\"emgBellYn\":\"null\",\"enterentCctvYn\":\"null\",\"dipersExchgPosi\":\"null\",\"modYear\":\"null\",\"referenceDate\":\"2019-09-20\",\"insttCode\":\"5090000\"},{\"toiletType\":\"공중화장실\",\"toiletNm\":\"순흥치안센터\",\"rdnmadr\":\"경상북도 영주시 순흥면 순흥로 63\",\"lnmadr\":\"경상북도 영주시 순흥면 읍내리 314-2\",\"unisexToiletYn\":\"N\",\"menToiletBowlNumber\":\"1\",\"menUrineNumber\":\"1\",\"menHandicapToiletBowlNumber\":\"0\",\"menHandicapUrinalNumber\":\"0\",\"menChildrenToiletBowlNumber\":\"0\",\"menChildrenUrinalNumber\":\"0\",\"ladiesToiletBowlNumber\":\"0\",\"ladiesHandicapToiletBowlNumber\":\"0\",\"ladiesChildrenToiletBowlNumber\":\"0\",\"institutionNm\":\"경상북도 영주경찰서\",\"phoneNumber\":\"054-633-2112\",\"openTime\":\"연중무휴\",\"installationYear\":\"2096\",\"latitude\":\"36.9152784\",\"longitude\":\"128.5754788\",\"toiletPossType\":\"null\",\"toiletPosiType\":\"null\",\"careSewerageType\":\"null\",\"emgBellYn\":\"null\",\"enterentCctvYn\":\"null\",\"dipersExchgPosi\":\"null\",\"modYear\":\"null\",\"referenceDate\":\"2019-09-20\",\"insttCode\":\"5090000\"},{\"toiletType\":\"공중화장실\",\"toiletNm\":\"소수박물관\",\"rdnmadr\":\"경상북도 영주시 순흥면 소백로 2740\",\"lnmadr\":\"경상북도 영주시 순흥면 내죽리 160-1\",\"unisexToiletYn\":\"N\",\"menToiletBowlNumber\":\"6\",\"menUrineNumber\":\"6\",\"menHandicapToiletBowlNumber\":\"1\",\"menHandicapUrinalNumber\":\"1\",\"menChildrenToiletBowlNumber\":\"0\",\"menChildrenUrinalNumber\":\"0\",\"ladiesToiletBowlNumber\":\"4\",\"ladiesHandicapToiletBowlNumber\":\"1\",\"ladiesChildrenToiletBowlNumber\":\"0\",\"institutionNm\":\"경상북도 영주시청\",\"phoneNumber\":\"054-639-7960\",\"openTime\":\"연중무휴\",\"installationYear\":\"\",\"latitude\":\"36.92525013\",\"longitude\":\"128.5790685\",\"toiletPossType\":\"null\",\"toiletPosiType\":\"null\",\"careSewerageType\":\"null\",\"emgBellYn\":\"null\",\"enterentCctvYn\":\"null\",\"dipersExchgPosi\":\"null\",\"modYear\":\"null\",\"referenceDate\":\"2019-09-20\",\"insttCode\":\"5090000\"}],\"totalCount\": \"34932\",\"numOfRows\": \"10\",\"pageNo\": \"1\"}}}\n"
                    );
        }

        model.addAttribute("kakaoMapKey", kakakoMapKey);
        model.addAttribute("result", stringBuffer);

        return "toilet/main";
    }

}
