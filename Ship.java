public class Ship {
    private int size;
    private int hits;
    private int[][] coordinates;

    public Ship(int size) {
        this.size = size;
        this.hits = 0;
        coordinates = new int[size][2];
    }

    public int getSize() {
        return size;
    }

    public void setCoordinate(int index, int row, int col) {
        coordinates[index][0] = row;
        coordinates[index][1] = col;
    }

    public boolean checkHit(int r, int c) {
        for (int i = 0; i < size; i++) {
            if (coordinates[i][0] == r && coordinates[i][1] == c) {
                hits++;
                return true;
            }
        }
        return false;
    }

    public boolean isDestroyed() {
        return hits >= size;
    }
}
