import java.io.*;
import java.util.Scanner;
import java.awt.event.*;
import javax.swing.*;


public class OpeningBox extends JPanel
{

	private String home;
	private String away;

	public OpeningBox()
	{
		JButton submit = new JButton("Submit");
		JLabel lab1 = new JLabel("Who is going first?");
		JLabel lab2 = new JLabel("Who is going second?");
		final JFrame frame = new JFrame("Opening Box");
		JPanel left = new JPanel();
		JPanel right = new JPanel();
		JPanel pan = new JPanel();
		File f;
		Scanner sc;
		int n = 0;
		String[] names = null;
		int i = 0;

		try
		{
			f = new File("names.txt");
			sc = new Scanner(f);

			while(sc.hasNextLine())
			{
				sc.nextLine();
				n++;
			}

			names = new String[n];

			sc.close();
			sc = new Scanner(f);

			while(sc.hasNextLine())
			{
				names[i] = sc.nextLine();
				i++;
			}
			sc.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}

		final JComboBox jcb1 = new JComboBox(names);
		final JComboBox jcb2 = new JComboBox(names);
		
		jcb1.setEditable(true);
		jcb2.setEditable(true);

		left.setLayout(new BoxLayout(left, BoxLayout.PAGE_AXIS));
		right.setLayout(new BoxLayout(right, BoxLayout.PAGE_AXIS));

		submit.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e)
			{
				home = (String) (jcb1.getSelectedItem());
				away = (String) (jcb2.getSelectedItem());
				frame.dispose();
			}

		});

		left.add(lab1);
		left.add(jcb1);

		right.add(lab2);
		right.add(jcb2);
		
		pan.add(left);
		pan.add(right);

		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(pan);
		this.add(submit);
		

	}

	public String getHome()
	{
		return home;
	}

	public String getAway()
	{
		return away;
	}
}
