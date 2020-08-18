
public class CCA {

	private String title;
	private String description; 
	private int class_size;
	private String week; 
	private float time;
	private String venue;
	private String instructor_name; 
	
	public CCA(String title, String description, int class_size, String week, int time, String venue, String instructor_name) {
	
	this.title = title;
	this.description = description; 
	this.class_size = class_size; 
	this.week = week;
	this.time = time;
	this.venue = venue; 
	this.instructor_name = instructor_name;
}
	
	public String getTitle() {
		return title;
		
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description; 
		
	}
	
	public void setDescription(String description) {
		this.description = description; 
		
	}
	
	public int getClass_Size() {
		return class_size;
	}
	
	public void setClass_Size(int class_size) {
		this.class_size = class_size;
	}
	
	public String getWeek() {
		return week;
		
	}
	
	public void setWeek(String week) {
		this.week = week; 
	}
	
	public float getTime() {
		return time;
	}
	
	public void setTime(float time) {
		this.time = time;
	}
	
	public String getVenue() {
		return venue;
	}
	
	public void setVenue(String venue) { 
		this.venue = venue;
	}
	
	public String getInstructor_Name() {
		return instructor_name;
	}
	
	public void setInstuructor_Name(String instructor_name) {
		this.instructor_name = instructor_name;
	}
	
}
