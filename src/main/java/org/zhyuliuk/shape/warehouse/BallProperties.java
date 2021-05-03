package org.zhyuliuk.shape.warehouse;

import java.util.Objects;

public class BallProperties {
    private double volume;
    private double area;


    public BallProperties(double volume, double area) {
        this.volume = volume;
        this.area = area;
    }
    public BallProperties(BallProperties ballProperties) {
        this.volume = ballProperties.getVolume();
        this.area = ballProperties.getArea();
    }


    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallProperties that = (BallProperties) o;
        return Double.compare(that.volume, volume) == 0 && Double.compare(that.area, area) == 0;
    }

    @Override
    public int hashCode() {
       int result=1;
        result = 31 * result + (int) volume;
        result = 31 * result + (int) area;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("BallProperties{").append("volume=").
                append(volume).append(", area=").append(area).append("}");
        return stringBuilder.toString();
    }
}

