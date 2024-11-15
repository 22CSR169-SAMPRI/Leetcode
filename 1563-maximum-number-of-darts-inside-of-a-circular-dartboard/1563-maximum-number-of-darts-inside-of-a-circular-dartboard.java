class Solution {
    public int numPoints(int[][] darts, int r) {
        DartCounter counter=new DartCounter();
        return counter.getNumPoints(darts, r);
    }
}


class DartCounter{
    int getNumPoints(int darts[][],int r){
        int maxPoints=1;
        Point points[]=makePoints(darts);
        List<Circle> goodCricles = getGoodCircles(points,r);
        for(Circle oneGoodCircle:goodCricles){
            int pointsInCircle=countPointInside(oneGoodCircle, points);
            maxPoints=Math.max(maxPoints, pointsInCircle);
        }
        return maxPoints;
    }
    List<Circle> getGoodCircles(Point points[],int radius){
        CircleBuilder builder = new CircleBuilder();
        List<Circle> circles=new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                if(points[i].distance(points[j])>radius*2){
                    continue;
                }
                List<Circle> twoPointCircles=builder.buildCircle(points[i], points[j], radius);
                circles.addAll(twoPointCircles);
            }
        }
        return circles;
    }
    int countPointInside(Circle circle, Point points[]){
        int insidePoints=0;
        for(int i=0;i<points.length;i++){
            if(circle.insideCircle(points[i])){
                insidePoints++;
            }
        }
        return insidePoints;
    }
    Point[] makePoints(int darts[][]){
        Point points[]=new Point[darts.length];
        for (int i = 0; i < points.length; i++) {
            points[i]=new Point(darts[i][0],darts[i][1]);
        }
        return points;
    }
}
class CircleBuilder{
    List<Circle> buildCircle(Point p1,Point p2,int radius){
        Point midPoint=p1.midPoint(p2);
        double distance=p1.distance(p2);
        double distanceToMidPoint=distance/2;
        double midPointToCenter = Math.sqrt(radius*radius-distanceToMidPoint*distanceToMidPoint);
        double centerX1 = midPoint.x + midPointToCenter * (p2.y-p1.y)/distance;
        double centerY1 = midPoint.y - midPointToCenter * (p2.x-p1.x)/distance;
        double centerX2 = midPoint.x - midPointToCenter * (p2.y-p1.y)/distance;
        double centerY2 = midPoint.y + midPointToCenter * (p2.x-p1.x)/distance;
        Circle circle1=new Circle(radius, new Point(centerX1,centerY1));
        Circle circle2=new Circle(radius, new Point(centerX2,centerY2));
        return List.of(circle1,circle2);
    }
}
class Point{
    double x,y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    Point midPoint(Point other){
        return new Point((x+other.x)/2,(y+other.y)/2);
    }
    double distance(Point other){
        double xDistnace=x-other.x;
        double yDistnace=y-other.y;
        return Math.sqrt(xDistnace*xDistnace+yDistnace*yDistnace);
    }
    double slope(Point other){
        return -((other.x-x) / (other.y-y));
    }

    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }
    
}
class Circle{
    double radius;
    Point center;

    public Circle(int radius, Point center) {
        this.radius = radius;
        this.center = center;
    }

    @Override
    public String toString() {
        return "Circle{" + "radius=" + radius + ", center=" + center + '}';
    }
    
    boolean insideCircle(Point point){
        return point.distance(center) - radius<=0.000000001;
    }
}