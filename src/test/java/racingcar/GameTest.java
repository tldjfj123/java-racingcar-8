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

    @Test
    @DisplayName("실행 결과 출력 테스트 - position 값에 따라 '-'가 올바르게 출력된다")
    void printGameResult_printsCorrectly() {
        // given
        Game game = new Game();
        Player pobi = new Player("pobi", 3);
        Player woni = new Player("woni", 0);
        Player jun = new Player("jun", 5);

        // when
        game.printGameResult(List.of(pobi, woni, jun));

        // then
        assertThat(output()).contains("pobi : ---", "woni : ", "jun : -----");
    }

    @Test
    @DisplayName("우승자 출력 테스트 - 단독 우승자를 올바르게 출력한다")
    void printWinner_printsSingleWinner() {
        // given
        Game game = new Game();
        Player pobi = new Player("pobi", 5);
        Player woni = new Player("woni", 2);

        // when
        game.printWinner(List.of(pobi, woni));

        // then
        assertThat(output()).contains("최종 우승자 : pobi");
    }

    @Test
    @DisplayName("우승자 출력 테스트 - 공동 우승자를 쉼표로 구분하여 올바르게 출력한다")
    void printWinner_printsJointWinners() {
        // given
        Game game = new Game();
        Player pobi = new Player("pobi", 5);
        Player woni = new Player("woni", 2);
        Player jun = new Player("jun", 5);

        // when
        game.printWinner(List.of(pobi, woni, jun));

        // then
        assertThat(output()).contains("최종 우승자 : pobi, jun");
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
