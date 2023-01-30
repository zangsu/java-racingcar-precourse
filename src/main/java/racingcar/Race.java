package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

/**
 * 고민 1 : 어짜피 객체가 자기 위치를 기억할건데, 내가 Map을 사용해야 하나?
 * 	-> 기억하지 말고, 매번 받아오자.
 */
public class Race {

	int NORMAL_NAME_LENGTH = 5;
	String ERROR_MESSEGE = "[ERROR] ";
	int maxRound;
	ArrayList<Car> carList = new ArrayList<>();

	public void run(){
		try {
			makeCarList();
			inputIterRound();
		}catch (IllegalArgumentException e){
			System.out.println(e);
		}
		play();
		printCampion(getChampion());
	}

	private void makeCarList(){
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String[] carNameList = Console.readLine().split(",");
		for(String car : carNameList){
			if(car.length() > NORMAL_NAME_LENGTH){
				throw new IllegalArgumentException(ERROR_MESSEGE + "이름의 길이는 5자 이하여야 합니다.");
			}
			Car newCar = new Car(car);
			carList.add(newCar);
		}
	}

	private void inputIterRound(){
		System.out.println("시도할 회수는 몇회인가요?");
		String inputRound = Console.readLine();
		for(int i = 0; i<inputRound.length(); i++){
			if(inputRound.charAt(i) < '0' || inputRound.charAt(i) > '9'){
				throw new IllegalArgumentException(ERROR_MESSEGE + "시도 횟수는 숫자여야 합니다.");
			}
		}
		maxRound = Integer.parseInt(inputRound);

	}
	// 각 라운드 반복

	private void play() {
		System.out.println("실행결과");
		for(int i = 0; i<maxRound; i++){
			playOneRound();
			System.out.println();
		}
	}
	private void playOneRound(){
		for (Car car : carList) {
			car.race();
		}
	}

	//우승자 출력
	private List<String> getChampion() {
		int maxPosition = 0;
		ArrayList<String> championName = new ArrayList<>();
		for (Car car : carList) {
			if(car.getPosition() == maxPosition){
				championName.add(car.getName());
			}
			if(car.getPosition() > maxPosition){
				maxPosition = car.getPosition();
				championName.clear();
				championName.add(car.getName());
			}
		}
		return championName;
	}
	// 결과 출력
	private void printCampion(List<String> championName){
		System.out.print("최종 우승자 : ");
		int size = championName.size();
		for (int i = 0; i< size; i++) {
			System.out.print(championName.get(i));
			if(i<size - 1)
				System.out.print(", ");
		}
	}
}
