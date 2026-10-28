
import java.util.Random;

public class HumidityMonitor implements Runnable {

    private final MonitoringData data;
    private final Random random = new Random();

    public HumidityMonitor(MonitoringData data) {
        this.data = data;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                double humidity = 20 + random.nextDouble() * 70;

                String status;
                String message = "";

                if (humidity < 30 || humidity > 70) {
                    status = "WARNING";
                    message = "ALERT: Humidity is outside the normal range!";
                } else {
                    status = "NORMAL";
                }

                data.addReading(
                        "Humidity",
                        i,
                        Math.round(humidity * 10.0) / 10.0,
                        "%",
                        status,
                        message
                );

                if (i < 10) {
                    Thread.sleep(2000);
                }

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Humidity monitoring interrupted.");
                return;
            }
        }
    }
}
