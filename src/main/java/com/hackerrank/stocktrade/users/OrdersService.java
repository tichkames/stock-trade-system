package com.hackerrank.stocktrade.users;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersService {
    List<Item> itemsBought(String username){
        List items = new ArrayList<>();
        items.add(new Item());
        return items;
    }
}

class Item {
}
