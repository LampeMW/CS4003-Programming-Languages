/*
**  Lab 3 - A Stream Extension
**  Matt Lampe
**  M03516707
**  CS4003
**  2/9/2015
*/

package collectorstream;

import java.applet.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TCRun extends Thread {
    TCFrame f;

    public TCRun (TCFrame f) { this.f = f; }

    public void run () {
        Notifier notifier = new Notifier(f);
        Producer p1 = new Producer("A", f);
        Producer p2 = new Producer("B", f);
        Producer p3 = new Producer("C", f);
        Producer p4 = new Producer("D", f);
        CollectorStream cs = new CollectorStream(notifier, f);
        cs.add(p1);
        cs.add(p2);
        cs.add(p3);
        cs.add(p4);
        f.area.append("Starting\n");
        cs.start();
        try { Thread.sleep(1000); } catch (Exception e) { }
        f.area.append("Ending\n");
        Notifier value = (Notifier)cs.next();
        f.area.append("\n\nStarting notifier: ");
        value.start();
    }
}

class TCFrame extends JFrame implements ActionListener {
    JButton go;
    JTextArea area;

    public TCFrame () {
        setLayout(new BorderLayout());
        add("Center", new JScrollPane(area = new JTextArea()));
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        p.add(go = new JButton("Start"));
        add("South", p);
        go.addActionListener(this);
        setSize(600, 400);
        setVisible(true);
    }

    public void actionPerformed (ActionEvent evt) {
        (new TCRun(this)).start();
    }
}

public class TestCollector extends Applet implements ActionListener {
    JButton go;

    public void init () {
        setLayout(new BorderLayout());
        add("Center", go = new JButton("Applet"));
        go.addActionListener(this);
    }

    public void actionPerformed (ActionEvent evt) {
        TCFrame f = new TCFrame();
        f.setSize(600,400);
        f.setVisible(true);
    }

      public static void main(String[] args) {
        TCFrame f = new TCFrame();
    }
}