package cz.jalasoft.learning.jmx.standardmbean;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 8/10/15.
 */
public class Monitoring implements MonitoringMBean {

    private int cycles;

    public Monitoring(int cycles) {
        this.cycles = cycles;
    }

    public void stop() {
        cycles = 0;
    }

    public Integer getCycles() {
        return cycles;
    }

    public synchronized void setCycles(Integer cycles) {
        this.cycles = cycles;
    }

    public Diagnostics getDiagnostics() {
        return new Diagnostics();
    }

    public void decrement() {
        this.cycles--;
    }
}
