import java.util.HashMap;
import java.util.Stack;


public class Score
{

    private String away;
    private String home;

    private int homeScore;
    private int awayScore;

    private HashMap<String, String> homeXs = new HashMap<String, String>();
    private HashMap<String, String> awayXs = new HashMap<String, String>();

    private int turn = 1;
    private int overAllTurn = 1;

    private char team = 'h';

    private Stack<String> stack = new Stack<String>();

    public Score(String home, String away)
    {
		this.away = away;
		this.home = home;
		homeScore = 0;
		awayScore = 0;
		for(int i = 20; i>=14; i--)
		{
	
			if(i != 14)
			{
				homeXs.put(Integer.toString(i), "");
				awayXs.put(Integer.toString(i), "");
			} else
			{
				homeXs.put("BE" , "");
				awayXs.put("BE" , "");
			}	        
		}
    }

	public void undo()
	{
		String strArr[];
		String num;
		int mult;
		stack.pop();
		for(String k : homeXs.keySet())
		{
			homeXs.put(k, "");
		}
		for(String k : awayXs.keySet())
		{
			awayXs.put(k, "");
		}

		homeScore = 0;
		awayScore=0;

		int m= 1;
		for(String str : stack)
		{
			strArr = str.split("x");
			num = strArr[0];
			mult = Integer.parseInt(strArr[1]);
			if(Math.ceil((double)(m)/3.0)%2 ==1)
			{
				if(homeXs.keySet().contains(num))
				{
					for(int i = 0; i< mult; i++)
					{ 
						if(!(homeXs.get(num).length() ==3 
					&& awayXs.get(num).length() ==3))
						{
							if(homeXs.get(num).length() <3)
							{
								homeXs.put(num, homeXs.get(num) + "X");
							} else 
							{
		
								if(!num.equals("BE"))
									homeScore += Integer.parseInt(num);
								else
									homeScore += 25;
							}
						}
					}
				}
			}
			else
			{
				if(awayXs.keySet().contains(num))
				{
					for(int i = 0; i< mult; i++)
					{ 
						if(!(awayXs.get(num).length() ==3 
					&& homeXs.get(num).length() ==3))
						{
							if(awayXs.get(num).length() <3)
							{
								awayXs.put(num, awayXs.get(num) + "X");
							} else 
							{
								if(!num.equals("BE"))
									awayScore += Integer.parseInt(num);
								else
									awayScore += 25;
							}
						}
					}
				}
			}
			m++;
		}	
		m = 1;
		turn--;
		overAllTurn--;
		if(turn ==0)
		{
			if(team=='h')
			{
				team ='a';
			}
			else team ='h';
			turn = 3;
		}
		System.out.println(team + ": turn: " +turn);
		System.out.println(team + ": overall turn: " +overAllTurn);
	}

    public void update(String toss)
	{
		String strArr[];
		String num;
		int mult;
		stack.push(toss);	

		for(String k : homeXs.keySet())
		{
			homeXs.put(k, "");
		}
		for(String k : awayXs.keySet())
		{
			awayXs.put(k, "");
		}

		homeScore = 0;
		awayScore=0;

		int m= 1;
		for(String str : stack)
		{
			strArr = str.split("x");
			num = strArr[0];
			mult = Integer.parseInt(strArr[1]);
			if(Math.ceil((double)(m)/3.0)%2 ==1)
			{
				if(homeXs.keySet().contains(num))
				{
					for(int i = 0; i< mult; i++)
					{ 
						if(!(homeXs.get(num).length() ==3 
					&& awayXs.get(num).length() ==3))
						{
							if(homeXs.get(num).length() <3)
							{
								homeXs.put(num, homeXs.get(num) + "X");
							} else 
							{
		
								if(!num.equals("BE"))
									homeScore += Integer.parseInt(num);
								else
									homeScore += 25;
							}
						}
					}
				}
			}
			else
			{
				if(awayXs.keySet().contains(num))
				{
					for(int i = 0; i< mult; i++)
					{ 
						if(!(awayXs.get(num).length() ==3 
					&& homeXs.get(num).length() ==3))
						{
							if(awayXs.get(num).length() <3)
							{
								awayXs.put(num, awayXs.get(num) + "X");
							} else 
							{
								if(!num.equals("BE"))
									awayScore += Integer.parseInt(num);
								else
									awayScore += 25;
							}
						}
					}
				}
			}
			m++;
		}	
		m = 1;
		turn++;
		overAllTurn++;
		if(turn ==4)
		{
			if(team=='h')
			{
				team ='a';
			}
			else team ='h';
			turn = 1;
		}
		System.out.println(team + ": turn: " +turn);
		System.out.println(team + ": overall turn: " +overAllTurn);
    }

	public int getTurn()
	{
		return turn;
	}

	public int getOverallTurn()
	{
		return overAllTurn;
	}

    public int getHomeScore()
    {
        return homeScore;
    }

    public int getAwayScore()
    {
        return awayScore;
    }

    public HashMap<String,String> getHomeXs()
    {
        return homeXs;
    }
    public HashMap<String,String> getAwayXs()
    {
        return awayXs;
    }

    public String getAwayName()
    {
        return away;
    }

    public String getHomeName()
    {
        return home;
    }
	
	public Stack<String> getStack()
	{
		return stack;
	}

    public char getTeam()
    {
        return team;
    }

}
