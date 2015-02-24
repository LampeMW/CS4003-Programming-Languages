/*
**  Lab 3 - A Stream Extension
**  Matt Lampe
**  M03516707
**  CS4003
**  2/9/2015
*/

package collectorstream;

public abstract class Stream extends Thread {
   Object value;
   
   public Stream ()  {  }
   
   synchronized public void putIt (Object t) {
      value = t;
      notify();
      try { wait(); } catch (Exception e) {  }
   }

   synchronized public Object next () {
      if (this.getState() == Thread.State.NEW) start(); else notify();

      try { wait(); } catch (Exception e) {  }

      return value;
   }
}

