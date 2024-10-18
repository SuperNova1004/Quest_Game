package com.game;

public class GameLogic {

    private int currentStep;
    private boolean isGameOver;
    private Player player;

    public GameLogic(Player player) {

        this.player = player;
        this.currentStep = 1;
        this.isGameOver = false;
    }

    public String getCurrentQuestion() {
        if (isGameOver) {
            return "Игра завершена!";
        }

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

        System.out.println("Current Step: " + currentStep);
        System.out.println("Answer received: " + answer);

        switch (currentStep) {
            case 1:
                if (answer.equals("да")) {
                    currentStep++;
                    System.out.println("Moving to step 2");
                } else {
                    isGameOver = true;
                    System.out.println("Game over: выбрали нет на шаге 1");
                }
                break;
            case 2:
                if (answer.equals("Пойти вместе")) {
                    currentStep++;
                    System.out.println("Moving to step 3");
                } else {
                    isGameOver = true;
                    System.out.println("Game over: выбрали отказ на шаге 2");
                }
                break;
            case 3:
                if (answer.equals("Нет! Это твоя мама и она заслуживает самого лучшего")) {
                    isGameOver = true;
                    System.out.println("Game won on step 3");
                } else {
                    isGameOver = true;
                    System.out.println("Game over: выбрали экономию на шаге 3");
                }
                break;
            default:
                isGameOver = true;
                System.out.println("Default case triggered");
                break;
        }
    }


    public boolean isGameOver() {

        return isGameOver;
    }

    public Player getPlayer() {

        return player;
    }

    public void resetGame() {

        currentStep = 3;
        isGameOver = false;
    }
}


