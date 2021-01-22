package dev.sda.team2.pma.mbeans;

public interface SystemStatusMBean {

    Integer getNumberOfSecondsRunning();
    String getProgramName();

    Long getNumberOfUnixSecondsRunning();
    Boolean getSwitchStatus();

    public void setSwitchStatus(Boolean switchStatus);
}
