package labT;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.hibernate.*;
import com.user.util.HibernateUtil;
import com.user.DBUser;

//import oracle.ucp.jdbc.PoolDataSourceFactory;
//import oracle.ucp.jdbc.PoolDataSource;

public class DB {





    public DB() throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        DBUser user = new DBUser();

        user.setUserId(100);
        user.setUsername("superman");
        user.setCreatedBy("system");
        user.setCreatedDate(new Date());
        session.save(user);
        session.getTransaction().commit();

    }


    public void addPoint(Points point) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.createSQLQuery("insert into point(x, y, r, ishitted) VALUES (" + point.getX() + ", " + point.getY() + ", "
                + point.getR() + ", " + point.isHitted() + ")");
        session.close();
    }

    public List<Points> getAllPoints() throws SQLException {
        List<Points> points = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        SQLQuery query = session.createSQLQuery("SELECT * FROM point");


        int pageSize = 10;

        ScrollableResults resultScroll = query.scroll(ScrollMode.FORWARD_ONLY);
        resultScroll.first();
        resultScroll.scroll(0);

        for (int i = 0; i < pageSize; i++) {
            points.add(new Points(resultScroll.getDouble('x'), resultScroll.getDouble('y'), resultScroll.getDouble('r')));
        }
        if (resultScroll.next()) {
            session.close();
        }

        return points;
    }


}
