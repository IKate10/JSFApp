package labT;

import javax.annotation.PostConstruct;
import javax.faces.component.UIInput;
import javax.faces.event.AjaxBehaviorEvent;
import java.io.Serializable;
import java.sql.BatchUpdateException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PointController implements Serializable {
    private DB db;
    private List<Point> points;
    private Point point;

    public PointController() {
    }


    public void addPoint() throws SQLException {
        try {
            System.out.println("points: " + points);
            point.checkHitted();
            points.add(point);
            db.addPoint(point);
            point = new Point(point.getX(), point.getY(), point.getR());
        } catch (BatchUpdateException e) {
            throw new SQLException(e.getNextException());
        }
    }

    public void resetR() throws SQLException {
        for (int i = 0; i < points.size(); i++) {
            points.get(i).setR(point.getR());
            points.get(i).checkHitted();
            db.addPoint(points.get(i));
        }
    }

    public DB getDb() {
        return db;
    }

    public void setDb(DB db) {
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
    }
}
