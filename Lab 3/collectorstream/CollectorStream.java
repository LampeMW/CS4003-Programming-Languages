/*
**  Lab 3 - A Stream Extension
**  Matt Lampe
**  M03516707
**  CS4003
**  2/9/2015
**  Usage - Compile collectorstream package, then run TestCollector.java
*/

package collectorstream;

import java.util.*;

class CollectorStream extends Stream {
	TCFrame f;
	Notifier n;
	Vector<Producer> p;

	public CollectorStream (Notifier notifier, TCFrame frame) {
		this.p = new Vector<Producer>();
		this.n = notifier;
		this.f = frame;
	}

	public void add(Producer producer) {
		this.p.add(producer);
	}

	public void run() {
		double total = 0;
		for (Producer producer : this.p) {
			Subscriber a = (Subscriber) producer.next();
			this.f.area.append("Collector: got " + producer.ident + "\n");
			total += a.stock_value;
		}

		IntObject total_value = new IntObject((int)total);
		this.n.putValue(total_value);
		this.putIt(n);
	}
        
      
}