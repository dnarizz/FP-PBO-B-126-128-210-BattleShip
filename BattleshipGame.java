import java.util.*;

public class BattleshipGame {
    private Player p1;
    private Player p2;
    private Scanner sc = new Scanner(System.in);

    public BattleshipGame() {
        p1 = new Player("Player 1");
        p2 = new Player("Player 2");
    }

    public void start() {
        System.out.println("=== Battleship 10x10 ===");

        setupPlayer(p1);
        setupPlayer(p2);

        battle();
    }

    private void setupPlayer(Player p) {
        System.out.println("\n=== " + p.getName() + " Set Your Ships ===");
        Board board = p.getBoard();
        board.displayForOwner();

        for (Ship s : p.getShips()) {
            boolean placed = false;
            while (!placed) {
                System.out.println("Place ship size " + s.getSize());
                System.out.print("Row (0-9): ");
                int r = sc.nextInt();
                System.out.print("Col (0-9): ");
                int c = sc.nextInt();
                System.out.print("Orientation (0 = horizontal, 1 = vertical): ");
                int orient = sc.nextInt();
                boolean h = (orient == 0);   

                placed = board.placeShip(s, r, c, h);
                if (!placed) System.out.println("Invalid position, try again!");
                board.displayForOwner();
            }
        }
    }

    private void battle() {
        Player current = p1;
        Player opponent = p2;

        while (true) {
            System.out.println("\n=== " + current.getName() + " TURN ===");
            System.out.println("Opponent board:");
            opponent.getBoard().displayFogOfWar();

            System.out.print("Enter row: ");
            int r = sc.nextInt();
            System.out.print("Enter col: ");
            int c = sc.nextInt();

            Tile t = opponent.getBoard().getTile(r, c);

            if (t.isHit()) {
                System.out.println("Already shot here!");
                continue;
            }

            t.hit();

            boolean hit = false;
            for (Ship s : opponent.getShips())
                if (s.checkHit(r, c))
                    hit = true;

            if (hit)
                System.out.println("HIT!");
            else
                System.out.println("MISS!");

            if (opponent.allDestroyed()) {
                System.out.println(current.getName() + " WINS!");
                break;
            }

            // Tukar giliran
            Player temp = current;
            current = opponent;
            opponent = temp;
        }
    }

    public static void main(String[] args) {
        BattleshipGame game = new BattleshipGame();
        game.start();
    }
}
