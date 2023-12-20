package com.saroka.codewars;

public class SoFixItSpaceship {
    private int totalSpace;

    private int spaceForBuildingsLeft;
    private int maxBuildingHeightLeft;
    private int maxBuildingIndexLeft;

    private int spaceForBuildingsRight;
    private int maxBuildingHeightRight;
    private int maxBuildingIndexRight;

    public int material(int[] spaceBase) {
        if (spaceBase == null) {
            throw new IllegalArgumentException("Spaceship can't be null!");
        }

        return getTotalSpace(spaceBase);
    }

    private int getTotalSpace(int[] spaceBase) {
        initializeVariablesForScan(spaceBase);

        int leftPointer = 0;
        int rightPointer = spaceBase.length - 1;

        while (rightPointer >= 0) {
            doStepScanToRightSide(leftPointer, spaceBase);
            doStepScanToLeftSide(rightPointer, spaceBase);

            leftPointer++;
            rightPointer--;
        }

        return totalSpace;
    }

    private void initializeVariablesForScan(int[] spaceBase) {
        totalSpace = 0;

        spaceForBuildingsLeft = 0;
        maxBuildingHeightLeft = spaceBase[0];
        maxBuildingIndexLeft = 0;

        spaceForBuildingsRight = 0;
        maxBuildingHeightRight = spaceBase[spaceBase.length - 1];
        maxBuildingIndexRight = spaceBase.length - 1;
    }

    private void doStepScanToLeftSide(int index, int[] spaceBase) {
        int currentBuilding = spaceBase[index];
        if (currentBuilding > maxBuildingHeightRight) {
            totalSpace += (Math.abs(index - maxBuildingIndexRight)) * maxBuildingHeightRight - spaceForBuildingsRight;
            maxBuildingHeightRight = currentBuilding;
            maxBuildingIndexRight = index;
            spaceForBuildingsRight = currentBuilding;
        } else {
            spaceForBuildingsRight += currentBuilding;
        }
    }

    private void doStepScanToRightSide(int index, int[] spaceBase) {
        int currentBuilding = spaceBase[index];
        if (currentBuilding >= maxBuildingHeightLeft) {
            totalSpace += (Math.abs(index - maxBuildingIndexLeft)) * maxBuildingHeightLeft - spaceForBuildingsLeft;
            maxBuildingHeightLeft = currentBuilding;
            maxBuildingIndexLeft = index;
            spaceForBuildingsLeft = currentBuilding;
        } else {
            spaceForBuildingsLeft += currentBuilding;
        }
    }
}
