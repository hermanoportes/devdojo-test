package pt.hermanoportes.devdojotest.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.hermanoportes.devdojotest.domain.Transaction;
import pt.hermanoportes.devdojotest.util.DateUtil;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("transactions")
@Log4j2
@AllArgsConstructor
public class TransactionController {
    private DateUtil dateUtil;
    
    @GetMapping(path="/{accountId}")
    public List<Transaction> listByAccount(){
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return List.of(new Transaction("234", "TRANSFER", -30.25),
                new Transaction("123", "DEPOSIT", 50.00));
    } 
}
