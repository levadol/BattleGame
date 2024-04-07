/**
  * מחלקה OceanBattle מייצגת יישום של משחק ספינת הקרב.
  */
import java.util.Scanner;
/**
  * מחלקת מעצבים של OceanBattle.
  * יוצר מופע חדש של אוקיינוס ​​המשחק, מאתחל את שדה המשחק בתאים ריקים.
  * גודל מגרש המשחקים נקבע על פי קבוע SIZE.
  */
class OceanBattle implements Ocean {
    private char[][] oceanGrid;
    private static final int SIZE = 6; 
    private int totalShips = 0;

    public OceanBattle() {
        oceanGrid = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                oceanGrid[i][j] = ' ';
            }
        }
    }

    @Override
    public void displayOcean() {
        System.out.println("  0 1 2 3 4 5");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(oceanGrid[i][j] + " ");
            }
            System.out.println();
        }
    }
/**
  * שיטה להנחת ספינה באוקיינוס ​​המשחק.
  * המשתמש מזין את הקואורדינטות של תא ההתחלה של הספינה ומציין את הכיוון שלה (אופקי או אנכי).
  * בודק אפשרות למקם ספינה בקואורדינטות שצוינו.
  * אם הספינה מוצבת בהצלחה, היא מעדכנת את שדה המשחק ומגדילה את מונה הספינות שהוצבו.
  * @param ship הספינה שיש להציב.
  * @return true אם הספינה הוצבה בהצלחה, false אחרת.
  */
    @Override
    public boolean placeShip(Ship ship) {
        Scanner scanner = new Scanner(System.in);
        
       
        System.out.println("Enter the column number (0-9) for the ship: ");
        int column = scanner.nextInt();
    
        
        System.out.println("Enter the row number (0-9) for the ship: ");
        int row = scanner.nextInt();
    
        
        System.out.println("Enter 'true' for horizontal orientation or 'false' for vertical orientation: ");
        boolean horizontal = scanner.nextBoolean();
    
        
        if (horizontal) {
            for (int i = 0; i < ship.size; i++) {
                if (column + i >= SIZE || oceanGrid[column + i][row] != ' ') {
                    return false;
                }
            }
            for (int i = 0; i < ship.size; i++) {
                oceanGrid[column + i][row] = 'S';
            }
        } else {
            for (int i = 0; i < ship.size; i++) {
                if (row + i >= SIZE || oceanGrid[column][row + i] != ' ') {
                    return false;
                }
            }
            for (int i = 0; i < ship.size; i++) {
                oceanGrid[column][row + i] = 'S';
            }
        }
        totalShips++;
        return true;
    }
/**
  * שיטה לתקיפה בקואורדינטות שצוינו באוקיינוס ​​המשחק.
  * בודק את תוכן התא בקואורדינטות שצוינו.
  * אם יש ספינה בתא ('S'), אז מסמן אותה כפגומה ('X') ומחזיר אמת.
  * אם אין ספינה בתא, אז מסמן את התא כפספוס ('-') ומחזיר false.
  * @param x קואורדינטת ה-x של ההתקפה.
  * @param y קואורדינטת ה-y של ההתקפה.
  * @return true אם ההתקפה הצליחה והספינה נפגעת, אחרת שקר.
  */
    @Override
    public boolean attack(int x, int y) {
        if (oceanGrid[x][y] == 'S') {
            oceanGrid[x][y] = 'X';
            return true;
        } else {
            oceanGrid[x][y] = '-';
            return false;
        }
    }

    @Override
    public boolean isAllShipsSunk() {
        return totalShips == 0;
    }
}
