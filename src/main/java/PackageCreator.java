import java.io.File;

public class PackageCreator {
    public static void createPackage(String name) {
        File dir = new File(name);

        if (!dir.exists()) {
            boolean result = false;
            try {
                dir.mkdir();
                result = true;
            } catch (SecurityException se) {
            }
        }
    }
}