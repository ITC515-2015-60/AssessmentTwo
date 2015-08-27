package datamanagement;

/**
 * The class represents a student object.
 *
 * @author Zeno Li
 * @since 2015-08-05
 */
public class Student
    implements IStudent
{
    private Integer id_;
    private String firstName_;
    private String lastName_;
    private StudentUnitRecordList studentUnitRecordList_;



    /**
     * Class constructor.
     *
     * @param id                    Student ID.
     * @param firstName             First name.
     * @param lastName              Last name.
     * @param studentUnitRecordList Student-unit record list.
     */
    public Student(Integer id, String firstName, String lastName,
                   StudentUnitRecordList studentUnitRecordList)
    {
        this.id_ = id;
        this.firstName_ = firstName;
        this.lastName_ = lastName;
        this.studentUnitRecordList_ =
                studentUnitRecordList == null ? new StudentUnitRecordList() :
                                         studentUnitRecordList;
    }



    /**
     * Return student ID.
     *
     * @return  Student ID.
     */
    public Integer getId()
    {
        return this.id_;
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
     * Set first name.
     *
     * @param firstName First name.
     */
    public void setFirstName(String firstName)
    {
        this.firstName_ = firstName;
    }



    /**
     * Return last name.
     *
     * @return  Last name.
     */
    public String getLastName()
    {
        return lastName_;
    }



    /**
     * Set last name
     *
     * @param lastName  Last name.
     */
    public void setLastName(String lastName)
    {
        this.lastName_ = lastName;
    }



    /**
     * Add student-unit record.
     *
     * @param studentUnitRecord Student-unit record.
     */
    public void addUnitRecord(IStudentUnitRecord studentUnitRecord)
    {
        studentUnitRecordList_.add(studentUnitRecord);
    }



    /**
     * Return student-unit record for an unit.
     *
     * @param unitCode Unit code.
     * @return  Student-unit record.
     */
    public IStudentUnitRecord getUnitRecord(String unitCode)
    {
        for (IStudentUnitRecord record : studentUnitRecordList_) {
            if (record.getUnitCode().equals(unitCode))
                return record;
        }

        return null;
    }



    /**
     * Return student-unit record list.
     *
     * @return Student-unit record list.
     */
    public StudentUnitRecordList getUnitRecords()
    {
        return studentUnitRecordList_;
    }
}
