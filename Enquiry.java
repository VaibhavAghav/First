public class Enquiry {

    int eid ;
    String sname ;
    String mail;
    String contact ;
    Course[] courses ;
    boolean status ;

    
    public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Course[] getCourses() {
		return courses;
	}
	public void setCourses(Course[] courses) {
		this.courses = courses;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}



}
