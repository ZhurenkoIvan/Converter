package converter.dto;

import lombok.Data;

@Data
public class TransactionInfo {

    private int idUser;

    private double fromCurrencyAmount;

    private String fromCurrency;

    private double toCurrencyAmount;

    private String toCurrency;

    private long transactionDate;

}
