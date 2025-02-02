// A tennis player class that
public class TennisPlayer extends Person
{
    private String racket;
    private String strings;
    private int ranking;
    public TennisPlayer(String firstName, String lastName, String phoneNumber, String racket, String strings, int ranking)
    {
        super(firstName, lastName, phoneNumber);
        this.racket = racket;
        this.strings = strings;
        this.ranking = ranking;
    }

    public String getRacket()
    {
        return racket;
    }

    public String getStrings()
    {
        return strings;
    }

    public int getRanking()
    {
        return ranking;
    }
    // Overrides the Person toString to print the racket, string, and ranking of the tennis player as well
    @Override
    public String toString()
    {
        // Uses the person toString for code fluency
        return super.toString() + " Racket: " + this.racket +  ", Strings: " + this.strings + ", Ranking: " + this.ranking;
    }
}
