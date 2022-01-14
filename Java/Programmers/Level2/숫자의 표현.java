// https://programmers.co.kr/learn/courses/30/lessons/12924

class Solution {
    public int solution(int n) {
        int answer = 0;

        for(int i=1; i<=n; i++) {
            boolean bool = true;
            int sum = i;
            int j = 0;

            for(j=i+1; j<=n; j++) {
                if(sum + j == n) {
                    break;
                } else if(sum + j > n) {
                    bool = false;
                    break;
                } else {
                    sum += j;
                }
            }

            if(bool) {
                answer++;
            }
        }

        return answer;
    }
}

// 주어진 자연수를 연속된 자연수의 합으로 표현하는 방법의 수는 주어진 수의 홀수 약수의 개수와 같다라는 정수론 정리