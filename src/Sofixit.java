public class Sofixit {

    public static int material(int[] spaceship) {

        int totalSpace = 0;
        int spaceForBuildings = 0;
        int maxBuildingHeight = spaceship[0];
        int maxBuildingIndex = 0;

        // Left-to-right scan
        for (int i = 0; i < spaceship.length; i++) {
            int building = spaceship[i];
            if (building >= maxBuildingHeight) {
                totalSpace += (i - maxBuildingIndex) * maxBuildingHeight - spaceForBuildings;
                maxBuildingHeight = building;
                maxBuildingIndex = i;
                spaceForBuildings = building;
            } else {
                spaceForBuildings += building;
            }
        }

        spaceForBuildings = 0;
        maxBuildingHeight = spaceship[spaceship.length - 1];
        maxBuildingIndex = spaceship.length - 1;

        // Right-to-left scan
        for (int i = spaceship.length - 1; i > -1; i--) {
            int building = spaceship[i];
            if (building > maxBuildingHeight) {
                totalSpace += (maxBuildingIndex - i) * maxBuildingHeight - spaceForBuildings;
                maxBuildingHeight = building;
                maxBuildingIndex = i;
                spaceForBuildings = building;
            } else {
                spaceForBuildings += building;
            }
        }

        return totalSpace;
    }

    public static void main(String[] args) {

        int[] firstBase = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] secondBase = {0, 1, 0, 2, 1, 0, 3, 1, 0, 1, 2};
        int[] thirdBase = {4, 2, 0, 3, 2, 5};
        int[] fourthBase = {6, 4, 2, 0, 3, 2, 0, 3, 1, 4, 5, 3, 2, 7, 5, 3, 0, 1, 2, 1, 3, 4, 6, 8, 1, 3};
        int[] fifthBase = {6, 2, 1, 1, 8, 0, 5, 5, 0, 1, 8, 9, 6, 9, 4, 8, 0, 0};


        System.out.printf("actual: %d <-> expected: %d%n", material(firstBase), 6);
        System.out.printf("actual: %d <-> expected: %d%n", material(secondBase), 8);
        System.out.printf("actual: %d <-> expected: %d%n", material(thirdBase), 9);
        System.out.printf("actual: %d <-> expected: %d%n", material(fourthBase), 83);
        System.out.printf("actual: %d <-> expected: %d%n", material(fifthBase), 50);
    }
}
