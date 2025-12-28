package assignments.Ex2;


import classes.week6.Point2D;

public class Index2D implements Pixel2D {

    public static final double EPS1 = 0.001, EPS2 = Math.pow(EPS1, 2), EPS = EPS2;
    public static final Point2D ORIGIN = new Point2D(0, 0);

    private int _x;
    private int _y;

    public Index2D(int w, int h) {
        _x = w;
        _y = h;

    }

    public Index2D(Pixel2D other) {
        _x = other.getX();
        _y = other.getY();

    }


    @Override
    public int getX() {

        return this._x;
    }

    @Override
    public int getY() {

        return this._y;
    }

    @Override
    public double distance2D(Pixel2D p2) {
        if (p2 == null) {
            throw new RuntimeException("In the method distance2D: the variable can't get null");
        }
        double dx = this._x - p2.getX();
        double dy = this._y - p2.getY();
        double t = (dx * dx + dy * dy);
        return Math.sqrt(t);
    }


    @Override
    public String toString() {


        return "(" + this._x + "," + this._y + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Index2D) {
            Index2D p = (Index2D) obj;
            return p.getX() == this._x && p.getY() == this._y;
        }

        return false;
    }
}
