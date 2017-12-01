package labT;


import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
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
  //TODO добавить нормальную проверку!!!
    public boolean checkHitted() {
        if (x==0)  {
            hitted = true;
        } else {
            hitted = false;
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