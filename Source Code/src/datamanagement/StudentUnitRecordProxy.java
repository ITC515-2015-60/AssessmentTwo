package datamanagement;

/**
 * The proxy class for student-unit record.
 *
 * @author Zeno Li
 * @since 2015-08-05
 */
public class StudentUnitRecordProxy
    implements IStudentUnitRecord
{
    private Integer studentID_;
    private String unitCode_;
    private StudentUnitRecordManager studentUnitRecordManager_;



    /**
     * Class constructor.
     *
     * @param id        Student ID.
     * @param unitCode  Unit code.
     */
    public StudentUnitRecordProxy(Integer id, String unitCode)
    {
        this.studentID_ = id;
        this.unitCode_ = unitCode;
        this.studentUnitRecordManager_ = StudentUnitRecordManager.getSelf();
    }



    /**
     * Return student ID.
     *
     * @return Student ID.
     */
    public Integer getStudentID()
    {
        return studentID_;
    }



    /**
     * Return unit code.
     *
     * @return Unit code.
     */
    public String getUnitCode()
    {
        return unitCode_;
    }



    /**
     * Set assignment 1 mark.
     *
     * @param mark Assignment 1 mark.
     */
    public void setAssignment1Mark(float mark)
    {
        studentUnitRecordManager_.
               getStudentUnitRecord(studentID_, unitCode_).
               setAssignment1Mark(mark);
    }



    /**
     * Return assignment 1 mark.
     *
     * @return Assignment 1 mark.
     */
    public float getAssignment1Mark()
    {
        return studentUnitRecordManager_.
               getStudentUnitRecord(studentID_, unitCode_).
               getAssignment1Mark();
    }



    /**
     * Set assignment 2 mark.
     *
     * @param mark Assignment 2 mark.
     */
    public void setAssignment2Mark(float mark) {
        studentUnitRecordManager_.getStudentUnitRecord(studentID_, unitCode_).
               setAssignment2Mark(mark);
    }



    /**
     * Return assignment 2 mark.
     *
     * @return Assignment 2 mark.
     */
    public float getAssignment2Mark() {
        return studentUnitRecordManager_.
               getStudentUnitRecord(studentID_, unitCode_).
               getAssignment2Mark();
    }



    /**
     * Set exam mark.
     *
     * @param mark Exam mark.
     */
    public void setExamMark(float mark) {
        studentUnitRecordManager_.
               getStudentUnitRecord(studentID_, unitCode_).
               setExamMark(mark);
    }



    /**
     * Return exam mark.
     *
     * @return Exam mark.
     */
    public float getExamMark() {
        return studentUnitRecordManager_.
               getStudentUnitRecord(studentID_, unitCode_).
               getExamMark();
    }



    /**
     * Return total mark.
     *
     * @return Total mark.
     */
    public float getTotalMark() {
        return studentUnitRecordManager_.
               getStudentUnitRecord(studentID_, unitCode_).
               getTotalMark();
    }
}
