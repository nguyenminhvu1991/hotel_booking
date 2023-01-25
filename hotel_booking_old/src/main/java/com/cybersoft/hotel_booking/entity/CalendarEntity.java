package com.cybersoft.hotel_booking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity(name = "calendar_table")
public class CalendarEntity {

    @Id
    @Column(name = "dt")
    @Temporal(TemporalType.DATE)
    private Date dt;

    @Column(name = "y")
    private Integer y;

    @Column(name = "q")
    private Integer q;

    @Column(name = "m")
    private Integer m;

    @Column(name = "d")
    private Integer d;

    @Column(name = "dw")
    private Integer dw;

    @Column(name = "w")
    private Integer w;

    @Column(name = "month_name")
    private String monthName;

    @Column(name = "day_name")
    private String dayName;

    @Column(name = "is_weekday")
    private Boolean isWeekday;

    @Column(name = "is_holiday")
    private Boolean isHoliday;

    @Column(name = "holiday_descr")
    private String holidayDescr;

    @Column(name = "is_payday")
    private Boolean isPayday;

    @JsonIgnore
    @OneToMany(mappedBy = "calendarEntity")
    Set<RoomDatesEntity> roomDatesEntitySet;

//    public Date getDt() {
//        return dt;
//    }
//
//    public void setDt(Date dt) {
//        this.dt = dt;
//    }
//
//    public int getY() {
//        return y;
//    }
//
//    public void setY(int y) {
//        this.y = y;
//    }
//
//    public int getQ() {
//        return q;
//    }
//
//    public void setQ(int q) {
//        this.q = q;
//    }
//
//    public int getM() {
//        return m;
//    }
//
//    public void setM(int m) {
//        this.m = m;
//    }
//
//    public int getD() {
//        return d;
//    }
//
//    public void setD(int d) {
//        this.d = d;
//    }
//
//    public int getDw() {
//        return dw;
//    }
//
//    public void setDw(int dw) {
//        this.dw = dw;
//    }
//
//    public int getW() {
//        return w;
//    }
//
//    public void setW(int w) {
//        this.w = w;
//    }
//
//    public String getMonthName() {
//        return monthName;
//    }
//
//    public void setMonthName(String monthName) {
//        this.monthName = monthName;
//    }
//
//    public String getDayName() {
//        return dayName;
//    }
//
//    public void setDayName(String dayName) {
//        this.dayName = dayName;
//    }
//
//    public boolean isWeekday() {
//        return isWeekday;
//    }
//
//    public void setWeekday(boolean weekday) {
//        isWeekday = weekday;
//    }
//
//    public boolean isHoliday() {
//        return isHoliday;
//    }
//
//    public void setHoliday(boolean holiday) {
//        isHoliday = holiday;
//    }
//
//    public String getHolidayDescr() {
//        return holidayDescr;
//    }
//
//    public void setHolidayDescr(String holidayDescr) {
//        this.holidayDescr = holidayDescr;
//    }
//
//    public boolean isPayday() {
//        return isPayday;
//    }
//
//    public void setPayday(boolean payday) {
//        isPayday = payday;
//    }
//
//    public Set<RoomDatesEntity> getRoomDatesEntitySet() {
//        return roomDatesEntitySet;
//    }
//
//    public void setRoomDatesEntitySet(Set<RoomDatesEntity> roomDatesEntitySet) {
//        this.roomDatesEntitySet = roomDatesEntitySet;
//    }
}
