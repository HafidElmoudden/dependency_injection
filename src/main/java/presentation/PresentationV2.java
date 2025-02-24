package presentation;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class PresentationV2 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("config.txt"));

            String daoClassName = scanner.nextLine();
            Class daoClass = Class.forName(daoClassName);
            IDao dao = (IDao) daoClass.getConstructor().newInstance();

            String metierClassName = scanner.nextLine();
            Class metierClass = Class.forName(metierClassName);
            IMetier metier = (IMetier) metierClass.getConstructor(IDao.class).newInstance(dao); // Injection de dépendance par constructeur

            Method setDao = metierClass.getDeclaredMethod("setDao", IDao.class);
            setDao.invoke(metier, dao); // Injection de dépendance par setter

            System.out.println(metier.calcul());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
