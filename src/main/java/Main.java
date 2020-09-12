import managerpro.utils.HibernateUtil;
import org.hibernate.Session;

public class Main {

    public static void main(String[] args){

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        HibernateUtil.shutdown();
    }
}
