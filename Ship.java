/*מחלקת הספינה מייצגת ספינה במשחק "ספינת קרב" */
class Ship {
    public int size;
    private int hits;
    private boolean isSunk;
/**
      * קונסטרוקטור לכיתה ספינה.
      * גודל @param גודל הספינה.
      */
    public Ship(int size) {
        this.size = size;
        this.hits = 0;
        this.isSunk = false;
    }
/**
      * שיטה לקביעה אם ספינה טובעת.
      * @return true אם הספינה טבעה, false אחרת.
      */
    public boolean isSunk() {
        return isSunk;
    }
/**
      * שיטה לחשבון פגיעות באונייה.
      */
    public void hit() {
        hits++;
        if (hits >= size) {
            isSunk = true;
        }
    }
}
