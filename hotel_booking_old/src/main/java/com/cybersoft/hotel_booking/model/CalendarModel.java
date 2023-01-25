package com.cybersoft.hotel_booking.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class CalendarModel {
    private Date dt;

    private Integer y;

    private Integer q;

    private Integer m;

    private Integer d;

    private Integer dw;

    private Integer w;

    private String monthName;

    private String dayName;

    private Boolean isWeekday;

    private Boolean isHoliday;

    private String holidayDescr;

    private Boolean isPayday;
}
