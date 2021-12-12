import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class NearestPointinTwoAxis {
	
	private Point best1, best2;
    private double bestDistance = Double.POSITIVE_INFINITY;
	
	
	public NearestPointinTwoAxis(List<Point>points,int numberOfPoints) {
		
		// sort by x-coordinate (breaking ties by y-coordinate via stability)
        Point[] pointsByX = new Point[numberOfPoints];
        for (int i = 0; i < numberOfPoints; i++)
            pointsByX[i] = points.get(i);
        Arrays.sort(pointsByX, Point.Y_ORDER);
        Arrays.sort(pointsByX, Point.X_ORDER);

        // check for incident points
        for (int i = 0; i < numberOfPoints-1; i++) {
            if (pointsByX[i].equals(pointsByX[i+1])) {
                bestDistance = 0.0;
                best1 = pointsByX[i];
                best2 = pointsByX[i+1];
                return;
            }
        }

        // sort by y-coordinate (but not yet sorted) 
        Point[] pointsByY = new Point[numberOfPoints];
        for (int i = 0; i < numberOfPoints; i++)
            pointsByY[i] = pointsByX[i];


        bestDistance = closest(pointsByX, pointsByY, 0, numberOfPoints-1);
	}
	
	
	
	private double closest(Point[] pointsByX, Point[] pointsByY, int lo, int hi) {
		
		if (hi-lo <=3) return bruteForce(pointsByX,lo,hi);

        int mid = lo + (hi - lo) / 2;
        Point median = pointsByX[mid];

        // compute closest pair with both endpoints in left subarray or both in right subarray
        double delta1 = closest(pointsByX, pointsByY, lo, mid);
        double delta2 = closest(pointsByX, pointsByY, mid+1, hi);
        double delta = Math.min(delta1, delta2);
        
     // Build an array strip[] that contains points close (closer than d)
        // to the line passing through the middle point
        Point strip[] = new Point[hi];
        int j = 0;
        for (int i = 0; i < hi; i++) {
            if (Math.abs(pointsByY[i].getX() - median.getX()) < delta) {
            	strip[j] = pointsByY[i];
            	j++;
            }
        }     
     
        // Find the closest points in strip.  Return the minimum of d and closest
        // distance is strip[]
        return stripClosest(strip, j, delta);

	}



	private double bruteForce(Point[] P, int lo, int hi) {
		// TODO Auto-generated method stub
		double min = Double.POSITIVE_INFINITY;
	    for (int i = lo; i < hi; ++i) {
	        for (int j = i+1; j < hi; ++j) {
	            if (dist(P[i], P[j]) < min) {
	                min = dist(P[i], P[j]);
	                best1 = P[i];
	                best2 = P[j];
	            }
	        }
	    }
	    return min;
	}



	private double stripClosest(Point[] strip, int size, double delta) {
		double min = delta;  // Initialize the minimum distance as d
		 
	    // Pick all points one by one and try the next points till the difference
	    // between y coordinates is smaller than d.
	    // This is a proven fact that this loop runs at most 6 times
	    for (int i = 0; i < size; ++i)
	        for (int j = i+1; j < size && (strip[j].getY() - strip[i].getY()) < min; ++j)
	            if (dist(strip[i],strip[j]) < min) {
	                min = dist(strip[i], strip[j]);
	                best1 = strip[i];
	                best2 = strip[j];
	            }
	 
	    return min;
	}



	private double dist(Point p1, Point p2) {
		// TODO Auto-generated method stub
		return Math.sqrt( (p1.getX() - p2.getX())*(p1.getX() - p2.getX()) +
                (p1.getY() - p2.getY())*(p1.getY() - p2.getY())
              );
	}



	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		try {
			int numberOfPoints = sc.nextInt();
			if(numberOfPoints <=1)
			{
				System.out.println("Points less than two");
			}
			else {
				List<Point> points = new ArrayList<Point>();
				for(int i=0;i<numberOfPoints;i++) {
					int x = sc.nextInt();
					int y = sc.nextInt();
					Point newPoint = new Point(x,y);
					points.add(newPoint);
				}
				NearestPointinTwoAxis obj = new NearestPointinTwoAxis(points,numberOfPoints);
				System.out.println(obj.bestDistance);
				System.out.println(obj.best1.getX()+","+obj.best1.getY());
				System.out.println(obj.best2.getX()+","+obj.best2.getY());
			}
			
		}
		finally {
			sc.close();
		}
	}

}

class Point{
	
	private int x;
	private int y;
	public Point(int x, int y) {
		this.x =x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	/**
     * Compares two points by x-coordinate.
     */
    public static final Comparator<Point> X_ORDER = new XOrder();

    /**
     * Compares two points by y-coordinate.
     */
    public static final Comparator<Point> Y_ORDER = new YOrder();
    
    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (other.getClass() != this.getClass()) return false;
        Point that = (Point) other;
        return this.x == that.x && this.y == that.y;
    }
	
}

//compare points according to their x-coordinate
class XOrder implements Comparator<Point> {
	
	@Override
    public int compare(Point p, Point q) {
        if (p.getX() < q.getX()) return -1;
        if (p.getX() > q.getX()) return +1;
        return 0;
    }
}

// compare points according to their y-coordinate
class YOrder implements Comparator<Point> {
	
	@Override
    public int compare(Point p, Point q) {
        if (p.getY() < q.getY()) return -1;
        if (p.getY() > q.getY()) return +1;
        return 0;
    }
}