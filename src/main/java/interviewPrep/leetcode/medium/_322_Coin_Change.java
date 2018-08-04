package interviewPrep.leetcode.medium;

import java.util.Arrays;

public class _322_Coin_Change {
    public int coinChange(int[] coins, int amount) {

        int[] memo = new int[amount + 1];
        Arrays.fill(memo, Integer.MAX_VALUE - 1);
        memo[0] = 0;

        // bottom up
        for(int i = 0; i < coins.length; i++){
            for(int amt = 1; amt <= amount; amt++){
                if(amt >= coins[i]){
                    memo[amt] = Math.min(memo[amt], memo[amt - coins[i]] + 1);
                }
            }
        }

        return memo[amount] == Integer.MAX_VALUE - 1 ? -1 : memo[amount];
    }
}
