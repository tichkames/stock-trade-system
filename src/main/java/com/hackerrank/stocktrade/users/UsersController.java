package com.hackerrank.stocktrade.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/{username}/items/total")
    public ResponseEntity<Map<String, Integer>> totalItemsBought(@PathVariable String username) {
        int numberOfItems = usersService.getNumberOfItemsBought(username);
        Map<String, Integer> result = new HashMap<>();
        result.put("totalItemsBought", numberOfItems);
        return ResponseEntity.ok(result);
    }
}
