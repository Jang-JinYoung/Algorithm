function solution(strings, n) {
  var answer = strings.sort((a,b) => {
    let c1 = a.charAt(n);
    let c2 = b.charAt(n);
    if(c1 < c2)
      return -1;
    else if(c1 > c2)
      return 1;
    else if(c1 == c2) {
      if(a < b) {
        return -1;
      } else {
        return 1;
      }
    }
  });
  return answer;
}

/*
function solution(strings, n) {
    return strings.sort((s1, s2) => s1[n] === s2[n] ? s1.localeCompare(s2) : s1[n].localeCompare(s2[n]));
}
*/