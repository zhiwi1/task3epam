package org.zhyuliuk.shape.entity.impl;

import org.zhyuliuk.shape.entity.ShapeInterface;

public class EntityPoint implements ShapeInterface {
    private double x, y, z;

    public EntityPoint(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }


    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityPoint entityPoint = (EntityPoint) o;
        return x == entityPoint.x && y == entityPoint.y && z == entityPoint.z;
    }

    @Override
    public int hashCode() {

        int result = 1;
        result = 31 * result + (int) x;
        result = 31 * result + (int) y;
        result = 31 * result + (int) z;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ShapePoint{").append("x=").append(x).
                append(", y=").append(y).append(", z=").append(z).append("}");
        return stringBuilder.toString();
    }
}
