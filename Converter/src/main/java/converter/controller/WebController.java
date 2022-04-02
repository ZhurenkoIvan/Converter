package converter.controller;

import converter.dto.ProcessedExchangeJson;
import converter.dto.Statistic;
import converter.dto.TransactionInfo;
import converter.entity.Operation;
import converter.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class WebController {

    @Autowired
    private ExchangeService exchangeService;

    @GetMapping("")
    public String startPage() {
        return "index";
    }

    @GetMapping("/exchangeRates")
    public ProcessedExchangeJson getExchangeRates() {
        ProcessedExchangeJson processedExchangeJson = exchangeService.getExchangeRates();
        System.out.println(processedExchangeJson);
        return processedExchangeJson;
    }

    @PostMapping("/exchangeRates")
    public ProcessedExchangeJson updateExchangeRates() {
        ProcessedExchangeJson processedExchangeJson = exchangeService.updateExchangeRates();
        System.out.println(processedExchangeJson);
        return processedExchangeJson;
    }

    @GetMapping("/transactionInfo")
    public List<Operation> getTodayOperationsInfo() {
        return exchangeService.getTodayOperations();
    }

    @PostMapping("/transactionInfo")
    public Operation saveTransactionInfo(@RequestBody TransactionInfo transactionInfo) {
      return exchangeService.saveOperation(transactionInfo);
    }

    @GetMapping("/stats")
    public Statistic getStatistics() {

        return exchangeService.getStatistic();
    }


}
