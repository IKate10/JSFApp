package labT;

import javax.annotation.PostConstruct;
import javax.faces.component.UIInput;
import javax.faces.event.AjaxBehaviorEvent;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PointController implements Serializable {
    private DB db;
    private List<Point> points;
    private Point point;
    private UIInput pseudoR;

    public PointController() {
    }

    public UIInput getPseudoR() {
        return pseudoR;
    }

    public void setPseudoR(UIInput pseudoR) {
        this.pseudoR = pseudoR;
    }

    public void addPoint(AjaxBehaviorEvent event) {

        try {
            System.out.println("points: " + points);
            point.checkHitted();
            points.add(point);
            db.addPoint(point);
            point = new Point(point.getX(), point.getY(), point.getR());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public DB getDb() {
        return db;
    }

    public void setDb(DB dB) {
        this.db = db;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    @PostConstruct
    public void initList() {
        try {
            points = db.getAllPoints();
            point.setR(1.0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //хз зачем тут этот catch но пусть пока будет. С ним работает и ладно
    }
}
