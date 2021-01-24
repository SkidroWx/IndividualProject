import model.UserModel;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import java.util.Properties;

public class DbConfig {
    private SessionFactory sessionFactory;

    public DbConfig() {

        Configuration configuration = new Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
        properties.put(Environment.URL, "jdbc:mysql://localhost:3306/practical_project");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "54321");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
        properties.put(Environment.SHOW_SQL, "true");
        // Creaza table daca nu exista.
        properties.put(Environment.HBM2DDL_AUTO, "update");

        configuration.addAnnotatedClass(UserModel.class);
        //configuration.addAnnotatedClass(EmployeeModel.class);
        //configuration.addAnnotatedClass(ManufacturerModel.class);
        //configuration.addAnnotatedClass(AddressModel.class);
        //configuration.addAnnotatedClass(CategoryModel.class);

        configuration.setProperties(properties);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;

    }

}
