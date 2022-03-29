package converter.dao;

import converter.dto.Statistic;
import converter.dto.TransactionInfo;
import converter.entity.Operation;

import java.util.List;

public interface OperationDAO {
    public List<Operation> getTodayOperations();
    public Operation saveOperation(TransactionInfo transactionInfo);
    public Statistic getStatistic();
}
