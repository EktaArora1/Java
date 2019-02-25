import java.util.*;
import java.text.*;
import java.applet.*;
import java.awt.*;
public class SimpleDigitalClock extends Applet implements Runnable
  {
    Thread thr=null;
    int clkhours=0, clkminutes=0, clkseconds=0;
    String clkString="";
    public void init()
      {
        setBackground(Color.black);
      }
    public void start()
      {
        thr=new Thread(this);
        thr.start();
      }
    public void run()
      {
        try
          {
            while(true)
              {
                Calendar calndr=Calendar.getInstance();
                clkhours=calndr.get(Calendar.HOUR_OF_DAY);
                if(clkhours>12)clkhours-=12;
                clkminutes=calndr.get(Calendar.MINUTE);
                clkseconds=calndr.get(Calendar.SECOND);
                SimpleDateFormat frmtr=new SimpleDateFormat("hh:mm:ss");
                Date date=calndr.getTime();
                clkString=frmtr.format(date);
                repaint();
                thr.sleep(1000);
              }
          }
        catch(Exception excp){
            System.out.println(excp);}
      }
    public void paint(Graphics grp)
      {
        grp.setColor(Color.red);
        grp.drawString(clkString, 150, 150);
      }
  }
