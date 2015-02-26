package structures;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Controller {

	ArrayList<Piece> block = new ArrayList<Piece>(); 
	int [][] srcRegs;
	
	public Controller(){
		
		
	}
	
	
	
	public void createBlock(BufferedReader br) throws IOException{
		
		String sCurrentLine;
		Object regs[];
		int [] temp;
		while ((sCurrentLine = br.readLine()) != null) {
			if(sCurrentLine.startsWith("//")){
				continue; 
			}
			//System.out.println(sCurrentLine);
			regs=this.parseLine(sCurrentLine);
			block.add(new Piece(regs, block.size()));
		}
		this.setupNextUse();
		/*for(int i =0; i<block.size();i++){
			Piece p=block.get(i);
			p.listOpRegs();
			System.out.println("--------------");
		}*/
	}
	
	public void setupNextUse(){
		
		srcRegs=new int[3][block.size()];
		Arrays.fill(srcRegs[0], -2);
		Arrays.fill(srcRegs[1], -2);
		Arrays.fill(srcRegs[2], -2);
		int [] regs = null; 
		int index; 
		
		for(int i =0; i<block.size();i++){
			Piece p=block.get(i);
			regs=p.getSrcRegs();
			p.listOpRegs();
			if(regs==null){
				continue;
			}

			for(int j =0;j<3;j++){
				
				if(regs[j]==-1){
					continue; 
				}
				index=Controller.indexOf(srcRegs[0], regs[j], 0);
				if(index==-1){
					index=Controller.indexOf(srcRegs[0], -2, 0);
					srcRegs[0][index]=regs[j];
					srcRegs[1][index]=i;
					continue;
				}
				srcRegs[2][index]=i;		
			}
		}
		
		//System.out.println(">" + srcRegs[0].length);
		
		for(int i =0;i<srcRegs[0].length;i++){
			for(int j=0; j<srcRegs.length;j++){
				if(j==0){
					System.out.println("reg:"+srcRegs[j][i]);
				}
				if(j==1){
					System.out.println("first "+srcRegs[j][i]);
				}
				if(j==2){
					System.out.println("Last "+srcRegs[j][i]);
				}
				}
		}
		
		
	}
	
	
	
	public Object[] parseLine(String s){
		char c = 0;
		String output="";
		String code ="";
		Object store[]=new Object[4];
		store[0]=-1;
		store[1]=-1;
		store[2]=-1;
		
		for(int i=0; i<s.length();i++){
			c=s.charAt(i);
			
			//System.out.println(s.charAt(i+1));
			if(c=='/'){
				break; 
			}
			else if(c=='r' && s.charAt(i-1)!='o'){
				i++;
				output=output+s.charAt(i);
				i++;
				
				if(i<s.length()){
					if(Character.isDigit(s.charAt(i))){
						output=output+s.charAt(i);
					}
					i++;
				}
				if(i<s.length()){
					if(Character.isDigit(s.charAt(i))){
						output=output+s.charAt(i);
					}
					i++;
				}
					
				output=output.trim();
				if((int)store[0]==-1){
					store[0]=Integer.parseInt(output);
					//System.out.println(store[0]);
				}
				else if((int)store[1]==-1){
					store[1]=Integer.parseInt(output);
					//System.out.println(store[1]);
				}
				else if((int)store[2]==-1){
					store[2]=Integer.parseInt(output);
					//System.out.println(store[2]);
				}
				output="";
			}
			else if(Character.isLetter(c)){
				while(Character.isLetter(c=s.charAt(i))){
					code=code+c;
					i++;
				}
			}
		}
		
		store[3]=code;
		
		if((int)store[2]==-1&&(int)store[1]!=-1){
			store[2]=store[1];
			store[1]=-1;
		}
		else if((int)store[0]!=-1&&(int)store[1]==-1){
			store[2]=store[0];
			store[0]=-1;
		}
		
		return store; 

	}
	
	  public static int indexOf(int[] array, int valueToFind, int startIndex) {
	      if (array == null) {
	          return -1;
	      }
	      if (startIndex < 0) {
	          startIndex = 0;
	      }
	      for (int i = startIndex; i < array.length; i++) {
	          if (valueToFind == array[i]) {
	              return i;
	          }
	      }
	      return -1;
	  }
	
	
	
}
