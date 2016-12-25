/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.isotopestudio.data;

/**
 *
 * @author 44750
 */
public class Score {

    private final int year;
    private final int month;
    private final int day;
    private final String mark;
    private final int math;
    private final int english;
    private final int reading;
    private final int science;
    private final int essay;
    private final int composite;

    public Score(int year, int month, int day, String mark, int math, int english, int reading, int science, int essay, int composite) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.mark = mark;
        this.math = math;
        this.english = english;
        this.reading = reading;
        this.science = science;
        this.essay = essay;
        this.composite = composite;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String getMark() {
        return mark;
    }

    public int getMath() {
        return math;
    }

    public int getEnglish() {
        return english;
    }

    public int getReading() {
        return reading;
    }

    public int getScience() {
        return science;
    }

    public int getEssay() {
        return essay;
    }

    public int getComposite() {
        return composite;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Score{");
        sb.append("year=").append(year);
        sb.append(", month=").append(month);
        sb.append(", day=").append(day);
        sb.append(", mark=").append(mark);
        sb.append(", math=").append(math);
        sb.append(", english=").append(english);
        sb.append(", reading=").append(reading);
        sb.append(", science=").append(science);
        sb.append(", essay=").append(essay);
        sb.append(", composite=").append(composite);
        sb.append('}');
        return sb.toString();
    }
}
