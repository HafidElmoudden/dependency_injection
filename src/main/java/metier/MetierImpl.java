package metier;

import dao.IDao;

public class MetierImpl implements IMetier {
    private IDao dao;

    public MetierImpl() {
        System.out.println("Constructeur MetierImpl sans paramètre");
    }

    public MetierImpl(IDao dao) {
        this.dao = dao;
        System.out.println("Constructeur MetierImpl avec paramètre");
    }

    @Override
    public double calcul() {
        double t = dao.getData();
        double res = t * 23;

        return res;
    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
