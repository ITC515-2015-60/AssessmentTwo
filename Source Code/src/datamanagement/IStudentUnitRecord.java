package datamanagement;

/**
 * Student Unit Record
 *
 * @author Pat Barilla
 * @since 26/08/2015
 */

public interface IStudentUnitRecord
{

    /**
     * Gets the Student ID.
     */
    Integer getStudentId();

    /**
     * Gets the Unit Code.
     */
    String getUnitCode();

    /**
     * Sets the result for Assignment 1.
     *
     * @param assignment1Mark
     */
    void setAssignment1Mark(float assignment1Mark);

    /**
     * Gets the result for Assignment 1.
     */
    float getAssignment1Mark();

    /**
     * Sts the result for Assignment 2.
     *
     * @param assignment2Mark
     */
    void setAssignment2Mark(float assignment2Mark);

    /**
     * Gets the result for Assignment 2.
     */
    float getAssignment2Mark();

    /**
     * Sets the Exam Mark
     *
     * @param examMark
     */
    void setExamMark(float examMark);

    /**
     * Gets the Exam Mark
     */
    float getExamMark();

    /**
     * Gets the Total Mark
     */
    float getTotalMark();
}
