
import java.util.Random;

public class TemperatureMonitor implements Runnable {

    private final MonitoringData data;
    private final Random random = new Random();

    public TemperatureMonitor(MonitoringData data) {
        this.data = data;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                double temperature = 10 + random.nextDouble() * 35;

                String status;
                String message = "";

                if (temperature < 18 || temperature > 35) {
                    status = "WARNING";
                    message = "ALERT: Temperature exceeds the permitted threshold!";
                } else {
                    status = "NORMAL";
                }

                data.addReading(
                        "Temperature",
                        i,
                        Math.round(temperature * 10.0) / 10.0,
                        "°C",
                        status,
                        message
                );

                if (i < 10) {
                    Thread.sleep(1000);
                }

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Temperature monitoring interrupted.");
                return;
            }
        }
    }
}
