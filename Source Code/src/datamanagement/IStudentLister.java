package datamanagement;

/**
 * Student Lister
 *
 * @author jtulip
 */

public interface IStudentLister
{
    /**
     * Clears Students out of the Lister (resets the lister)
     */
    void clearStudents();

    /**
     * Adds a student to the Lister
     *
     * @param student
     */
    void addStudent(IStudent student);
}
