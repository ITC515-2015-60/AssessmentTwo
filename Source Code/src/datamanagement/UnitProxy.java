package datamanagement;

public class UnitProxy implements IUnit {

    private String unitCode_;
    private String unitName_;
    private UnitManager unitManager_;

    public UnitProxy(String unitCode, String unitName) {
        unitCode_ = unitCode;
        unitName_ = unitName;

        unitManager_ = UnitManager.getInstance();
    }

    public String getUnitCode() {
        return unitCode_;
    }

    public String getUnitName() {
        return unitName_;
    }

    public void setPassCutoff(float cutoff) {
        unitManager_.getUnit(unitCode_).setPassCutoff(cutoff);
    }

    public float getPassCutoff() {
        return unitManager_.getUnit(unitCode_).getPassCutoff();
    }

    public void setCreditCutoff(float cutoff) {
        unitManager_.getUnit(unitCode_).setCreditCutoff(cutoff);
    }

    public float getCreditCutoff() {
        return unitManager_.getUnit(unitCode_).getCreditCutoff();
    }

    public void setDistinctionCutoff(float cutoff) {
        unitManager_.getUnit(unitCode_).setDistinctionCutoff(cutoff);
    }

    public float getDistinctionCutoff() {
        return unitManager_.getUnit(unitCode_).getDistinctionCutoff();
    }

    public void setHighDistinctionCutoff(float cutoff) {
        unitManager_.getUnit(unitCode_).setHighDistinctionCutoff(cutoff);
    }

    public float getHighDistinctionCutoff() {

        return unitManager_.getUnit(unitCode_).getHighDistinctionCutoff();
    }

    public void setAdditionalExamCutoff(float cutoff) {
        unitManager_.getUnit(unitCode_).setAdditionalExamCutoff(cutoff);
    }

    public float getAdditionalExamCutoff() {
        return unitManager_.getUnit(unitCode_).getAdditionalExamCutoff();
    }

    public String getGrade(float assessment1Score, float assessment2Score, float examScore) {
        return unitManager_.getUnit(unitCode_).getGrade(assessment1Score, assessment2Score, examScore);
    }

    public void addStudentRecord(IStudentUnitRecord record) {
        unitManager_.getUnit(unitCode_).addStudentRecord(record);
    }

    public IStudentUnitRecord getStudentRecord(int studentId) {
        return unitManager_.getUnit(unitCode_).getStudentRecord(studentId);
    }

    public StudentUnitRecordList getStudentRecords() {
        return unitManager_.getUnit(unitCode_).getStudentRecords();
    }

    public int getAssessment1Weight() {
        return unitManager_.getUnit(unitCode_).getAssessment1Weight();
    }

    public int getAssessment2Weight() {
        return unitManager_.getUnit(unitCode_).getAssessment2Weight();
    }

    public int getExamWeight() {
        return unitManager_.getUnit(unitCode_).getExamWeight();
    }

    public void setAssessmentWeights(int assessment1Weight, int assessment2Weight, int assessment3Weight) {
        unitManager_.getUnit(unitCode_).setAssessmentWeights(assessment1Weight, assessment2Weight, assessment3Weight);
    }
}
