package converter.service;

import converter.dto.ProcessedExchangeJson;
import converter.dto.Statistic;
import converter.dto.TransactionInfo;
import converter.entity.Operation;
import converter.entity.User;

import java.util.List;

public interface ExchangeService {
    public ProcessedExchangeJson updateExchangeRates();
    public ProcessedExchangeJson getExchangeRates();

    public List<Operation> getTodayOperations();
    public Operation saveOperation(TransactionInfo transactionInfo);

    public Statistic getStatistic();

    public User getUser();
    public User saveUser();
}
