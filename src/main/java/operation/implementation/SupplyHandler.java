package operation.implementation;

import dao.FruitDao;
import model.FruitTransaction;
import operation.OperationHandler;

public class SupplyHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public SupplyHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        fruitDao.update(fruitTransaction.getFruit(),
                fruitDao.getQuantity(fruitTransaction.getFruit()) - fruitTransaction.getQuantity());
    }
}
