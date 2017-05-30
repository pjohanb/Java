import java.io.*;
import java.util.*;
import java.nio.*;

public class Encode {
	
	public static int tmpData;
	
	public static void encode() {
		try {
			InputStream in = new FileInputStream("assets//test.txt");
			OutputStream out = new FileOutputStream("assets//test-encoded.txt");
			
			int data = in.read();
			
			while(data != -1) {
				tmpData = data + 13;
				
				out.write(tmpData);
				
				data = in.read();
			}
			
			in.close();
			out.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void decode() {
		try {
			InputStream in = new FileInputStream("assets//test-encoded.txt");
			OutputStream out = new FileOutputStream("assets//test-decoded.txt");
			
			int data = in.read();
			
			while(data != -1) {
				tmpData = data - 13;
				
				out.write(tmpData);
				
				data = in.read();
			}
			
			in.close();
			out.close();	
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		//encode();
		decode();
	}

}
