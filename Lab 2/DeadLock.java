/*
*  Lab 2 - Deadlock
*  Matt Lampe
*  M03516707
*  CS4003
*  2/2/2015
*/

class Monitor {
   String name;
	
   public Monitor (String name) { this.name = name; }
		   
   public String getName() {  return this.name; }
				
   public synchronized void ping (Monitor p) {
      p.release(this);
       try {
           wait();
       } catch (InterruptedException ex) {}
      System.out.println(this.name+ " (ping): asking " + p.getName() + " to confirm");
      p.confirm(this);
      System.out.println(this.name + " (ping): got confirmation");
      p.release(this);
   }
				
   public synchronized void confirm (Monitor p) {
      System.out.println(this.name+" (confirm): confirm to "+p.getName());
   }

   public synchronized void release (Monitor p) {
      notify();
   }
}

class Runner extends Thread {
   Monitor m1, m2;
		
   public Runner (Monitor m1, Monitor m2) { 
      this.m1 = m1; 
      this.m2 = m2; 
   }
							
   public void run () {  
       System.out.println(m1.getName() + " (ping): pinging " + m2.getName());
       m1.ping(m2);  
   }
}
									
public class DeadLock {
   public static void main (String args[]) {
      int i=1;
      System.out.println("Starting..."+(i++));
      Monitor a = new Monitor("Girl");
      Monitor b = new Monitor("Boy");
      (new Runner(a, b)).start();
      (new Runner(b, a)).start();
   }
}