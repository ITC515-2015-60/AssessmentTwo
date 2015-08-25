package datamanagement;

/**
 * The class controls wraps access to the Unit object.
 *
 * @author Andrew Tobin
 * @since 2015-08-05
 */
public class UnitProxy implements IUnit {

    private String unitCode_;
    private String unitName_;
    private UnitManager unitManager_;

    /**
     * Constructor for the wrapper class.
     * @param unitCode Code for the subject.
     * @param unitName Subject name.
     */
    public UnitProxy(String unitCode, String unitName) {
        unitCode_ = unitCode;
        unitName_ = unitName;

        unitManager_ = UnitManager.getInstance();
    }


    /**
     * Cet Subject Code.
     * @return
     */
    public String getUnitCode() {
        return unitCode_;
    }


    /**
     * Get Subject Name.
     * @return
     */
    public String getUnitName() {
        return unitName_;
    }


    /**
     * Set the cutoff mark required for a Pass.
     * @param cutoff
     */
    public void setPassCutoff(float cutoff) {
        unitManager_.getUnit(unitCode_).setPassCutoff(cutoff);
    }


    /**
     * Get the cutoff mark required for a Pass.
     * @return
     */
    public float getPassCutoff() {
        return unitManager_.getUnit(unitCode_).getPassCutoff();
    }


    /**
     * Set the cutoff mark required for a Credit.
     * @param cutoff
     */
    public void setCreditCutoff(float cutoff) {
        unitManager_.getUnit(unitCode_).setCreditCutoff(cutoff);
    }


    /**
     * Get the cutoff mark required for a Credit.
     * @return
     */
    public float getCreditCutoff() {
        return unitManager_.getUnit(unitCode_).getCreditCutoff();
    }


    /**
     * Set the cutoff mark required for a Distinction.
     * @param cutoff
     */
    public void setDistinctionCutoff(float cutoff) {
        unitManager_.getUnit(unitCode_).setDistinctionCutoff(cutoff);
    }


    /**
     * Get the cutoff mark required for a Distinction.
     * @return
     */
    public float getDistinctionCutoff() {
        return unitManager_.getUnit(unitCode_).getDistinctionCutoff();
    }


    /**
     * Set the cutoff mark required for a High Distinction.
     * @param cutoff
     */
    public void setHighDistinctionCutoff(float cutoff) {
        unitManager_.getUnit(unitCode_).setHighDistinctionCutoff(cutoff);
    }


    /**
     * Get the cutoff mark required for a High Distinction.
     * @return
     */
    public float getHighDistinctionCutoff() {

        return unitManager_.getUnit(unitCode_).getHighDistinctionCutoff();
    }


    /**
     * Set the cutoff mark required for an Additional Exam.
     * @param cutoff
     */
    public void setAdditionalExamCutoff(float cutoff) {
        unitManager_.getUnit(unitCode_).setAdditionalExamCutoff(cutoff);
    }


    /**
     * Get the cutoff mark required for an Additional Exam.
     * @return
     */
    public float getAdditionalExamCutoff() {
        return unitManager_.getUnit(unitCode_).getAdditionalExamCutoff();
    }


    /**
     * Get the appropriate grade given a set of scores.
     * @param assessment1Score
     * @param assessment2Score
     * @param examScore
     * @return
     */
    public String getGrade(float assessment1Score, float assessment2Score,
                           float examScore) {
        return unitManager_.getUnit(unitCode_).getGrade(assessment1Score,
                assessment2Score, examScore);
    }


    /**
     * Add a student record to the class subject.
     * @param record
     */
    public void addStudentRecord(IStudentUnitRecord record) {
        unitManager_.getUnit(unitCode_).addStudentRecord(record);
    }


    /**
     * Get a student's record from the class subject.
     * @param studentId
     * @return
     */
    public IStudentUnitRecord getStudentRecord(int studentId) {
        return unitManager_.getUnit(unitCode_).getStudentRecord(studentId);
    }


    /**
     * Get all student records for the subject.
     * @return
     */
    public StudentUnitRecordList getStudentRecords() {
        return unitManager_.getUnit(unitCode_).getStudentRecords();
    }


    /**
     * Get the weighting for the first assessment for the subject.
     * @return
     */
    public int getAssessment1Weight() {
        return unitManager_.getUnit(unitCode_).getAssessment1Weight();
    }


    /**
     * Get the weighting for the second assessment for the subject.
     * @return
     */
    public int getAssessment2Weight() {
        return unitManager_.getUnit(unitCode_).getAssessment2Weight();
    }


    /**
     * Get the weighting for the exam for the subject.
     * @return
     */
    public int getExamWeight() {
        return unitManager_.getUnit(unitCode_).getExamWeight();
    }


    /**
     * Set the weightings for the assessments and exam for the subject.
     * @param assessment1Weight
     * @param assessment2Weight
     * @param examWeight
     */
    public void setAssessmentWeights(int assessment1Weight,
                                     int assessment2Weight, int examWeight) {
        unitManager_.getUnit(unitCode_).setAssessmentWeights(assessment1Weight,
                assessment2Weight, examWeight);
    }
}
