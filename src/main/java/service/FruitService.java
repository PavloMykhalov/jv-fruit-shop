package service;

import java.util.List;
import model.Fruit;

public interface FruitService {
    Integer getQuantity(String fruitName);

    void update(String fruitName, Integer amount);

    List<Fruit> getAll();
}
