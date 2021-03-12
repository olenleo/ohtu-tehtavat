
package ohtu;

import java.util.Comparator;

public class Player implements Comparable<Player> {
    private String name;
    private String nationality;
    private String team;
    private int goals;
    private int assists;


    public void setName(String name) {
        this.name = name;
    }


    public void setTeam(String team) {
        this.team = team;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;        
    }

    public String getNationality() {
        return this.nationality;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return this.goals + this.assists;
    }

    @Override
    public String toString() {
        return name + " \t\t\t team " + team + "\t\t\t\t" + goals + " + " + assists + " =\t " + this.getScore();
    }
    @Override
    public int compareTo(Player b) {
        return (b.assists + b.goals) - (this.assists + this.goals);

    }
      
}
