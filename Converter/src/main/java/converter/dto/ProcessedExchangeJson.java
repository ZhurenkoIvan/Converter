package converter.dto;

import lombok.Data;

import java.sql.Date;
import java.util.HashMap;

@Data
public class ProcessedExchangeJson {

    private String base;

    private Date date;

    private HashMap<String, Double> rates;

}
