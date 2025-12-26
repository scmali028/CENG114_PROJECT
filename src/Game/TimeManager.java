package Game;

import javax.swing.Timer;

public class TimeManager {

    private int totalTime;      // örn: 120
    private int estimateTime;   // örn: 30

    public TimeManager(int totalTime) {
        this.totalTime = totalTime;
        this.estimateTime = 0;
    }

    // ===== ANA SÜRE =====
    public void tickTotal() {
        totalTime--;
    }

    public boolean isTimeOver() {
        return totalTime <= 0;
    }

    public int getTotalTime() {
        return totalTime;
    }

    // ===== ESTIMATE =====
    public void startEstimate() {
        estimateTime = 15;
    }

    public void tickEstimate() {
        estimateTime--;
    }

    public boolean isEstimateOver() {
        return estimateTime <= 0;
    }

    public int getEstimateTime() {
        return estimateTime;
    }
}