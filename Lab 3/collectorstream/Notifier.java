/*
**  Lab 3 - A Stream Extension
**  Matt Lampe
**  M03516707
**  CS4003
**  2/9/2015
*/

package collectorstream;

public class Notifier extends Stream {
   IntObject value;
   TCFrame f;

   public Notifier (TCFrame f) { this.f = f; }
   public void putValue (IntObject v) { value = v; }
   public void run () {  f.area.append(value.number+"\n");  }
}
