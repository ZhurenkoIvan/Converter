package converter.dao;

import converter.dto.ProcessedExchangeJson;
import converter.entity.ExchangeRates;
import org.json.JSONObject;

public interface ExchangeRatesDAO {
    public ProcessedExchangeJson getProcessedExchangeJson();


    public ProcessedExchangeJson updateExchangeRates(JSONObject jsonObject);
    public ExchangeRates getExchangeRates();
}
