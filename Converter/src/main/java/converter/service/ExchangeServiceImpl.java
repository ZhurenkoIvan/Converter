package converter.service;

import converter.dao.ExchangeRatesDAO;
import converter.dao.OperationDAO;
import converter.dto.ProcessedExchangeJson;
import converter.dto.Statistic;
import converter.dto.TransactionInfo;
import converter.entity.Operation;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        String body = "{ \"success\":true, \"timestamp\":1648653484, \"base\":\"EUR\", \"date\":\"2022-03-30\", \"rates\":{ \"AED\":4.097886, \"AFN\":98.73601, \"ALL\":122.860691, \"AMD\":544.179656, \"ANG\":2.010662, \"AOA\":499.907369, \"ARS\":123.755571, \"AUD\":1.48544, \"AWG\":2.008166, \"AZN\":1.913586, \"BAM\":1.960668, \"BBD\":2.252559, \"BDT\":96.194577, \"BGN\":1.957489, \"BHD\":0.420638, \"BIF\":2242.452585, \"BMD\":1.115648, \"BND\":1.510728, \"BOB\":7.669927, \"BRL\":5.334473, \"BSD\":1.115653, \"BTC\":2.3714583e-5, \"BTN\":84.71074, \"BWP\":12.742745, \"BYN\":3.633566, \"BYR\":21866.70182, \"BZD\":2.248749, \"CAD\":1.391225, \"CDF\":2243.568501, \"CHF\":1.030011, \"CLF\":0.031931, \"CLP\":881.060389, \"CNY\":7.081802, \"COP\":4176.952837, \"CRC\":731.164273, \"CUC\":1.115648, \"CUP\":29.564673, \"CVE\":111.508823, \"CZK\":24.447081, \"DJF\":198.605643, \"DKK\":7.437055, \"DOP\":61.282577, \"DZD\":158.923563, \"EGP\":20.383229, \"ERN\":16.734726, \"ETB\":56.898313, \"EUR\":1, \"FJD\":2.322892, \"FKP\":0.855656, \"GBP\":0.847597, \"GEL\":3.486454, \"GGP\":0.855656, \"GHS\":8.406372, \"GIP\":0.855656, \"GMD\":59.965826, \"GNF\":9923.689702, \"GTQ\":8.573557, \"GYD\":233.405969, \"HKD\":8.732077, \"HNL\":27.210727, \"HRK\":7.569786, \"HTG\":118.255816, \"HUF\":367.679669, \"IDR\":15990.974006, \"ILS\":3.548056, \"IMP\":0.855656, \"INR\":84.531986, \"IQD\":1628.846156, \"IRR\":47136.130437, \"ISK\":141.988574, \"JEP\":0.855656, \"JMD\":171.27064, \"JOD\":0.790992, \"JPY\":136.092882, \"KES\":128.182375, \"KGS\":92.943542, \"KHR\":4518.374724, \"KMF\":495.7661, \"KPW\":1004.083638, \"KRW\":1348.394815, \"KWD\":0.339068, \"KYD\":0.929694, \"KZT\":518.928917, \"LAK\":13108.864472, \"LBP\":1687.975022, \"LKR\":329.108932, \"LRD\":170.694426, \"LSL\":16.210122, \"LTL\":3.294219, \"LVL\":0.674844, \"LYD\":5.215645, \"MAD\":10.772138, \"MDL\":20.41588, \"MGA\":4460.36105, \"MKD\":61.766034, \"MMK\":1983.74533, \"MNT\":3211.697256, \"MOP\":8.993596, \"MRO\":398.286163, \"MUR\":49.479231, \"MVR\":17.236602, \"MWK\":912.039934, \"MXN\":22.161256, \"MYR\":4.700784, \"MZN\":71.211441, \"NAD\":16.210061, \"NGN\":463.83044, \"NIO\":39.862398, \"NOK\":9.570631, \"NPR\":135.540469, \"NZD\":1.598383, \"OMR\":0.429611, \"PAB\":1.115653, \"PEN\":4.164158, \"PGK\":3.921514, \"PHP\":57.998635, \"PKR\":203.439094, \"PLN\":4.643707, \"PYG\":7762.95642, \"QAR\":4.062064, \"RON\":4.946334, \"RSD\":117.692081, \"RUB\":94.278838, \"RWF\":1134.614069, \"SAR\":4.185516, \"SBD\":8.943141, \"SCR\":16.082719, \"SDG\":499.262963, \"SEK\":10.335888, \"SGD\":1.5095, \"SHP\":1.53669, \"SLL\":13237.164318, \"SOS\":651.538193, \"SRD\":23.057093, \"STD\":23091.662192, \"SVC\":9.76209, \"SYP\":2802.508283, \"SZL\":16.221836, \"THB\":37.190684, \"TJS\":14.469281, \"TMT\":3.904768, \"TND\":3.287262, \"TOP\":2.513053, \"TRY\":16.343127, \"TTD\":7.580205, \"TWD\":31.882209, \"TZS\":2588.3038, \"UAH\":32.966651, \"UGX\":4009.594359, \"USD\":1.115648, \"UYU\":46.259152, \"UZS\":12776.401434, \"VEF\":238559271015.14075, \"VND\":25499.809701, \"VUV\":127.313967, \"WST\":2.925281, \"XAF\":657.57969, \"XAG\":0.04466, \"XAU\":0.000576, \"XCD\":3.015095, \"XDR\":0.809598, \"XOF\":664.366245, \"XPF\":120.545603, \"YER\":279.190566, \"ZAR\":16.151828, \"ZMK\":10042.168906, \"ZMW\":20.053285, \"ZWL\":359.238218 } }";
//        Element element = null;
//        try {
//            element = Jsoup.connect("http://data.fixer.io/api/latest?access_key=2adea4d5f675b20c882ca0c215cf7ba3&format=1")
//                        .ignoreContentType(true).get().body();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        String body = element.text();
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
