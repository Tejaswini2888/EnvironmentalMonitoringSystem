
import java.util.Random;

public class AirQualityMonitor implements Runnable {

    private final MonitoringData data;
    private final Random random = new Random();

    public AirQualityMonitor(MonitoringData data) {
        this.data = data;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                double aqi = random.nextInt(301);

                String status;
                String message = "";

                if (aqi > 200) {
                    status = "CRITICAL";
                    message = "CRITICAL ALERT: Air quality is hazardous!";
                } else if (aqi > 100) {
                    status = "WARNING";
                    message = "WARNING: Air quality is unhealthy!";
                } else {
                    status = "NORMAL";
                }

                data.addReading(
                        "Air Quality",
                        i,
                        aqi,
                        " AQI",
                        status,
                        message
                );

                if (i < 10) {
                    Thread.sleep(3000);
                }

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Air quality monitoring interrupted.");
                return;
            }
        }
    }
}

