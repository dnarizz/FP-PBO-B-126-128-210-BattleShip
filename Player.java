import java.util.*;

public class Player {
    private Board board;
    private Ship[] ships;
    private String name;

    public Player(String name) {
        this.name = name;
        board = new Board();
        ships = new Ship[] {
            new Ship(3), // Cruiser
        };
    }

    public String getName() {
        return name;
    }

    public Board getBoard() {
        return board;
    }

    public Ship[] getShips() {
        return ships;
    }

    public boolean allDestroyed() {
        for (Ship s : ships)
            if (!s.isDestroyed()) return false;
        return true;
    }
}
