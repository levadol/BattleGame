/**
  * מחלקת OceanDisplayConsole מייצגת את תפוקת הקונסולה של המצב הנוכחי של האוקיינוס.
  */
public class OceanDisplayConsole {
    private Ocean ocean;
/**
      * מחלקת מעצבים OceanDisplayConsole.
      * @param ocean אובייקט המייצג את האוקיינוס.
      */
    public OceanDisplayConsole(Ocean ocean) {
        this.ocean = ocean;
    }
/**
      * שיטה להצגת המצב הנוכחי של האוקיינוס ​​בקונסולה.
      */
    public void displayOcean() {
        ocean.displayOcean();
    }
}
