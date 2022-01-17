import java.util.*;

class Solution {

    static HashMap<String, Car> carMap = new HashMap<>();

    public int[] solution(int[] fees, String[] records) {

        for(String record : records) {
            String [] temp = record.split(" ");

            if(!carMap.containsKey(temp[1])) {// 차량 기록이 없다면
                carMap.put(temp[1], new Car(temp[1], temp[0], "23:59", true));
            } else { // 차량 기록이 있다면
                if(temp[2].equals("IN")) { // 들어오는 차량일 시
                    carMap.get(temp[1]).inTime = temp[0]; // 들어오는 시간 설정
                    carMap.get(temp[1]).outTime = "23:59"; // 나가는 시간 설정
                    carMap.get(temp[1]).status = true; // 차 들어옴
                } else { // 나가는 차량일 시
                    carMap.get(temp[1]).outTime = temp[0]; // 나가는 시간 설정
                    setParkingTime(temp[1]); // 시간 계산
                }
            }
        }

        // 차량 번호가 작은 자동차부터 청구할 주차 요금을 차례대로 정수 배열에 담아서 return 하도록 solution 함수를 완성해주세요.
        String [] keySet = carMap.keySet().toArray(new String[0]);
        Arrays.sort(keySet);
        int [] answer = new int[keySet.length];
        int i = 0;

        for(String carNo : keySet) { // 나머지 계산
            if(carMap.get(carNo).status) {// 나가지 않았다면
                setParkingTime(carNo); // 시간 계산
            }
            // 요금 계산
            setFee(fees, carNo);
            answer[i++] = carMap.get(carNo).fee;
        }

        return answer;
    }

    private void setFee(int[] fees, String carNo) {
        // 0 기본 시간 1 기본 요금 2 단위 시간 3 단위 요금
        // ⌈a⌉ : a보다 작지 않은 최소의 정수를 의미합니다. 즉, 올림을 의미합니다. -> Math.ceil
        carMap.get(carNo).fee = fees[1];
        if(carMap.get(carNo).parkingTime > fees[0]) { // 기본 시간을 넘어 스면
            carMap.get(carNo).fee += Math.ceil((double) (carMap.get(carNo).parkingTime - fees[0]) / fees[2]) * fees[3];
        }
    }

    private void setParkingTime(String carNo) {

        String inTime = carMap.get(carNo).inTime; // 들어오는 시간
        String outTime = carMap.get(carNo).outTime; // 나가는 시간
        
        int inHour = Integer.parseInt(inTime.substring(0, 2));
        int inMin = Integer.parseInt(inTime.substring(3));
        int outHour = Integer.parseInt(outTime.substring(0, 2));
        int outMin = Integer.parseInt(outTime.substring(3));

        int parkingTime = ((outHour * 60) +  outMin) - ((inHour * 60) + inMin);
        carMap.get(carNo).parkingTime = carMap.get(carNo).parkingTime + parkingTime;

        carMap.get(carNo).status = false; // 차 나감
    }
}

class Car {
    String carNo;
    String inTime;
    String outTime;
    int parkingTime;
    boolean status;
    int fee;

    public Car(String carNo, String inTime, String outTime, boolean status) {
        this.carNo = carNo;
        this.inTime = inTime;
        this.outTime = outTime;
        this.parkingTime = 0;
        this.status = status;
    }

}