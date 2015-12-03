import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Transparency;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingUtilities;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.io.File;
import javax.swing.JLabel;
import java.awt.RenderingHints;

/*
need to get proper measurements of board picture 
*/


public class Board extends JPanel implements MouseListener 
{

    private static final int[] VALUEARRAY = {6, 10, 15, 2, 17, 3, 19, 7, 16, 8, 11, 14, 9, 12, 5, 20, 1, 18, 4, 13, 6};
    private static final int COUNT = 20;
    private static final int FRAME_HEIGHT = 550;
    private static final int FRAME_WIDTH = FRAME_HEIGHT;
    private static final double OUTER_TEXT_MARGIN = 0.9;
    private static final double OUTER_DOUBLES = 206.0/275.0;
    private static final double INNER_DOUBLES = 195.0/275.0;
    private static final double OUTER_TRIPLES = 129.0/275.0;
    private static final double INNER_TRIPLES = 119.0/275.0;
    private static final double OUTER_BULL = 20.0/275.0;
    private static final double OUTER_BULLSEYE = 9.0/275.0;
    private static final int BOARD_WIDTH = (int) (FRAME_WIDTH*0.868317);
    private BufferedImage img;
    private boolean drawlines = false;
    private Scoreboard sb;
    private Score score;

    public Board(Scoreboard sb)
    {
        this.sb = sb;
		this.score = sb.getScore();
		File f;
		Dimension d = new Dimension(FRAME_HEIGHT, FRAME_WIDTH);

        try
		{
            f = new File("dartboard550.png");
            img = ImageIO.read(f);
        } catch(Exception e)
		{
		e.printStackTrace();
		}
		setPreferredSize(d);
		repaint();
		addMouseListener(this);
    }
   
    public void paintComponent(Graphics g)
    {
        g.drawImage(img,0,0, null);
		g.setColor(Color.BLACK);
    }

    public void mouseClicked(MouseEvent e)
    {
		results(e.getX(), e.getY());
    }
    public void mouseEntered(MouseEvent e)
    {
    }
    public void mouseExited(MouseEvent e)
    {
    }
    public void mousePressed(MouseEvent e)
    {
    }
    public void mouseReleased(MouseEvent e)
    {
    }

    public void setScoreboard(Scoreboard s)
    {
        sb = s;
    }

    public void results(int x, int y)
    {

        x -= FRAME_WIDTH/2;
		y = FRAME_HEIGHT/2 -y + 1;

		double r = Math.sqrt(x*x + y*y);
		double deg1, deg2; //degrees
		double rad1, rad2; //radians
		int mult; //multiplier
	
		if(r < 190 && r>= 127)
		{
			mult = 1;
		} else if( r < 127 && r>=115)
		{
			mult = 3;
		}
		else if(r < 202 && r>=190)
		{
			mult=2;
		}
		else if(r< 115 && r> 20)
		{
			mult =1;
		}
		else mult = 0;
		if(r<=20 && r>8)
		{
			mult = 1;
			sendScore("BE", mult);
		}
		else if(r<=8)
		{
			mult =2;
			sendScore("BE", mult);
		}
		else if(x > r*Math.cos(81*Math.PI/180) && y > r*Math.sin(9*Math.PI/180))
		{
			for(int i = 0; i<COUNT; i++)
			{
				deg1 = (360 + 9 -i*18)%360;
				deg2 = (360 + 9 -i*18 - 18)%360;
				rad1 = deg1*Math.PI/180;
				rad2 = deg2*Math.PI/180;
				
				if( x > (int) (r*Math.cos(rad1))
				&& y < (int) (r*Math.sin(rad1))
				&& x < (int) (r*Math.cos(rad2))
				&& y > (int) (r*Math.sin(rad2)))
				{
					sendScore(	VALUEARRAY[i], mult );
					break;
				}
			}

        } else if( x <= r*Math.cos(99*Math.PI/180) && y > r*Math.sin(171*Math.PI/180))
		{ 
			for(int i = 0; i<COUNT; i++)
			{
				deg1 = (360 + 9 -i*18)%360;
				deg2 = (360 + 9 -i*18 - 18)%360;
				rad1 = deg1*Math.PI/180;
				rad2 = deg2*Math.PI/180;
				if( x > (int) (r*Math.cos(rad1))
				&& y > (int) (r*Math.sin(rad1))
				&& x <= (int) (r*Math.cos(rad2))
				&& y <= (int) (r*Math.sin(rad2)))
				{
					sendScore(	VALUEARRAY[i], mult );
					break;
				}
			}
		} else if( x > r*Math.cos(81*Math.PI/180) && y <= r*Math.sin(-9*Math.PI/180))
		{ 
			for(int i = 0; i<COUNT; i++)
			{
				deg1 = (360 + 9 -i*18)%360;
				deg2 = (360 + 9 -i*18 - 18)%360;
				rad1 = deg1*Math.PI/180;
				rad2 = deg2*Math.PI/180;
				if( x <= (int) (r*Math.cos(rad1))
				&& y <= (int) (r*Math.sin(rad1))
				&& x > (int) (r*Math.cos(rad2))
				&& y > (int) (r*Math.sin(rad2)))
				{
					sendScore(	VALUEARRAY[i] , mult);
					break;
				}
			}
		} else if( x <= r*Math.cos(261*Math.PI/180) && y <= r*Math.sin(189*Math.PI/180))
		{ 
			for(int i = 0; i<COUNT; i++)
			{
				deg1 = (360 + 9 -i*18)%360;
				deg2 = (360 + 9 -i*18 - 18)%360;
				rad1 = deg1*Math.PI/180;
				rad2 = deg2*Math.PI/180;
				if( x <= (int) (r*Math.cos(rad1))
				&& y > (int) (r*Math.sin(rad1))
				&& x > (int) (r*Math.cos(rad2))
				&& y <= (int) (r*Math.sin(rad2)))
				{
					sendScore(	VALUEARRAY[i], mult );
					break;
				}
			}
		} else if(x > r*Math.cos(99*Math.PI/180) && x <= r*Math.cos(81*Math.PI/180) && y>0)
		{
	        sendScore(20, mult);
		}  else if(x <= r*Math.cos(279*Math.PI/180) && x > r*Math.cos(261*Math.PI/180) && y<=0)
		{
	        sendScore(3, mult);
		}  else if(x>0 && y <= r*Math.sin(9*Math.PI/180) && y> r*Math.sin(-9*Math.PI/180))
		{
			sendScore(6, mult);
		} else if (x<0 && y>r*Math.sin(189*Math.PI/180) && y<= r*Math.sin(171*Math.PI/180))
		{
			sendScore(11, mult);
		}

		System.out.printf("x: %d y: %d r: %f\n",x,y,r);
	}
	public void sendScore(String s, int m)
	{
        String toss = s + "x" + Integer.toString(m);
		System.out.println(toss);
        score.update(toss);

		/*
		 *{turn, overall turn, teamUp, home, X_20, X_19, X_18, X_17, X_16, X_15, X_BE,
		 *                             away, ........................................};
		 */

//need a stack of tosses, each turn run through stack printing 
//each toss in the order it happened
//then at the end, use same approach to add to csv file
				

        sb.printScore();
	}

    public void sendScore(int s, int m)
    {
        String toss = Integer.toString(s) + "x" + Integer.toString(m);
		System.out.println(toss);
        score.update(toss);
        sb.printScore();
    }

    public static BufferedImage getScaledInstance(
	    BufferedImage img, int targetWidth,
	    int targetHeight, Object hint, 
	    boolean higherQuality)
    {
        int type =
               (img.getTransparency() == Transparency.OPAQUE)
               ? BufferedImage.TYPE_INT_RGB 
      	       : BufferedImage.TYPE_INT_ARGB;

	    BufferedImage ret = (BufferedImage) img;
	    int w, h;

	    if (higherQuality)
	    {
	        // Use multi-step technique: start with original size, then
	        // scale down in multiple passes with drawImage()
	        // until the target size is reached
	        w = img.getWidth();
	        h = img.getHeight();
	    }
	    else
	    {
	        // Use one-step technique: scale directly from original
	        // size to target size with a single drawImage() call
	        w = targetWidth;
	        h = targetHeight;
	    }

	    do
	    {
	        if (higherQuality && w > targetWidth)
	        {
	            w /= 2;
	            if (w < targetWidth)
	            {
	                w = targetWidth;
	            }

            } else if (higherQuality && w <= targetWidth)
            {
                w *= 2;
                if (w > targetWidth)
                {
                    w = targetWidth;
                }
            }

            if (higherQuality && h > targetHeight)
            {
                h /= 2;
                if (h < targetHeight)
                {
                    h = targetHeight;
                }
            }
            else if (higherQuality && h <= targetWidth)
            {
                h *= 2;
                if (h > targetHeight)
                {
                    h = targetHeight;
                }
            }

            BufferedImage tmp = new BufferedImage(w, h, type);

            Graphics2D g2 = tmp.createGraphics();

            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, hint);
            g2.drawImage(ret, 0, 0, w, h, null);
            g2.dispose();

            ret = tmp;

        } while (w != targetWidth || h != targetHeight);

        return ret;
    }



/*
    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame();
	frame.add(new Board());
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
*/
}
