import dao.ProductDao;
import model.UserModel;
import org.hibernate.SessionFactory;

import java.util.Scanner;

public class Main {
    static String username;
    static String password;
    static UserModel userModel;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean acc = true;
        boolean loggedIn = false;

        DbConfig dbConfig = new DbConfig();
        SessionFactory sessionFactory =dbConfig.getSessionFactory();
        ProductDao productDao =new ProductDao(sessionFactory);

        while (acc) {
            System.out.println("");
            System.out.println("-------------------");
            System.out.println("[1]-LogIn-[1]");
            System.out.println("[2]-Register-[2]");
            System.out.println("[3]-Accounts-[3]");
            System.out.println("[4]-Close App-[4]");
            System.out.println("-------------------");
            System.out.print("Option= ");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.print("username: ");
                    username = sc.next();
                    System.out.print("password: ");
                    password = sc.next();

                    if (loggedIn) {
                        System.out.println("You are already logged in your bank account!");
                        continue;
                    }

                    if (userModel == productDao.findByName(username) && password.equals(userModel.getPassword())) {
                        loggedIn = true;
                        System.out.println("LogIn success!");
                        System.out.println("Your commands = Withdraw, Deposit, Transfer, LogOut");
                        String option1 = sc.next();
                        if (option1.equals("withdraw".toLowerCase())) {

                        } else if (option1.equals("deposit".toLowerCase())) {
                            System.out.println();

                        } else if (option1.equals("transfer".toLowerCase())) {
                            System.out.println();

                        } else if (option1.equals("logout".toLowerCase())) {
                            System.out.println();
                        }
                    } else {
                        System.out.println("Wrong username or password! Try again...");
                    }

                    break;




                case 2:
                    System.out.print("username: ");
                    username = sc.next();
                    System.out.print("password: ");
                    password = sc.next();

                    userModel = new UserModel();
                    userModel.setUsername(username);
                    userModel.setPassword(password);
                    productDao.addAccount(userModel);
                    break;

                case 3:


                    break;

                case 4:
                    acc = false;
                    System.out.println("App closed!");
                    break;

                default:
                    System.out.println("Wrong option! Try again...");

            }
        }



    }
}
