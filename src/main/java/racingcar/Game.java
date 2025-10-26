package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
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
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        validateNumberOfAttempts(input);
        return Integer.parseInt(input);
    }

    private void validateNumberOfAttempts(String input) {
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

    // 게임 실행 메소드
    public void playGame(List<Player> players) {
        for (Player player : players) {
            checkRandomNumber(player);
        }
    }

    private void checkRandomNumber(Player player) {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            player.position++;
        }
    }

    // 현재 상황 출력 메소드
    public void printGameResult(List<Player> players) {
        for (Player player : players) {
            System.out.println(player.name + " : " + "-".repeat(player.position));
        }
        System.out.println();
    }

    // 승자 출력 메소드
    public void printWinner(List<Player> players) {
        int maxPosition = findMaxPosition(players);
        List<String> winners = findWinners(players, maxPosition);

        String resultMessage = "최종 우승자 : " + String.join(", ", winners);

        System.out.println(resultMessage);
    }

    private int findMaxPosition(List<Player> players) {
        int maxPosition = -1;

        for (Player player : players) {
            maxPosition = Math.max(maxPosition, player.position);
        }

        return maxPosition;
    }

    private List<String> findWinners(List<Player> players, int maxPosition) {
        List<String> winners = new ArrayList<>();

        for (Player player : players) {
            if (player.position == maxPosition) {
                winners.add(player.name);
            }
        }

        return winners;
    }
}
