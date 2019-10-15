import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Dimension;


class UFrame extends JFrame implements ActionListener
{
	JTextField fname;
	public UFrame(String name3)
	{
		super(name3);
		setSize(320,320);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	getContentPane().setBackground(new java.awt.Color(49, 55, 59));
		FlowLayout fo = new FlowLayout();

		JLabel lbl = new JLabel("Packed File Path/Name",JLabel.LEFT);
		fname = new JTextField(12);
		JPanel pn = new JPanel();
		JPanel pn1 = new JPanel();

		JButton bt = new JButton("Unpack");
		JButton pb = new JButton("Previous");
		bt.setBackground(new java.awt.Color(49, 55, 59));
		bt.setForeground(new java.awt.Color(241, 174, 27));
		lbl.setForeground(new java.awt.Color(239, 240, 241));
		pb.setBackground(new java.awt.Color(49, 55, 59));
		pb.setForeground(new java.awt.Color(241, 174, 27));

		pn1.add(lbl);
		pn1.add(fname);
		pn.add(bt);
		pn.add(pb);
		pn.setBackground(new java.awt.Color(49, 55, 59));
		pn1.setBackground(new java.awt.Color(49, 55, 59));

    	bt.addActionListener(this);
    	pb.addActionListener(this);
		setLayout(fo);

	    add(pn1);
	    add(pn);


    	setVisible(true);
	}
  	public void actionPerformed(ActionEvent e)
  	{
    	String str = e.getActionCommand();
    	if(str.equals("Unpack"))
    	{
      		String fl_name = fname.getText();
      		unPack(fl_name);
      		System.out.println("Files unpacked succesfully");
    	}
    	else if(str.equals("Previous"))
    	{
    		Packer wobj = new Packer("Packing & Unpacking");
    		setVisible(false);
    	}
  }

   private void unPack(String Namef)
  {
  	File file =null;
  	FileReader robj = null;
  	BufferedReader bobj =null;
  	RandomAccessFile fobj=null;
  	FileOutputStream wobj=null;

  	long point;
  	String name=null;
  	int iSize=0;
  	byte buffer[]= new byte[1024];
  	String line =null;
  	int length;
  	try
  	{
  		 file = new File(Namef);
  		 robj = new FileReader(file);
  		 fobj = new RandomAccessFile(file,"r");

  		 point =fobj.getFilePointer();

  		  while((line=fobj.readLine())!=null)
  		  {

  		 	String word[]=line.split(" ");//Split the header
  			 name = word[0];//Seprate the name of the file
  		 	iSize= Integer.parseInt(word[1]);//Separate the fileSize
  		 	length=line.length();//calculate the header size.

  		 	int offset= (int)point;//Convert Offset datatype from long to int

 		 	fobj.read(buffer,offset,iSize);//Read the file from offset to the length of file.


  		 	wobj = new FileOutputStream(name);
  		 	wobj.write(buffer,0,iSize);

  		}


  		 robj.close();
  		 wobj.close();
  		 fobj.close();
  	}
  	catch(Exception ex)
  	{
  		System.out.println(ex);
  	}

  }

}

class Login extends JFrame implements ActionListener
{
	JTextField username=null;
	JPasswordField password =null;

	public Login()
	{
		setTitle("User Login");
		//setPreferredSize( new Dimension(500,300));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);
		getContentPane().setBackground(new Color(49, 55, 59));
		FlowLayout fll = new FlowLayout();
		setLayout(fll);
		JLabel lbl = new JLabel("File Packer Unpacker User Login");
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		JPanel pn = new JPanel();
		JPanel pn1 = new JPanel();
		JPanel pn2 = new JPanel();
		JPanel pn3 = new JPanel();

		JLabel ul = new JLabel("Username:");
		JLabel pw = new JLabel("Password:");

		username= new JTextField(12);
		password= new JPasswordField(12);

		JButton sb = new JButton("Submit");
		sb.setBackground(new Color(110, 115, 117));
		sb.setForeground(new Color(239, 240, 241));
		lbl.setForeground(new Color(239, 240, 241));
		pn.setBackground(new Color(49, 55, 59));
		pn1.setBackground(new Color(49, 55, 59));
		pn2.setBackground(new Color(49, 55, 59));
		pn3.setBackground(new Color(49, 55, 59));
		ul.setForeground(new Color(239, 240, 241));
		pw.setForeground(new Color(239, 240, 241));

		sb.addActionListener(this);
		username.addActionListener(this);
		password.addActionListener(this);

		//ul.setForeground(new Color(239, 240, 241));
		//pw.setForeground(new Color(239, 240, 241));
		sb.setBounds(40,100,50,10);
		setVisible(true);

		pn.add(ul);
		pn.add(username);
		pn1.add(pw);
		pn1.add(password);
		pn2.add(sb);
		pn3.add(lbl);

		add(pn3);
		add(pn);
		add(pn1);
		add(pn2);



	}

	public void actionPerformed(ActionEvent e)
	{
		String str=e.getActionCommand();
		if(str.equals("Submit"))
		{
			String usr=username.getText();
			String pwd=password.getText();

			if((usr.equals("India"))&&(pwd.equals("India")))
			{
				Packer wobj = new Packer("Packing & Unpacking");
				setVisible(false);
			}
		}
	}
}



class NewFrame extends JFrame implements ActionListener
{
	JTextField fname,flname;
	public NewFrame(String name2)
	{
		super(name2);
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	getContentPane().setBackground(new java.awt.Color(49, 55, 59));
		FlowLayout fo = new FlowLayout();

		JLabel lbl = new JLabel("Foleder Name:",JLabel.LEFT);
		fname = new JTextField(10);

		JLabel lbl2 = new JLabel("Output File:",JLabel.LEFT);
		flname = new JTextField(15);
		JPanel pn = new JPanel();
		JPanel pn2 = new JPanel();
		JPanel pn3 = new JPanel();
		JButton bt = new JButton("Pack");
		JButton pb = new JButton("Previous");
		bt.setForeground(new Color(241, 174, 27));
		bt.setBackground(new Color(49, 55, 59));
		pb.setForeground(new Color(241, 174, 27));
		pb.setBackground(new Color(49, 55, 59));
		pn.setBackground(new Color(49, 55, 59));
		lbl.setForeground(new Color(239, 240, 241));
		pn2.setBackground(new Color(49, 55, 59));
		lbl2.setForeground(new Color(239, 240, 241));
		pn3.setBackground(new Color(49, 55, 59));

		pn.add(lbl);
		pn.add(fname);
		pn2.add(lbl2);
		pn2.add(flname);
		pn3.add(bt);
		pn3.add(pb);

		bt.addActionListener(this);
		pb.addActionListener(this);

		setLayout(fo);

		add(pn);
		add(pn2);
		add(pn3);

    setVisible(true);
	}

	public void actionPerformed(ActionEvent a)
	{
		String str = a.getActionCommand();

		if(str.equals("Pack"))
		{
			String folder = fname.getText();
			String file = flname.getText();
			packFile(folder,file);
		}
		else if(str.equals("Previous"))
    	{
    		Packer wobj = new Packer("Packing & Unpacking");
    		setVisible(false);
    	}
	}

	private void packFile(String Dname, String Fname)
	{
		try
		{
		File fold = new File(Dname);
		FileOutputStream file = new FileOutputStream(Fname,true);
		FileInputStream robj=null;

		File list[]=fold.listFiles();
		String header,nam;
		int length=0;
		byte buffer[] = new byte[1024];
		for(File temp:list)
		{
			nam=temp.getName();
			File f1=new File(Dname,nam);
			header=nam+" "+f1.length()+"\n";

			robj = new FileInputStream(Dname+"/"+nam);
			byte hedr[] = header.getBytes();
			file.write(hedr,0,hedr.length);
			while((length=robj.read(buffer))>0)
			{
				file.write(buffer,0,length);
			}

		}

		file.close();
		robj.close();
		System.out.println("Files packed succesfully");

	}
	catch(Exception ex)
	{
		System.out.println(ex);
	}
	}
}

public class Packer extends JFrame implements ActionListener
{
	public Packer(String name)
	{
		super(name);// calls the constructor of JFrame class, parameter 'name' sends the frame title to the Constructor of JFreame
		setSize(500,300);// Set the size of frame to W=350 and H=125 pixels.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Closes the frame when user clicks on close button.
   	    //getContentPane().setBackground(new java.awt.Color(153, 153, 255));
		getContentPane().setBackground(new java.awt.Color(49, 55, 59));
		FlowLayout fl = new FlowLayout();//Create Button layout within a frame

		JButton pb = new JButton("Packing");//Create Button
		JButton ub = new JButton("Unpacking");//Create Button
		pb.setBackground(new java.awt.Color(0, 170, 255));
		pb.setForeground(new java.awt.Color(0,0,0));
		ub.setBackground(new java.awt.Color(0, 170, 255));
		ub.setForeground(new java.awt.Color(0,0,0));


		setLayout(fl);//Set Button layout within a frame

		add(pb);
		add(ub);

    pb.addActionListener(this);
    ub.addActionListener(this);

		//pack();
		setVisible(true);
	}

      public void actionPerformed(ActionEvent e)
      {
        String str = e.getActionCommand();
        if(str.equals("Packing"))
        {
          NewFrame nobj =new NewFrame("Packing");
          setVisible(false);
        }
        else if(str.equals("Unpacking"))
        {
          UFrame uobj =new UFrame("Unpacking");
          setVisible(false);
        }


      }

	private void setLook()
	{
		try
		{
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.numbus.NimbusLookAndFeel");
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public static void main(String arg[])
	{

		Login lobj = new Login();
	}
}
