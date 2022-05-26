package operation.implementation;

import dao.FruitDao;
import model.FruitTransaction;
import operation.OperationHandler;

public class BalanceHandler implements OperationHandler {
    private FruitDao fruitDao;

    public BalanceHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        fruitDao.update(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
