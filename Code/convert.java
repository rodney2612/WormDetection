import java.io.*;
class convert{

static double toPts(String [] lineArr){
	double lineArr1=Double.parseDouble(lineArr[1]);
	double lineArr2=Double.parseDouble(lineArr[2]);
	double lineArr3=Double.parseDouble(lineArr[3]);
	double lineArr4=Double.parseDouble(lineArr[4]);
	double lineArr5=Double.parseDouble(lineArr[5]);
	double pt=lineArr1*0.083+lineArr2*0.083+lineArr3*0.084+lineArr4*0.25+lineArr5*0.5;
	return pt;
  }

public static void main(String args[])throws Exception{
BufferedReader br = new BufferedReader(new FileReader("new_log16.txt"));
int line_no=0;
String line="";
while ((line = br.readLine()) != null) {
	line_no++;
	String [] lineArr=line.split(" ");
	if(line_no==1)System.out.println(lineArr[0]+" "+lineArr[1]+" "+lineArr[2]+" "+lineArr[3]+" "+lineArr[4]+" "+lineArr[5]+" "+"Worm");	   
	else{
		double pt=toPts(lineArr);
         	if(pt>=2.50)
			System.out.println(lineArr[0]+" "+lineArr[1]+" "+lineArr[2]+" "+lineArr[3]+" "+lineArr[4]+" "+lineArr[5]+" "+"yes");
		else 
			System.out.println(lineArr[0]+" "+lineArr[1]+" "+lineArr[2]+" "+lineArr[3]+" "+lineArr[4]+" "+lineArr[5]+" "+"no");

	}

}

}
}