package pt.hermanoportes.devdojotest.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.hermanoportes.devdojotest.domain.Transaction;
import pt.hermanoportes.devdojotest.service.JsonToTransactionMapper;
import pt.hermanoportes.devdojotest.util.DateUtil;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("transactions")
@Log4j2
@RequiredArgsConstructor
public class TransactionController {
    private final DateUtil dateUtil;
    private final JsonToTransactionMapper mapper;

    @GetMapping(path="/{accountId}")
    public List<Transaction> listByAccount(){
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        try {
            return mapper.mapTransactions();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    } 
}
