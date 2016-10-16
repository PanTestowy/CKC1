
public class Position {
	private int x, y;
	public Position(){
		
	}
	
	public void setX(int x){
		if(x<99 && x>0)
			this.x=x;
	}
	
	public void setY(int y){
		if(y<29 && y>0)
			this.y=y;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
}
