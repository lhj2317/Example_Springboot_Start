package com.study.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.dao.ITransaction1Dao;
import com.study.springboot.dao.ITransaction2Dao;

@Service
public class BuyTicketService implements IBuyTicketService {

    @Autowired
    ITransaction1Dao transaction1;
    @Autowired
    ITransaction2Dao transaction2;

    @Override
    public int buy(String consumerId, int amount, String error) {

        try {
            transaction1.pay(consumerId, amount);
            
            // 의도적 에러 발생
            if (error.equals("1")) { int n = 10 / 0;}
            
            transaction2.pay(consumerId, amount);
            
            return 1;
        } catch(Exception e) {
            return 0;
        }
    }

}
