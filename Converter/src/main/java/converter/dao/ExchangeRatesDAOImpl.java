package converter.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import converter.dto.ProcessedExchangeJson;
import converter.entity.ExchangeRates;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;

@Repository
public class ExchangeRatesDAOImpl implements ExchangeRatesDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public ProcessedExchangeJson getProcessedExchangeJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        ExchangeRates exchangeRates = getExchangeRates();
        ProcessedExchangeJson processedExchangeJson = new ProcessedExchangeJson();
        String newRates = exchangeRates.getRates().replace(":1,",":1.0,");
        processedExchangeJson.setDate(exchangeRates.getDate());
        HashMap<String, Double> map = new HashMap();
        try {
            map = objectMapper.readValue(newRates, HashMap.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        processedExchangeJson.setBase(exchangeRates.getBase());
        processedExchangeJson.setRates(map);
        return processedExchangeJson;
    }


    @Override
    public ProcessedExchangeJson updateExchangeRates(JSONObject jsonObject) {
        ExchangeRates exchangeRates = exchangeRatesBuild(jsonObject);
        entityManager.merge(exchangeRates);
        ProcessedExchangeJson processedExchangeJson = getProcessedExchangeJson();
        return processedExchangeJson;
    }

    @Override
    public ExchangeRates getExchangeRates() {
        Query query = entityManager.createQuery("from ExchangeRates");
        List<ExchangeRates> exchangeRates = query.getResultList();
        return exchangeRates.get(0);
    }

    private ExchangeRates exchangeRatesBuild(JSONObject jsonObject) {
        ExchangeRates exchangeRates = new ExchangeRates();
        exchangeRates.setRates(jsonObject.get("rates").toString());
        exchangeRates.setBase(jsonObject.getString("base"));
        Date date = new Date(System.currentTimeMillis());
        exchangeRates.setDate(date);
        return exchangeRates;
    }
}
