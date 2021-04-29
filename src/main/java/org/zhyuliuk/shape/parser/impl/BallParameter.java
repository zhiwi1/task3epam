package org.zhyuliuk.shape.parser.impl;

import java.util.Objects;

public class BallParameter {
    private double x;
    private double y;
    private double z;
    private double radius;

    BallParameter() {

    }

    public BallParameter(double x, double y, double z, double radius) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.radius = radius;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallParameter parameter = (BallParameter) o;
        return Double.compare(parameter.x, x) == 0 && Double.compare(parameter.y, y) == 0 && Double.compare(parameter.z, z) == 0 && Double.compare(parameter.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        double result = 1;
        result = 13 * result + x;
        result = 13 * result + y;
        result = 13 * result + z;
        result = 13 * result + radius;
        return (int) result;
    }
}
