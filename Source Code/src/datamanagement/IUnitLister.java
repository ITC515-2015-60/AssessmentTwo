package datamanagement;

/**
 * Unit Lister
 */
public interface IUnitLister
{

    /**
     * Clears all the Units from the lister.
     */
    void clearUnits();

    /**
     * Adds a Unit to the Lister.
     *
     * @param unit
     */
    void addUnit(IUnit unit);
}
