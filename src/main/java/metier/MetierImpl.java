package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("metier")
public class MetierImpl implements IMetier {
    @Autowired
    private IDao dao;

    public MetierImpl() {
        System.out.println("Constructeur MetierImpl sans paramètre");
    }

    public MetierImpl(@Qualifier("dao") IDao dao) {
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
