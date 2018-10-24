import java.util.*;
import java.io.*;
class EncodingUTF
{
	 static String g[];
	 static String p[];
	 static String g1[];
	 public static void main(String args[])throws Exception
	 {
		  String o ="";
		  String x="";
      FileInputStream f = new FileInputStream("AddNumbers.java");
	  //FileInputStream f = new FileInputStream("Add.java");
      InputStreamReader isr = new InputStreamReader(f);
      BufferedReader bf = new BufferedReader(isr);
	 
			  boolean flag=true;
	   do{
        x=bf.readLine();
		if(x!=null)
		{
			 
			 byte ptext[] = x.getBytes("UTF8");
              for(int i=0;i<ptext.length;i++)
			  {
				      if(ptext[i]!=32&&ptext[i]!=34&&ptext[i]!=47&&ptext[i]!=59&&ptext[i]!=123&&ptext[i]!=125&&ptext[i]!=9)
					  {
				    o=o+Integer.toHexString(ptext[i])+" ";
					 
					   flag=false;
					  }
					  else
					  {
						if(!flag)
						{
						o+="* ";
                         flag=true;						
						}
					  }
				   
			  }
			  
		}   
		
	   }while(x!=null);
		
		
	    BufferedWriter bw = new BufferedWriter(new FileWriter("signature.txt"));
		 bw.write(o+" ");
		 bw.flush();  
    bw.close();
	   p = new String[o.length()];
	   
		token(p,o);
	   
	    String u_text[]= new String [p.length];
		  u_text[0]=p[0];
		 for(int i=0;i<p.length;i++)
			 if(p[i]!=null)
		   if(!search(u_text,p[i]))
			 u_text[i]=p[i];
		 
		 for(int i=0;i<u_text.length;i++)
	   if(u_text[i]!=null)
		System.out.print(u_text[i]+" ");
	
	   String ou="";
	    for(int i=0;i<u_text.length;i++)
	   if(u_text[i]!=null&&!u_text[i].contains("*"))
	   {
		int a =Integer.parseInt(u_text[i],16);
		ou=ou+(char)a+"";
           
	   } System.out.print("\n"+ou);
	   g= new String[p.length*5];
	   gram(p,g);
	   
	    bw = new BufferedWriter(new FileWriter("output.txt"));
	 for(int i=0;i<g.length;i++)
	   if(g[i]!=null)
		bw.write(g[i]+"\n ");
	
	bw.flush();  
    bw.close();
	   
	   /*---------------2nd half -----------------*/
	   
	   o="";
	   ou="";
	   f = new FileInputStream("Add.java");
	   isr = new InputStreamReader(f);
	   bf = new BufferedReader(isr);
	   
	   flag=true;
	   
	   do{
        x=bf.readLine();
		if(x!=null)
		{
			 
			 byte ptext[] = x.getBytes("UTF8");
              for(int i=0;i<ptext.length;i++)
			  {
				      if(ptext[i]!=32&&ptext[i]!=34&&ptext[i]!=47&&ptext[i]!=59&&ptext[i]!=123&&ptext[i]!=125&&ptext[i]!=9)
					  {
				    o=o+Integer.toHexString(ptext[i])+" ";
					 
					   flag=false;
					  }
					  else
					  {
						if(!flag)
						{
						o+="* ";
                         flag=true;						
						}
					  }
				   
			  }
			  
		}   
		
	   }while(x!=null);
	   
	    bw = new BufferedWriter(new FileWriter("signature1.txt"));
		 bw.write(o+" ");
		 bw.flush();  
	   bw.close();
	   String p1[] = new String[o.length()];
	   
		token(p1,o);
	   
	    String u_text1[]= new String [p1.length];
		  u_text1[0]=p1[0];
		 for(int i=0;i<p1.length;i++)
			 if(p1[i]!=null)
		   if(!search(u_text1,p1[i]))
			 u_text1[i]=p1[i];
		 
		 for(int i=0;i<u_text1.length;i++)
	   if(u_text1[i]!=null)
		System.out.print(u_text1[i]+" ");
	
	   String ou1="";
	    for(int i=0;i<u_text1.length;i++)
	   if(u_text1[i]!=null&&!u_text1[i].contains("*"))
	   {
		int a =Integer.parseInt(u_text1[i],16);
		ou=ou+(char)a+"";
           
	   } System.out.print("\n"+ou1);
	   
	   g1= new String[p1.length*5];
	   gram(p1,g1);
	   
	    bw = new BufferedWriter(new FileWriter("output1.txt"));
	 for(int i=0;i<g.length;i++)
	   if(g[i]!=null)
		bw.write(g[i]+"\n ");
	
	bw.flush();  
    bw.close();
	    int og_total=0;
		int match=0;
	    for(int i=0;i<g1.length;i++)
		{
			
		 if(g1[i]!=null)
		  {
			og_total++;
				 if(search(g,g1[i]))
					match++;
				 
		  }
		}
		
		System.out.println("\n"+ ou);
		System.out.println("Total ="+og_total);
		System.out.println("Match ="+match);
		double ratio= (double)match/(double)og_total;
		System.out.println("Match ratio ="+ratio);
	   
}

 static void gram(String p[],String g[]) throws Exception
 {
	   int cnt=0;
	    
	   for(int i=0;i<p.length-2;i++)
	   {
		    if(p[i]!=null)
		    {
				
			g[cnt]=p[i]+p[i+1]+p[i+2];
			 if(g[cnt].equals("***"))
			 {
				g[cnt]="";
                cnt--;				
			 }
			 cnt++;
			}
	   }
	   
      
      
  
 }

 
      static void token(String p[],String x)
     {
         
         int a=0;
       StringTokenizer str = new StringTokenizer(x);
         while(str.hasMoreTokens())
          { 
            p[a]=str.nextToken();
             a++;
          }
     }//token() 
	
	static boolean search(String x[],String p)
	{
		for(int i=0;i<x.length;i++)
		{ 
	         if(x[i]!=null)
			 if(x[i].equals(p))
			  return true;
		}
		return false;
	}
     
}

