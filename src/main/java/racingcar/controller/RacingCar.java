package racingcar.controller;

import racingcar.dto.InputCars;
import racingcar.dto.RoundResult;
import racingcar.model.Cars;
import racingcar.model.MovingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class RacingCar {
    private final Cars cars;
    private final int roundCount;

    public RacingCar(InputCars inputCars, int roundCount) {
        validate(roundCount);

        this.roundCount = roundCount;
        this.cars = inputCars.value();
    }

    private void validate(int roundCount) {
        if (isNegative(roundCount)) {
            throw new IllegalArgumentException("주어진 횟수는 0 이상이어야 합니다. 입력 값 : " + roundCount);
        }
    }

    private boolean isNegative(int value) {
        return value < 0;
    }

    public List<RoundResult> play(MovingStrategy movingStrategy) {
        List<Cars> results = new ArrayList<>();
        for (int count = 0; count < roundCount; count++) {
            playAndAdd(results, movingStrategy);
        }
        return results.stream()
                .map(result -> RoundResult.of(result.names(), result.distances()))
                .collect(Collectors.toList());
    }

    private void playAndAdd(List<Cars> results, MovingStrategy movingStrategy) {
        if (results.isEmpty()) {
            results.add(cars.play(movingStrategy));
            return;
        }

        Cars currentCars = results.get(results.size() - 1);
        results.add(currentCars.play(movingStrategy));
    }
}
