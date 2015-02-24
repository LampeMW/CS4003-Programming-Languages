/*
**  Lab 3 - A Stream Extension
**  Matt Lampe
**  M03516707
**  CS4003
**  2/9/2015
*/

package collectorstream;

import java.util.*;

public class Producer extends Stream {
   String ident;
   int count;
   boolean flag;
   TCFrame f;

   Producer (String id, TCFrame f) { 
      ident = id;  
      count = 0;  
      flag = true; 
      this.f = f;
   }

   public void run () {
      while (flag) {
    int sleep_time = (int)(Math.random()*3000);
    double stock_value = Math.random()*111;
    stock_value = (Math.floor(stock_value*100))/100.0;
    try { sleep(sleep_time); } catch (Exception e) {}
    f.area.append("Producer "+ident+" puts subscriber with value="+
             stock_value+"\n");
    putIt(new Subscriber(count++, stock_value, this));
    f.area.append("Producer "+ident+" returns from put\n");
      }
   }
}



