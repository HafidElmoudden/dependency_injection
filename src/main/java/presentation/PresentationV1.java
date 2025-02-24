package presentation;

import dao.DaoImpl;
import dao.IDao;
import metier.IMetier;
import metier.MetierImpl;

public class PresentationV1 {
    public static void main(String[] args) {
        DaoImpl dao = new DaoImpl();
        MetierImpl metier = new MetierImpl(dao); // Injection de dépendance par constructeur

        // metier.setDao(dao); // Injection de dépendance par setter

        double res = metier.calcul();

        System.out.println("Résultat: " + res);
    }
}
