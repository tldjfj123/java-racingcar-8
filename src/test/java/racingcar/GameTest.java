package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class GameTest extends NsTest {

    @Test
    @DisplayName("전진 조건 테스트 - 랜덤 숫자가 4 이상이면 position이 1 증가한다")
    void playGame_movesForward_when_randomNumberIs4OrMore() {
        // given
        Game game = new Game();
        Player player = new Player("pobi", 0);
        int movingNumber = 4; // 4 이상인 전진 조건 값

        // when
        assertRandomNumberInRangeTest(
            () -> game.playGame(List.of(player)),
            movingNumber
        );

        // then
        assertThat(player.position).isEqualTo(1);
    }

    @Test
    @DisplayName("정지 조건 테스트 - 랜덤 숫자가 4 미만이면 position이 변하지 않는다")
    void playGame_stops_when_randomNumberIsLessThan4() {
        // given
        Game game = new Game();
        Player player = new Player("pobi", 0);
        int stopNumber = 3; // 4 미만인 정지 조건 값

        // when
        assertRandomNumberInRangeTest(
            () -> game.playGame(List.of(player)),
            stopNumber
        );

        // then
        assertThat(player.position).isEqualTo(0);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
