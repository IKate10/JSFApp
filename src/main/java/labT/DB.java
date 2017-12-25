package labT;


import java.io.Serializable;
import java.sql.BatchUpdateException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.hibernate.*;
import com.user.util.HibernateUtil;
import com.user.DBUser;

public class DB implements Serializable {

    public DB() throws SQLException {

        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        DBUser user = new DBUser();

        user.setUserId(100);
        user.setUsername("superman");
        user.setCreatedBy("system");
        user.setCreatedDate(new Date());
        session.saveOrUpdate(user);
        session.getTransaction().commit();
        session.close();
    }

    public void addPoint(Point point) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(point);
        session.getTransaction().commit();
        session.close();

    }

    public List<Point> getAllPoints() throws SQLException {
        List<Point> points = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("SELECT p FROM Point p");

        int pageSize = 10;

        ScrollableResults resultScroll = query.scroll(ScrollMode.SCROLL_INSENSITIVE);
        resultScroll.beforeFirst();
        resultScroll.scroll(0);

        for (int i = 0; i < pageSize && resultScroll.next(); i++) {
            points.add(new Point((double) resultScroll.get()[1], (double) resultScroll.get()[2], (double) resultScroll.get()[3]));

        }
        if (resultScroll.next()) {
            session.close();
        }
        session.getTransaction().commit();
        return points;
    }


}
