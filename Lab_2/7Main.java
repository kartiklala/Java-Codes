import java.util.Scanner;


// Main class
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // ----------------------------------------------------
        // Input Cricket Team
        // ----------------------------------------------------

        String cricketData = sc.nextLine();

        // Splitting input using comma
        String[] cricketValues = cricketData.split(",");

        String cricketName = cricketValues[1];
        int cricketMatches = Integer.parseInt(cricketValues[2]);
        int cricketWins = Integer.parseInt(cricketValues[3]);
        int cricketDraws = Integer.parseInt(cricketValues[4]);

        // Creating CricketTeam object
        CricketTeam cricket = new CricketTeam(
            cricketName,
            cricketMatches,
            cricketWins,
            cricketDraws
        );


        // ----------------------------------------------------
        // Input Football Team
        // ----------------------------------------------------

        String footballData = sc.nextLine();

        // Splitting input using comma
        String[] footballValues = footballData.split(",");

        String footballName = footballValues[1];
        int footballMatches = Integer.parseInt(footballValues[2]);
        int footballWins = Integer.parseInt(footballValues[3]);
        int footballDraws = Integer.parseInt(footballValues[4]);

        // Creating FootballTeam object
        FootballTeam football = new FootballTeam(
            footballName,
            footballMatches,
            footballWins,
            footballDraws
        );


        // ----------------------------------------------------
        // Display Results
        // ----------------------------------------------------

        cricket.display();
        football.display();

        sc.close();
    }
}


// Team class
class Team
{
    String name;
    int matchesPlayed;
    int wins;
    int draws;

    // no argument constructor
    Team()
    {
        System.out.println("Team constructor called");
    }

    // parameterized constructor
    Team(String name, int matchesPlayed, int wins, int draws)
    {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.wins = wins;
        this.draws = draws;
    }

    // method to calculate points
    // This method will be overridden by child classes
    int calculatePoints()
    {
        return 0;
    }

    // display method
    void display()
    {
        System.out.println("Team: " + name);
        System.out.println("Points: " + calculatePoints());
    }
}


// CricketTeam inherits Team
class CricketTeam extends Team
{
    // parameterized constructor
    CricketTeam(String name, int matchesPlayed, int wins, int draws)
    {
        // calling Team constructor
        super(name, matchesPlayed, wins, draws);
    }

    // overriding calculatePoints()
    // Cricket: win = 2 points, draw = 1 point
    @Override
    int calculatePoints()
    {
        return (wins * 2) + (draws * 1);
    }

    // overriding display method
    void display()
    {
        System.out.println("Team: " + name +
                           " (Cricket) Points: " +
                           calculatePoints());
    }
}


// FootballTeam inherits Team
class FootballTeam extends Team
{
    // parameterized constructor
    FootballTeam(String name, int matchesPlayed, int wins, int draws)
    {
        // calling Team constructor
        super(name, matchesPlayed, wins, draws);
    }

    // overriding calculatePoints()
    // Football: win = 3 points, draw = 1 point
    @Override
    int calculatePoints()
    {
        return (wins * 3) + (draws * 1);
    }

    // overriding display method
    void display()
    {
        System.out.println("Team: " + name +
                           " (Football) Points: " +
                           calculatePoints());
    }
}


