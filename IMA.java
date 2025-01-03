import java.text.SimpleDateFormat;
import java.util.*;
public class IMA {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter case ");
        int val = sc.nextInt();

        int ad = 0 ;
        Batch[] batches = new Batch[3];
        int batchCounter = 0;
        Course[] courses = new Course[3];
        Enquiry[] enq = new Enquiry[5];
        Addimission[] admn = new Addimission[ad];

    while(val != 0){

        switch (val) {
            case 1:
                    System.out.println("Enter courses ");
                    for(int i = 0 ;i< courses.length;i++){
                        courses[i] = new Course();
                        int cid = sc.nextInt();
                        sc.nextLine();
                        String cname = sc.nextLine();
                        courses[i].setId(cid);
                        courses[i].setCname(cname);
                    }
                    System.out.println("Courses Done....");
                break;
                
            case 2:
                    System.out.println("Enter student id, name, mail, contact, choices of course , taking addmission or not  ");
                    for(int i = 0 ;i< enq.length;i++){
                        enq[i] = new Enquiry();
                        int eid = sc.nextInt();
                        sc.nextLine();
                        String name = sc.nextLine();
                        String mail = sc.nextLine();
                        String contact = sc.nextLine();
                        boolean status = sc.nextBoolean();
                        System.out.println("Courses arwe ");
                        Course[] studentEnqiuryCourse = new Course[3];
                        int j = 0 ;
                        for (Course course : courses) {
                            System.out.println(course.getId()+" "+course.getCname());
                            int check = sc.nextInt();
                            if(check != 0){
                                studentEnqiuryCourse[j] = new Course();
                                studentEnqiuryCourse[j].setCname(course.getCname());
                                studentEnqiuryCourse[j].setId(course.getId());
                            }
                        }
                        enq[i].setContact(contact);
                        enq[i].setCourses(studentEnqiuryCourse);
                        enq[i].setEid(eid);
                        enq[i].setMail(mail);
                        enq[i].setSname(name);
                        enq[i].setStatus(status);
                    }
                    System.out.println("Enquiry student ... ");
                break;
            
            case 3:
                System.out.println("Enter  courseid for student  ");
                for(int i = 0 ;i< enq.length;i++){
                    System.out.println("Enter 1 for addminssion of "+ enq[i].getSname());
                    int cond = sc.nextInt();
                    if(cond != 0 ){
                        ad++;
                        enq[i].setStatus(true);
                    }
                }
                admn = new Addimission[ad];

                // System.out.println("Enter the course id for each student now");
                int k = 0;
                for(int i= 0 ;i< enq.length;i++){
                    if(enq[i].isStatus()){
                        System.out.println("Enter for course  "+ enq[i].getSname());
                        int courseid = sc.nextInt();
                        admn[k] = new Addimission();
                        admn[k].setEnquiry(enq[i]);
                        Course course = new Course();
                        for(int j = 0 ;j<courses.length;j++) {
                            if(courses[j].getId() == courseid){
                                course.setId(courses[j].getId());
                                course.setCname(courses[j].getCname());
                            }
                        }
                        admn[k].setCourse(course);
                        k++;
                    }
                }

                for(int i = 0 ;i< ad ;i++){
                    System.out.println(admn[i].getEnquiry().getSname() +" "+ admn[i].getCourse().getCname());
                }  

                break;
            
            case 4:
                    if(batchCounter < 3){
                        System.out.println("Enter batch like id ,start date, end date batch name  courseobj admin arr");
                        batches[batchCounter] = new Batch();
                        
                        int bid = sc.nextInt();
                        String bname = sc.nextLine();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        dateFormat.setLenient(false);
                        
                        String startdate = sc.nextLine();
                        String enddate = sc.nextLine();
                        Date sDate = null;
                        Date eDate = null ;
                        try{
                            sDate = dateFormat.parse(startdate);
                            eDate = dateFormat.parse(enddate);
                        }catch(Exception ex ){
                            System.out.println(startdate+" is not in right format ");
                        }

                        int courseIdForBatch = sc.nextInt();
                        int studnetForBatch = 0 ;
                        Course courseForBatch = new Course();

                        for(int i= 0 ;i< courses.length;i++){
                            if(courses[i].getId() == courseIdForBatch){
                                courseForBatch.setId(courses[i].getId());
                                courseForBatch.setCname(courses[i].getCname());
                            }
                        }

                        for(int i =0;i< admn.length;i++){
                            if(admn[i].getCourse().getId() == courseForBatch.getId()){
                                studnetForBatch ++ ;
                            }
                        }

                        Addimission[] admnforBatchFromCourse = new Addimission[studnetForBatch];
                        int j = 0 ;
                        for(int i = 0 ;i< ad;i++){
                            if(admn[i].getCourse().getId() == courseIdForBatch){
                                admnforBatchFromCourse[j] = new Addimission();
                                admnforBatchFromCourse[j].setCourse(courseForBatch);
                                admnforBatchFromCourse[j].setEnquiry(admn[i].getEnquiry());
                                j++;
                            }
                        }

                        batches[batchCounter].setSdate(sDate);
                        batches[batchCounter].setBname(bname);
                        batches[batchCounter].setId(bid);
                        batches[batchCounter].setEdate(eDate);
                        batches[batchCounter].setCourse(courseForBatch);
                        batches[batchCounter].setAddimissions(admnforBatchFromCourse);

                        System.out.println(sDate+" "+eDate+" "+bname+" "+courseForBatch.getCname()+" "+bid);
                        for (int i = 0; i < admnforBatchFromCourse.length; i++) {
                            System.out.println(admnforBatchFromCourse[i].getEnquiry().getSname()+" "+admnforBatchFromCourse[i].getCourse().getCname());
                        }

                        batchCounter ++;
                    }
                break;
            
            case 5 :
                    for(int i = 0 ;i< courses.length;i++){
                        System.out.println(courses[i].getCname()+" "+courses[i].getId());
                    }
                break ;

            case 6:
                    System.out.println("course wise student ");
                    for(int  i= 0;i< courses.length;i++){
                        System.out.println("Addission for "+ courses[i].getCname());
                        for (int j = 0; j < admn.length; j++) {
                            if(admn[j].getCourse().getId() == courses[i].getId()){
                               System.out.println(admn[i].getEnquiry().getSname()+" "+admn[i].getEnquiry().getMail()); 
                            }
                        }
                    }

                break ;

            case 7:
                    System.out.println("Batch wise student ");
                    for(int i = 0 ;i< batches.length;i++){
                        System.out.println("batch is "+ batches[i].getBname());
                        for(int j = 0 ;j< admn.length;j++){
                            if(batches[i].getCourse().getId() == admn[j].getCourse().getId())
                            System.out.println(admn[i].getEnquiry().getSname()+" "+admn[i].getEnquiry().getMail());  
                        }
                    }
                break ;

            case 8:
                    System.out.println("all Enquiries");
                    for (int i = 0; i < enq.length; i++) {
                        System.out.println(enq[i].getSname()+" "+enq[i].mail);
                    }
                break;
            
            case 9 :
                System.out.println("all Addmission");
                for (int i = 0; i < admn.length; i++) {
                    System.out.println(admn[i].getEnquiry().getSname()+" "+admn[i].getCourse().getCname());
                }
                break;
            case 10 :

                    System.out.println("Student how cancel admission ");

                    for (int i = 0; i < enq.length; i++) {
                        if(!enq[i].isStatus()){
                            System.out.println(enq[i].getSname()+" "+enq[i].getMail());
                        }
                    }
                
                break;

            default:
                System.out.println(" thank you ghar bhago");
                break;
        }
        
        System.out.println("Enter case ");
        val = sc.nextInt();

    }

    System.out.println(" thank you ");
    sc.close();
    }
    
}
