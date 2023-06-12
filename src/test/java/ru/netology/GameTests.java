package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class GameTests {

    Player player1 = new Player(1, "Иван", 93);
    Player player2 = new Player(2, "Аня", 75);
    Player player3 = new Player(3, "Антон", 69);
    Player player4 = new Player(4, "Маша", 75);

    Game game = new Game();

    @BeforeEach
    public void setup() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
    }

    @Test
    public void shouldRoundWhenWinFistPlayer() {
        int expected = 1;
        int actual = game.round("Иван", "Антон");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRoundWhenWinSecondPlayer() {
        int expected = 2;
        int actual = game.round("Антон", "Аня");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRoundWhenNoPlayerWin() {
        int expected = 0;
        int actual = game.round("Аня", "Маша");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRoundWhenFirstPlayerNotRegistered() {

        Assertions.assertThrows(NotRegisteredException.class, ()-> {
            game.round("Света", "Маша");
        });
    }

    @Test
    public void shouldRoundWhenSecondPlayerNotRegistered() {

        Assertions.assertThrows(NotRegisteredException.class, ()-> {
            game.round("Антон", "Андрей");
        });

    }

    @Test
    public void shouldRoundWhenTwoPlayersNotRegistered() {

        Assertions.assertThrows(NotRegisteredException.class, ()-> {
            game.round("Света", "Оля");
        });
    }
}