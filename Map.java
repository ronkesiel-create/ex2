package assignments.Ex2;

import java.io.Serializable;

/**
 * This class represents a 2D map (int[w][h]) as a "screen" or a raster matrix or maze over integers.
 * This is the main class needed to be implemented.
 *
 * @author boaz.benmoshe
 *
 */
public class Map implements Map2D, Serializable {

    private int _arr[][];


    /**
     * Constructs a w*h 2D raster map with an init value v.
     *
     * @param w
     * @param h
     * @param v
     * @throws RuntimeException if w or h are zero
     */
    public Map(int w, int h, int v) {
        if (w == 0 || h == 0) {
            throw new RuntimeException("the array is not legal");
        }
        init(w, h, v);

    }

    /**
     * Constructs a square map (size*size).
     *
     * @param size
     * @throws RuntimeException if size is zero
     */
    public Map(int size) {
        this(size, size, 0);
    }

    /**
     * Constructs a map from a given 2D array.
     *
     * @param data
     */
    public Map(int[][] data) {
        if (data == null) {
            throw new RuntimeException("the array is not legal");
        }
        if (data.length == 0) {
            throw new RuntimeException("the array arr is not legal");
        }
        if (data[0].length == 0) {
            throw new RuntimeException("the array arr is not legal");
        }
        if (!isRagged(data)) {
            throw new RuntimeException("the array arr is not legal");
        }
        init(data);

    }

    @Override
    public void init(int w, int h, int v) {
        _arr = new int[w][h];
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                _arr[i][j] = v;

            }
        }
    }

    @Override
    public void init(int[][] arr) {
        _arr = getDeepCopy(arr);

    }

    @Override
    public int[][] getMap() {

        return getDeepCopy(_arr);

    }

    @Override
    public int getWidth() {
        int ans = _arr.length;

        return ans;
    }

    @Override
    public int getHeight() {
        int ans = _arr[0].length;

        return ans;
    }

    @Override
    public int getPixel(int x, int y) {
        int ans = _arr[x][y];

        return ans;
    }

    @Override
    public int getPixel(Pixel2D p) {
        int ans = _arr[p.getX()][p.getY()];

        return ans;
    }

    @Override
    public void setPixel(int x, int y, int v) {
        _arr[x][y] = v;
    }

    @Override
    public void setPixel(Pixel2D p, int v) {
        _arr[p.getX()][p.getY()] = v;
    }
/**
     * This method checks if a given point is on the current map
     * @param p- a point to be checked on
     * @return if both width and height of the 2 map are equal
     */
    @Override
    public boolean isInside(Pixel2D p) {

        boolean x = (_arr.length > p.getX()) && (0 <= p.getX());
        boolean y = (_arr[0].length > p.getY()) && (0 <= p.getY());

        return x && y;
    }
/**
     * This method checks if a given map has the same dimensions as the current map
     * @param p- a map to be checked on
     * @return if both width and height of the 2 map are equal
     */
    @Override
    public boolean sameDimensions(Map2D p) {
        boolean w = (_arr.length == p.getWidth());
        boolean h = (_arr[0].length == p.getHeight());
        return w && h;
    }
/**
     * This method duplicates a given map
     * @param p- a map to be duplicated
     */
    @Override
    public void addMap2D(Map2D p) {
        if (sameDimensions(p)) {
            for (int i = 0; i < p.getWidth(); i++) {
                for (int j = 0; j < p.getHeight(); j++) {
                    _arr[i][j] += p.getPixel(i, j);
                }
            }
        }
    }
/**
     * This method draws A map given a scalar
     * @param scalar- a multiplier number
     */
    @Override
    public void mul(double scalar) {
        for (int i = 0; i < _arr.length; i++) {
            for (int j = 0; j < _arr[i].length; j++) {
                _arr[i][j] *= (int) scalar;
            }
        }
    }

    @Override
    public void rescale(double sx, double sy) {
        _arr = new int[(int) (_arr.length * sx)][(int) (_arr[0].length * sy)];
    }
/**
     * This method draws A circle given a point of Pixel2D, a radius and A color
     * @param canter- a point of Pixel2D
     * @param color- the color number
     * @param rad- the radius of the circle
     * The method is using a new point (current) in order to see draw the circle given it's distance from center and radius
     */
    @Override
    public void drawCircle(Pixel2D center, double rad, int color) {
        for (int i = 0; i < _arr.length; i++) {
            for (int j = 0; j < _arr[i].length; j++) {
                Index2D current = new Index2D(i, j);
                if (current.distance2D(center) <= rad) {
                    _arr[i][j] = color;
                }
            }
        }
    }
 /**
     * This method draws A Line given two points of Pixel2D and A color
     *
     * @param p1,p2- points of Pixel2D
     * @param color- the color number
     * The method get 2 new points with the help of p1,p2 in order to get the linear function
     * Draws the line with color using the linear function and the 2 given points
     */
    @Override
    public void drawLine(Pixel2D p1, Pixel2D p2, int color) {
        int dx = Math.abs(p1.getX() - p2.getX());
        int dy = Math.abs(p1.getY() - p2.getY());
        if (dx == 0 && dy == 0) {
            setPixel(p1, color);
        }
        if (dx >= dy) {
            double numerator = p1.getY() - p2.getY();
            double denominator = p1.getX() - p2.getX();
            double m = numerator / denominator;//denominator is certainly not 0
            double b = -m * p1.getX() + p1.getY();

            if (p1.getX() < p2.getX()) {
                for (int x = p1.getX(); x < p1.getX() + dx + 1; x++) {
                    setPixel(x, (int) Math.round((m * x) + b), color);
                }
            }
            if (p1.getX() > p2.getX()) {
                for (int x = p2.getX(); x < p2.getX() + dx + 1; x++) {
                    setPixel(x, (int) Math.round((m * x) + b), color);
                }
            }

        }
        if (dx < dy) {
            double denominator = p1.getY() - p2.getY();
            double numerator = p1.getX() - p2.getX();
            double m = numerator / denominator;//denominator is certainly not 0
            double b = -m * p1.getY() + p1.getX();


            if (p1.getY() < p2.getY()) {
                for (int y = p1.getY(); y < p1.getY() + dy + 1; y++) {
                    setPixel((int) Math.round((m * y) + b), y, color);
                }
            }
            if (p1.getY() > p2.getY()) {
                for (int y = p2.getY(); y < p2.getY() + dy + 1; y++) {
                    setPixel((int) Math.round((m * y) + b), y, color);
                }
            }

        }

    }
 /**
     * This method draws A Rectangle given two points of Pixel2D and A color
     *
     * @param p1,p2- points of Pixel2D
     * @param color- the color number
     * The method get 2 new points with the help of p1,p2 in order to draw the Rectangle
     */
    @Override
    public void drawRect(Pixel2D p1, Pixel2D p2, int color) {
        int minX = Math.min(p1.getX(), p2.getX());
        int minY = Math.min(p1.getY(), p2.getY());
        Index2D leftUpCorner = new Index2D(minX, minY);
        int rectWidth = Math.abs(p1.getX() - p2.getX()) + 1;
        int rectHeight = Math.abs(p1.getY() - p2.getY()) + 1;
        for (int x = leftUpCorner.getX(); x < leftUpCorner.getX() + rectWidth; x++) {
            for (int y = leftUpCorner.getY(); y < leftUpCorner.getY() + rectHeight; y++) {
                setPixel(x, y, color);
            }
        }
    }
 /**
     * This method checks whether the given object is equal to map type or not
     *
     * @param ob
     * @return True if ob is instanceof Map, False otherwise
     */
    @Override
    public boolean equals(Object ob) {
        if (!(ob instanceof Map)) {
            return false;
        }
        Map m = (Map) ob;

        if (_arr.length != m.getWidth() || _arr[0].length != m.getHeight()) {
            return false;
        }

        for (int i = 0; i < _arr.length; i++) {
            for (int j = 0; j < _arr[i].length; j++) {
                if (_arr[i][j] != m.getPixel(i, j)) {
                    return false;
                }

            }
        }
        return true;
    }


    @Override
/**
 * Fills this map with the new color (new_v) starting from p.
 * https://en.wikipedia.org/wiki/Flood_fill
 */
    public int fill(Pixel2D xy, int new_v, boolean cyclic) {
        int ans = -1;

        return ans;
    }

    @Override
/**
 * BFS like shortest the computation based on iterative raster implementation of BFS, see:
 * https://en.wikipedia.org/wiki/Breadth-first_search
 */
    public Pixel2D[] shortestPath(Pixel2D p1, Pixel2D p2, int obsColor, boolean cyclic) {
        Pixel2D[] ans = null;  // the result.

        return ans;
    }

    @Override
    public Map2D allDistance(Pixel2D start, int obsColor, boolean cyclic) {
        Map2D ans = null;  // the result.

        return ans;
    }
////////////////////// Private Methods ///////////////////////
///
    /**
     * This method checks whether the given 2D array is ragged or not
     *
     * @param arr
     * @return True if 2D array is ragged, False otherwise
     * @throws RuntimeException if arr == null or if the array is empty.
     */
    private boolean isRagged(int[][] arr) {

        int checkLength = arr[0].length;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != checkLength) {
                return false;
            }
        }
        return true;
    }


    /*
     * @throws RuntimeException
     */
    private int[][] getDeepCopy(int[][] arr) {

        int[][] copyArr = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                copyArr[i][j] = arr[i][j];

            }
        }
        return copyArr;
    }

    public void printMap() {
        for (int i = 0; i < _arr.length; i++) {
            for (int j = 0; j < _arr[i].length; j++) {
                System.out.print(_arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
