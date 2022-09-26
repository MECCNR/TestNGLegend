package ru.netology.service;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CashbackHackServiceTestTwo {

    public CashbackHackService adv = new CashbackHackService();

    @Test
    public void boundaryTest() {
        int actual = adv.remain(900);
        int expected = 100;
        assertEquals(expected, actual);
    }

    @Test
    // ЗДЕСЬ ОШИБКА
    // в случае с ровно тысячей программа требует от вас все 1000 рублей
    public void boundaryEqualTest() {;
        int actual = adv.remain(1000);
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    // ЗДЕСЬ ДРУГАЯ ОШИБКА!
    // в этом случае он требует все 990 рублей
    public void boundaryMoreThanTest() {
        int actual = adv.remain(3010);
        int expected = 0;
        assertEquals(expected, actual);
    }
}