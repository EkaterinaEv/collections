package ru.netology.gameplayers;

import java.util.ArrayList;
import java.util.List;

public class Game {

    List<Player> playerList = new ArrayList<Player>();

    public void register(Player player) {
        playerList.add(player);
    }

    public Player findByName(String name) {
        for (Player player : playerList) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);

        if (player1 == null) {
            throw new NotRegisteredException(
                    "Player with name: " + playerName1 + " is not registered"
            );
        }
        if (player2 == null) {
            throw new NotRegisteredException(
                    "Player with name: " + playerName2 + " is not registered"
            );
        }
        if (player1.getStrength() == player2.getStrength()) {
            return 0;
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        return 2;
    }
}