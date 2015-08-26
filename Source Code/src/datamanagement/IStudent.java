package datamanagement;

/**
 * Student Object
 *
 * @author Pat Barilla
 * @since 26/08/2015
 */

public interface IStudent {

    /**
     * Gets the ID of the student.
     */
    public Integer getId();

    /**
     * Gets the students First Name.
     */
    public String getFirstName();

    /**
     * Sets the students First Name.
     *
     * @param firstName
     */
    public void setFirstName(String firstName);

    /**
     * Gets the students Last Name.
     */
    public String getLastName();

    /**
     * Sets the students Last Name.
     *
     * @param lastName
     */
    public void setLastName(String lastName);

    /**
     * Adds a Unit Record to the student.
     *
     * @param unitRecord
     */
    public void addUnitRecord (IStudentUnitRecord unitRecord);

    /**
     * Gets the Unit Record based on the Unit Code.
     *
     * @param unitCode
     */
    public IStudentUnitRecord getUnitRecord (String unitCode);

    /**
     * Gets all Unit Records for the Student.
     */
    public StudentUnitRecordList getUnitRecords();
}