package dao;

import model.FruitTransaction;

import java.util.List;


public interface FruitTransactionDao {
    void add(FruitTransaction fruitTransaction);

    FruitTransaction get(String fruitName);

    List<FruitTransaction> getAll();
}
