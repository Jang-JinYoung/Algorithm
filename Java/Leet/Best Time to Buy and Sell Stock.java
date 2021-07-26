//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/


class Solution {
    public int maxProfit(int[] prices) {


        int maxValue = Integer.MIN_VALUE;
        int sellDay = prices.length;
        int minValue = Integer.MAX_VALUE;
        int buyDay = 0;
        int res = 0;


        for(int i=0; i<prices.length; i++) {

            //MAX값보다 컸을때 계산
            if(maxValue < prices[i]) {
                maxValue = prices[i];
                sellDay = i;
            }

            //MIN값보다 작을때 계산
            if(minValue > prices[i] ) {
                minValue = prices[i];
                buyDay = i;
            }

            //만약 판매한 날짜가 구매한 날짜보다 앞설경우, 판매날짜 초기화
            if(sellDay < buyDay) {
                maxValue = Integer.MIN_VALUE;
                sellDay = prices.length;
            } else {
                if(res < maxValue - minValue)
                    res = maxValue - minValue;
            }

        }


        return res;
    }
}