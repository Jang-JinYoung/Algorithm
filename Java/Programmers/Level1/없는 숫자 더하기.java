//https://programmers.co.kr/learn/courses/30/lessons/86051

class Solution {
    public int solution(int[] numbers) {
    
    	boolean visited[] = new boolean[10];
    	int answer = 0;
    	
    	for(int i=0; i<numbers.length; i++) {
    		visited[numbers[i]] = true;
    	}
    	
    	for(int i=0; i<visited.length; i++) {
    		if(!visited[i]) {
    			answer = answer + i;
    		}
    	}
    	
    	
        return answer;
    }
}