package cz.jalasoft.learning.jmx.dynamicmbean;

import cz.jalasoft.learning.jmx.Counter;

import javax.management.*;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 8/10/15.
 */
public class MyDynamic implements DynamicMBean {

    private final MBeanInfo info;

    private final Counter counter;

    public MyDynamic(Counter counter) {

        this.counter = counter;
        MBeanAttributeInfo cyclesCount = new MBeanAttributeInfo("Count", "java.lang.Integer", "Moje velicita", true, true, false);
        MBeanOperationInfo stop = new MBeanOperationInfo("Stop", "Zastav!!!!", new MBeanParameterInfo[] { new MBeanParameterInfo("Cycle", "java.lang.Integer", "Nasta cykli")}, "javal.lang.Void", 0);

        info = new MBeanInfo("MojeMBeana", "No proste moje bina", new MBeanAttributeInfo[] {cyclesCount}, new MBeanConstructorInfo[0], new MBeanOperationInfo[] { stop }, new MBeanNotificationInfo[0]);

    }

    public Object getAttribute(String attribute) throws AttributeNotFoundException, MBeanException, ReflectionException {
        if (attribute.equals("Count")) {
            return counter.value();
        }
        throw new AttributeNotFoundException();
    }

    public void setAttribute(Attribute attribute) throws AttributeNotFoundException, InvalidAttributeValueException, MBeanException, ReflectionException {
        if (attribute.getName().equals("Count")) {
            Object val = attribute.getValue();
            if (!(val instanceof Integer)) {
                throw new InvalidAttributeValueException();
            }
            Integer value = (Integer) val;
            counter.setValue(value);
        }
    }

    public AttributeList getAttributes(String[] attributes) {
        AttributeList result = new AttributeList();

        for(String name : attributes) {

            try {
                Object val = getAttribute(name);
                result.add(new Attribute(name, val));
            } catch (Exception exc) {
                System.out.println("Hovno");
            }
        }

        return result;
    }

    public AttributeList setAttributes(AttributeList attributes) {

        AttributeList res = new AttributeList();

        for(Object attrObj : attributes) {
            Attribute attr = (Attribute) attrObj;
            try {
                setAttribute(attr);
                res.add(attr);
            } catch (Exception exc) {
                System.out.println("ggg");
            }
        }
        return res;
    }

    public Object invoke(String actionName, Object[] params, String[] signature) throws MBeanException, ReflectionException {
        if (actionName.equals("Stop")) {
            Integer val = (Integer) params[0];
            counter.setValue(val);
        }
        return new ReflectionException(new RuntimeException());
    }

    public MBeanInfo getMBeanInfo() {
        return info;
    }
}
