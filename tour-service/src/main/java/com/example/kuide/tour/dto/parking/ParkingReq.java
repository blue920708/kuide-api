package com.example.kuide.tour.dto.parking;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class ParkingReq extends ParkingCommonReq {

    private String prkplceNo;
    private String prkplceNm;
    private String prkplceSe;
    private String prkplceType;
    private String rdnmadr;
    private String lnmadr;
    private String prkcmprt;
    private String feedingSe;
    private String enforceSe;
    private String operDay;
    private String weekdayOperOpenHhmm;
    private String weekdayOperColseHhmm;
    private String satOperOperOpenHhmm;
    private String satOperCloseHhmm;
    private String holidayOperOpenHhmm;
    private String holidayCloseOpenHhmm;
    private String parkingchrgeInfo;
    private String basicTime;
    private String basicCharge;
    private String addUnitTime;
    private String addUnitCharge;
    private String dayCmmtktAdjTime;
    private String dayCmmtkt;
    private String monthCmmtkt;
    private String metpay;
    private String spcmnt;
    private String institutionNm;
    private String phoneNumber;
    private String latitude;
    private String longitude;
    private String pwdbsPpkZoneYn;
    private String referenceDate;
    private String instt_code;
    private String instt_nm;
    
}
