// https://programmers.co.kr/learn/courses/30/lessons/12939

import java.util.Arrays;
import java.util.stream.Stream;

class Solution {
    public String solution(String s) {

        Integer [] nums = Stream.of(s.split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        return Arrays.stream(nums).min(Integer::compareTo).get() + " " + Arrays.stream(nums).max(Integer::compareTo).get();
    }
}