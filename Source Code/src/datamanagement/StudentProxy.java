package datamanagement;

/**
 * The proxy class for student.
 *
 * @author Zeno Li
 * @since 2015-08-05
 */
public class StudentProxy
    implements IStudent
{
    private Integer id_;
    private String firstName_;
    private String lastName_;
    private StudentManager studentManager_;


    /**
     * Class constructor.
     *
     * @param id        Student ID.
     * @param firstName First name.
     * @param lastName  Last name.
     */
    public StudentProxy(Integer id, String firstName, String lastName)
    {
        this.id_ = id;
        this.firstName_ = firstName;
        this.lastName_ = lastName;
        this.studentManager_ = StudentManager.getInstance();
    }



    /**
     * Return student ID.
     *
     * @return Student ID.
     */
    public Integer getId()
    {
        return id_;
    }



    /**
     * Return first name.
     *
     * @return First name.
     */
    public String getFirstName()
    {
        return firstName_;
    }



    /**
     * Return last name.
     *
     * @return Last name.
     */
    public String getLastName()
    {
        return lastName_;
    }



    /**
     * Set first name.
     *
     * @param firstName First name.
     */
    public void setFirstName(String firstName)
    {
        studentManager_.getStudent(id_).setFirstName(firstName);
    }



    /**
     * Set last name.
     *
     * @param lastName Last name.
     */
    public void setLastName(String lastName)
    {
        studentManager_.getStudent(id_).setLastName(lastName);
    }



    /**
     * Add student-unit record to a student.
     *
     * @param studentUnitRecord Student-unit record.
     */
    public void addUnitRecord(IStudentUnitRecord studentUnitRecord)
    {
        studentManager_.getStudent(id_).addUnitRecord(studentUnitRecord);
    }



    /**
     * Return Student-unit record for a unit.
     *
     * @param unitCode Unit code.
     * @return  Student-unit record.
     */
    public IStudentUnitRecord getUnitRecord(String unitCode)
    {
        return studentManager_.getStudent(id_).getUnitRecord(unitCode);
    }



    /**
     * Return student-unit record list.
     *
     * @return Student-unit record list.
     */
    public StudentUnitRecordList getUnitRecords()
    {
        return studentManager_.getStudent(id_).getUnitRecords();
    }
}
