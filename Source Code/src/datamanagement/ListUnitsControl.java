package datamanagement;

/**
 * This class lists all the Units
 * EG: ITC101, ITC102
 *
 * @author Pat Barilla
 * @since 2015-08-05
 */

public class ListUnitsControl {

    private UnitManager unitManager_;

    public ListUnitsControl() {
        unitManager_ = UnitManager.getInstance();
    }

    /**
     * Adds all the Units to the IUnitLister object
     *
     * @param unitLister the IUnitLister object that will contain all the Units
     */
    public void listUnits(IUnitLister unitLister) {
        unitLister.clearUnits();

        UnitMap units = unitManager_.getUnitMap();

        for (String i : units.keySet()) {
            IUnit unit = units.get(i);
            unitLister.addUnit(unit);
        }
    }
}
