package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName() == name) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        Player player1;
        Player player2;
        if (findByName(playerName1) == null) {
            throw new NotRegisteredException(
                    "Игрок с именем " + playerName1 + " не зарегистрирован");
        }
        player1 = findByName(playerName1);

        if (findByName(playerName2) == null) {
            throw new NotRegisteredException(
                    "Игрок с именем " + playerName2 + " не зарегистрирован");
        }
        player2 = findByName(playerName2);

        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }
        return 0;
    }
}