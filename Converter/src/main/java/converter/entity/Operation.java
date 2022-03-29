package converter.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "operation")
@Data
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "from_currency_amount")
    private double fromCurrencyAmount;

    @Column(name = "to_currency_amount")
    private double toCurrencyAmount;

    @Column(name = "id_user")
    private int idUser;

    @Column(name = "from_currency")
    private String fromCurrency;

    @Column(name = "to_currency")
    private String toCurrency;

    @Column(name = "transaction_date")
    private Date transactionDate;

}
