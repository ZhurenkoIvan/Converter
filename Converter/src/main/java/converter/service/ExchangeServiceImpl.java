package converter.service;

import converter.dao.ExchangeRatesDAO;
import converter.dao.OperationDAO;
import converter.dto.ProcessedExchangeJson;
import converter.dto.Statistic;
import converter.dto.TransactionInfo;
import converter.entity.Operation;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
public class ExchangeServiceImpl implements ExchangeService {

    @Autowired
    private OperationDAO operationDAO;

    @Autowired
    private ExchangeRatesDAO exchangeRatesDAO;

    @Override
    @Transactional
    public ProcessedExchangeJson updateExchangeRates() {
        Element element = null;
        try {
            element = Jsoup.connect("http://data.fixer.io/api/latest?access_key=49b9cfd24fa60656d5cd953e0d6eafe9&format=1")
                        .ignoreContentType(true).get().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String body = element.text();
        JSONObject jsonObject = new JSONObject(body);
        return exchangeRatesDAO.updateExchangeRates(jsonObject);
    }


    @Override
    @Transactional
    public ProcessedExchangeJson getExchangeRates() {
        System.out.println("Сервис отработал");
        return exchangeRatesDAO.getProcessedExchangeJson();
    }

    @Override
    @Transactional
    public List<Operation> getTodayOperations() {
        return operationDAO.getTodayOperations();
    }

    @Override
    @Transactional
    public Operation saveOperation(TransactionInfo transactionInfo) {

        return operationDAO.saveOperation(transactionInfo);
    }

    @Override
    @Transactional
    public Statistic getStatistic() {
        return operationDAO.getStatistic();
    }

}
