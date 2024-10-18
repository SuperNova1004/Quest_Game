package com.game;

public class GameLogic {

    private int currentStep;
    private boolean isGameOver;
    private String message;
    private Player player;

    public GameLogic(Player player) {
        this.player = player;
        this.currentStep = 1;
        this.isGameOver = false;
        this.message = "";
    }

    public String getCurrentQuestion() {
        switch (currentStep) {
            case 1:
                return "У тёщи сегодня день рождения! Пойдёшь покупать подарки?";
            case 2:
                return "Пойдёшь выбирать вместе с женой?";
            case 3:
                return "Вы пришли в магазин. Предложить выбрать подарок подешевле?";
            default:
                return "Вы завершили игру!";
        }
    }

    public void processAnswer(String answer) {
        if (isGameOver) return;

        switch (currentStep) {
            case 1:
                if (answer.equals("да")) {
                    currentStep++;
                } else {
                    message = "Ты плохой зять";
                    isGameOver = true;
                }
                break;
            case 2:
                if (answer.equals("Пойти вместе")) {
                    currentStep++;
                } else {
                    message = "Ты просто не любишь свою жену!";
                    isGameOver = true;
                }
                break;
            case 3:
                if (answer.equals("Нет! Это твоя мама и она заслуживает самого лучшего")) {
                    message = "Вы купили хороший подарок, тёща и жена были очень довольны. Вы, " + player.getName() + ", хороший муж и зять!";
                    isGameOver = true;
                } else {
                    message = "Ты не ценишь свою тёщу и оскорбил жену!";
                    isGameOver = true;
                }
                break;
        }
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public Player getPlayer() {
        return player;
    }

    public String getMessage() {
        return message;
    }

    public void resetGame() {
        currentStep = 1;
        isGameOver = false;
        message = "";
    }
}



