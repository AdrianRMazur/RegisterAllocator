package structures;

public class Piece {

	int index; 
	String code; 
	Operation op[]=new Operation[3];
	int nextPiece;
	
	
	public void addFirstOp(Operation o){
		
		this.op[0]=o; 
		
	}
	
	public void addSecondOp(Operation o){
		
		this.op[1]=o; 
		
	}
	
	public void addThirdOp(Operation o){
		
		this.op[2]=o; 
		
	}
	
	
}
