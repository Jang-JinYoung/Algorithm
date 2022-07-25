function solution(s) {
  for(let i=0; i<map.length; i++) {
    while(s.includes(map[i]['key'])) {
      s = s.replace(map[i]['key'], map[i]['value']);
      if(!s.includes(map[i]['key']))
        break;
    }
  }
  return Number(s);
}


let map = [
  {"key" : "zero", "value" : 0},
  {"key" : "one", "value" : 1},
  {"key" : "two", "value" : 2},
  {"key" : "three", "value" : 3},
  {"key" : "four", "value" : 4},
  {"key" : "five", "value" : 5},
  {"key" : "six", "value" : 6},
  {"key" : "seven", "value" : 7},
  {"key" : "eight", "value" : 8},
  {"key" : "nine", "value" : 9},
]

let s = "1zerotwozero3"
console.log(solution(s));

/*
function solution(s) {
    let numbers = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"];
    var answer = s;

    for(let i=0; i< numbers.length; i++) {
        let arr = answer.split(numbers[i]);
        answer = arr.join(i);
    }

    return Number(answer);
}
*/
