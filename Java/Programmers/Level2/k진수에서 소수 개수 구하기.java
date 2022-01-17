class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        StringBuilder str = new StringBuilder();
        while(n > 0) {
            int p = n % k;
            n = n/k;
            str.insert(0, p);
        }

        String [] nums = str.toString().split("0+");
        for(String num : nums) {
            if(isPrime(Long.parseLong(num))) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isPrime(long num) {

        if(num == 1) {
            return false;
        } else if(num == 2) {
            return true;
        }

        for(long i = 2; i *i<=num; i++) {
            if(num%i == 0) {
                return false;
            }
        }
        return true;
    }
}