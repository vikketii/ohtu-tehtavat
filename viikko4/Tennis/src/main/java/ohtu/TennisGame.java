package ohtu;

public class TennisGame {
    
    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            player1Score += 1;
        else
            player2Score += 1;
    }

    public String getOngoingScore() {
        String score = "";
        String[] scores = new String[]{"Love", "Fifteen", "Thirty", "Forty"};

        score += scores[player1Score];
        score += "-";
        if (player1Score == player2Score) {
            score += "All";
        } else {
            score += scores[player2Score];
        }

        return score;
    }

    private String getAdvantageOrWinningScore() {
        String score;
        if (Math.abs(player1Score - player2Score) < 2) {
            if (player1Score > player2Score) score = "Advantage player1";
            else score = "Advantage player2";
        } else {
            if (player1Score > player2Score) score = "Win for player1";
            else score = "Win for player2";
        }

        return score;
    }

    public String getScore() {
        String score = "";

        if (player1Score < 4 && player2Score < 4) {
            score = getOngoingScore();
        } else if (player1Score == player2Score) {
            score = "Deuce";
        } else {
            score = getAdvantageOrWinningScore();
        }

        return score;
    }

}