package fr.orantoine.fortnitegenerationv2.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Document("match")
public class Match {
    @Id
    private int id;
    private String accountId;
    private String playlist;
    private int kills;
    private int minutesPlayed;
    private int top1;
    private int top5;
    private int top6;
    private int top10;
    private int top12;
    private int top25;
    private int matches;
    private int top3;
    private Date dateCollected;
    private int score;
    private int platform;
    private float trnRating;
    private float trnRatingChange;

    public Match(int id, String accountId, String playlist, int kills, int minutesPlayed, int top1, int top5, int top6, int top10, int top12, int top25, int matches, int top3, Date dateCollected, int score, int platform, float trnRating, float trnRatingChange) {
        this.id = id;
        this.accountId = accountId;
        this.playlist = playlist;
        this.kills = kills;
        this.minutesPlayed = minutesPlayed;
        this.top1 = top1;
        this.top5 = top5;
        this.top6 = top6;
        this.top10 = top10;
        this.top12 = top12;
        this.top25 = top25;
        this.matches = matches;
        this.top3 = top3;
        this.dateCollected = dateCollected;
        this.score = score;
        this.platform = platform;
        this.trnRating = trnRating;
        this.trnRatingChange = trnRatingChange;
    }

    public Match() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getPlaylist() {
        return playlist;
    }

    public void setPlaylist(String playlist) {
        this.playlist = playlist;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getMinutesPlayed() {
        return minutesPlayed;
    }

    public void setMinutesPlayed(int minutesPlayed) {
        this.minutesPlayed = minutesPlayed;
    }

    public int getTop1() {
        return top1;
    }

    public void setTop1(int top1) {
        this.top1 = top1;
    }

    public int getTop5() {
        return top5;
    }

    public void setTop5(int top5) {
        this.top5 = top5;
    }

    public int getTop6() {
        return top6;
    }

    public void setTop6(int top6) {
        this.top6 = top6;
    }

    public int getTop10() {
        return top10;
    }

    public void setTop10(int top10) {
        this.top10 = top10;
    }

    public int getTop12() {
        return top12;
    }

    public void setTop12(int top12) {
        this.top12 = top12;
    }

    public int getTop25() {
        return top25;
    }

    public void setTop25(int top25) {
        this.top25 = top25;
    }

    public int getMatches() {
        return matches;
    }

    public void setMatches(int matches) {
        this.matches = matches;
    }

    public int getTop3() {
        return top3;
    }

    public void setTop3(int top3) {
        this.top3 = top3;
    }

    public Date getDateCollected() {
        return dateCollected;
    }

    public void setDateCollected(Date dateCollected) {
        this.dateCollected = dateCollected;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getPlatform() {
        return platform;
    }

    public void setPlatform(int platform) {
        this.platform = platform;
    }

    public float getTrnRating() {
        return trnRating;
    }

    public void setTrnRating(float trnRating) {
        this.trnRating = trnRating;
    }

    public float getTrnRatingChange() {
        return trnRatingChange;
    }

    public void setTrnRatingChange(float trnRatingChange) {
        this.trnRatingChange = trnRatingChange;
    }


    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", accountId='" + accountId + '\'' +
                ", playlist='" + playlist + '\'' +
                ", kills=" + kills +
                ", minutesPlayed=" + minutesPlayed +
                ", top1=" + top1 +
                ", top5=" + top5 +
                ", top6=" + top6 +
                ", top10=" + top10 +
                ", top12=" + top12 +
                ", top25=" + top25 +
                ", matches=" + matches +
                ", top3=" + top3 +
                ", dateCollected='" + dateCollected + '\'' +
                ", score=" + score +
                ", platform=" + platform +
                ", trnRating=" + trnRating +
                ", trnRatingChange=" + trnRatingChange +
                '}';
    }
}
