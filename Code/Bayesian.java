import java.io.*;
import java.util.concurrent.*;
import java.util.*;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


class Bayesian
{
     public static void generateAndSendEmail(String time) throws AddressException, MessagingException {
 
//Step1		
		//System.out.println("\n 1st ===> setup Mail Server Properties..");
		Properties mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		//System.out.println("Mail Server Properties have been setup successfully..");
 
//Step2		
		//System.out.println("\n\n 2nd ===> get Mail Session..");
		Session getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		MimeMessage generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("rodneystephen.rodrigues@gmail.com"));
		//generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("rishikeshmisal_123@ymail.com "));
		//generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("patil.deepak1993@gmail.com  "));
		//generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("rodneystephen.rodrigues@gmail.com"));
		generateMailMessage.setSubject("");
		String emailBody = "Worm detected at "+time;
		generateMailMessage.setContent(emailBody, "text/html");
		//System.out.println("Mail Session has been created successfully..");
 
//Step3		
		//System.out.println("\n\n 3rd ===> Get Session and Send mail");
		Transport transport = getMailSession.getTransport("smtp");
		
		// Enter your correct gmail UserID and Password 
		transport.connect("smtp.gmail.com", "projecthoneypot1@gmail.com", "BEPROJECT");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}

   static void takeAction(String time) throws Exception {
 	File source=new File("C:\\Documents and Settings\\Rodney\\My Documents\\captures");
 	File dest=new File("F:\\captures");	
	copyFiles(source,dest);
	generateAndSendEmail(time);
	//System.out.println("\n\n ===> Your Java Program has just sent an Email successfully. Check your email..");
	//Process p=Runtime.getRuntime().exec("shutdown -s -t 00");
   }


   public static void copyFiles(File sourceLocation , File targetLocation)
    throws IOException {

        if (sourceLocation.isDirectory()) 
            if (!targetLocation.exists()) {
                targetLocation.mkdir();
            }
            File[] files = sourceLocation.listFiles();
            for(File file:files){
                InputStream in = new FileInputStream(file);
                OutputStream out = new FileOutputStream(targetLocation+"/"+file.getName());

                // Copy the bits from input stream to output stream
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                in.close();
                out.close();
            }            
        }    
	 
	 
    public static void main(String args[])throws Exception
     {
	   TimeUnit.MILLISECONDS.sleep(10000);
	   Scanner src = new Scanner (System.in);
	     int ms_yes=0;
			  int ms_no=0;
			  int msg_yes=0;
			  int msg_no=0;
			  int echo_yes=0;
			  int echo_no=0;
			  int mem_yes=0;
			  int mem_no=0;
			  int pro_yes=0;
			  int pro_no=0;
			  int yes=0;
			  int no=0;
			
	    int match=0;
		int total=0;
		int fp=0,fn=0;
		double ratio=0;
	   int nLines=1041;
	   String ip[][]= new String [nLines+1][7];
	   String ou[]= new String [7];
	   int count=0;
	   int c=0;
         String x,x1;
       try{
        FileInputStream f = new FileInputStream("Logs\\naya_log.txt");
        InputStreamReader isr = new InputStreamReader(f);
        BufferedReader bf= new BufferedReader(isr);
          x=bf.readLine();
          x=bf.readLine();
		  do{
		      
		   StringTokenizer str = new StringTokenizer(x);
		     ip[count][c]=str.nextToken();
			  c++;
			 ip[count][c]=str.nextToken();
			    c++;
			 ip[count][c]=str.nextToken();
			     c++;
			 ip[count][c]=str.nextToken();
			     c++;
			 ip[count][c]=str.nextToken();
			     c++;
		     ip[count][c]=str.nextToken();
			   c++;
		     ip[count][c]=str.nextToken();
			   c=0;
			   count++;
			   x=bf.readLine();
			  }while(x!=null);
		  }
		  catch (Exception e){}
		  
			  
			 /*System.out.println("Message sent//sec");
			  String ms = src.next();
			 System.out.println("Message?");
			  String msg = src.next();
			  System.out.println("Echo?");
			  String echo = src.next();
			  System.out.println("Memory?");
			  String mem = src.next();
			  System.out.println("Processor?");
			  String pro = src.next();*/
				c=0;
				for(int i=0;i<nLines;i++)
			    if(ip[i][6].equals("yes"))
				   yes++;
				else
				  no++;
			  double probab_yes = (double) yes / nLines;
 				double probab_no = (double) no / nLines;
				
				
		FileOutputStream f1 = new FileOutputStream("false_negative1.txt");
        OutputStreamWriter osr = new OutputStreamWriter(f1);
        BufferedWriter bw= new BufferedWriter(osr);
		boolean brk=false;
		
				try{
				//System.out.println(total);
        FileInputStream f = new FileInputStream("dynamic_log.txt");
        InputStreamReader isr = new InputStreamReader(f);
        BufferedReader bf= new BufferedReader(isr);
          x1=bf.readLine();
          x1=bf.readLine();
		  do{
		      
		   StringTokenizer str = new StringTokenizer(x1);
		       ou[c]=str.nextToken();
			  c++;
			 ou[c]=str.nextToken();
			    c++;
			 ou[c]=str.nextToken();
			     c++;
			 ou[c]=str.nextToken();
			     c++;
			 ou[c]=str.nextToken();
			     c++;
		     ou[c]=str.nextToken();
			   c++;
		     ou[c]=str.nextToken();
			   c=0;
			   //count++;
			   x1=bf.readLine();
			  
		  
			  
          
			  
			  //System.out.println("Yes="+yes+"   No="+no);
				    x = ou[1];
				  int b=1;
				
				 //System.out.println("Probability of yes "+ probab_yes);
				 //System.out.println("Probability of no "+ probab_no);
				 
				  //for Message_sent/sec
				 for(int i=0;i<nLines;i++)
				  {
  				  if(ip[i][b].equals(x) && ip[i][6].equals("yes"))
				     ms_yes++;
				  else if(ip[i][b].equals(x) && ip[i][6].equals("no"))
				     ms_no++;
				  }
				  //System.out.println("ms_yes="+ms_yes +"  ms_no="+ms_no);
				  b++;
				   x=ou[2];
				  //for Message/sec
				   for(int i=0;i<nLines;i++)
				  {
  				  if(ip[i][b].equals(x) && ip[i][6].equals("yes"))
				     msg_yes++;
				  else if(ip[i][b].equals(x) && ip[i][6].equals("no"))
				     msg_no++;
				  }
				  //System.out.println("msg_yes="+msg_yes +"  msg_no="+msg_no);
				  b++;
				  x=ou[3];
				  //for Echo/sec
				   for(int i=0;i<nLines;i++)
				  {
  				  if(ip[i][b].equals(x) && ip[i][6].equals("yes"))
				     echo_yes++;
				  else if(ip[i][b].equals(x) && ip[i][6].equals("no"))
				     echo_no++;
				  }
				  //System.out.println("echo_yes="+echo_yes +"  echo_no="+echo_no);
				  b++;
				  x=ou[4];
				   for(int i=0;i<nLines;i++)
				  {
  				  if(ip[i][b].equals(x) && ip[i][6].equals("yes"))
				     mem_yes++;
				  else if(ip[i][b].equals(x) && ip[i][6].equals("no"))
				     mem_no++;
				  }
				  //System.out.println("mem_yes="+mem_yes +"  mem_no="+mem_no);
				    b++;
				  x=ou[5];
				   for(int i=0;i<nLines;i++)
				  {
  				  if(ip[i][b].equals(x) && ip[i][6].equals("yes"))
				     pro_yes++;
				  else if(ip[i][b].equals(x) && ip[i][6].equals("no"))
				     pro_no++;
				  }
				  //System.out.println("pro_yes="+pro_yes +"  pro_no="+pro_no);
				  //for "yes"
				      
				  double p_yes = ((double)ms_yes * (double)msg_yes * (double)echo_yes * (double)mem_yes * (double)pro_yes )/(double)Math.pow(yes,5);
				  double p_no =  ((double)ms_no * (double)msg_no * (double)echo_no * (double)mem_no * (double)pro_no )/(double)Math.pow(no,5);
				  
				  double yes_x = p_yes * probab_yes;
				  double no_x = p_no* probab_no;
				  
				  /*System.out.println(ou[0]);
				  System.out.println("p_yes  = "+ p_yes);
				  System.out.println("p_no  = "+ p_no);
				  System.out.println(" P(C1/X) = "+ yes_x);
				  System.out.println(" P(C2/X) = "+ no_x);
				  System.out.println("YES_X = "+ yes_x+"  NO_X= "+no_x);*/

				  if(yes_x>no_x)
				    {
					  System.out.println("Worm = YES ");
					  //System.out.println(ou[0]+" ");
					  
					  if(ou[6].equals("yes")){
					    match++;
						brk=true;
						takeAction(ou[0]);
					  }
					  else if(ou[6].equals("no"))
					  {
						  fp++;
						  bw.write(ou[0]+" "+ou[1]+" "+ou[2]+" "+ou[3]+" "+ou[4]+" "+ou[5]+" "+ou[6]+"\n");
					  }
					}
					
			      else 
				    {
					  if(ou[6].equals("no"))
					   match++;
				   
				       else if(ou[6].equals("yes"))
					   {
						   fn++;
						    bw.write(ou[0]+" "+ou[1]+" "+ou[2]+" "+ou[3]+" "+ou[4]+" "+ou[5]+" "+ou[6]+"\n");
					   }
					 }
					
				  //System.out.println("enter");
				   //int q = src.nextInt();
					total++;
					
			   ms_yes=0;
			   ms_no=0;
			   msg_yes=0;
			   msg_no=0;
			   echo_yes=0;
			   echo_no=0;
			   mem_yes=0;
			   mem_no=0;
			   pro_yes=0;
			   pro_no=0;
			   
			   if(brk==true)break;   // worm detected break while loop
			   TimeUnit.MILLISECONDS.sleep(1000);

					}while(x1!=null);
		  }
		    catch(Exception  e){}
			bw.flush();
			bw.close();
		
			
			System.out.println("Total="+ total+" Match = "+match);
			System.out.println("FP= "+fp+" FN= "+fn); 
			System.out.println("Ratio = "+(double)match/(double)total);
			System.out.println("FP= "+(double)fp/(double)total);
			System.out.println("FN= "+(double)fn/(double)total);
			char ch=(char)System.in.read();
         }//main
	}//class
				   
				   
					 
				  
			 
			  
			 
			  
			 
		   