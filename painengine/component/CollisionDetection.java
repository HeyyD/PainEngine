package painengine.component;

import painengine.gameobject.GameObject;

import java.awt.Point;

import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

class CollisionDetection{

    private GameObject host;

    private List<Point> topPoints       = new LinkedList<>();
    private List<Point> rightPoints     = new LinkedList<>();
    private List<Point> bottomPoints    = new LinkedList<>();
    private List<Point> leftPoints      = new LinkedList<>();

    private Point topLeft;
    private Point bottomLeft;
    private Point topRight;
    private Point bottomRight;

    private Point topMid;
    private Point leftMid;
    private Point rightMid;
    private Point bottomMid;

    protected CollisionDetection(GameObject host){
        this.host = host;
        init();
    }

    private void init(){
        //Corners
        topLeft = new Point(host.getX(), host.getY());
        bottomLeft = new Point(host.getX(), host.getY() + host.getHeight());
        topRight = new Point(host.getX() + host.getWidth(), host.getY());
        bottomRight = new Point(host.getX() + host.getWidth(), host.getY() + host.getHeight());
        //Mid
        topMid = new Point(host.getX() + host.getWidth() / 2, host.getY());
        leftMid = new Point(host.getX(), host.getY() + host.getHeight() /2);
        rightMid = new Point(host.getX() + host.getWidth(), host.getY() + host.getHeight() / 2);
        bottomMid = new Point(host.getX() + host.getWidth() / 2, host.getY() + host.getHeight());

        topPoints.addAll(Arrays.asList(topLeft, topMid, topRight));
        rightPoints.addAll(Arrays.asList(topRight, rightMid, bottomRight));
        bottomPoints.addAll(Arrays.asList(bottomLeft, bottomMid, bottomRight));
        leftPoints.addAll(Arrays.asList(topLeft, leftMid, bottomLeft));
    }

    public void updatePosition(){
        topLeft.setLocation(host.getX(), host.getY());
        bottomLeft.setLocation(host.getX(), host.getY() + host.getHeight());
        topRight.setLocation(host.getX() + host.getWidth(), host.getY());
        bottomRight.setLocation(host.getX() + host.getWidth(), host.getY() + host.getHeight());
        
        topMid.setLocation(host.getX() + host.getWidth() / 2, host.getY());
        leftMid.setLocation(host.getX(), host.getY() + host.getHeight() /2);
        rightMid.setLocation(host.getX() + host.getWidth(), host.getY() + host.getHeight() / 2);
        bottomMid.setLocation(host.getX() + host.getWidth() / 2, host.getY() + host.getHeight());
    }

}