package allocator;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class RegAllocator {

	
	public static void main (String args[]){
		
		
	    File file = null;
	    FileInputStream fis = null;
	    BufferedInputStream bis = null;
	    DataInputStream dis = null;
		
		
		if(args.length!=3){
			System.out.println("Not enough arguments. Provide "
					+ "k(# of Registers) "
					+ "A flag(b|s|t)"
					+ "The name of the inputfile");
			return;
		}
		
		if(!(args[1].equals("b") || args[1].equals("s") || args[1].equals("t"))){
			System.out.println("Error with flag input.");
			return; 
		}
		
		if(!(Character.isDigit(args[0].charAt(0)))){
			System.out.println("Error with user k input.");
			return;
		}
		
		BufferedReader br =null;
		
		try {
			 
			String sCurrentLine;
 
			br = new BufferedReader(new FileReader(args[2]));
 
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		} 
 
	}
		

		
		
}
	
	
	

