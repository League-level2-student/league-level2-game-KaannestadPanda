
public class CollisionCircle {
	int x;
	int y;
	int radius;
	
	
	CollisionCircle(int newX,int newY,int newRadius){
		
		x=newX;
		y=newY;
		radius=newRadius;
		
	
		
	}
	
	boolean intersectsCircle(CollisionCircle c) {
		int maxDistance=radius+c.radius;
		int changeInX=Math.abs(x-c.x);
		int changeInY=Math.abs(y-c.y);
		
		
		double distance= Math.sqrt((changeInY*changeInY)+(changeInX*changeInX));
		
		if(distance<=maxDistance) {
			return true;
		}
		
		return false;
		
	}
	
	boolean intersectsSquare(Buttonn b) {
		return false;
		
	}
	
	void setBounds(int xx, int yy) {
		
		
		x=xx;
		y=yy;
	}
	
	
	
	
	
	
	
	
}
