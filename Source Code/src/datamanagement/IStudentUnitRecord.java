package datamanagement;

/**
 * Student Unit Record
 *
 * @author Pat Barilla
 * @since 26/08/2015
 */

public interface IStudentUnitRecord {

    /**
     * Gets the Student ID.
     */
    public Integer getStudentID();

    /**
     * Gets the Unit Code.
     */
    public String getUnitCode();

    /**
     * Sets the result for Assignment 1.
     *
     * @param assignment1Mark
     */
    public void setAssignment1Mark(float assignment1Mark);

    /**
     * Gets the result for Assignment 1.
     */
    public float getAssignment1Mark();

    /**
     * Sts the result for Assignment 2.
     *
     * @param assignment2Mark
     */
    public void setAssignment2Mark(float assignment2Mark);

    /**
     * Gets the result for Assignment 2.
     */
    public float getAssignment2Mark();

    /**
     * Sets the Exam Mark
     *
     * @param examMark
     */
    public void setExamMark(float examMark);

    /**
     * Gets the Exam Mark
     */
    public float getExamMark();

    /**
     * Gets the Total Mark
     */
    public float getTotalMark();
}
