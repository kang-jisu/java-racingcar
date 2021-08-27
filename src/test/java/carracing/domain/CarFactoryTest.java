package carracing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarFactoryTest {

    @Test
    @DisplayName("자동차 이름이 담긴 배열을 받으면 그 수만큼 자동차 list를 반환할 수 있어야 한다.")
    void makeCarTest() {

        // given
        String[] names = {"자동차1", "자동차2", "자동차3"};

        // when
        List<Car> cars = CarFactory.makeCars(names);

        // then
        assertThat(cars.size()).isEqualTo(names.length);
        assertThat(cars.get(0).name()).isEqualTo(new Name(names[0]));
        assertThat(cars.get(1).name()).isEqualTo(new Name(names[1]));
        assertThat(cars.get(2).name()).isEqualTo(new Name(names[2]));
    }

}