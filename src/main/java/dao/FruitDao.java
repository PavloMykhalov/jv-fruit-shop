package dao;

public interface FruitDao {
    Integer getQuantity(String fruitName);

    void update(String fruitName, Integer amount);
}
