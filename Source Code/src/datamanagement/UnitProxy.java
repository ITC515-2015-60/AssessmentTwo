package datamanagement;
public class UnitProxy implements IUnit {
private String UC;
        private String un;

        
        UnitManager   um;

    public UnitProxy( String unitCode, String unitName ) {
        this.UC = unitCode;
            this.un = unitName;
                um = UnitManager.UM(); }
    public String getUnitCode() {
        return this.UC;}
        public String getUnitName() { 
            return this.un; 
        }
    public void setPassCutoff(float cutoff) {
        um.getUnit(UC).setPassCutoff(cutoff);
}
public float getPassCutoff() {
        return um.getUnit(UC).getPassCutoff();}
    public void setCreditCutoff(float cutoff) {um.getUnit(UC).setCreditCutoff(cutoff);
    }
    public float getCreditCutoff() {
return um.getUnit(UC).getCreditCutoff();
    }

public void setDistinctionCutoff(float cutoff) {um.getUnit(UC).setDistinctionCutoff(cutoff);}
    public float getDistinctionCutoff() {return um.getUnit(UC).getDistinctionCutoff();}
public void setHighDistinctionCutoff(float cutoff) {
    um.getUnit(UC).setHighDistinctionCutoff(cutoff);}
    public float getHighDistinctionCutoff() {

        return um.getUnit(UC).getHighDistinctionCutoff();}
public void setAdditionalExamCutoff(float cutoff) {um.getUnit(UC).setAdditionalExamCutoff(cutoff);
    }
    public float getAdditionalExamCutoff() {return um.getUnit(UC).getAdditionalExamCutoff();}
public String getGrade(float f1, float f2, float f3) {
return um.getUnit(UC).getGrade(f1, f2, f3);
    }
    public void addStudentRecord(IStudentUnitRecord record) 
{ 
um.getUnit(UC).addStudentRecord(record);
    }
    public IStudentUnitRecord getStudentRecord(int s) {return um.getUnit(UC).getStudentRecord(s);}
public StudentUnitRecordList getStudentRecords() {
    return um.getUnit(UC).getStudentRecords();
}
public int getAssessment1Weight() {
	return um.getUnit(UC).getAssessment1Weight();
}
public int getAssessment2Weight() {
	return um.getUnit(UC).getAssessment2Weight();
}
public int getExamWeight() {
	return um.getUnit(UC).getExamWeight();
}
public void setAssessmentWeights(int asg1Wgt, int asg2Wgt, int examWgt) {
	um.getUnit(UC).setAssessmentWeights(asg1Wgt, asg2Wgt, examWgt);
	
}}
