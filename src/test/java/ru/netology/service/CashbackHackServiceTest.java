package ru.netology.service;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class CashbackHackServiceTest {

    public CashbackHackService adv = new CashbackHackService();
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void boundaryTest() {
        int actual = adv.remain(900);
        int expected = 100;
        assertEquals(expected, actual);
    }

    @Test
    // ЗДЕСЬ ОШИБКА
    // в случае с ровно тысячей программа не заправшивает у вас 100 рублей, а вместо этого он
    // требует от вас все 1000
    public void boundaryEqualTest() {
        exceptionRule.expect(java.lang.AssertionError.class);
        int actual = adv.remain(1000);
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    // ЗДЕСЬ ДРУГАЯ ОШИБКА!
    // в этом случае вместо 90 рублей он требует все 990
    public void boundaryMoreThanTest() {
        exceptionRule.expect(java.lang.AssertionError.class);
        int actual = adv.remain(3010);
        int expected = 0;
        assertEquals(expected, actual);
    }
}