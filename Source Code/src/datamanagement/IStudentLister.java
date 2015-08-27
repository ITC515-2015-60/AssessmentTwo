package datamanagement;

/**
 * Student Lister
 *
 * @author jtulip
 */

public interface IStudentLister {
    /**
     * Clears Students out of the Lister (resets the lister)
     */
    public void clearStudents();

    /**
     * Adds a student to the Lister
     *
     * @param student
     */
    public void addStudent(IStudent student);
}
