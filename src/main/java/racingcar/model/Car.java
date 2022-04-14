package racingcar.model;

import java.util.Objects;

public final class Car {
    private static final Distance MOVE_STATE = new Distance(PositiveInteger.ONE);
    private final PositiveInteger state;

    public Car() {
        this.state = PositiveInteger.ZERO;
    }

    public Car(PositiveInteger state) {
        validate(state);
        this.state = state;
    }

    private void validate(PositiveInteger state) {
        Objects.requireNonNull(state, "Car 생성시 전달된 state 가 올바르지 않습니다. : state is null");
    }

    public Car move(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            return new Car(PositiveInteger.add(state, MOVE_STATE.value()));
        }
        return new Car(new PositiveInteger(state.value()));
    }

    public PositiveInteger state() {
        return state;
    }
}