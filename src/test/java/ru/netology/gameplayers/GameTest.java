package ru.netology.gameplayers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Player player1 = new Player(1, "Анна", 2);
    Player player2 = new Player(2, "Сергей", 4);
    Player player3 = new Player(3, "Андрей", 2);


    @Test
    public void roundTest1() {
        Game roundPlayer = new Game();
        roundPlayer.register(player1);
        roundPlayer.register(player2);

        int expected = 2;
        int actual = roundPlayer.round("Анна", "Сергей");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void roundTest2() {
        Game roundPlayer = new Game();
        roundPlayer.register(player1);
        roundPlayer.register(player3);

        int expected = 0;
        int actual = roundPlayer.round("Анна", "Андрей");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void roundTest3() {
        Game roundPlayer = new Game();
        roundPlayer.register(player2);
        roundPlayer.register(player3);

        int expected = 1;
        int actual = roundPlayer.round("Сергей", "Андрей");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void NotRegisteredExceptionTest1() {
        Game roundPlayer = new Game();
        roundPlayer.register(player1);
        roundPlayer.register(player3);
        Assertions.assertThrows(NotRegisteredException.class, () ->
        {
            roundPlayer.round("Анна", "Сергей");
        });
    }

    @Test
    public void NotRegisteredExceptionTest2() {
        Game roundPlayer = new Game();
        roundPlayer.register(player1);
        roundPlayer.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, () ->
        {
            roundPlayer.round("Андрей", "Сергей");
        });
    }

    @Test
    public void NotRegisteredExceptionTest3() {
        Game roundPlayer = new Game();
        roundPlayer.register(player2);
        roundPlayer.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, () ->
        {
            roundPlayer.round("Анна", "Андрей");
        });
    }
}
