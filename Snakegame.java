import java.io.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
/*<applet code="Snakegame.class" width=1500 height=1000> </applet>*/

public class Snakegame extends Applet implements  Runnable,ActionListener
{
String head="right";
int hx=80,hy=80,n=1,cnt=1,i,px=100,py=100,score=0;
int x[]=new int[40];
int y[]=new int[40];
boolean go=true,next=false,end=false;
Button b1,b2,b3,b4,b5,b6,b7,b8,b9;
Thread t1;
GridLayout g;
Panel p;
Frame f;
public void init()
{
setBackground(Color.white);
b1=new Button();
b2=new Button("UP");
b3=new Button();
b4=new Button("LEFT");
b5=new Button("Pause");
b6=new Button("RIGHT");
b7=new Button();
b8=new Button("DOWN");
b9=new Button();
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(this);
b6.addActionListener(this);
b7.addActionListener(this);
b8.addActionListener(this);
b9.addActionListener(this);
g=new GridLayout(3,3);
p=new Panel();
p.setBackground(Color.green);

p.setLayout(g);
p.add(b1);p.add(b2);p.add(b3);p.add(b4);p.add(b5);p.add(b6);p.add(b7);p.add(b8);p.add(b9);
add(p);
}
public void start()
{
for(i=0;i<40;i++)
{x[i]=0;y[i]=0;}
t1=new Thread(this);
t1.start();
}

public void actionPerformed(ActionEvent e)
{
 if(e.getSource()==b2)
      if(head.equals("down"))
          {}
        else
            head="up";
else if(e.getSource()==b4)
         if(head.equals("right"))
            {}
         else
              head="left";
       else if(e.getSource()==b6)
                if(head.equals("left"))
                  {}
                  else
                      head="right";
            else if(e.getSource()==b8)
                     if(head.equals("up"))
                      {}
                       else
                             head="down";
if(e.getSource()==b5)
  if(go)
      go=false;
  else
     go=true;
}         

public void run()
{
try{
while(true)
{
if(go)
{
Thread.sleep(400);
if((hx==0)||(hx==1200)||(hy==0)||(hy==620))
  { go=false;end=true;break;}
else if((hx==px)&&(hy==py))
    {n++;next=true;}
 
if(head.equals("up"))
{
for(i=n-1;i>0;i--)//n means no. of nodes...
{x[i]=x[i-1];y[i]=y[i-1];}
x[0]=hx;  y[0]=hy;
   hy-=20;repaint();
}
else if(head.equals("down"))
{
for(i=n-1;i>0;i--)
{x[i]=x[i-1];y[i]=y[i-1];}
x[0]=hx;y[0]=hy;
   hy+=20;repaint();
}
       else if(head.equals("left"))
{
for(i=n-1;i>0;i--)
{x[i]=x[i-1];y[i]=y[i-1];}
   x[0]=hx;y[0]=hy;
          hx-=20;repaint();
}
              else if(head.equals("right"))
{
for(i=n-1;i>0;i--)
{x[i]=x[i-1];y[i]=y[i-1];}
  x[0]=hx;y[0]=hy;
          hx+=20;repaint();
}

}//end of go if confition
}//end of outer while
}//end of try
catch(InterruptedException e)
{}
repaint();
}

public void paint(Graphics g)
{
g.setColor(Color.red);
g.fillRect(0,0,1220,20);
g.fillRect(1200,0,20,620);
g.fillRect(0,620,1220,20);
g.fillRect(0,0,20,620);

g.setColor(Color.green);

cnt=1;
while (cnt<=n)
{  
switch(cnt)
{
case 1: g.fillRect(hx,hy,20,20);
            break;
case 2:g.fillRect(x[0],y[0],20,20);
             break;
case 3:g.fillRect(x[1],y[1],20,20);
            break;
case 4:g.fillRect(x[2],y[2],20,20);
            break;
case 5:g.fillRect(x[3],y[3],20,20);
            break;
case 6:g.fillRect(x[4],y[4],20,20);
            break;
case 7:g.fillRect(x[5],y[5],20,20);
              break;
case 8:g.fillRect(x[6],y[6],20,20);
              break;
case 9:g.fillRect(x[7],y[7],20,20);
              break;
case 10:g.fillRect(x[8],y[8],20,20);
              break;
case 11:g.fillRect(x[9],y[9],20,20);
              break;
case 12:g.fillRect(x[10],y[10],20,20);
              break;
case 13:g.fillRect(x[11],y[11],20,20);
              break;
case 14:g.fillRect(x[12],y[12],20,20);
              break;
case 15:g.fillRect(x[13],y[13],20,20);
              break;
case 16:g.fillRect(x[14],y[14],20,20);
              break;
case 17:g.fillRect(x[15],y[15],20,20);
              break;
case 18:g.fillRect(x[16],y[16],20,20);
              break;
case 19:g.fillRect(x[17],y[17],20,20);
              break;
case 20:g.fillRect(x[18],y[18],20,20);
              break;
case 21:g.fillRect(x[19],y[19],20,20);
              break;
case 22:g.fillRect(x[20],y[20],20,20);
              break;
case 23:g.fillRect(x[21],y[22],20,20);
              break;
case 24:g.fillRect(x[22],y[22],20,20);
              break;
case 25:g.fillRect(x[23],y[23],20,20);
              break;
case 26:g.fillRect(x[24],y[24],20,20);
              break;
case 27:g.fillRect(x[25],y[25],20,20);
              break;
}//end of switch
cnt++;
}//while end

g.setColor(Color.blue);
g.fillArc(hx,hy,10,10,0,360);

//points code
if(next)
  if(n<16)
     if(n%2==0)
      {px=n*20;py=n*20;}
     else 
       {px=n*40;py=n*40;}
  else 
     if(n%2==0)
       {px-=20;py-=40;}
      else
        {px-=40;py-=20;}

g.fillArc(px,py,20,20,0,360);
next=false;
if(n!=1)
{
score=(n-1)*100;g.drawString("Score:"+score,500,30);
}

if(end)
{
g.setColor(Color.black);
g.drawString("Game Over",500,200);
g.drawString("Your Final score is"+score,500,210);
g.drawString("Thanks For playing try Again",500,220);
g.drawString("Designed by ***** gautham ****",500,230);
}
}//end of paint
}//end of program