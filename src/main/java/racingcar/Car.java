package racingcar;

import static constant.GameConstant.*;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public void race(){
        int randomNumber = Randoms.pickNumberInRange(RANDOM_NUMBER_START, RANDOM_NUMBER_END);
        if(randomNumber >= GO_FORWARD_NUMBER) {
            goForward();
        }
    }

    public int getPosition(){
        return position;
    }

    public void printPosition(){
        System.out.print(name + " : ");
        for(int i = 0; i<position; i++){
            System.out.print("-");
        }
    }

    private void goForward() {
        position++;
    }
}
