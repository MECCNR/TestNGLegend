package ru.netology.service;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CashbackHackServiceTest {

    public CashbackHackService adv = new CashbackHackService();

    @Test
    public void boundaryTest() {
        int actual = adv.remain(900);
        int expected = 100;
        assertEquals(expected, actual);
    }

    @Test(expectedExceptions = java.lang.AssertionError.class)
    // ЗДЕСЬ ОШИБКА
    // в случае с ровно тысячей программа не заправшивает у вас 100 рублей, а вместо этого он
    // требует от вас все 1000
    public void boundaryEqualTest() {
        int actual = adv.remain(1000);
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test(expectedExceptions = java.lang.AssertionError.class)
    // ЗДЕСЬ ДРУГАЯ ОШИБКА
    // в этом случае вместо 90 рублей он требует все 990
    public void boundaryMoreThanTest() {
        int actual = adv.remain(3010);
        int expected = 90;
        assertEquals(expected, actual);
    }
}