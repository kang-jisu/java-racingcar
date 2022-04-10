package racingcar;

public class Car {
    private static final int DEFAULT_STATE = 0;
    private final int maxState;
    private int state;

    Car(int maxState) {
        state = DEFAULT_STATE;
        this.maxState = maxState;
    }

    public void move() {
        if (state == maxState) {
            throw new IllegalStateException(String.format("자동차의 상태는 시도 횟수를 넘을 수 없습니다. 현재 상태: %d, 최대 횟수: %d", state, maxState));
        }
        state++;
    }

    public int getState() {
        return state;
    }
}
