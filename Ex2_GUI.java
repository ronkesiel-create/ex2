package assignments.Ex2;

import classes.week4.StdDraw;
import classes.week4.StdDrawTest;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Intro2CS_2026A
 * This class represents a Graphical User Interface (GUI) for Map2D.
 * The class has save and load functions, and a GUI draw function.
 * You should implement this class, it is recommender to use the StdDraw class, as in:
 * https://introcs.cs.princeton.edu/java/stdlib/javadoc/StdDraw.html
 *
 *
 */
public class Ex2_GUI {
    private static Map map = new Map(5);
    private static String mapFileName = map.toString();
    public static void drawMap(Map2D map) {

        StdDrawTest.drawMat(map.getMap());

    }

    /**
     * @param mapFileName
     * @return
     */
    public static Map2D loadMap(String mapFileName) {
        Map2D ans = null;
        return ans;



    }

    /**
     *
     * @param map
     * @param mapFileName
     */
    public static void saveMap(Map2D map, String mapFileName) {
        mapFileName = map.toString();
        StdDraw.save(mapFileName);
    }
    public static void main(String[] a) {
        String mapFile = "map.txt";
        Map2D map = loadMap(mapFile);
        drawMap(map);
    }
    /// ///////////// Private functions ///////////////

}
