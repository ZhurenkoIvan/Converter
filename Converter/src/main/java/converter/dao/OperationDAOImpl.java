package converter.dao;

import converter.dto.Statistic;
import converter.dto.TransactionInfo;
import converter.entity.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.Date;
import java.util.List;

@Repository
public class OperationDAOImpl implements OperationDAO{

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Operation> getTodayOperations() {
        String date = new Date(System.currentTimeMillis()).toString();
        Query query = entityManager.createQuery("FROM Operation WHERE " +
                "transaction_date='" + date + "'");
        return (List<Operation>) query.getResultList();
    }

    @Override
    public Operation saveOperation(TransactionInfo transactionInfo) {
        Operation operation = new Operation();

        operation.setIdUser(transactionInfo.getIdUser());
        operation.setFromCurrency(transactionInfo.getFromCurrency());
        operation.setToCurrency(transactionInfo.getToCurrency());
        operation.setTransactionDate(new Date(transactionInfo.getTransactionDate()));
        operation.setToCurrencyAmount(transactionInfo.getToCurrencyAmount());
        operation.setFromCurrencyAmount(transactionInfo.getFromCurrencyAmount());

        return entityManager.merge(operation);
    }

    @Override
    public Statistic getStatistic() {
        String date = new Date(System.currentTimeMillis()).toString();
        Statistic statistic = new Statistic();
        Query query = entityManager.createQuery("SELECT count(*) FROM Operation WHERE " +
                "transaction_date='" + date + "'");
        statistic.setOperationCountToday(Math.toIntExact((Long) query.getResultList().get(0)));
        query = entityManager.createQuery("SELECT count (*) FROM Operation");
        statistic.setAllOperationCount(Math.toIntExact((Long) query.getResultList().get(0)));
//        query = entityManager.createQuery("Select from_currency from (Select max(c.sell_count) as max_sell_count from (select from_currency, count(*) as sell_count from operation where transaction_date ='" + date + "' group by from_currency) as c ) as a inner join (select from_currency, count(*) as sell_count from operation where transaction_date ='" + date + "' group by from_currency) b on a.max_sell_count = b.sell_count");
//        statistic.setMostPopularCurrency(query.getResultList().get(0).toString());
        return statistic;
    }
}
