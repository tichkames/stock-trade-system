package com.hackerrank.stocktrade.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    private OrdersService ordersService;

    public int getNumberOfItemsBought(String username) {
        return ordersService.itemsBought(username).size();
    }
}
