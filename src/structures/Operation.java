package structures;

public class Operation {

	int sourceReg; 
	int physicalReg;
	int nextUse; 
	int firstUse;
	int lastUse; 
	
	
	public Operation(int source, int physical){
		this.sourceReg=source;
		this.physicalReg=-1; 
		this.nextUse=-1; 
		this.firstUse=-1;
		this.lastUse=-1; 
	}
	
	public int getNextUse(){
		return this.nextUse;
	}
	
	public String SourceReg(){
		return "r"+sourceReg;
	}
	
	public String PhysicalReg(){
		return "p"+physicalReg;	
	}
	
	public int liveRange(){
		return lastUse - firstUse; 
	}
	
	public void setSourceReg(int s){
		this.sourceReg=s;
		
	}
	
	public void setPhysical(int p){
		this.physicalReg=p; 
	}
	
	public void setNextUse(int u){
		this.nextUse=u;
	}
	
	public boolean setFirstUse(int f){
		if(this.firstUse!=-1)
			return false;
		this.firstUse=f;
		return true; 
	}
	
	public boolean setLastUse(int l){
		if(this.lastUse!=-1)
			return false;
		this.lastUse=l;
		return true; 
	}
	
	
	
}
