package labT;

import javax.annotation.PostConstruct;
import javax.faces.component.UIInput;
import javax.faces.event.AjaxBehaviorEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PointController {
    private DB db;
    private List<Points> points;
    private Points point;
    private UIInput pseudoR;

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
            point = new Points(point.getX(), point.getY(), point.getR());
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

    public Points getPoint() {
        return point;
    }

    public void setPoint(Points point) {
        this.point = point;
    }

    public List<Points> getPoints() {
        return points;
    }

    public void setPoints(List<Points> points) {
        this.points = points;
    }

    @PostConstruct
    public void initList() {
        try {
            point.setR(1.0);
            points = db.getAllPoints();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //хз зачем тут этот catch но пусть пока будет. С ним работает и ладно
        catch (NullPointerException ex){
            points=new ArrayList<>();
            point=new Points(0,0,1);
        }
    }
}
