import javax.swing.event.*;
import javax.swing.undo.*;
import javax.swing.text.*;
import javax.swing.*;
import java.util.Stack;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Font;

/*

   All classes that need to be connected should be connected in 
   a clean way that can be easily changed if necessary.
   Only data transfers: names(from dialog) > Score > Scoreboard
          Dartboard>Score>Scoreboard, console

   I can save all data by adding every single score in the 
   order it happened. Can store in json.

*/

public class Scoreboard extends JTextArea
{
    private final int WIDTH = 300;
    private final int HEIGHT = 300;

    private String s = "name1";
    private String t = "name2";

    private String home;
    private String away;

    private boolean debug = true;
    
    private Score score;

    public Scoreboard(Score score)
    {
        this.score = score;
		Dimension d = new Dimension(WIDTH, HEIGHT);
		this.setPreferredSize(d);
        this.setEditable(false);
		this.setBackground(new Color(50,125,50));
		printScore();
    }



    public void printScore()
    {

        Font font = new Font("Courier", Font.BOLD, 19);
		this.setForeground(Color.WHITE);
		this.setFont(font);
		this.setText(null);
		String nameStr;
		if(score.getTeam() == 'a')
		{
			nameStr = String.format("%12s|  |%-12s\n", 
					(">"+ score.getAwayName()), score.getHomeName());
		} else
		{
			nameStr = String.format("%12s|  |%-12s\n", 
					score.getAwayName(), (score.getHomeName()+"<"));
		}
		this.append(nameStr);
        this.append("-----------------------------\n"); 
		String[] keyArr = {"20", "19", "18", "17", "16", "15", "BE"};
		for(String s : keyArr)
		{
			String xStr = String.format(
					"%12s|%2s|%-12s\n", score.getAwayXs().get(s),
					s, score.getHomeXs().get(s));
			this.append(xStr);
		}
        this.append("-----------------------------\n"); 
        String scoreStr = String.format("%11d      %-11d\n",
					score.getAwayScore(), score.getHomeScore());
		this.append(scoreStr);

    }
	 

    public Score getScore()
    {
		return score;
    }


}
