package datamanagement;

/**
 * The class represents a student-unit relationship.
 *
 * @author Zeno Li
 * @since 2015-08-05
 */
public class StudentUnitRecord
    implements IStudentUnitRecord
{
    private Integer studentId_;
    private String unitCode_;
    private float assignment1Mark_, assignment2Mark_, examMark_;



    /**
     * Class constructor.
     *
     * @param id                Student ID.
     * @param unitCode          Unit code.
     * @param assignment1Mark   Assignment 1 mark.
     * @param assignment2Mark   Assignment 2 mark.
     * @param examMark          Exam mark.
     */
    public StudentUnitRecord(Integer id, String unitCode,
                             float assignment1Mark, float assignment2Mark,
                             float examMark)
    {
        this.studentId_ = id;
        this.unitCode_ = unitCode;
        this.setAssignment1Mark(assignment1Mark);
        this.setAssignment2Mark(assignment2Mark);
        this.setExamMark(examMark);
    }



    /**
     * Return student ID.
     *
     * @return Student ID.
     */
    public Integer getStudentId()
    {
        return studentId_;
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
        if (mark < 0 ||
            mark > UnitManager.UM().getUnit(unitCode_).getAsg1Weight())
            throw new RuntimeException("Mark cannot be less than zero " +
                                       "or greater than assessment weight");

        this.assignment1Mark_ = mark;
    }



    /**
     * Return assignment 1 mark.
     *
     * @return Assignment 1 mark.
     */
    public float getAssignment1Mark() {

        return assignment1Mark_;
    }



    /**
     * Set assignment 2 mark.
     *
     * @param mark Assignment 2 mark.
     */
    public void setAssignment2Mark(float mark) {
        if (mark < 0 ||
                mark > UnitManager.UM().getUnit(unitCode_).getAsg2Weight())
            throw new RuntimeException("Mark cannot be less than zero " +
                                       "or greater than assessment weight");

        this.assignment2Mark_ = mark;
    }



    /**
     * Return assignment 2 mark.
     *
     * @return Assignment 2 mark.
     */
    public float getAssignment2Mark()
    {
        return assignment2Mark_;
    }



    /**
     * Set exam mark.
     *
     * @param mark Exam mark.
     */
    public void setExamMark(float mark) {
        if (mark < 0 ||
                mark > UnitManager.UM().getUnit(unitCode_).getExamWeight())
            throw new RuntimeException("Mark cannot be less than zero or " +
                                       "greater than assessment weight");

        this.examMark_ = mark;
    }



    /**
     * Return exam mark.
     *
     * @return Exam mark.
     */
    public float getExamMark()
    {
        return examMark_;
    }



    /**
     * Return total mark.
     *
     * @return Total mark.
     */
    public float getTotalMark()
    {
        return assignment1Mark_ + assignment2Mark_ + examMark_;
    }
}
