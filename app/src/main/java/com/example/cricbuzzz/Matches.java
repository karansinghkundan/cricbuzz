package com.example.cricbuzzz;

import androidx.appcompat.app.AppCompatActivity;

public class Matches extends AppCompatActivity {

    Boolean matchStarted;
    String match_date;
    String team1;
            String team2;
            String team1_score;
            String team2_score;
            String Message;
            String MoM;


    public Matches(Boolean matchStarted, String match_date, String team1, String team2, String team1_score, String team2_score, String message, String moM) {
        this.matchStarted = matchStarted;
        this.match_date = match_date;
        this.team1 = team1;
        this.team2 = team2;
        this.team1_score = team1_score;
        this.team2_score = team2_score;
        Message = message;
        MoM = moM;
    }


    public Boolean getMatchStarted() {
        return matchStarted;
    }

    public void setMatchStarted(Boolean matchStarted) {
        this.matchStarted = matchStarted;
    }

    public String getMatch_date() {
        return match_date;
    }

    public void setMatch_date(String match_date) {
        this.match_date = match_date;
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
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getMoM() {
        return MoM;
    }

    public void setMoM(String moM) {
        MoM = moM;
    }

    @Override
    public String toString() {
        return "Matches{" +
                "matchStarted=" + matchStarted +
                ", match_date='" + match_date + '\'' +
                ", team1='" + team1 + '\'' +
                ", team2='" + team2 + '\'' +
                ", team1_score='" + team1_score + '\'' +
                ", team2_score='" + team2_score + '\'' +
                ", Message='" + Message + '\'' +
                ", MoM='" + MoM + '\'' +
                '}';
    }

    public void add(Matches mMatches) {
    }
}
