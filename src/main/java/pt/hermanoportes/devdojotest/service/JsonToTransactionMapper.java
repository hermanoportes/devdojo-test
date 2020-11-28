package pt.hermanoportes.devdojotest.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import pt.hermanoportes.devdojotest.domain.Transaction;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class JsonToTransactionMapper {
    public List<Transaction> mapTransactions() throws IOException {
        List<?> objList =  Arrays.asList(
                new ObjectMapper().readValue(
                        new File("transactions.json"), Object[].class));

        List<Transaction> transactionList = new ArrayList<>();
        for (Object o : objList) {
            Map transactionMap =(Map<String, ?>) o;
            Map accountBalancesMap = (Map<String, ?>) transactionMap.get("accountBalances");

            transactionList.add(new Transaction(
                    transactionMap.get("encodedKey").toString(),
                    transactionMap.get("parentAccountKey").toString(),
                    LocalDateTime.parse(transactionMap.get("creationDate").toString(), DateTimeFormatter.ISO_DATE_TIME),
                    transactionMap.get("type").toString(),
                    LocalDateTime.parse(transactionMap.get("valueDate").toString(), DateTimeFormatter.ISO_DATE_TIME),
                    Double.valueOf(transactionMap.get("amount").toString()),
                    transactionMap.get("currencyCode").toString(),
                    transactionMap.get("currencyCode").toString(),
                    transactionMap.get("amount").toString(),
                    Double.valueOf(accountBalancesMap.get("totalBalance").toString()),
                    transactionMap.get("id").toString(),
                    transactionMap.get("parentAccountKey").toString(),
                    transactionMap.get("type").toString(),
                    Double.valueOf(transactionMap.get("amount").toString())
            ));
        }
        return transactionList;
    }
}
