// https://programmers.co.kr/learn/courses/30/lessons/17683?language=java#

class Solution {
    public String solution(String m, String[] musicinfos) {

        //조건이 일치하는 음악이 없을 때에는 “(None)”을 반환한다.
        String answer = "(None)";

        int max = 0;
        for(String musicinfo : musicinfos) {
            String [] temp = musicinfo.split(",");

            String begin = temp[0];
            String end = temp[1];
            String title = temp[2];
            String music = replaceMusic(temp[3]);

            int size = music.length();

            // 시작 시간 + 시간 분
            int beginHour = Integer.parseInt(begin.substring(0, 2));
            int beginMin = Integer.parseInt(begin.substring(3));

            // 종료 시간 + 종료 분
            int endHour = Integer.parseInt(end.substring(0, 2));
            int endMin = Integer.parseInt(end.substring(3));

            //시간
            int time = ((endHour*60)+endMin)-((beginHour*60)+beginMin);

            StringBuilder line = new StringBuilder();

            for(int i=0; i<time; i++) {
                line.append(music.charAt(i % size));
            }

            m = replaceMusic(m);
            // 조건이 일치하는 음악이 여러 개일 때에는 라디오에서 재생된 시간이 제일 긴 음악 제목을 반환한다.
            // 재생된 시간도 같을 경우 먼저 입력된 음악 제목을 반환한다.
            if(max < time && line.toString().contains(m)) {
                answer = title;
                max = time;
            }
        }


        return answer;
    }

    public String replaceMusic(String music) {

        // C, C#, D, D#, E, F, F#, G, G#, A, A#, B
        String [][] temp = {{"A#", "C#", "D#", "F#", "G#"}, {"V", "W", "X", "Y", "Z"}};
        for(int i=0; i<temp[0].length; i++) {
            music = music.replace(temp[0][i], temp[1][i]);
        }
        return music;
    }
}