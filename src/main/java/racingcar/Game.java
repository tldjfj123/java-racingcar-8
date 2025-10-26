package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 게임 진행에 필요한 메소드들을 모은 class
 */
public class Game {

    public Game() {
    }

    // 플레이어 등록 메소드
    public List<Player> registerPlayers() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] names = input.split(",");

        List<Player> players = new ArrayList<>();
        for (String name : names) {
            String trimmedName = name.trim();
            validatePlayerName(trimmedName);
            players.add(new Player(trimmedName, 0));
        }
        return players;
    }

    private void validatePlayerName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
    }

    // 실행 횟수 등록 메소드
    public int registerNumberOfAttempts() {
        // 구현 예정
        return 0;
    }

    // 게임 실행 메소드
    public void playGame(List<Player> players) {
        // 구현 예정
    }

    // 현재 상황 출력 메소드
    public void printGameResult(List<Player> players) {
        // 구현 예정
    }

    // 승자 출력 메소드
    public void printWinner(List<Player> players) {
        // 구현 예정
    }
}
