package com.example.cricbuzzz.Controler;

public class MatchRow {
    String matchDate;
    String team1;
    String team2;
    String leagueMatch;

    public MatchRow(String matchDate, String team1, String team2) {
        this.matchDate = matchDate;
        this.team1 = team1;
        this.team2 = team2;
        this.leagueMatch = team1+" vs "+team2;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getLeagueMatch() {
        return leagueMatch;
    }

    public void setLeagueMatch(String leagueMatch) {
        this.leagueMatch = leagueMatch;
    }

    @Override
    public String toString() {
        return "MatchAdapter{" +
                "matchDate='" + matchDate + '\'' +
                ", team1='" + team1 + '\'' +
                ", team2='" + team2 + '\'' +
                ", leagueMatch='" + leagueMatch + '\'' +
                '}';
    }
}
