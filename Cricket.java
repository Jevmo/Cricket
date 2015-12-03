import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.BorderFactory;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;


public class Cricket extends JPanel
{
    /*
     *dartboard panel next to info panel
     *all above button panel
     */

    private JButton undo = new JButton("Undo");
    private JButton newGame = new JButton("New Game");
    private JButton stats = new JButton("Stats");

	private JPanel rightPan = new JPanel();
	private JPanel buttonPan = new JPanel();
	private Score score;
	private Board db;
  	private JTextArea cc;
	private String home,away;
	private Scoreboard sb;

    public Cricket()
    {

		/*OpeningBox ob = new OpeningBox();
		home = ob.getHome();
		away=ob.getAway();
		*/
		System.out.println("Who is going first?");
		java.util.Scanner sc = new java.util.Scanner(System.in);
		home = sc.nextLine();
		System.out.println("Who is going second?");
		away = sc.nextLine();

		score = new Score(home,away);
		cc = new JTextArea();
			
		sb = new Scoreboard(score);
		db = new Board(sb);

		cc.setPreferredSize(new Dimension(300, 210));
		cc.setEditable(false);
		cc.setBackground(new Color(18, 21, 62));

		 buttonPan.setLayout(new FlowLayout());
		 buttonPan.add(stats);
		 buttonPan.add(undo);
		 buttonPan.add(newGame);
		 buttonPan.setPreferredSize(new Dimension(300, 40));

		 rightPan.setLayout(new BoxLayout(rightPan, BoxLayout.Y_AXIS));
		 rightPan.add(sb);
		 rightPan.add(cc);
		 rightPan.add(buttonPan);


		 this.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));	
		 this.add(db);
		 this.add(rightPan);

		 this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    }

	

    public static  void createAndShowGUI()
    {
        JFrame frame = new JFrame("Cricket");
        frame.add(new Cricket());
        frame.pack() ;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String args[])
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}
