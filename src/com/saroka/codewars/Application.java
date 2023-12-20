package com.saroka.codewars;

public class Application {
    public static final String MESSAGE = "actual: %d <-> expected: %d%n";
    private final SoFixItSpaceship spaceship = new SoFixItSpaceship();

    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }

    private void run() {
        int[] baseOne = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] baseTwo = {0, 1, 0, 2, 1, 0, 3, 1, 0, 1, 2};
        int[] baseThree = {4, 2, 0, 3, 2, 5};
        int[] baseFour = {6, 4, 2, 0, 3, 2, 0, 3, 1, 4, 5, 3, 2, 7, 5, 3, 0, 1, 2, 1, 3, 4, 6, 8, 1, 3};
        int[] baseFive = {6, 2, 1, 1, 8, 0, 5, 5, 0, 1, 8, 9, 6, 9, 4, 8, 0, 0};

        System.out.printf(MESSAGE, spaceship.material(baseOne), 6);
        System.out.printf(MESSAGE, spaceship.material(baseTwo), 8);
        System.out.printf(MESSAGE, spaceship.material(baseThree), 9);
        System.out.printf(MESSAGE, spaceship.material(baseFour), 83);
        System.out.printf(MESSAGE, spaceship.material(baseFive), 50);
    }
}
