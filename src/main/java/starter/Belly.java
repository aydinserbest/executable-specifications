package starter;

public class Belly {
    private int cukes;
    public void eat(int cukes) {
        this.cukes = cukes;
    }

    public void waitTime(int hours) {
        // Simulate waiting time, you can expand this if needed
    }

    public String growl() {
        return cukes > 0 ? "Growl" : "Silent";

    }
}
