package service.implementation;

import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.ParseService;

public class ParseServiceImpl implements ParseService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_TYPE_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        return lines.stream()
                .skip(1)
                .map(s -> s.split(","))
                .map(splittedLine -> {
                    FruitTransaction fruitTransaction = new FruitTransaction();
                    fruitTransaction.setOperation(FruitTransaction.Operation
                            .findByLetter(splittedLine[OPERATION_INDEX]));
                    fruitTransaction.setFruit(splittedLine[FRUIT_TYPE_INDEX]);
                    fruitTransaction.setQuantity(Integer.parseInt(splittedLine[QUANTITY_INDEX]));
                    return fruitTransaction;
                })
                .collect(Collectors.toList());
    }
}
