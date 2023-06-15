/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author mastermac
 */
public class OsUtils {

    private static String OS = null;

    public static String getOsName() {
        if (OS == null) {
            OS = System.getProperty("os.name");
        }
        return OS;
    }

    public static boolean isWindows() {
        return getOsName().startsWith("Windows");
    }

    public static boolean isMac() {
        return getOsName().startsWith("Mac");
    }

    public static String getUsersFolder() {
        return System.getProperty("user.home");
    }

    public static String getOSPathBar() {
        if (getOsName().startsWith("Windows")) {
            return "\\";
        } else {
            return "/";
        }
    }

}
