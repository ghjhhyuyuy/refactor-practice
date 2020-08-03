package com.twu.refactoring;

public class Direction {
    private final char direction;
    private String directions = "ESWN";
    public Direction(char direction) {
        this.direction = direction;
    }

    public Direction turnRight() {
        int index = directions.indexOf(String.valueOf(direction));
        if(index < 0){
            throw new IllegalArgumentException();
        }
        return new Direction(directions.toCharArray()[(index + 1)%4]);
    }

    public Direction turnLeft() {
        int index = directions.indexOf(String.valueOf(direction));
        if(index < 0){
            throw new IllegalArgumentException();
        }
        return new Direction(directions.toCharArray()[(index + 3)%4]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Direction direction1 = (Direction) o;

        if (direction != direction1.direction) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) direction;
    }

    @Override
    public String toString() {
        return "Direction{direction=" + direction + '}';
    }
}
