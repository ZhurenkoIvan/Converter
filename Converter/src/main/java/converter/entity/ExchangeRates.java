package converter.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "exchange_rates")
@Data
public class ExchangeRates {

    @Id
    @Column(name = "base")
    private String base;

    @Column(name = "date")
    private Date date;

    @Column(name = "rates")
    private String rates;
}
