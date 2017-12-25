package labT;

import java.io.Serializable;

public class Point implements Serializable {
    private int id;
    private double x;
    private double y;
    private double r;
    private int ishitted;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public int getIshitted() {
        return ishitted;
    }

    public void setIshitted(int ishitted) {
        this.ishitted = ishitted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (id != point.id) return false;
        if (Double.compare(point.x, x) != 0) return false;
        if (Double.compare(point.y, y) != 0) return false;
        if (Double.compare(point.r, r) != 0) return false;
        if (ishitted != point.ishitted) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        temp = Double.doubleToLongBits(x);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(r);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + ishitted;
        return result;
    }

    public String toString() {
        return "[\"x\":" + x +
                ", \"y\":" + y +
                ", \"r\":" + r +
                ", \"isHitted\":" + ishitted + "]";
    }

    public Point(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
        checkHitted();
    }

    public Point() {
    }

    public int checkHitted() {
        ishitted = 0;
        if (x <= 0 && y >= 0) {
            if (x >= r / -2 && y <= r)
                ishitted = 1;
        }
        if (x >= 0 && y >= 0) {
            if (x * x + y * y <= Math.pow(r / 2, 2))
                ishitted = 1;
        }
        if (x >= 0 && y <= 0) {
            if (y >= x - r)
                ishitted = 1;
        }
        return ishitted;
    }
}
