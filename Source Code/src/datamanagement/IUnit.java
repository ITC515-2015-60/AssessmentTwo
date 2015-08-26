package datamanagement;

/**
 * Unit
 *
 * @author Pat Barilla
 * @since 26/08/2015
 */
public interface IUnit {

    /**
     * Gets the Unit Code.
     */
    public String getUnitCode();

    /**
     * Gets the Unit Name.
     */
    public String getUnitName();

    /**
     * Get the Pass Cutoff.
     */
    public float getPassCutoff();

    /**
     * Sets the Pass Cutoff.
     *
     * @param passCutoff
     */
    public void setPassCutoff(float passCutoff);

    /**
     * Gets the Credit Cutoff.
     */
    public float getCreditCutoff();

    /**
     * Sets the Credit Cutoff.
     *
     * @param creditCutoff
     */
    public void setCreditCutoff(float creditCutoff);

    /**
     * Gets the Distinction Cutoff.
     */
    public float getDistinctionCutoff();

    /**
     * Sets the Distinction Cutoff.
     *
     * @param distinctionCutoff
     */
    public void setDistinctionCutoff(float distinctionCutoff);

    /**
     * Gets the High Distinction Cutoff.
     */
    public float getHighDistinctionCutoff();

    /**
     * Sets the High Distinction Cutoff.
     *
     * @param highDistinctionCutoff
     */
    public void setHighDistinctionCutoff(float highDistinctionCutoff);

    /**
     * Gets Additional Exam Cutoff.
     */
    public float getAdditionalExamCutoff();

    /**
     * Sets the Additional Exam Cutoff.
     *
     * @param additionalExamCutoff
     */
    public void setAdditionalExamCutoff(float additionalExamCutoff);

    /**
     * Gets Assignment 1's Weighting.
     */
    public int getAssessment1Weight();

    /**
     * Gets Assignment 2's Weighting.
     */
    public int getAssessment2Weight();

    /**
     * Gets the Exam Weighting.
     */
    public int getExamWeight();

    /**
     * Sets the Assignment Weights
     *
     * @param assessment1Weight
     * @param assessment2Weight
     * @param examWeight
     */
    public void setAssessmentWeights(int assessment1Weight, int assessment2Weight, int examWeight);

    /**
     * Gets the grade based on the scores.
     *
     * @param assignment1
     * @param assignment2
     * @param exam
     * @return
     */
    public String getGrade(float assignment1, float assignment2, float exam);

    /**
     * Adds a student record.
     *
     * @param record
     */
    public void addStudentRecord(IStudentUnitRecord record);

    /**
     * Gets the student record.
     *
     * @param studentID
     *
     * @return The student Record.
     */
    public IStudentUnitRecord getStudentRecord(int studentID);

    /**
     * Gets the Student Records
     */
    public StudentUnitRecordList getStudentRecords();
}
