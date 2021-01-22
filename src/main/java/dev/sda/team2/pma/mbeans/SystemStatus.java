package dev.sda.team2.pma.mbeans;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(objectName = "status:name=SystemStatus",
description = "System status introspection demo",
persistName = "PersistName" )
public class SystemStatus implements SystemStatusMBean {

    private Integer numberOfSecondsRunning;

    private String programName;
    private Long numberOfUnixSecondsRunning;

    // Important switch : run locally or remotely
    private Boolean switchStatus;

    private Thread backgroundThread;

    public SystemStatus(String programName) {
        // First we initialize all the metrics
        this.backgroundThread = new Thread();
        this.programName = programName;
        this.numberOfSecondsRunning = 0;
        this.numberOfUnixSecondsRunning = System.currentTimeMillis() / 1000L;
        this.switchStatus = false;

        // We will use a background thread to update the metrics
        this.backgroundThread = new Thread(() -> {
            try {
                while (true) {
                    // Every second we update the metrics
                    numberOfSecondsRunning += 1;
                    numberOfUnixSecondsRunning += 1;

                    Thread.sleep(1000L);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        this.backgroundThread.setName("backgroundThread");
        this.backgroundThread.start();
    }


    // Through this getters, defined in the interface SystemStatusMBean,
    // all the metrics will be automatically retrieved

    @Override
    public Integer getNumberOfSecondsRunning() {
        return numberOfSecondsRunning;
    }

    @ManagedAttribute( description = "Export program name", defaultValue = "Java8" )
    @Override
    public String getProgramName() {
        return programName;
    }

    @Override
    public Long getNumberOfUnixSecondsRunning() {
        return numberOfUnixSecondsRunning;
    }

    @Override
    public Boolean getSwitchStatus() {
        return switchStatus;
    }

    // This bean attribute is even writable
    @Override
    public void setSwitchStatus(Boolean switchStatus) {
        this.switchStatus = switchStatus;
    }
}
