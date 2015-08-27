package datamanagement;

/**
 * Unit
 *
 * @author Pat Barilla
 * @since 26/08/2015
 */
public interface IUnit
{

    /**
     * Gets the Unit Code.
     */
    String getUnitCode();

    /**
     * Get the Pass Cutoff.
     */
    float getPassCutoff();

    /**
     * Sets the Pass Cutoff.
     *
     * @param passCutoff
     */
    void setPassCutoff(float passCutoff);

    /**
     * Gets the Credit Cutoff.
     */
    float getCreditCutoff();

    /**
     * Sets the Credit Cutoff.
     *
     * @param creditCutoff
     */
    void setCreditCutoff(float creditCutoff);

    /**
     * Gets the Distinction Cutoff.
     */
    float getDistinctionCutoff();

    /**
     * Sets the Distinction Cutoff.
     *
     * @param distinctionCutoff
     */
    void setDistinctionCutoff(float distinctionCutoff);

    /**
     * Gets the High Distinction Cutoff.
     */
    float getHighDistinctionCutoff();

    /**
     * Sets the High Distinction Cutoff.
     *
     * @param highDistinctionCutoff
     */
    void setHighDistinctionCutoff(float highDistinctionCutoff);

    /**
     * Gets Additional Exam Cutoff.
     */
    float getAdditionalExamCutoff();

    /**
     * Sets the Additional Exam Cutoff.
     *
     * @param additionalExamCutoff
     */
    void setAdditionalExamCutoff(float additionalExamCutoff);

    /**
     * Gets Assignment 1's Weighting.
     */
    int getAssessment1Weight();

    /**
     * Gets Assignment 2's Weighting.
     */
    int getAssessment2Weight();

    /**
     * Gets the Exam Weighting.
     */
    int getExamWeight();

    /**
     * Sets the Assignment Weights
     *
     * @param assessment1Weight
     * @param assessment2Weight
     * @param examWeight
     */
    void setAssessmentWeights(int assessment1Weight, int assessment2Weight, int examWeight);

    /**
     * Gets the grade based on the scores.
     *
     * @param assignment1
     * @param assignment2
     * @param exam
     * @return
     */
    String getGrade(float assignment1, float assignment2, float exam);

    /**
     * Adds a student record.
     *
     * @param record
     */
    void addStudentRecord(IStudentUnitRecord record);

    /**
     * Gets the student record.
     *
     * @param studentID
     *
     * @return The student Record.
     */
    IStudentUnitRecord getStudentRecord(int studentID);

    /**
     * Gets the Student Records
     */
    StudentUnitRecordList getStudentRecords();
}
