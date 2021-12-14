package ru.mirea.task16;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    public void Ghost() {

        HashMap <String, Integer> expected = Board.Ghost();

        HashMap <String, Integer> actual = new HashMap<>();
        actual.put("PAC_ANIM_DELAY", 2);
        actual.put("PACMAN_ANIM_COUNT", 4);
        actual.put("MAX_GHOSTS", 12);
        actual.put("PACMAN_SPEED", 6);
        actual.put("pacAnimDir", 1);
        actual.put("pacmanAnimPos", 0);

        Assert.assertEquals(expected, actual);
    }

}