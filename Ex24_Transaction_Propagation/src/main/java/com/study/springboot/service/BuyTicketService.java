package com.study.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.study.springboot.dao.ITransaction1Dao;
import com.study.springboot.dao.ITransaction2Dao;

@Service
public class BuyTicketService {

    @Autowired
    ITransaction1Dao transaction1;
    @Autowired
    ITransaction2Dao transaction2;
    
    @Autowired
    TransactionTemplate transactionTemplate;
    
//    @Transactional(propagation=Propagation.REQUIRED)
    @Transactional(propagation=Propagation.REQUIRES_NEW)
    public int buy(String consumerId, int amount, String error) {

        try {
            transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            	
            	// doInTransactionWithoutResult 안에 작성한 비지니스 로직에서 에러가 발생하지 않는다면 정상적으로 커밋 처리가 되고, 
                // 에러가 발생하면 자동으로 롭백처리가 된다.
                @Override
                protected void doInTransactionWithoutResult(TransactionStatus arg0) {             

                    transaction1.pay(consumerId, amount);
                    
                    // 의도적 에러 발생
                    if (error.equals("1")) { int n = 10 / 0;}

                    transaction2.pay(consumerId, amount);
                }
            });
    
            return 1;
        } catch(Exception e) {
            System.out.println("[Transacion Propagation #2] Rollback"); 
            return 0;
        }
    }

}