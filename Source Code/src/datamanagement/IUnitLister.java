package datamanagement;

/**
 * Unit Lister
 */
public interface IUnitLister {

    /**
     * Clears all the Units from the lister.
     */
    public void clearUnits();

    /**
     * Adds a Unit to the Lister.
     *
     * @param unit
     */
    public void addUnit(IUnit unit);
}
