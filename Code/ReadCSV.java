import java.io.*;
import java.util.concurrent.*;
public class ReadCSV {


  static String msgSent(String temp){
    double dblLine=Double.parseDouble(temp);
	if(dblLine>=0&&dblLine<=2) temp="1";
	else if(dblLine>2&&dblLine<=3) temp="2";
	else if(dblLine>3&&dblLine<=4) temp="3";
	else temp="4";
	return temp;
  }

  static String msg(String temp){
    double dblLine=Double.parseDouble(temp);
	if(dblLine>=0&&dblLine<=2) temp="1";
	else if(dblLine>2&&dblLine<=4) temp="2";
	else if(dblLine>4&&dblLine<=5) temp="3";
	else temp="4";
	return temp;
  }


  static String icmp(String temp){
    double dblLine=Double.parseDouble(temp);
	if(dblLine>=0&&dblLine<=0.33) temp="1";
	else if(dblLine>0.33&&dblLine<=0.66) temp="2";
	else if(dblLine>0.66&&dblLine<=1) temp="3";
	else temp="4";
	return temp;
  }

  static String mem(String temp){
    double dblLine=Double.parseDouble(temp);
	if(dblLine>=0&&dblLine<=20) temp="1";
	else if(dblLine>20&&dblLine<=30) temp="2";
	else if(dblLine>30&&dblLine<=45) temp="3";
	else temp="4";
	return temp;
  }
  
  
  static String proc(String temp){
	double dblLine=Double.parseDouble(temp);
	if(dblLine>=0&&dblLine<=25) temp="1";
	else if(dblLine>25&&dblLine<=50) temp="2";
	else if(dblLine>50&&dblLine<=75) temp="3";
	else temp="4";
	return temp;
  }
  

  static void toFuzzy(String [] lineArr){
	lineArr[1]=msgSent(lineArr[1]);
	lineArr[2]=msg(lineArr[2]);
	lineArr[3]=icmp(lineArr[3]);
	lineArr[4]=mem(lineArr[4]);
	lineArr[5]=proc(lineArr[5]);
  }
 
  static String changeHeaders(String line){
	line=line.replace("\\\\RODNEY-A9F2EF35\\","");
	line=line.replace("\\"," ");
	line=line.replace("(PDH-CSV 4.0) (India Standard Time)(-330)","Time");
	line=line.replace("Processor(_Total) % Processor Time","%_Processor_Time");
	return line;
  }
  
  static void findMax(String [] lineArr,double [] max){
	double lineArr1=Double.parseDouble(lineArr[1]);
	double lineArr2=Double.parseDouble(lineArr[2]);
	double lineArr3=Double.parseDouble(lineArr[3]);
	double lineArr4=Double.parseDouble(lineArr[4]);
	double lineArr5=Double.parseDouble(lineArr[5]);
	if(lineArr1>max[1])max[1]=lineArr1;
	if(lineArr2>max[2])max[2]=lineArr2;
	if(lineArr3>max[3])max[3]=lineArr3;
	if(lineArr4>max[4])max[4]=lineArr4;
	if(lineArr5>max[5])max[5]=lineArr5;
  }
  
  static double toPoints(String [] lineArr){
	double lineArr1=Double.parseDouble(lineArr[1]);
	double lineArr2=Double.parseDouble(lineArr[2]);
	double lineArr3=Double.parseDouble(lineArr[3]);
	double lineArr4=Double.parseDouble(lineArr[4]);
	double lineArr5=Double.parseDouble(lineArr[5]);
	double pt=lineArr1*0.083+lineArr2*0.083+lineArr3*0.084+lineArr4*0.25+lineArr5*0.5;
	return pt;
  }

 
  public static void main(String[] args) throws Exception{
	TimeUnit.MILLISECONDS.sleep(5000);
	String csvFile = "C:\\PerfLogs\\realTime_000014.csv";
	BufferedReader br = new BufferedReader(new FileReader(csvFile));
	String line = "";
	String csvSplitBy = ",";
	//PrintWriter pw=new PrintWriter(new FileWriter("dynamic_log.txt"));
    	int line_no=0;
	double pt=0;
	
	/*double max[]=new double[6];
	for(int i=1;i<6;i++)max[i]=-9999;*/
	
	while ((line = br.readLine()) != null) {
	    line_no++;
		
		if(line_no==1) 
			line=changeHeaders(line);
		
		line=line.replace(" ","_");
		line=line.replace("\"","");  
		
		String[] lineArr = line.split(csvSplitBy);
		
		if(line_no==1){
			//pw.println(lineArr[0]+" "+lineArr[1]+" "+lineArr[2]+" "+lineArr[3]+" "+lineArr[4]+" "+lineArr[5]+" "+"Worm");
			System.out.println(lineArr[0]+" "+lineArr[1]+" "+lineArr[2]+" "+lineArr[3]+" "+lineArr[4]+" "+lineArr[5]+" "+"Worm");
		}
		
		if(line_no>2){  
			//findMax(lineArr,max);
			lineArr = line.split(csvSplitBy);
			toFuzzy(lineArr);
			pt=toPoints(lineArr);
			if(pt>=2.50){
				//pw.println(lineArr[0]+" "+lineArr[1]+" "+lineArr[2]+" "+lineArr[3]+" "+lineArr[4]+" "+lineArr[5]+" "+"yes");
				System.out.println(lineArr[0]+" "+lineArr[1]+" "+lineArr[2]+" "+lineArr[3]+" "+lineArr[4]+" "+lineArr[5]+" "+"yes");
			}
			else{
				//pw.println(lineArr[0]+" "+lineArr[1]+" "+lineArr[2]+" "+lineArr[3]+" "+lineArr[4]+" "+lineArr[5]+" "+"no");
				System.out.println(lineArr[0]+" "+lineArr[1]+" "+lineArr[2]+" "+lineArr[3]+" "+lineArr[4]+" "+lineArr[5]+" "+"no");
			}
			//System.out.println("Written a new row");
		}
		

		TimeUnit.MILLISECONDS.sleep(1000);
		
		} //while
	
	//for(int i=1;i<6;i++)System.out.println(max[i]);
	
 	//pw.close();
 } //main
} //class