package racingcar;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Distance;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Distance 클래스 테스트")
public class DistanceTest {

    public static final Distance TEST_DISTANCE = Distance.ZERO;
    public static final Distance ZERO = Distance.ZERO;
    public static final Distance ONE = Distance.ONE;

    @Test
    @DisplayName("0미만의 값을 생성하면 예외가 발생한다.")
    void negativeValueTest() {
        assertThatThrownBy(() -> new Distance(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("add 메서드를 이용해서 두 Distance 를 더할 수 있다.")
    void addTest() {
        Distance one = new Distance(1);
        Distance two = new Distance(2);

        assertThat(Distance.add(one, two)).isEqualTo(new Distance(3));
    }

    @Test
    @DisplayName("compareTo 를 이용해 두 Distance 를 비교한다")
    void compareToTest() {
        assertThat(new Distance(1).compareTo(new Distance(2))).isEqualTo(-1);
    }

    @Test
    @DisplayName("stream max를 이용해 Distance 리스트의 max 값을 구한다.")
    void getMaxDistanceTest() {
        // given
        Distance threeDistance = new Distance(3);
        Distance fourDistance = new Distance(4);
        Distance fiveDistance = new Distance(5);
        List<Distance> distances = Lists.newArrayList(threeDistance, fourDistance, fiveDistance);

        // when
        Distance maxDistance = distances.stream()
                .max(Distance::compareTo)
                .orElseThrow(IllegalStateException::new);

        // then
        assertThat(maxDistance).isEqualTo(fiveDistance);
    }
}
