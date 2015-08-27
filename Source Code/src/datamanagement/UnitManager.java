package datamanagement;

import java.util.List;

import org.jdom.Element;

/**
 *  Class for control manager for the Unit objects
 */
public class UnitManager
{

    private final static UnitManager instance_ = new UnitManager();

    private UnitMap unitMap_;


    /**
     * Constructor for the Unit Manager, creates a UnitMap.
     */
    public UnitManager() {
        unitMap_ = new UnitMap();
    }


    /**
     * Returns the singleton instance of the Unit Manager.
     * @return
     */
    public static UnitManager getInstance() {
        return instance_;
    }


    /**
     * Returns a unit from the collection.
     * @param unitCode
     * @return
     */
    public IUnit getUnit(String unitCode) {
        IUnit unit = unitMap_.get(unitCode);

        return unit != null ? unit : createUnit(unitCode);
    }



    /**
     * Creates a new Unit into the collection
     * @param unitCode
     * @return
     */
    private IUnit createUnit(String unitCode) {
        for (Element element : (List<Element>) XmlManager.getInstance()
                .getDocument().getRootElement()
                .getChild("unitTable").getChildren("unit")) {

            if (unitCode.equals(element.getAttributeValue("uid"))) {

                IUnit unit = new Unit(element.getAttributeValue("uid"),
                        element.getAttributeValue("name"),
                        Float.valueOf(element.getAttributeValue("ps")).floatValue(),
                        Float.valueOf(element.getAttributeValue("cr")).floatValue(),
                        Float.valueOf(element.getAttributeValue("di")).floatValue(),
                        Float.valueOf(element.getAttributeValue("hd")).floatValue(),
                        Float.valueOf(element.getAttributeValue("ae")).floatValue(),
                        Integer.valueOf(element.getAttributeValue("asg1wgt")).intValue(),
                        Integer.valueOf(element.getAttributeValue("asg2wgt")).intValue(),
                        Integer.valueOf(element.getAttributeValue("examwgt")).intValue(),
                        StudentUnitRecordManager.getInstance().getRecordsByUnit(unitCode));

                unitMap_.put(unit.getUnitCode(), unit);

                return unit;
            }
        }

        throw new RuntimeException("DBMD: createUnit : unit not in file");
    }


    /**
     * Returns the HashMap of Unit's from the collection.
     * @return
     */
    public UnitMap getUnitMap() {

        UnitMap unitMap = new UnitMap();

			for (Element element : (List<Element>) XmlManager.getInstance()
                .getDocument().getRootElement()
                .getChild("unitTable").getChildren("unit")) {
            IUnit unit = new UnitProxy(element.getAttributeValue("uid"),
                    element.getAttributeValue("name"));

            unitMap.put(unit.getUnitCode(), unit);
        }

        return unitMap;
    }
}
