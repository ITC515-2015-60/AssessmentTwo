package datamanagement;

public class ListUnitsControl {

    private UnitManager unitManager_;

    public ListUnitsControl() {
        unitManager_ = UnitManager.getInstance();
    }

    public void listUnits(IUnitLister unitLister) {
        unitLister.clearUnits();

        UnitMap units = unitManager_.getUnitMap();

        for (String key : units.keySet()) {

            IUnit unit = units.get(key);

            unitLister.addUnit(unit);
        }
    }
}
