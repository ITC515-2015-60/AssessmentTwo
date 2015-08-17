package datamanagement;

import org.jdom.Element;

import java.util.List;

/**
 * The class controls student objects.
 *
 * @author Zeno Li
 * @since 2015-08-05
 */
public class StudentManager
{
    private static StudentManager self_ = null;

    private StudentMap studentMap_;
    private java.util.HashMap<String, StudentMap> unitStudentMap_;



    /**
     * Class constructor.
     */
    private StudentManager()
    {
        studentMap_ = new StudentMap();
        unitStudentMap_ = new java.util.HashMap<>();
    }



    /**
     * Return static student manager object self_.
     *
     * @return Student manager.
     */
    public static StudentManager getSelf()
    {
        if (self_ == null)
            self_ = new StudentManager();

        return self_;
    }



    /**
     * Return student by student ID.
     *
     * @param id    Student ID.
     * @return  Student object.
     */
    public IStudent getStudent(Integer id)
    {
        IStudent student = studentMap_.get(id);
        return student != null ? student : createStudent(id);
    }



    private Element getStudentElement(Integer id)
    {
        for (Element element :
             (List<Element>)
             XMLManager.getXML().getDocument().getRootElement().
                        getChild("studentTable").getChildren("student"))
            if (id.toString().equals(element.getAttributeValue("sid")))
                return element;

        return null;
    }



    private IStudent createStudent(Integer id)
    {
        IStudent student;
        Element element = getStudentElement(id);

        if (element != null) {
            StudentUnitRecordList recordList =
                StudentUnitRecordManager.getSelf().getRecordsByStudent(id);

            student = new Student(
                                new Integer(element.getAttributeValue("sid")),
                                element.getAttributeValue("fname"),
                                element.getAttributeValue("lname"),
                                recordList);

            studentMap_.put(student.getId(), student);

            return student;
        }

        throw new RuntimeException("DBMD: createStudent : " +
                                   "student not in file");
    }



    private IStudent createStudentProxy(Integer id)
    {
        Element element = getStudentElement(id);

        if (element != null)
            return new StudentProxy(id,
                                    element.getAttributeValue("fname"),
                                    element.getAttributeValue("lname"));

        throw new RuntimeException("DBMD: createStudent : " +
                                   "student not in file");
    }



    /**
     * Return student map contains the given unit code.
     *
     * @param unitCode Unit code.
     * @return  Student map.
     */
    public StudentMap getStudentsByUnit(String unitCode)
    {
        StudentMap studentMap = unitStudentMap_.get(unitCode);

        if (studentMap != null)
            return studentMap;

        studentMap = new StudentMap();

        IStudent student;
        StudentUnitRecordList studentUnitRecordList =
                StudentUnitRecordManager.getSelf().getRecordsByUnit(unitCode);

        for (IStudentUnitRecord record : studentUnitRecordList) {
            student = createStudentProxy(new Integer(record.getStudentID()));
            studentMap.put(student.getId(), student);
        }

        unitStudentMap_.put(unitCode, studentMap);

        return studentMap;
    }
}
