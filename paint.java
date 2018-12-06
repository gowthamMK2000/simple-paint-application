//import java.awt.event.MouseMotionListener;
import java.awt.event.*;
import java.applet.*;
import java.awt.*;
/*<applet code="paint" width=700 height=500 >
</applet>
 */
public class paint extends Applet implements MouseMotionListener,MouseListener,ActionListener
{
 int i,j,k,l;
 int select=1;
 boolean draw=false;
 Button linebutton,ellipsebutton,rectbutton,clearbutton,pencilbutton,circlebutton,bHeading;
 Font font;
 public void init()
 {
   addMouseMotionListener(this);
   addMouseListener(this);
   setLayout(null);
   pencilbutton= new Button("PENCIL");
   pencilbutton.setSize(60,40);
   pencilbutton.setLocation(10,100);
   add(pencilbutton);
   pencilbutton.addActionListener(this);
   linebutton=new Button("LINE");
   linebutton.setSize(60,40);
   linebutton.setLocation(10,150);
   add(linebutton);
	 linebutton.addActionListener(this);
   rectbutton=new Button("RECT");
   rectbutton.setSize(60,40);
   rectbutton.setLocation(10,200);
   add(rectbutton);
	 rectbutton.addActionListener(this);
   ellipsebutton=new Button("ELLIPSE");
   ellipsebutton.setSize(60,40);
   ellipsebutton.setLocation(10,250);
   add(ellipsebutton);
		ellipsebutton.addActionListener(this);
    circlebutton=new Button("circle");
    circlebutton.setSize(60,40);
    circlebutton.setLocation(10,300);
    add(circlebutton);
 		circlebutton.addActionListener(this);
    clearbutton=new Button("CLEAR");
    clearbutton.setSize(60,40);
    clearbutton.setLocation(10,350);
    add(clearbutton);
    clearbutton.addActionListener(this);
}
 public void actionPerformed(ActionEvent e)
 {
    if(e.getSource()==pencilbutton)
        select=1;
		if (e.getSource() == linebutton)
      select=2;
    if (e.getSource() == rectbutton)
      select=3;
    if (e.getSource() == ellipsebutton)
      select=4;
    if(e.getSource()==circlebutton)
      select=5;
    if(e.getSource()==clearbutton)
     select=6;
	}
  public void mouseClicked(MouseEvent m)
  {
    showStatus("mouse clicked ");
  }
  public void mouseEntered (MouseEvent m)
  {
    showStatus("mouse entered");
  }public void  mouseExited(MouseEvent m)
  {
     showStatus("mouse exited");
  }
  public void  mousePressed(MouseEvent m)
  {
    showStatus("mouse pressed");
    draw=true;
    i=m.getX();j=m.getY();
    k=m.getX();l=m.getY();
    repaint();
  }
  public void mouseReleased (MouseEvent m)
  {
    showStatus("mouse released");
    k=m.getX();l=m.getY();
    draw=false;
    repaint();
  }
  public void mouseDragged(MouseEvent m)
  {
    if(select==1)
    {
      i=m.getX();j=m.getY();
      repaint();
    }
    else
    { k=m.getX();l=m.getY();  }
     showStatus("mouse dragged");
  //    repaint();
  }
  public void mouseMoved(MouseEvent m)
  {
    if(select==1)
    {
      i=m.getX();j=m.getY();
    }
    showStatus(m.getX()+" "+m.getY());
  }
 public void update(Graphics g)
  {
    int w,h,x=0,y=0;
    w=Math.abs(i-k);
    h=Math.abs(j-l);
    if(i<k && j<l)//top-left to buttom-right
    {  x=i; y=j;}
    if(i>k && j<l)//top-right to buttom-left
    {  x=k; y=j;}
    if(i>k && j>l)//bottom-right to top-left
    { x=k; y=l; }
    if(i<k && j>l)//buttom-left to top-right
    {  x=i; y=l;}
    if(select==1)
      g.drawLine(i,j,i,j);
    if(select==2)
       g.drawLine(i,j,k,l);
    if(select==3)
        g.drawRect(x,y,w,h);
    if(select==4)
        g.drawOval(x,y,w,h);
    if(select==5)
        g.drawOval(x,y,h,h);
    if(select==6)
    {
        g.clearRect(x,y,w,h);
    }
 }
  public void paint(Graphics g)
  {
  }
}
/*
class updateit extends linedrawer
{
  public void update(Graphics g)
   {
     int w,h,x,y;
     //if(up){
     if(i>k)
     {  w=i-k;x=k;}
     else
     {  w=k-i; x=i;}
     if(j>l)
       h=j-i;
     else
      h=l-j;
     if(select==1)
        g.drawLine(i,j,k,l);
     if(select==2)
         g.drawRect(x,j,w,h);
     if(select==3)
         g.drawOval(x,j,w,h);
    //  else
      //   paint(g);
    //g.drawLine(i,j,k,l);
  }
}
/*class over extends linedrawer
{
  over(){
    Graphics g1=getGraphics();

  }

  public void paint(Graphics g)
  {
    g.drawLine(i,j,k,l);
  }
}*/
/*
public class Appwindow
extends Frame
{
  public static void main(String args[])
  {
    Appwindow appwin=new Appwindow();
    appwin.setSize(new Dimension(300,200));
    appwin.setvisible(true);
 }
}
*/
