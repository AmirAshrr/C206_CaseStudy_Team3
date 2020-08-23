//create by Amir at 18/8/2020
public class Student {
private int id;
private String name;
private int grade;
private String studentClass;
private String classroomTeacher;
public Student(int id, String name, int grade, String class1, String classroomTeacher) {
	this.id = id;
	this.name = name;
	this.grade = grade;
	this.studentClass = class1;
	this.classroomTeacher = classroomTeacher;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getGrade() {
	return grade;
}
public void setGrade(int grade) {
	this.grade = grade;
}
public String getStudentClass() {
	return studentClass;
}
public void setStudentClass(String class1) {
	studentClass = class1;
}
public String getClassroomTeacher() {
	return classroomTeacher;
}
public void setClassroomTeacher(String classroomTeacher) {
	this.classroomTeacher = classroomTeacher;
}


}
