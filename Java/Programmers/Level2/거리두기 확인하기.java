// https://programmers.co.kr/learn/courses/30/lessons/81302

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int [places.length];

        //맨해튼 거리가 2 이하로 앉지 말아 주세요. -> t1(r1,c1), t2(r2, c2) -> abs(r1-r2) + abs(c1-c2)
//        P는 응시자가 앉아있는 자리를 의미합니다.
//        O는 빈 테이블을 의미합니다.
//        X는 파티션을 의미합니다.

        int pCount = 0;

        for(int i=0; i<places.length; i++) {

            String temp[][] = new String[5][5];
            //settting
            for(int j=0; j<places[i].length; j++) {
                for(int k=0; k<places[i][j].length(); k++) {
                    temp[j][k] = places[i][j].charAt(k) + "";
                    if(temp[j][k].equals("P")) {
                        pCount++;
                    }
                }
            }

            //연산
            answer[i] = 1;
            for(int j=0; j<places[i].length; j++) {
                for(int k=0; k<places[i][j].length(); k++) {

                    if(temp[j][k].equals("P")) {
                        //좌-우 검사
                        for(int x=1; x<=2; x++) {
                            //좌 검사
                            if(k-x >= 0) {
                                if (x == 1) {
                                    if (temp[j][k - x].equals("P")) {
                                        answer[i] = 0;
                                        break;
                                    }
                                } else {
                                    if (temp[j][k - 1].equals("O") && temp[j][k - x].equals("P")) {
                                        answer[i] = 0;
                                        break;
                                    }
                                }
                            }

                            //우 검사
                            if(k+x < 5) {
                                if (x == 1) {
                                    if (temp[j][k + x].equals("P")) {
                                        answer[i] = 0;
                                        break;
                                    }
                                } else {
                                    if (temp[j][k + 1].equals("O") && temp[j][k + x].equals("P")) {
                                        answer[i] = 0;
                                        break;
                                    }
                                }
                            }

                            //상 검사
                            if(j-x >= 0) {
                                if(x == 1) {
                                    if(temp[j-x][k].equals("P")) {
                                        answer[i] = 0;
                                        break;
                                    }
                                } else {
                                    if(temp[j-1][k].equals("O") && temp[j-x][k].equals("P")) {
                                        answer[i] = 0;
                                        break;
                                    }
                                }
                            }
                            
                            //하 검사
                            if(j+x < 5) {
                                if(x == 1) {
                                    if(temp[j+x][k].equals("P")) {
                                        answer[i] = 0;
                                        break;
                                    }
                                } else {
                                    if(temp[j+1][k].equals("O") && temp[j+x][k].equals("P")) {
                                        answer[i] = 0;
                                        break;
                                    }
                                }
                            }
                        }

                        //대각 검사
                        if(temp[j][k].equals("P")) {
                            //좌상
                            if((j != 0 && k != 0) && temp[j-1][k-1].equals("P")) {
                                if(temp[j-1][k].equals("O") || temp[j][k-1].equals("O")) {
                                    answer[i] = 0;
                                    break;
                                }
                            }
                            //우상
                            if((j != 0 && k != 4) && temp[j-1][k+1].equals("P")) {
                                if(temp[j-1][k].equals("O") || temp[j][k+1].equals("O")) {
                                    answer[i] = 0;
                                    break;
                                }
                            }
                            //좌하
                            if((j != 4 && k != 0) && temp[j+1][k-1].equals("P")) {
                                if(temp[j][k-1].equals("O") || temp[j+1][k].equals("O")) {
                                    answer[i] = 0;
                                    break;
                                }
                            }
                            //우하
                            if((j != 4 && k != 4) && temp[j+1][k+1].equals("P")) {
                                if(temp[j][k+1].equals("O") || temp[j+1][k].equals("O")) {
                                    answer[i] = 0;
                                    break;
                                }
                            }
                        }


                    }

                }
            }
        }

        // for(int i=0; i<answer.length; i++) {
        //     System.out.println(answer[i]);
        // }


        return answer;
    }
}