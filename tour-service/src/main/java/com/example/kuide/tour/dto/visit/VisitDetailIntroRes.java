package com.example.kuide.tour.dto.visit;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class VisitDetailIntroRes {
	@Schema(description = "콘텐츠 ID")
    private String contentid;

    @Schema(description = "관광타입 ID (12: 관광지, 14: 문화시설, 15: 축제/공연/행사, 25: 여행코스, 28: 레포츠, 32: 숙박, 38: 쇼핑, 39: 음식점)")
    private String contenttypeid;

    // 관광지 (12)
    @Schema(description = "수용인원")
    private String accomcount;

    @Schema(description = "유모차대여정보")
    private String chkbabycarriage;

    @Schema(description = "신용카드가능정보")
    private String chkcreditcard;

    @Schema(description = "애완동물동반가능정보")
    private String chkpet;

    @Schema(description = "체험가능연령")
    private String expagerange;

    @Schema(description = "체험안내")
    private String expguide;

    @Schema(description = "세계문화유산유무")
    private String heritage1;

    @Schema(description = "세계자연유산유무")
    private String heritage2;

    @Schema(description = "세계기록유산유무")
    private String heritage3;

    @Schema(description = "문의및안내")
    private String infocenter;

    @Schema(description = "개장일")
    private String opendate;

    @Schema(description = "주차시설")
    private String parking;

    @Schema(description = "쉬는날")
    private String restdate;

    @Schema(description = "이용시기")
    private String useseason;

    @Schema(description = "이용시간")
    private String usetime;


    // 문화시설 (14)
    @Schema(description = "수용인원")
    private String accomcountculture;

    @Schema(description = "유모차대여정보")
    private String chkbabycarriageculture;

    @Schema(description = "신용카드가능정보")
    private String chkcreditcardculture;

    @Schema(description = "애완동물동반가능정보")
    private String chkpetculture;

    @Schema(description = "할인정보")
    private String discountinfo;

    @Schema(description = "문의및안내")
    private String infocenterculture;

    @Schema(description = "주차시설")
    private String parkingculture;

    @Schema(description = "주차요금")
    private String parkingfee;

    @Schema(description = "쉬는날")
    private String restdateculture;

    @Schema(description = "이용요금")
    private String usefee;

    @Schema(description = "이용시간")
    private String usetimeculture;

    @Schema(description = "규모")
    private String scale;

    @Schema(description = "관람소요시간")
    private String spendtime;


    // 축제/공연/행사 (15)
    @Schema(description = "관람가능연령")
    private String agelimit;

    @Schema(description = "예매처")
    private String bookingplace;

    @Schema(description = "할인정보")
    private String discountinfofestival;

    @Schema(description = "행사종료일")
    private String eventenddate;

    @Schema(description = "행사홈페이지")
    private String eventhomepage;

    @Schema(description = "행사장소")
    private String eventplace;

    @Schema(description = "행사시작일")
    private String eventstartdate;

    @Schema(description = "축제등급")
    private String festivalgrade;

    @Schema(description = "행사장위치안내")
    private String placeinfo;

    @Schema(description = "공연시간")
    private String playtime;

    @Schema(description = "행사프로그램")
    private String program;

    @Schema(description = "관람소요시간")
    private String spendtimefestival;

    @Schema(description = "주최자정보")
    private String sponsor1;

    @Schema(description = "주최자연락처")
    private String sponsor1tel;

    @Schema(description = "주관사정보")
    private String sponsor2;

    @Schema(description = "주관사연락처")
    private String sponsor2tel;

    @Schema(description = "부대행사")
    private String subevent;

    @Schema(description = "이용요금")
    private String usetimefestival;


    // 여행코스 (25)
    @Schema(description = "코스총거리")
    private String distance;

    @Schema(description = "문의및안내")
    private String infocentertourcourse;

    @Schema(description = "코스일정")
    private String schedule;

    @Schema(description = "코스총소요시간")
    private String taketime;

    @Schema(description = "코스테마")
    private String theme;


    // 레포츠 (28)
    @Schema(description = "수용인원")
    private String accomcountleports;

    @Schema(description = "유모차대여정보")
    private String chkbabycarriageleports;

    @Schema(description = "신용카드가능정보")
    private String chkcreditcardleports;

    @Schema(description = "애완동물동반가능정보")
    private String chkpetleports;

    @Schema(description = "체험가능연령")
    private String expagerangeleports;

    @Schema(description = "문의및안내")
    private String infocenterleports;

    @Schema(description = "개장기간")
    private String openperiod;

    @Schema(description = "주차요금")
    private String parkingfeeleports;

    @Schema(description = "주차시설")
    private String parkingleports;

    @Schema(description = "예약안내")
    private String reservation;

    @Schema(description = "쉬는날")
    private String restdateleports;

    @Schema(description = "규모")
    private String scaleleports;

    @Schema(description = "입장료")
    private String usefeeleports;

    @Schema(description = "이용시간")
    private String usetimeleports;


    // 숙박 (32)
    @Schema(description = "수용가능인원")
    private String accomcountlodging;

    @Schema(description = "입실시간")
    private String checkintime;

    @Schema(description = "퇴실시간")
    private String checkouttime;

    @Schema(description = "객실내취사여부")
    private String chkcooking;

    @Schema(description = "식음료장")
    private String foodplace;

    @Schema(description = "문의및안내")
    private String infocenterlodging;

    @Schema(description = "주차시설")
    private String parkinglodging;

    @Schema(description = "픽업서비스")
    private String pickup;

    @Schema(description = "객실수")
    private String roomcount;

    @Schema(description = "예약안내")
    private String reservationlodging;

    @Schema(description = "예약안내홈페이지")
    private String reservationurl;

    @Schema(description = "객실유형")
    private String roomtype;

    @Schema(description = "규모")
    private String scalelodging;

    @Schema(description = "부대시설 (기타)")
    private String subfacility;

    @Schema(description = "바비큐장여부")
    private String barbecue;

    @Schema(description = "뷰티시설정보")
    private String beauty;

    @Schema(description = "식음료장여부")
    private String beverage;

    @Schema(description = "자전거대여여부")
    private String bicycle;

    @Schema(description = "캠프파이어여부")
    private String campfire;

    @Schema(description = "휘트니스센터여부")
    private String fitness;

    @Schema(description = "노래방여부")
    private String karaoke;

    @Schema(description = "공용샤워실여부")
    private String publicbath;

    @Schema(description = "공용 PC실여부")
    private String publicpc;

    @Schema(description = "사우나실여부")
    private String sauna;

    @Schema(description = "세미나실여부")
    private String seminar;

    @Schema(description = "스포츠시설여부")
    private String sports;

    @Schema(description = "환불규정")
    private String refundregulation;


    // 쇼핑 (38)
    @Schema(description = "유모차대여정보")
    private String chkbabycarriageshopping;

    @Schema(description = "신용카드가능정보")
    private String chkcreditcardshopping;

    @Schema(description = "애완동물동반가능정보")
    private String chkpetshopping;

    @Schema(description = "문화센터바로가기")
    private String culturecenter;

    @Schema(description = "장서는날")
    private String fairday;

    @Schema(description = "문의및안내")
    private String infocentershopping;

    @Schema(description = "개장일")
    private String opendateshopping;

    @Schema(description = "영업시간")
    private String opentime;

    @Schema(description = "주차시설")
    private String parkingshopping;

    @Schema(description = "쉬는날")
    private String restdateshopping;

    @Schema(description = "화장실설명")
    private String restroom;

    @Schema(description = "판매품목")
    private String saleitem;

    @Schema(description = "판매품목별가격")
    private String saleitemcost;

    @Schema(description = "규모")
    private String scaleshopping;

    @Schema(description = "매장안내")
    private String shopguide;


    // 음식점 (39)
    @Schema(description = "신용카드가능정보")
    private String chkcreditcardfood;

    @Schema(description = "할인정보")
    private String discountinfofood;

    @Schema(description = "대표메뉴")
    private String firstmenu;

    @Schema(description = "문의및안내")
    private String infocenterfood;

    @Schema(description = "어린이놀이방여부")
    private String kidsfacility;

    @Schema(description = "개업일")
    private String opendatefood;

    @Schema(description = "영업시간")
    private String opentimefood;

    @Schema(description = "포장가능")
    private String packing;

    @Schema(description = "주차시설")
    private String parkingfood;

    @Schema(description = "예약안내")
    private String reservationfood;

    @Schema(description = "쉬는날")
    private String restdatefood;

    @Schema(description = "규모")
    private String scalefood;

    @Schema(description = "좌석수")
    private String seat;

    @Schema(description = "금연/흡연여부")
    private String smoking;

    @Schema(description = "취급메뉴")
    private String treatmenu;

    @Schema(description = "인허가번호")
    private String lcnsno;
}
