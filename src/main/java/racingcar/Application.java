package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();

        List<Player> players = game.registerPlayers();
        int numberOfAttempts = game.registerNumberOfAttempts();

        for (int i = 0; i < numberOfAttempts; i++) {
            game.playGame(players);
            game.printGameResult(players);
        }

        game.printWinner(players);
    }
}
