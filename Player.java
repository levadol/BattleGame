import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
  * מחלקת השחקן מייצגת את השחקן במשחק "ספינת קרב".
  */
class Player {
    private Ocean ocean;
    private List<Ship> ships;
    private int playerNumber; 
/**
      * מעצב מחלקת שחקנים.
      * @param ocean אובייקט המייצג את האוקיינוס ​​עם ספינות עבור השחקן.
      */
    public Player(Ocean ocean, int playerNumber) {
        this.ocean = ocean;
        this.ships = new ArrayList<>();
        this.playerNumber = playerNumber;
    }
/**
      * שיטה להנחת ספינות על ידי השחקן.
      */

      /**
  * שיטה להנחת ספינות על ידי השחקן.
  * מבקש מהשחקן קואורדינטות להצבת ספינות באוקיינוס.
  * יוצר ספינה חדשה בגודל 2 תאים.
  * לאחר הנחת ספינה בהצלחה, מוסיף אותה לרשימת הספינות של השחקן.
  *השיטה חוזרת פעמיים להצבת שתי ספינות.
  */
    public void placeShips() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 2; i++) {
            Ship ship = new Ship(2);

            int shipNumber = i + 1;
            System.out.println("Player " + playerNumber + ", place ship " + shipNumber); 
            while (!ocean.placeShip(ship)) {
                System.out.println("Invalid coordinates. Try again.");
            }
            ships.add(ship);
        }
    }
/**
      * שיטה לתקיפת שחקן אחר.
      */
    public void attack() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Player " + playerNumber + ", enter coordinates to attack: "); 
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        ocean.attack(x, y);
    }

    public void displayOcean() {
        ocean.displayOcean();
    }

    @Override
    public String toString() {
        return "Player " + playerNumber; 
    }
}