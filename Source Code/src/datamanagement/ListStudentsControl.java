package datamanagement;

/**
 * This class lists all the Students in a set, based on Unit Code
 * EG: ITC101, ITC102...
 *
 * @author Pat Barilla
 * @since 2015-08-05
 */

public class ListStudentsControl {

    private StudentManager studentManager_;

    public ListStudentsControl() {
        studentManager_ = StudentManager.getSelf();
    }

    /**
     * Lists all the students based on a unitCode
     *
     * @param lister    the lister object to store the Students
     * @param unitCode  the unitCode we'd like the students for
     */
    public void listStudents(IStudentLister lister, String unitCode) {
        lister.clearStudents();
        StudentMap students = studentManager_.getStudentsByUnit(unitCode);

        for (Integer i : students.keySet()) {
            lister.addStudent(students.get(i));
        }
    }
}
