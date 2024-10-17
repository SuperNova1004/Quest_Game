package com.game;

public class GameLogic {

    private int currentStep;
    private boolean isGameOver;
    private Player player;
    private String gameResult; // Новый атрибут для хранения результата игры

    public GameLogic(Player player) {
        this.player = player;
        this.currentStep = 1;
        this.isGameOver = false;
        this.gameResult = "";
    }

    public String getCurrentQuestion() {
        switch (currentStep) {
            case 1:
                return "У твоей тёщи день рождения! Пойдёшь выбирать подарок? (да/нет)";
            case 2:
                // Дальнейшая логика будет добавлена
                return "Продолжение квеста...";
            default:
                return "Ты завершил своё приключение!";
        }
    }

    public void processAnswer(String answer) {
        if (isGameOver) return;

        switch (currentStep) {
            case 1:
                if (answer.equalsIgnoreCase("Да")) {

                    currentStep++; // Переход на следующий шаг
                } else if (answer.equalsIgnoreCase("Нет")) {

                    isGameOver = true;
                    gameResult = "Ты плохой зять"; // Поражение
                }
                break;

            // Дополнительная логика для следующих шагов
            default:
                isGameOver = true;
                break;
        }
    }

    public boolean isGameOver() {

        return isGameOver;
    }

    public String getGameResult() {

        return gameResult;
    }

    public Player getPlayer() {

        return player;
    }

    public int getCurrentStep() {

        return currentStep;
    }

    public void resetGame() {

        currentStep = 1;
        isGameOver = false;
        gameResult = "";
    }
}

