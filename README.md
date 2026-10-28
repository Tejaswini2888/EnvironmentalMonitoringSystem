
# Concurrent Environmental Monitoring System

## Project Overview
A Java application that simulates concurrent environmental monitoring
using multithreading. It monitors temperature, humidity, and air quality
and generates alerts when readings exceed defined thresholds.

## Technologies Used
- Java 26
- Multithreading
- Runnable Interface
- Thread and Thread.sleep()
- Thread.join()
- Exception Handling
- Git and GitHub

## Features
- Concurrent monitoring of three environmental parameters
- 10 readings per monitoring thread
- Independent sampling intervals
- Normal, Warning, and Critical status classification
- Threshold-based alerts
- Thread-safe reading collection and counting
- Consolidated environmental status report

## Monitoring Intervals

| Parameter | Interval | Normal Range |
|---|---|---|
| Temperature | 1 second | 18°C–35°C |
| Humidity | 2 seconds | 30%–70% |
| Air Quality Index (AQI) | 3 seconds | 0–100 |

## Project Structure

```text
EnvironmentalMonitoringSystem/
└── src/
    ├── Main.java
    ├── MonitoringData.java
    ├── TemperatureMonitor.java
    ├── HumidityMonitor.java
    └── AirQualityMonitor.java
```

## How to Run

1. Install JDK 26 or another compatible JDK.
2. Clone or download this repository.
3. Open the project in IntelliJ IDEA.
4. Run `Main.java`.

## Learning Outcomes
- Understanding Java multithreading
- Running concurrent tasks using Thread
- Synchronizing access to shared data
- Handling InterruptedException
- Generating a consolidated report

## Future Enhancements
- Collect readings from real sensors
- Store historical readings in a database
- Display readings on a dashboard
- Add graphical charts and notifications

## Author
B. Tejaswini
