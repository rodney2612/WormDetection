import java.util.*;
import java.io.*;
class Combinations
{
 public static void main(String args[])throws Exception
  {
	 String ou[]= new String [7];
    BufferedWriter  bw = new BufferedWriter(new FileWriter("naya_log.txt"));
	//int a1=0,a2=0,a3=0,a4=0,a5=0;
	String x1="";
	FileInputStream f = new FileInputStream("Logs\\training_log11.txt");
        InputStreamReader isr = new InputStreamReader(f);
        BufferedReader bf= new BufferedReader(isr);
          x1=bf.readLine();
		  bw.write(x1+"\n");
          x1=bf.readLine();
		  int c1=0;
	 for(int a=1;a<5;a++)
	  for(int b=1;b<5;b++)
		for(int c=1;c<5;c++)
		  for(int d=1;d<5;d++)
			 for(int e=1;e<5;e++)
			 {
				
		   StringTokenizer str = new StringTokenizer(x1);
		       ou[c1]=str.nextToken();
			  c1++;
			 ou[c1]=str.nextToken();
			    c1++;
			 ou[c1]=str.nextToken();
			     c1++;
			 ou[c1]=str.nextToken();
			     c1++;
			 ou[c1]=str.nextToken();
			     c1++;
		     ou[c1]=str.nextToken();
			   c1++;
		     ou[c1]=str.nextToken();
			   c1=0;
			      
			   x1=bf.readLine();
			    ou[6]= fuzzy(a+" "+b+" "+c+" "+d+" "+e+" ");
				 bw.write(ou[0]+" "+a+" "+b+" "+c+" "+d+" "+e+" "+ou[6]+"\n");
			 }
			
			bw.flush();
			bw.close();
  }
  
     static String fuzzy(String x1)
	 {
		  int c1=0;
		 StringTokenizer str = new StringTokenizer(x1);
		       int ms=Integer.parseInt(str.nextToken());
			  c1++;
			 int msg=Integer.parseInt(str.nextToken());
			    c1++;
			 int echo=Integer.parseInt(str.nextToken());
			     c1++;
			 int mem=Integer.parseInt(str.nextToken());
			     c1++;
			 int pro=Integer.parseInt(str.nextToken());
			     c1=0;
         double threshold = 0.5*(double)pro+0.25*(double)mem+0.083*(double)ms+0.083*(double)msg+0.083*(double)echo;
		      if(threshold>=2.50)
				  return "yes";
			     return "no";
	 }
}