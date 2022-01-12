// https://programmers.co.kr/learn/courses/30/lessons/12928

function solution(n) {
    
    var sum = 0;
    
    for(var i=1; i<=n; i++) {
        if(n%i == 0)
            sum = sum + i;
    }
    
    return sum;
}