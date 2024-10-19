package com.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameLogicTest {

    private GameLogic gameLogic;

    @BeforeEach
    void test_setUp() {

        Player player = new Player("Тестовый игрок");
        gameLogic = new GameLogic(player);
    }

    @Test
    void test_InitialQuestion() {

        // Проверяем первый шаг
        assertEquals("У тёщи сегодня день рождения! Пойдёшь покупать подарки?", gameLogic.getCurrentQuestion());
    }

    @Test
    void test_CorrectPath() {

        // Проверка правильного пути до победы
        gameLogic.processAnswer("да");
        assertEquals("Пойдёшь выбирать вместе с женой?", gameLogic.getCurrentQuestion());

        gameLogic.processAnswer("Пойти вместе");
        assertEquals("Вы пришли в магазин. Предложить выбрать подарок подешевле?", gameLogic.getCurrentQuestion());

        gameLogic.processAnswer("Нет! Это твоя мама и она заслуживает самого лучшего");
        assertTrue(gameLogic.isGameOver());
    }

    @Test
    void test_WrongAnswerStep1() {

        // Проверка неправильного ответа на первом шаге
        gameLogic.processAnswer("нет");
        assertTrue(gameLogic.isGameOver());
    }

    @Test
    void test_WrongAnswerStep2() {
        // Правильный ответ на первом шаге
        gameLogic.processAnswer("да");
        // Неправильный ответ на втором шаге
        gameLogic.processAnswer("Отказаться идти вдвоём");
        assertTrue(gameLogic.isGameOver());
    }

    @Test
    void test_WrongAnswerStep3() {

        // Правильные ответы до третьего шага
        gameLogic.processAnswer("да");
        gameLogic.processAnswer("Пойти вместе");
        // Неправильный ответ на третьем шаге
        gameLogic.processAnswer("Да! Нам нужно экономить");
        assertTrue(gameLogic.isGameOver());
    }

    @Test
    void test_ResetGame() {

        // Проверяем перезапуск игры
        gameLogic.processAnswer("да");
        gameLogic.processAnswer("Пойти вместе");
        gameLogic.processAnswer("Да! Нам нужно экономить");

        // Перезапускаем игру
        gameLogic.resetGame();
        assertEquals("У тёщи сегодня день рождения! Пойдёшь покупать подарки?", gameLogic.getCurrentQuestion());
        assertFalse(gameLogic.isGameOver());
    }
}
