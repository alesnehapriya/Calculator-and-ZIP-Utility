package Calculator;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

class calgui extends JFrame implements ActionListener
{
//declare components
JTextField tf,tftop,ttape,memory_label,memory_result;
JButton n0,n1,n2,n3,n4,n5,n6,n7,n8,n9;
JButton badd,bsub,bmul,bdiv,beql,bclr,bdot,bquit,bsqrt,bsqr,bexp,blog,sin,cos,tan,mc,mr,mminus,mplus,percentage,history;
JPanel ptrig,p0,p1,p2,p3,p4,p5,ptext,panel_display,ptop,px;
JFrame f;
JButton a,b,c,d,e,f1;
Font font;
JRadioButton binary,hdec,dec;
Object[] selectionValues=null;
GridBagConstraints gbc_lblNewLabel_1;
JLabel lb1;
Connection connect=null;
JMenu fileMenu;
JMenuBar menu;
//end of component declare

//declare variables
String value="",fvalue="",tvalue="", tvalue1="";
String opr;
String str="";
double value1=0.0,value2=0.0,answer,memory=0,memory1=0;
int ctr=0,vctr=0,vcol=1,ctrsqr=0,check=0;
JMenuItem program,scientific,Standard;
//end of variable declaration
calgui()
{
f=new JFrame(" A Calculator");

connect = databaseConnection.connector();

memory_label = new JTextField(5);
memory_label.setBounds(0, 5, 68, 26);
memory_result = new JTextField(5);
memory_result.setBounds(70, 5, 68, 26);

Icon icon = new ImageIcon("C:\\Users\\aelay\\workspace\\CalculatorGUI\\Resources\\Eraser.png");

menu = new JMenuBar();

fileMenu = new JMenu("Functions");
fileMenu.setMnemonic(KeyEvent.VK_F);
menu.add(fileMenu);

program = new JMenuItem("Programmer");
scientific = new JMenuItem("Scientific");
Standard = new JMenuItem("Standard");
fileMenu.add(program);
fileMenu.add(scientific);
fileMenu.add(Standard);

mc = new JButton("MC");
mr = new JButton("MR");
mminus = new JButton("M-");
mplus = new JButton("M+");
percentage = new JButton("%");
sin = new JButton("Sin(x)");
cos = new JButton("Cos(x)");
tan = new JButton("Tan(x)");
blog = new JButton("log(x)");
bexp = new JButton("e^x");
bsqrt = new JButton("√");
bsqr = new JButton("x^2");
bmul=new JButton("*");
bsub=new JButton("-");
badd=new JButton("+");
bdiv=new JButton("/");
bdot=new JButton(".");
bclr=new JButton(icon);
beql=new JButton("=");
bquit=new JButton("CE");
history = new JButton("History");

a= new JButton("A");
b= new JButton("B");
c=new JButton("C");
d = new JButton("D");
e= new JButton("E");
f1= new JButton("F");

lb1 = new JLabel();

n0=new JButton("0");
n1=new JButton("1");
n2=new JButton("2");
n3=new JButton("3");
n4=new JButton("4");
n5=new JButton("5");
n6=new JButton("6");
n7=new JButton("7");
n8=new JButton("8");
n9=new JButton("9");

binary= new JRadioButton("Binary");
hdec= new JRadioButton("HexaDecimal");
dec= new JRadioButton("Decimal");

ButtonGroup btn_group= new ButtonGroup();
btn_group.add(binary);
btn_group.add(hdec);
btn_group.add(dec);

dec.setSelected(true);


tf=new JTextField(35);
tftop=new JTextField(35);
ttape = new JTextField(35);
ttape.setBorder(null);
tf.setBorder(null);
tftop.setBorder(null);
memory_label.setBorder(null);
memory_result.setBorder(null);
tf.setBackground(Color.BLACK);
tftop.setBackground(Color.black);
tf.setForeground(Color.white);
tftop.setForeground(Color.white);
ttape.setBackground(Color.black);
ttape.setForeground(Color.white);
memory_label.setForeground(Color.white);
memory_label.setBackground(Color.black);
memory_result.setForeground(Color.white);
memory_result.setBackground(Color.black);
binary.setBackground(Color.black);
binary.setForeground(Color.white);
hdec.setBackground(Color.black);
hdec.setForeground(Color.white);
dec.setBackground(Color.black);
dec.setForeground(Color.white);

font = new Font("Serif", Font.BOLD, 25);

a.setFont(font);
b.setFont(font);
c.setFont(font);
d.setFont(font);
e.setFont(font);
f1.setFont(font);
memory_label.setFont(new Font("Serif",Font.BOLD,18));
memory_result.setFont(new Font("Serif",Font.BOLD,18));
binary.setFont(font);
hdec.setFont(font);
dec.setFont(font);
mc.setFont(font);
mr.setFont(font);
mminus.setFont(font);
mplus.setFont(font);
sin.setFont(font);
cos.setFont(font);
tan.setFont(font);
blog.setFont(font);
bexp.setFont(font);
bsqr.setFont(font);
bsqrt.setFont(font);
bmul.setFont(font);
bsub.setFont(font);
badd.setFont(font);
bdiv.setFont(font);
bdot.setFont(font);
bclr.setFont(font);
beql.setFont(font);
bquit.setFont(font);
n0.setFont(font);
n1.setFont(font);
n2.setFont(font);
n3.setFont(font);
n4.setFont(font);
n5.setFont(font);
n6.setFont(font);
n7.setFont(font);
n8.setFont(font);
n9.setFont(font);
tf.setFont(font);
tftop.setFont(font);
ttape.setFont(font);
history.setFont(font);

lb1.setBackground(Color.black);
n0.setBackground(Color.black);
n1.setBackground(Color.black);
n2.setBackground(Color.black);
n3.setBackground(Color.black);
n4.setBackground(Color.black);
n5.setBackground(Color.black);
n6.setBackground(Color.black);
n7.setBackground(Color.black);
n8.setBackground(Color.black);
n9.setBackground(Color.black);
bquit.setBackground(Color.gray);
beql.setBackground(Color.gray);
bclr.setBackground(Color.gray);
bdot.setBackground(Color.gray);
bdiv.setBackground(Color.gray);
badd.setBackground(Color.gray);
bsub.setBackground(Color.gray);
bmul.setBackground(Color.gray);
bsqrt.setBackground(Color.gray);
bsqr.setBackground(Color.gray);
bexp.setBackground(Color.gray);
blog.setBackground(Color.gray);
sin.setBackground(Color.gray);
cos.setBackground(Color.gray);
tan.setBackground(Color.gray);
mc.setBackground(Color.gray);
mr.setBackground(Color.gray);
mplus.setBackground(Color.gray);
mminus.setBackground(Color.gray);
history.setBackground(Color.gray);
a.setBackground(Color.gray);
b.setBackground(Color.gray);
c.setBackground(Color.gray);
d.setBackground(Color.gray);
e.setBackground(Color.gray);
f1.setBackground(Color.gray);

lb1.setForeground(Color.white);
n0.setForeground(Color.white);
n1.setForeground(Color.white);
n2.setForeground(Color.white);
n3.setForeground(Color.white);
n4.setForeground(Color.white);
n5.setForeground(Color.white);
n6.setForeground(Color.white);
n7.setForeground(Color.white);
n8.setForeground(Color.white);
n9.setForeground(Color.white);
bquit.setForeground(Color.black);
beql.setForeground(Color.black);
bclr.setForeground(Color.black);
bdot.setForeground(Color.black);
bdiv.setForeground(Color.black);
badd.setForeground(Color.black);
bsub.setForeground(Color.black);
bmul.setForeground(Color.black);
bsqrt.setForeground(Color.black);
bsqr.setForeground(Color.black);
bexp.setForeground(Color.black);
blog.setForeground(Color.black);
sin.setForeground(Color.black);
cos.setForeground(Color.black);
tan.setForeground(Color.black);
mc.setForeground(Color.black);
mr.setForeground(Color.black);
mplus.setForeground(Color.black);
mminus.setForeground(Color.black);
history.setForeground(Color.BLACK);
a.setForeground(Color.black);
b.setForeground(Color.black);
c.setForeground(Color.black);
d.setForeground(Color.black);
e.setForeground(Color.black);
f1.setForeground(Color.black);

ptrig=new JPanel(new GridLayout(1,3,0,0));
p0=new JPanel(new GridLayout(1,2,0,0) );
p1=new JPanel(new GridLayout(1,3,0,0) );
p2=new JPanel(new GridLayout(1,3,0,0) );
p3=new JPanel(new GridLayout(1,3,0,0) );
p4=new JPanel(new GridLayout(1,3,0,0) );
p5=new JPanel(new GridLayout(1,3,0,0) );
ptext = new JPanel();
ptext.setLayout(new BorderLayout());
panel_display = new JPanel();
ptop = new JPanel(new GridLayout(1,3,0,0));
px = new JPanel(new GridLayout(1,3,0,0));

}

public void launchframe()
{
tf.setText("");
tftop.setText("");

memory_label.setText("Memory ");
memory_result.setText("  ");

ptop.add(binary);
ptop.add(hdec);
ptop.add(dec);

ptrig.add(sin);
ptrig.add(cos);
ptrig.add(cos);
ptrig.add(tan);
ptrig.add(history);

p0.add(blog);
p0.add(bsqrt);
p0.add(bsqr);
p0.add(bexp);

p1.add(mc);
p1.add(n1);
p1.add(n2);
p1.add(n3);
p1.add(badd);

p2.add(mr);
p2.add(n4);
p2.add(n5);
p2.add(n6);
p2.add(bsub);

p3.add(mminus);
p3.add(n7);
p3.add(n8);
p3.add(n9);
p3.add(bmul);

p4.add(mplus);
p4.add(bdot);
p4.add(n0);
p4.add(beql);
p4.add(bdiv);

p5.add(bclr);
p5.add(bquit);

ptext.add(memory_label,BorderLayout.WEST);
ptext.add(memory_result,BorderLayout.CENTER);
ptext.add(ttape,BorderLayout.EAST);

p5.add(a);
p5.add(b);
p5.add(c);
p5.add(d);
p5.add(e);
p5.add(f1);

f.setLayout(new GridLayout(11,1,0,0));
//f.setResizable(false);
f.setSize(600,600);
f.add(ptext);
f.add(tftop);
f.add(tf);

f.add(ptop);
f.add(ptrig);
f.add(p0);
f.add(p3);
f.add(p2);
f.add(p1);
f.add(p4);
f.add(p5);
f.setJMenuBar(menu);
//f.add(px);


f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//f.add(swcol);

f.setVisible(true);

//Action Listener
mr.addActionListener(this);
mc.addActionListener(this);
mminus.addActionListener(this);
mplus.addActionListener(this);
sin.addActionListener(this);
cos.addActionListener(this);
tan.addActionListener(this);
blog.addActionListener(this);
bexp.addActionListener(this);
bsqr.addActionListener(this);
bsqrt.addActionListener(this);
bquit.addActionListener(this);
n0.addActionListener(this);
n1.addActionListener(this);
n2.addActionListener(this);
n3.addActionListener(this);
n4.addActionListener(this);
n5.addActionListener(this);
n6.addActionListener(this);
n7.addActionListener(this);
n8.addActionListener(this);
n9.addActionListener(this);
bdot.addActionListener(this);
bclr.addActionListener(this);
badd.addActionListener(this);
beql.addActionListener(this);
bsub.addActionListener(this);
bmul.addActionListener(this);
bdiv.addActionListener(this);
history.addActionListener(this);
binary.addActionListener(this);
hdec.addActionListener(this);
dec.addActionListener(this);
program.addActionListener(new ActionListener(){

	@Override
	public void actionPerformed(ActionEvent e1) {
		// TODO Auto-generated method stub
		
		history.setBackground(Color.black);
		history.setForeground(Color.white);
		history.setBorder(null);
		ptop.add(binary);
		ptop.add(hdec);
		ptop.add(dec);
		ptop.add(history);
		
		p1.add(mc);
		p1.add(n1);
		p1.add(n2);
		p1.add(n3);
		p1.add(badd);

		p2.add(mr);
		p2.add(n4);
		p2.add(n5);
		p2.add(n6);
		p2.add(bsub);

		p3.add(mminus);
		p3.add(n7);
		p3.add(n8);
		p3.add(n9);
		p3.add(bmul);

		p4.add(mplus);
		p4.add(bdot);
		p4.add(n0);
		p4.add(beql);
		p4.add(bdiv);

		p5.add(bclr);
		p5.add(bquit);
		ptext.add(memory_label,BorderLayout.WEST);
		ptext.add(memory_result,BorderLayout.CENTER);
		ptext.add(ttape,BorderLayout.EAST);

		p5.add(a);
		p5.add(b);
		p5.add(c);
		p5.add(d);
		p5.add(e);
		p5.add(f1);
		
		f.setLayout(new GridLayout(9,1,0,0));
		//f.setResizable(false);
		f.setSize(600,600);
		f.add(ptext);
		f.add(tftop);
		f.add(tf);

		f.add(ptop);
		f.add(p3);
		f.add(p2);
		f.add(p1);
		f.add(p4);
		f.add(p5);
		f.setJMenuBar(menu);
		
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	
});
scientific.addActionListener(new ActionListener(){

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ptrig.add(sin);
		ptrig.add(cos);
		ptrig.add(cos);
		ptrig.add(tan);
		ptrig.add(history);

		p0.add(blog);
		p0.add(bsqrt);
		p0.add(bsqr);
		p0.add(bexp);

		p1.add(mc);
		p1.add(n1);
		p1.add(n2);
		p1.add(n3);
		p1.add(badd);

		p2.add(mr);
		p2.add(n4);
		p2.add(n5);
		p2.add(n6);
		p2.add(bsub);

		p3.add(mminus);
		p3.add(n7);
		p3.add(n8);
		p3.add(n9);
		p3.add(bmul);

		p4.add(mplus);
		p4.add(bdot);
		p4.add(n0);
		p4.add(beql);
		p4.add(bdiv);

		p5.add(bclr);
		p5.add(bquit);

		ptext.add(memory_label,BorderLayout.WEST);
		ptext.add(memory_result,BorderLayout.CENTER);
		ptext.add(ttape,BorderLayout.EAST);
		f.setLayout(new GridLayout(11,1,0,0));
		//f.setResizable(false);
		f.setSize(600,600);
		f.add(ptext);
		f.add(tftop);
		f.add(tf);

		f.add(ptrig);
		f.add(p0);
		f.add(p3);
		f.add(p2);
		f.add(p1);
		f.add(p4);
		f.add(p5);
		f.setJMenuBar(menu);
		//f.add(px);


		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//f.add(swcol);

		f.setVisible(true);


		
	}
	
});
Standard.addActionListener(new ActionListener(){

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		p1.add(mc);
		p1.add(n1);
		p1.add(n2);
		p1.add(n3);
		p1.add(badd);
		
		p2.add(mr);
		p2.add(n4);
		p2.add(n5);
		p2.add(n6);
		p2.add(bsub);

		p3.add(mminus);
		p3.add(n7);
		p3.add(n8);
		p3.add(n9);
		p3.add(bmul);

		p4.add(mplus);
		p4.add(bdot);
		p4.add(n0);
		p4.add(beql);
		p4.add(bdiv);

		p5.add(bclr);
		p5.add(bquit);
		p5.add(history);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ptext.add(memory_label,BorderLayout.WEST);
		ptext.add(memory_result,BorderLayout.CENTER);
		ptext.add(ttape,BorderLayout.EAST);
		
		f.setLayout(new GridLayout(8,1,0,0));
		

		f.setSize(600,600);
		f.add(ptext);
		f.add(tftop);
		f.add(tf);
		
		f.add(p3);
		f.add(p2);
		f.add(p1);
		f.add(p4);
		f.add(p5);
		f.setJMenuBar(menu);

		//f.add(swcol);

		f.setVisible(true);
		
	}
	
});


//swcol.addActionListener(this);

addWindowListener(new WindowAdapter()
{
	public void windowClosing(WindowEvent e)
	{
		f.dispose();
		}
	}
);

}

public void actionPerformed(ActionEvent ae)
{
	
	AbstractButton radionbtn = (AbstractButton) ae.getSource();
	if(radionbtn.getText()== "Binary"){
		System.out.println("Binary");
		JOptionPane.showMessageDialog(null, "Select 1/0 to enter Binary number");
		if(value!=null){
			tf.setText(Integer.toBinaryString(Integer.parseInt(value)));
		}
	}
	
	if(radionbtn.getText()=="HexaDecimal"){
		System.out.println("Hexa Decimal");
		JOptionPane.showMessageDialog(null, "You can select A-F and 0-9 to enter HexaDecimal number.");
		if(value!=null){
			tf.setText(Integer.toHexString(Integer.parseInt(value)));
		}
		
	}

try
{
if (ae.getSource()==bquit) System.exit(0);

if (ae.getSource()==bclr) { value=""; tvalue="0";ctr=0;tftop.setText(tvalue); tf.setText("0");vctr=0; tvalue=""; check=0; }

if (ae.getSource()==n0) { value=value+0;tftop.setText(tvalue); tf.setText(value); }
if (ae.getSource()==n1) { value=value+1;tftop.setText(tvalue); tf.setText(value); }
if (ae.getSource()==n2) { value=value+2;tftop.setText(tvalue); tf.setText(value); }
if (ae.getSource()==n3) { value=value+3;tftop.setText(tvalue); tf.setText(value); }
if (ae.getSource()==n4) { value=value+4;tftop.setText(tvalue); tf.setText(value); }
if (ae.getSource()==n5) { value=value+5;tftop.setText(tvalue); tf.setText(value); }
if (ae.getSource()==n6) { value=value+6;tftop.setText(tvalue); tf.setText(value); }
if (ae.getSource()==n7) { value=value+7;tftop.setText(tvalue); tf.setText(value); }
if (ae.getSource()==n8) { value=value+8;tftop.setText(tvalue); tf.setText(value); }
if (ae.getSource()==n9) { value=value+9;tftop.setText(tvalue); tf.setText(value); }
if (ae.getSource()==a) { value=value+"A";tftop.setText(tvalue); tf.setText(value); }
if (ae.getSource()==b) { value=value+"B";tftop.setText(tvalue); tf.setText(value); }
if (ae.getSource()==c) { value=value+"C";tftop.setText(tvalue); tf.setText(value); }
if (ae.getSource()==d) { value=value+"D";tftop.setText(tvalue); tf.setText(value); }
if (ae.getSource()==e) { value=value+"E";tftop.setText(tvalue); tf.setText(value); }
if (ae.getSource()==f1) { value=value+"F";tftop.setText(tvalue); tf.setText(value); }

if(ae.getSource()== mplus){
	System.out.println(memory+"  "+value);
	memory=memory+ Double.parseDouble(value);
	memory1=Double.parseDouble(value);
	JOptionPane.showMessageDialog(null, "Stored in Memory .");
	memory_result.setText(Double.toString(memory));
	
}

if(ae.getSource()== history){
	
	CalculatorGUI gui= new CalculatorGUI();
	gui.getContentPane().setVisible(true);
}

if(ae.getSource()==mr){
	if(memory!=0){
	tf.setText(Double.toString(memory));
	}
	else 
		JOptionPane.showMessageDialog(null, "Memory is Empty.");

}
if(ae.getSource()==mc){
	memory=0;
	memory_result.setText(Double.toString(memory));
}
if(ae.getSource()==mminus){
	memory=memory-memory1;
	memory_result.setText(Double.toString(memory));
}

if (ae.getSource()==bdot) 
{    if (ctr==0) 
    { value=value+".";
    tvalue=value+value;
    tftop.setText(tvalue);
    tf.setText(value);
    ctr+=1;
    }
}

if(ae.getSource() == sin){
	if(vctr==1){
		equal();
		value1=Double.parseDouble(tf.getText());
		tvalue = "sin("+value1+")"+value;
	}
	else{
		vctr=1;
		value1= Double.parseDouble(tf.getText());
		if(check==0){
			tvalue = "sin("+value1+")"+tvalue;
			check++;
		}
		else{
			tvalue = "sin("+value1+")"+value;
		}
		
		tftop.setText(tvalue);
		tf.setText("");
		value="";
	}
	opr= "Sin(x)";
	ctr=0;
	ctrsqr=1;	
	
}
if(ae.getSource() == cos){
	if(vctr==1){
		equal();
		value1=Double.parseDouble(tf.getText());
		tvalue = "cos("+value1+")"+value;
	}
	else{
		vctr=1;
		value1= Double.parseDouble(tf.getText());
		if(check==0){
			tvalue = "cos("+value1+")"+tvalue;
			check++;
		}
		else{
			tvalue = "cos("+value1+")"+value;
		}
		
		tftop.setText(tvalue);
		tf.setText("");
		value="";
	}
	opr= "Cos(x)";
	ctr=0;
	ctrsqr=1;	
	
}
if(ae.getSource() == tan){
	if(vctr==1){
		equal();
		value1=Double.parseDouble(tf.getText());
		tvalue = "tan("+value1+")"+value;
	}
	else{
		vctr=1;
		value1= Double.parseDouble(tf.getText());
		if(check==0){
			tvalue = "tan("+value1+")"+tvalue;
			check++;
		}
		else{
			tvalue = "tan("+value1+")"+value;
		}
		
		tftop.setText(tvalue);
		tf.setText("");
		value="";
	}
	opr= "Tan(x)";
	ctr=0;
	ctrsqr=1;	
	
}

if(ae.getSource()==blog){
	if(vctr==1){
		equal();
		value1=Double.parseDouble(tf.getText());
		tvalue = "log("+value1+")"+value;
	}
	else{
		vctr=1;
		value1= Double.parseDouble(tf.getText());
		if(check==0){
			tvalue = "log("+value1+")"+tvalue;
			check++;
		}
		else{
			tvalue = "log("+value1+")"+value;
		}
		
		tftop.setText(tvalue);
		tf.setText("");
		value="";
	}
	opr= "log(x)";
	ctr=0;
	ctrsqr=1;
}

if(ae.getSource()== bexp){
	if(vctr==1){
		equal();
		value1=Double.parseDouble(tf.getText());
		tvalue = "e^"+value1+value;
	}
	else{
		vctr=1;
		value1= Double.parseDouble(tf.getText());
		if(check==0){
			tvalue = "e^"+value1+tvalue;
			check++;
		}
		else{
			tvalue = "e^"+value1+value;
		}
		tftop.setText(tvalue);
		tf.setText("");
		value="";
	}
	opr= "e^x";
	ctr=0;
	ctrsqr=1;
	
}

if(ae.getSource()==bsqr) {
	
	if(vctr==1){
		equal();
		value1=Double.parseDouble(tf.getText());
		tvalue = value1+"^2"+value;
	}
	else{
		vctr=1;
		value1= Double.parseDouble(tf.getText());
		if(check==0){
			tvalue = value1+"^2"+tvalue;
			check++;
		}
		else{
			tvalue = value1+"^2"+value;
		}
		tftop.setText(tvalue);
		tf.setText("");
		value="";
	}
	opr= "x^2";
	ctr=0;
	ctrsqr=1;
	
}

if(ae.getSource()==bsqrt){
	if(vctr==1){
		equal();
		value1=Double.parseDouble(tf.getText());
		tvalue = "√("+value1+")"+value;
	}
	else{
		vctr=1;
		value1= Double.parseDouble(tf.getText());
		if(check==0){
			tvalue = "√("+value1+")"+tvalue;
			check++;
		}
		else{
			tvalue = "√("+value1+")"+value;
		}
		tftop.setText(tvalue);
		tf.setText("");
		value="";
	}
	opr= "√";
	ctr=0;
	ctrsqr=1;
}

if (ae.getSource()==beql) 
{   equals();
}

if (ae.getSource()==badd)
{ if (vctr==1) {
	equal();
	value1=Double.parseDouble(tf.getText());
	tvalue=value1+"+"+value;
	
} 
else {
	vctr=1;
	value1=Double.parseDouble(tf.getText());
	if(check==0){
		tvalue = value1+"+"+tvalue;
		check++;
	}
	else{
		tvalue=value1+"+"+value;
	}
	tftop.setText(tvalue);
	tf.setText("");
	value="";
}
ctr=0;opr="+";
	
}

if (ae.getSource()==bsub)
{ if (vctr==1) {equal();value1=Double.parseDouble(tf.getText());
tvalue=value1+"-"+value;
} else {vctr=1;value1=Double.parseDouble(tf.getText());
if(check==0){
	tvalue = value1+"-"+tvalue;
	check++;
}
else{
	tvalue=value1+"-"+value;
}
tftop.setText(tvalue);
tf.setText("");value="";}
ctr=0;opr="-";}

if (ae.getSource()==bmul)
{ if (vctr==1) {
	equal();value1=Double.parseDouble(tf.getText());
	tvalue=value1+"*"+value;

} else {vctr=1;value1=Double.parseDouble(tf.getText());
if(check==0){
	tvalue = value1+"*"+tvalue;
	check++;
}
else{
	tvalue=value1+"*"+value;
}

tftop.setText(tvalue);
tf.setText("");value="";}
ctr=0;opr="*";}

if (ae.getSource()==bdiv)
{ if (vctr==1) {equal();value1=Double.parseDouble(tf.getText());
tvalue = value1+"/"+value;
} else {
	vctr=1;value1=Double.parseDouble(tf.getText());
	if(check==0){
		tvalue = value1+"/"+tvalue;
		check++;
	}
	else{
		tvalue = value1+"/"+value;
	}

tftop.setText(tvalue);
tf.setText("");value="";}
ctr=0;opr="/";}

}
catch(Exception e)
{
	e.printStackTrace();
	System.out.println(e);}
}
void equal()
{
	value2=Double.parseDouble(tf.getText());ctr=0;
//	tvalue = value+value2;
//	tftop.setText(tvalue);
	if(opr=="Sin(x)"){ answer=Math.sin(value1); value=""+answer;tf.setText(value);}
	if(opr=="Cos(x)"){ answer=Math.cos(value1); value=""+answer;tf.setText(value);}
	if(opr=="Tan(x)"){ answer=Math.tan(value1); value=""+answer;tf.setText(value);}
	if(opr=="log(x)"){ answer= Math.log(value1); value=""+answer; tf.setText(value);}
	if(opr=="e^x") {answer= Math.exp(value1); value=""+answer; tf.setText(value);}
	if(opr=="√") {answer= Math.sqrt(value1); value=""+answer; tf.setText(value);}
	if(opr=="x^2") {answer= value1*value1; value=""+answer; tf.setText(value);}
    if (opr=="+") {answer=value1+value2;value=""+answer;tf.setText(value);}
    if (opr=="-") {answer=value1-value2;value=""+answer;tf.setText(value);}
    if (opr=="*") {answer=value1*value2;value=""+answer;tf.setText(value);}
    if (opr=="/") {answer=value1/value2;value=""+answer;tf.setText(value);}
    tftop.setText(value);
   value="";
}
void equals()
{
	if(ctrsqr!=1){
		value2=Double.parseDouble(tf.getText());ctr=0;
		tvalue = tvalue+value2;
		tftop.setText(tvalue);
	}
	
	if(opr=="Sin(x)"){ answer=Math.sin(value1); value=""+answer;tf.setText(value);}
	if(opr=="Cos(x)"){ answer=Math.cos(value1); value=""+answer;tf.setText(value);}
	if(opr=="Tan(x)"){ answer=Math.tan(value1); value=""+answer;tf.setText(value);}
	if(opr=="log(x)"){ answer= Math.log(value1);value=""+answer; tf.setText(value);}
	if(opr=="e^x") {answer= Math.exp(value1); value=""+answer; tf.setText(value);}
	if(opr=="√") {answer= Math.sqrt(value1); value=""+answer; tf.setText(value);}
	if(opr=="x^2") {answer= value1*value1; value=""+answer; tf.setText(value);}
    if (opr=="+") {
    	if(dec.isSelected()==true){
    	answer=value1+value2;
    	value=""+answer;
    	tf.setText(value);
    	}
    	if(binary.isSelected()==true){
    		String binary1 = String.valueOf((int)value1);
    		String binary2 = String.valueOf((int)value2);
    		answer = Integer.parseInt(binary1,2)+ Integer.parseInt(binary2,2);
    		value = ""+Integer.toBinaryString((int)answer);
    		tf.setText(value);
    	}
    	if(hdec.isSelected()==true){
    		String binary1 = String.valueOf((int)value1);
    		String binary2 = String.valueOf((int)value2);
    		answer = Integer.parseInt(binary1,16)+ Integer.parseInt(binary2,16);
    		value = ""+Integer.toHexString((int)answer);
    		tf.setText(value);
    	}
    	}
    if (opr=="-") {
    	if(dec.isSelected()==true){
    	answer=value1-value2;
    	value=""+answer;
    	tf.setText(value);
    	}
    	if(binary.isSelected()==true){
    		String binary1 = String.valueOf((int)value1);
    		String binary2 = String.valueOf((int)value2);
    		answer = Integer.parseInt(binary1,2)- Integer.parseInt(binary2,2);
    		value = ""+Integer.toBinaryString((int)answer);
    		tf.setText(value);
    	}
    	if(hdec.isSelected()==true){
    		String binary1 = String.valueOf((int)value1);
    		String binary2 = String.valueOf((int)value2);
    		answer = Integer.parseInt(binary1,16)- Integer.parseInt(binary2,16);
    		value = ""+Integer.toHexString((int)answer);
    		tf.setText(value);
    	}
    	}
    if (opr=="*") {
    	if(dec.isSelected()==true){
    	answer=value1*value2;
    	value=""+answer;
    	tf.setText(value);
    	}
    	if(binary.isSelected()==true){
    		String binary1 = String.valueOf((int)value1);
    		String binary2 = String.valueOf((int)value2);
    		answer = Integer.parseInt(binary1,2)* Integer.parseInt(binary2,2);
    		value = ""+Integer.toBinaryString((int)answer);
    		tf.setText(value);
    	}
    	if(hdec.isSelected()==true){
    		String binary1 = String.valueOf((int)value1);
    		String binary2 = String.valueOf((int)value2);
    		answer = Integer.parseInt(binary1,16)* Integer.parseInt(binary2,16);
    		value = ""+Integer.toHexString((int)answer);
    		tf.setText(value);
    	}
    	
    }
    if (opr=="/") {
    	if(dec.isSelected()==true){
    	answer=value1/value2;
    	value=""+answer;
    	tf.setText(value);
    	}
    	if(binary.isSelected()==true){
    		String binary1 = String.valueOf((int)value1);
    		String binary2 = String.valueOf((int)value2);
    		answer = Integer.parseInt(binary1,2)/ Integer.parseInt(binary2,2);
    		value = ""+Integer.toBinaryString((int)answer);
    		tf.setText(value);
    	}
    	if(hdec.isSelected()==true){
    		String binary1 = String.valueOf((int)value1);
    		String binary2 = String.valueOf((int)value2);
    		answer = Integer.parseInt(binary1,16)/ Integer.parseInt(binary2,16);
    		value = ""+Integer.toHexString((int)answer);
    		tf.setText(value);
    	}
    	
    	}
    tftop.setText(tvalue+"="+value);
    str=tvalue+"="+value;
    try {
        String query ="insert into Calculator (Object) Values(?)";
        String query_delete="delete from Calculator";
		PreparedStatement statement = connect.prepareStatement(query);
		PreparedStatement statement_delete = connect.prepareStatement(query_delete);
		statement.setString(1,str);
		statement_delete.execute();
		statement.execute();
		
		statement.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    lb1.setText(str);
   value="";vctr=0;
}
}

public class Calculator2
{
public static void main(String args[])
{
calgui t=new calgui();
t.launchframe();
}
}











