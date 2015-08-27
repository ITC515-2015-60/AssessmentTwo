package datamanagement;

/**
 * Student Object
 *
 * @author Pat Barilla
 * @since 26/08/2015
 */

public interface IStudent
{

    /**
     * Gets the ID of the student.
     */
    Integer getId();

    /**
     * Gets the students First Name.
     */
    String getFirstName();

    /**
     * Sets the students First Name.
     *
     * @param firstName
     */
    void setFirstName(String firstName);

    /**
     * Gets the students Last Name.
     */
    String getLastName();

    /**
     * Sets the students Last Name.
     *
     * @param lastName
     */
    void setLastName(String lastName);

    /**
     * Adds a Unit Record to the student.
     *
     * @param unitRecord
     */
    void addUnitRecord(IStudentUnitRecord unitRecord);

    /**
     * Gets the Unit Record based on the Unit Code.
     *
     * @param unitCode
     */
    IStudentUnitRecord getUnitRecord(String unitCode);

    /**
     * Gets all Unit Records for the Student.
     */
    StudentUnitRecordList getUnitRecords();
}