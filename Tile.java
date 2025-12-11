public class Tile {
    private boolean hasShip;
    private boolean isHit;

    public Tile() {
        hasShip = false;
        isHit = false;
    }

    public boolean hasShip() {
        return hasShip;
    }

    public void placeShip() {
        hasShip = true;
    }

    public boolean isHit() {
        return isHit;
    }

    public void hit() {
        isHit = true;
    }

    @Override
    public String toString() {
    if (!isHit) return "~";   // belum diserang

    // Jika sudah ditembak:
    if (hasShip) return "1";  // HIT
    else return "0";          // MISS
}

}
