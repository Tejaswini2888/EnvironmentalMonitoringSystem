
public class Main {

    public static void main(String[] args) {

        MonitoringData data = new MonitoringData();

        Thread temperatureThread =
                new Thread(new TemperatureMonitor(data));

        Thread humidityThread =
                new Thread(new HumidityMonitor(data));

        Thread airQualityThread =
                new Thread(new AirQualityMonitor(data));

        System.out.println("========================================");
        System.out.println(" CONCURRENT ENVIRONMENTAL MONITORING");
        System.out.println("========================================");
        System.out.println("Starting all monitoring threads...\n");

        temperatureThread.start();
        humidityThread.start();
        airQualityThread.start();

        try {
            temperatureThread.join();
            humidityThread.join();
            airQualityThread.join();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Main thread was interrupted.");
            return;
        }

        System.out.println("\nAll monitoring threads have completed.");

        data.printReport();

        System.out.println("\nMonitoring system stopped.");
    }
}