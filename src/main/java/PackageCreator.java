import java.io.File;

public class PackageCreator {
    public static void createPackage(String name) {
        File dir = new File(name);
        if (dir.exists()) {
            LogCreator.logCreator("Папка " + name + " уже создана");
        } else {
            boolean result = false;
            try {
                dir.mkdir();
                result = true;
                LogCreator.logCreator("Папка " + name + " создана");
            } catch (SecurityException se) {
            }
        }
    }
}