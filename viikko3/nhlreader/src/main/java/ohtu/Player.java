
package ohtu;

public class Player implements Comparable<Player> {
    private String name;
    private int goals;
    private int assists;
    private String team;
    private String nationality;

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String info = name + "\t" + team + "\t" + goals + " + " + assists + " = " + (goals + assists);
        return info;
    }

    @Override
    public int compareTo(Player player) {
        return (player.goals + player.assists) - (goals + assists);
    }
}
