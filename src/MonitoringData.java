
import java.util.ArrayList;
import java.util.List;

public class MonitoringData {

    private final List<String> readings = new ArrayList<>();

    private int normalCount;
    private int warningCount;
    private int criticalCount;

    public synchronized void addReading(
            String parameter,
            int readingNumber,
            double value,
            String unit,
            String status,
            String message) {

        String reading = parameter + " Thread - Reading "
                + readingNumber + ": " + value + unit
                + " - " + status;

        readings.add(reading);

        System.out.println(reading);

        if (status.equals("NORMAL")) {
            normalCount++;
        } else if (status.equals("WARNING")) {
            warningCount++;
        } else if (status.equals("CRITICAL")) {
            criticalCount++;
        }

        if (!message.isEmpty()) {
            System.out.println(message);
        }
    }

    public synchronized void printReport() {
        System.out.println("\n===== CONSOLIDATED MONITORING REPORT =====");

        System.out.println("Total readings: " + readings.size());
        System.out.println("Normal readings: " + normalCount);
        System.out.println("Warning readings: " + warningCount);
        System.out.println("Critical readings: " + criticalCount);

        String overallStatus;

        if (criticalCount > 0) {
            overallStatus = "CRITICAL";
        } else if (warningCount > 0) {
            overallStatus = "WARNING";
        } else {
            overallStatus = "NORMAL";
        }

        System.out.println("Overall Environmental Status: "
                + overallStatus);
    }
}
