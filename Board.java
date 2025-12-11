public class Board {
    private Tile[][] grid;
    public static final int SIZE = 10;

    public Board() {
        grid = new Tile[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                grid[i][j] = new Tile();
    }

    public boolean placeShip(Ship ship, int row, int col, boolean horizontal) {
        int size = ship.getSize();

        if (horizontal) {
            if (col + size > SIZE) return false;
            for (int c = col; c < col + size; c++)
                if (grid[row][c].hasShip()) return false;
        } else {
            if (row + size > SIZE) return false;
            for (int r = row; r < row + size; r++)
                if (grid[r][col].hasShip()) return false;
        }

        for (int i = 0; i < size; i++) {
            int r = horizontal ? row : row + i;
            int c = horizontal ? col + i : col;
            grid[r][c].placeShip();
            ship.setCoordinate(i, r, c);
        }

        return true;
    }

    public Tile getTile(int r, int c) {
        return grid[r][c];
    }

    public void displayForOwner() {
    System.out.println("  0 1 2 3 4 5 6 7 8 9");
    for (int r = 0; r < SIZE; r++) {
        System.out.print(r + " ");
        for (int c = 0; c < SIZE; c++) {
            Tile t = grid[r][c];

            if (!t.isHit()) {
                
                if (t.hasShip()) System.out.print("S "); 
                else System.out.print("~ ");
            } else {
                System.out.print(t.toString() + " ");
            }
        }
        System.out.println();
    }
}


    public void displayFogOfWar() {
    System.out.println("  0 1 2 3 4 5 6 7 8 9");
    for (int r = 0; r < SIZE; r++) {
        System.out.print(r + " ");
        for (int c = 0; c < SIZE; c++) {
            System.out.print(grid[r][c].toString() + " ");
        }
        System.out.println();
    }
}

}
