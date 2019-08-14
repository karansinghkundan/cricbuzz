package com.example.cricbuzzz;

public class Row {
    String matchDate;
    String team1;
    String team2;
    String team1_score;
    String team2_score;
    String message;
    String MoM;

    public Row(String cricstarImage, String matchDate, String team1, String team2, String team1_score, String team2_score, String message, String moM) {
        this.matchDate = matchDate;
        this.team1 = team1;
        this.team2 = team2;
        this.team1_score = team1_score;
        this.team2_score = team2_score;
        this.message = message;
        MoM = moM;
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

    public String getTeam1_score() {
        return team1_score;
    }

    public void setTeam1_score(String team1_score) {
        this.team1_score = team1_score;
    }

    public String getTeam2_score() {
        return team2_score;
    }

    public void setTeam2_score(String team2_score) {
        this.team2_score = team2_score;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMoM() {
        return MoM;
    }

    public void setMoM(String moM) {
        MoM = moM;
    }

    @Override
    public String toString() {
        return "Row{" +
                 '\'' +
                ", matchDate='" + matchDate + '\'' +
                ", team1='" + team1 + '\'' +
                ", team2='" + team2 + '\'' +
                ", team1_score='" + team1_score + '\'' +
                ", team2_score='" + team2_score + '\'' +
                ", message='" + message + '\'' +
                ", MoM='" + MoM + '\'' +
                '}';
    }
}
