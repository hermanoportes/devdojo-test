package pt.hermanoportes.devdojotest.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Transaction {
    private String id;
    private String arrangementId;
    private LocalDateTime bookingDate;
    private String type; //Type
    private LocalDateTime valueDate;
    private double amount;
    private String currencyCode; //Currency
    private String currency; //Currency
    private String creditDebitIndicator; //CreditDebitIndicator
    private double runningBalance;
    private String counterPartyAccountNumber;
    private String reference;
    private String typeGroup; //TypeGroup
    private double instructedAmount;
}
