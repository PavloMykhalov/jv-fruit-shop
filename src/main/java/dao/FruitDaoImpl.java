package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.FruitTransaction;
import storage.Storage;

public class FruitTransactionDaoImpl implements FruitTransactionDao {
    @Override
    public void add(FruitTransaction fruitTransaction) {
        Storage.fruits.put(fruitTransaction.getFruit(), fruitTransaction);
    }

    @Override
    public FruitTransaction get(String fruitName) {
        return Storage.fruits.get(fruitName);
    }

    @Override
    public List<FruitTransaction> getAll() {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (Map.Entry<String, FruitTransaction> entry : Storage.fruits.entrySet()) {
            fruitTransactions.add(entry.getValue());
        }
        return fruitTransactions;
    }
}
