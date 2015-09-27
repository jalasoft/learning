package cz.jalasoft.learning.jmx.standardmbean;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 8/10/15.
 */
public interface MonitoringMBean {

    void stop();

    Integer getCycles();

    void setCycles(Integer cycles);

    //Diagnostics getDiagnostics();
}
