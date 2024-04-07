import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Интерфейс Ocean
interface Ocean { /* */
    void displayOcean(); /*שיטה להצגת המצב הנוכחי של האוקיינוס */      
    boolean placeShip(Ship ship);/* שיטה להצגת המצב הנוכחי של האוקיינוס* */
    boolean attack(int x, int y);/*שיטה לבדוק אם כל הספינות באוקיינוס ​​טובעות */
    boolean isAllShipsSunk();/*שיטה לבדוק אם כל הספינות באוקיינוס ​​טובעות */
}