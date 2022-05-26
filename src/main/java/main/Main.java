package main;

import dao.FruitDao;
import dao.FruitDaoImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import operation.OperationHandler;
import operation.implementation.BalanceHandler;
import operation.implementation.PurchaseHandler;
import operation.implementation.ReturnHandler;
import operation.implementation.SupplyHandler;
import service.ParseService;
import service.ReaderService;
import service.ReportService;
import service.WriteService;
import service.implementation.ParseServiceImpl;
import service.implementation.ReaderServiceImpl;
import service.implementation.ReportServiceImpl;
import service.implementation.WriteServiceImpl;
import strategy.Strategy;
import strategy.StrategyImpl;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/fruitInput.csv";
    private static final String REPORT_FILE_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        Map<FruitTransaction.Operation,
                OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceHandler(fruitDao));
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseHandler(fruitDao));
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnHandler(fruitDao));
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyHandler(fruitDao));

        ReaderService readerService = new ReaderServiceImpl();
        ParseService parseService = new ParseServiceImpl();
        List<String> lines = readerService.readFromFile(INPUT_FILE_PATH);
        List<FruitTransaction> fruitTransactions = parseService.parse(lines);

        Strategy strategy = new StrategyImpl(operationHandlerMap);
        for (FruitTransaction fruitTransaction: fruitTransactions) {
            strategy.process(fruitTransaction.getOperation()).handle(fruitTransaction);
        }

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.getReport();
        WriteService writeService = new WriteServiceImpl();
        writeService.writeToFile(REPORT_FILE_PATH, report);

    }
}
