package com.hackerrank.stocktrade;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int N) {
        for (int i = 1; i < N; ++i) {
            int potentialFirst = i, potentialSecond = N - potentialFirst;
            if (doesNotContainZero(potentialFirst) && doesNotContainZero(potentialSecond)) {
                return new int[]{potentialFirst, potentialSecond};
            }
        }
        return new int[]{};
    }

    private boolean doesNotContainZero(int num) {
        if(String.valueOf(num).contains("0")){
            return false;
        }
        return true;
    }
}

public class RandomTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.solution(3);
        for (int val: result){
            System.out.println(val);
        }
    }
}
