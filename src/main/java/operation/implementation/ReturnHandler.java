package operation.implementation;

import dao.FruitDao;
import model.FruitTransaction;
import operation.OperationHandler;

public class ReturnHandler implements OperationHandler {
    private FruitDao fruitDao;

    public ReturnHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        fruitDao.update(fruitTransaction.getFruit(),
                fruitDao.getQuantity(fruitTransaction.getFruit()) - fruitTransaction.getQuantity());
    }
}
