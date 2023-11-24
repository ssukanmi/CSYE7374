package edu.neu.csye7374;
import java.util.HashMap;

/**
 * API for abstract factory of cloneable objects
 *
 * @author dpeters
 *
 */
public abstract class MyCloneableAbstractFactoryAPI {
    /**
     * @param id            ID of prototype
     * @param prototype        one cloneable prototype object
     */
    public abstract void load(int id, MyCloneable prototype);
    /**
     * dynamically load list of prototypes
     *
     * @param prototypeList        list of cloneable prototype objects
     */
    public abstract void load(HashMap<Integer, MyCloneable> prototypeList);
    /**
     * return clone of requested object
     *
     * @param id            ID of requested object
     * @return                cloned object
     */
    public abstract MyCloneable getObject(int id);
}