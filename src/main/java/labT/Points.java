package labT;


import java.io.Serializable;

public class Points implements Serializable {
    private double x;
    private double y;
    private double r = 1.0;
    private boolean hitted;

    public Points() {
    }

    public Points(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
        checkHitted();
    }

    public boolean checkHitted() {
        hitted = false;
        if (x <= 0 && y >= 0) {
            if (x >= r / -2 || y <= r)
                hitted = true;
        }
        if (x >= 0 && y >= 0) {
            if (x * x + y * y <= Math.pow(r / 2, 2))
                hitted = true;
        }
        if (x >= 0 && y <= 0) {
            if (y <= x - r)
                hitted = true;
        }
        return hitted;
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

    public boolean isHitted() {
        return hitted;
    }

    public String toString() {
        return "[\"x\":" + x +
                ", \"y\":" + y +
                ", \"r\":" + r +
                ", \"isHitted\":" + hitted + "]";
    }
}