package service.implementation;

import dao.FruitDao;
import dao.FruitDaoImpl;
import java.util.List;
import model.Fruit;
import service.FruitService;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    private FruitDao fruitDao = new FruitDaoImpl();
    private FruitService fruitService = new FruitServiceImpl(fruitDao);

    @Override
    public String getReport() {
        StringBuilder builder = new StringBuilder("fruit, quantity");
        List<Fruit> fruits = fruitService.getAll();
        for (Fruit fruit : fruits) {
            builder.append(System.lineSeparator())
                    .append(fruit.getName())
                    .append(",")
                    .append(fruit.getAmount());
        }
        return builder.toString();
    }
}
