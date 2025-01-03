import java.util.Date;
public class Batch {
    
    int id ;
	Date sdate ;
	Date edate ;
	String bname ;
	Course course ;
	Addimission[] admn ;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getSdate() {
		return sdate;
	}
	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}
	public Date getEdate() {
		return edate;
	}
	public void setEdate(Date edate) {
		this.edate = edate;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Addimission[] getAddimissions() {
		return admn;
	}
	public void setAddimissions(Addimission[] enquiry) {
		this.admn = enquiry;
	}
	
    
}
