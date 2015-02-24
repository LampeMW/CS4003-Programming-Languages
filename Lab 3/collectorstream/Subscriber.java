/*
**  Lab 3 - A Stream Extension
**  Matt Lampe
**  M03516707
**  CS4003
**  2/9/2015
*/

package collectorstream;

public class Subscriber {
   int number;
   double stock_value;
   Producer producer;
   
   public Subscriber (int n, double v, Producer p) { 
      number = n; 
      stock_value = v;
      producer = p;
   }
}

