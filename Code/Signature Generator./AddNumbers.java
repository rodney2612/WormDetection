import java.util.Scanner;
class AddNumbers
{
   public static void main(String a[])
   {
      int a, b, c;	
      Scanner in = new Scanner(System.in);
      a = in.nextInt();
      b = in.nextInt();
      c = a + b;
      System.out.println(c);
   }
}