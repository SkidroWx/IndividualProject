package dao;

import model.UserModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class ProductDao {
    private SessionFactory sessionFactory;

    public ProductDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addAccount(UserModel userModel) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(userModel);
        transaction.commit();
        session.close();
    }

    public UserModel findByName(String productName) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from model.UserModel li where li.name = '" + productName + "' ");
        UserModel productModel = (UserModel) query.getSingleResult();
        session.close();
        return productModel;
    }

    public List<UserModel> getAccounts() {
        Session session = sessionFactory.openSession();
        List<UserModel> productModelList = session.createQuery("from model.UserModel").getResultList();
        session.close();
        return productModelList;
    }

}
