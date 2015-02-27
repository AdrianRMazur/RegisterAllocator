package structures;

public class Piece {

	int index;
	String code; 
	Operation op[]=new Operation[3];
	int nextPiece;
	
	public Piece(Object regs[], int index){
		
		op[0]=new Operation((int)regs[0]);
		op[1]=new Operation((int)regs[1]);
		op[2]=new Operation((int)regs[2]);
		this.code=(String)regs[3];
		
		this.index=index; 
		nextPiece=index+1; 
		
	}
	
	public int[] getSrcRegs(){
		
		int []regs = new int[3];
		
		if(op[0].getSourceReg()==-1 && op[1].getSourceReg()==-1 && op[2].getSourceReg()==-1){
			return null;
		}
		regs[0]=op[0].getSourceReg();
		regs[1]=op[1].getSourceReg();
		regs[2]=op[2].getSourceReg();
		
		/*System.out.println(op[0].getSourceReg());
		System.out.println(op[1].getSourceReg());
		System.out.println(op[2].getSourceReg());*/
		
		return regs;
	}
	
	public void setNextUse(){
		
	}
	
	public void listOpRegs(){
		System.out.print(this.code+ " ");
		System.out.print(op[0].getSourceReg()+ " ");
		System.out.print(op[1].getSourceReg()+ " ");
		System.out.print("=> ");
		System.out.print(op[2].getSourceReg()+" ");
		System.out.println("");
		System.out.println("-----------");
	}
	

	
	
}
