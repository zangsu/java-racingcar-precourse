package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

/**
 * 고민 1 : 어짜피 객체가 자기 위치를 기억할건데, 내가 Map을 사용해야 하나?
 */
public class Race {

	int NORMAL_NAME_LENGTH = 5;
	String ERROR_MESSEGE = "[ERROR] ";
	HashMap<Car, Integer> carPosition = new HashMap<>();
	int maxRound;

	private void makeCarList(){
		String[] carList = Console.readLine().split(",");
		for(String car : carList){
			if(car.length() > NORMAL_NAME_LENGTH){
				throw new IllegalArgumentException(ERROR_MESSEGE + "이름의 길이는 5자 이하여야 합니다.");
			}
			Car newCar = new Car(car);
			carPosition.put(newCar, 0);
		}
	}
	private void inputIterRound(){
		String inputRound = Console.readLine();
		for(int i = 0; i<inputRound.length(); i++){
			if(inputRound.charAt(i) < '0' || inputRound.charAt(i) > '9'){
				throw new IllegalArgumentException(ERROR_MESSEGE + "시도 횟수는 숫자여야 합니다.");
			}
		}
		maxRound = Integer.parseInt(Console.readLine());

	}
	public void run(){
		try {
			makeCarList();
			inputIterRound();
		}catch (IllegalArgumentException e){
			System.out.println(e);
		}
		for(int i = 0; i<maxRound; i++){
			playOneRound();
			printRoundResult();
		}
		getChampion();
		printCampion();
	}

	// 각 라운드 반복
	private void playOneRound(){}
	/*
	Car 객체에서의 메서드 실행을 통해 전진시킨다.
	Map 을 이용해 라운드 종료 이후의 위치를 기억한다.
	 */

	private void printRoundResult(){}

	//우승자 출력
	private List<String> getChampion() { return new ArrayList<>();}
	// 결과 출력
	private void printCampion(){}
}
