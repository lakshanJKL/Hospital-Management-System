import java.util.*;

public class HMS {
    // data store
    static  String[] questions = new String[5];
    static String [] patientsQts = new String[6];
    static String [] doctorsQts = new String[6];
    static String [][] patients = new String[100][4];
    static String [][] doctors = new String[50][3];
    static String [][]  appointment = new String [100][5];

    static int count1 = 1;
    static int count2 = 1;
    static int count3 = 1;

    //colors & text format
    static String red= "\u001B[31m";
    static String BRIGHT_CYAN ="\u001B[96m";
    static String Lightblue ="\u001B[94m";
    static String lightGreen ="\u001B[92m";
    static String yellow = "\u001B[33m";
    static String purple = "\u001B[35m";
    static String light_purple = "\u001B[95m";
    static String resetclr= "\u001B[0m";
    static String BOLD = "\u001b[1m";


    //main menu
    public static int mainqts(String[] questions,Scanner input){

         System.out.println(" ");
         System.out.print(purple);
         System.out.println(BOLD+"  HOSPITAL MANAGEMENT SYSTEM"+resetclr);
         System.out.println(" ");
         System.out.println(BRIGHT_CYAN+"Hospital Management System Menu"+resetclr);

         //main menu questions
         questions[0] = "1) Patient Management";
         questions[1] = "2) Doctor Management";
         questions[2] = "3) Appointments Management";
         questions[3] = "4) View All Appointments by Doctor ID";
         questions[4] = "5) Exit";


         for (String str1 : questions) {
             System.out.println(str1);
         }

         System.out.println("Select the number :");
         int num =input.nextInt();
         return num;
    }

    //Patient Management

    //Patient id verification
    public static boolean idverification_paatient(String id){
        if(patients[0][0]==null){
            System.out.println(yellow+"index 0 has no value Please enter a value"+resetclr);
            return false;
        }
        for (int n = 0; n < patients.length; n++) {
            if(patients[n][0]==null){
                System.out.println(yellow+"index "+n+" has no value Please enter a value"+resetclr);
                return false;
            }
            if ((patients[n][0] != null) && (patients[n][0].equals(id))) {
                return true;
            }
        }
        return false;
    }
    //Patient questions menu
    public static void patientQuestion(Scanner input){

        System.out.println(BRIGHT_CYAN+"  Patient Management  "+resetclr);
        patientsQts[0]="1) Create new Patient ";
        patientsQts[1]="2) Found Patient ";
        patientsQts[2]="3) Update Patient";
        patientsQts[3]="4) Delete Patient ";
        patientsQts[4]="5) All Patients ";
        patientsQts[5]="6) Back";

          for(String str2:patientsQts){
              System.out.println(str2);
        }
        while(true) {
            System.out.println("Select the number :");
            int number2 = input.nextInt();
            switch (number2 - 1) {
                    case (0):
                        createpatient(input);
                        break;
                    case (1):
                        readpatient(input);
                        break;
                    case (2):
                        updatepatient(input);
                        break;
                    case (3):
                        deletepatient(input);
                        break;
                    case (4):
                        allpatient(input);
                        break;
                    case (5):
                        main(questions);
                        break;
                    default:
                        System.out.println(red+"Wrong number!! try again"+resetclr);
            }
        }
    }
    //create Patient
    public static void createpatient(Scanner input) {

        while (true) {
            input.nextLine();
            if(patients[patients.length-1][0]!= null){
                System.out.println(red+"Data is Full !!"+resetclr);
            }
            outer1:for (int a = 0; a < patients.length; a++) {
                inner1:for (int b = 0; b < patients[a].length; b++) {
                    if (patients[a][b] == null) {
                        System.out.println("Enter Patient ID");
                        patients[a][0] = input.nextLine();
                        System.out.println("Enter Patient Name");
                        patients[a][1] = input.nextLine();
                        System.out.println("Enter Patient Age");
                        patients[a][2] = input.nextLine();
                        System.out.println("Enter Patient Contact");
                        patients[a][3] = input.nextLine();
                        break outer1;
                    }
                }
            }
            System.out.println("Do you want to continue ?");
            System.out.println("1) Yes");
            System.out.println("2) No");
            int insertno1 = input.nextInt();
            if (insertno1 != 1) {
                patientQuestion(input);
            }
        }
    }
    //read Patient
    public static void readpatient(Scanner input){
      while(true) {
          input.nextLine();
          System.out.println("Please Enter Patient ID :");
          String gr_id = input.nextLine();

          if (null != gr_id) {
              boolean rid = idverification_paatient(gr_id);
              if (rid) {
                  for (int c = 0; c < patients.length; c++) {
                      if (patients[c][0].equals(gr_id)) {
                          System.out.println(Lightblue+Arrays.deepToString(patients[c])+resetclr);
                          break;
                      }
                  }
               }else{
                  System.out.println(red+"ID Not Found"+resetclr);
              }
          } else {
              System.out.println(red+"Invalid ID"+resetclr);
          }
              System.out.println("Do you want to continue ?");
              System.out.println("1) Yes");
              System.out.println("2) No");
              int insertno2 = input.nextInt();
              if (insertno2 != 1) {
                 patientQuestion(input);
           }
       }
    }
    //update Patient
    public static void updatepatient(Scanner input){

     while(true) {
         input.nextLine();
         System.out.println("Please Enter Patient ID :");
         String up_id = input.nextLine();

         if (null != up_id) {
             boolean check_uid = idverification_paatient(up_id);
             if (check_uid) {
               outer3:for (int e = 0; e < patients.length; e++) {
                 for (int f = 0; f < patients[e].length; f++) {
                     if (patients[e][0].equals(up_id)) {
                         System.out.println("Change the patient name :");
                         patients[e][1] = input.nextLine();
                         System.out.println("Change the patient Age :");
                         patients[e][2] = input.nextLine();
                         System.out.println("Change the patient Contact :");
                         patients[e][3] = input.nextLine();
                         break outer3;
                     }
                 }
             }
         } else {
                 System.out.println(red+"ID Not Found " + resetclr);
             }
         }

           System.out.println("Do you want to continue ?");
           System.out.println("1) Yes");
           System.out.println("2) No");
           int insertno3 = input.nextInt();
           if (insertno3 != 1) {
               System.out.println(lightGreen+"Updated !"+resetclr);
               patientQuestion(input);
          }
       }
    }
    //delete Patient
    public static void deletepatient(Scanner input){
        while(true) {
            input.nextLine();
            System.out.println("Please Enter Patient ID :");
            String d_id = input.nextLine();

            if (null != d_id) {
                boolean check_did = idverification_paatient(d_id);
                if (check_did) {
                outer4:for (int g = 0; g < patients.length; g++) {
                    inner4:for (int h = 0; h < patients[g].length; h++) {
                        if ((patients[g][0] != null) && (patients[g][0].equals(d_id))) {

                            System.out.println("Are you sure ?");
                            System.out.println("1) Yes");
                            System.out.println("2) No");
                            int insertno4 = input.nextInt();
                            if (insertno4 == 1) {
                                patients[g][0] = null;
                                patients[g][1] = null;
                                patients[g][2] = null;
                                patients[g][3] = null;
                                System.out.println(lightGreen+"Successfully Deleted"+resetclr);
                                patientQuestion(input);
                            }
                            else{
                                deletepatient(input);
                                break outer4;
                            }
                        }
                    }
                }
            }else{
                    System.out.println(red+"ID Not Found " + resetclr);
                    System.out.println("Do you want to continue ?");
                    System.out.println("1) Yes");
                    System.out.println("2) No");
                    int insertno5 = input.nextInt();
                    if (insertno5 != 1) {
                        patientQuestion(input);
                    }
                }
            }
        }
    }
    //all Patients
    public static void allpatient(Scanner input){
      if(patients[0][0]==null){
          System.out.println(red+"please create patients"+resetclr);
          patientQuestion(input);
        }
      while(true) {
          System.out.println(" ");
          System.out.println("         All Patients  ");
              System.out.printf(red+"  "+"%-7S %-10S %-8S %S\n", "ID ", "Name ","Age ","Contact "+resetclr);

          outer5:for (int i = 0; i < patients.length; i++) {
              if(patients[i][0]!=null) {
                  System.out.printf(resetclr+count1+" "+yellow+"%-7S %-10S %-8S %S\n", patients[i][0], patients[i][1],patients[i][2],patients[i][3]);
                  count1++;
              }
          }
          System.out.println(resetclr);
          System.out.println("Do you want to continue ?");
          System.out.println("1) Yes");
          System.out.println("2) No");
          int insertno6 = input.nextInt();
          if (insertno6 != 1) {
              patientQuestion(input);
          }
      }
    }

    //Doctors Management

    // doctor id verification
    public static boolean idverification_doctor(String id){
        if(doctors[0][0]==null){
            System.out.println(yellow+"index 0 has no value Please enter a value"+resetclr);
            return false;
        }

        for(int u=0;u<doctors.length;u++){
            if(doctors[u][0]==null){
            System.out.println(yellow+"index "+u+" has no value Please enter a value"+resetclr);
            return false;
           }
            if(doctors[u][0]!=null&&doctors[u][0].equals(id)){
                return true;
            }
        }
        return false;
    }
    //doctor questions menu
    public static void doctorQuestion(Scanner input){

        System.out.println(BRIGHT_CYAN+"  Doctor Management  "+resetclr);
        doctorsQts[0]="1) Create new Doctor ";
        doctorsQts[1]="2) Found Doctor ";
        doctorsQts[2]="3) Update Doctor";
        doctorsQts[3]="4) Delete Doctor ";
        doctorsQts[4]="5) All Doctors ";
        doctorsQts[5]="6) Back";

        for(String str3:doctorsQts){
            System.out.println(str3);
        }
        while(true) {
            System.out.println("Select the number :");
            int number2 = input.nextInt();
            switch (number2 - 1) {
                    case (0):
                        createdoctor(input);
                        break;
                    case (1):
                        readdoctor(input);
                        break;
                    case (2):
                        updatedoctor(input);
                        break;
                    case (3):
                        deletedoctor(input);
                        break;
                    case (4):
                        alldoctors(input);
                        break;
                    case (5):
                        main(questions);
                        break;
                    default:
                        System.out.println(red+"Wrong number!! try again"+resetclr);
            }
        }
    }
    //create doctor
    public static void createdoctor(Scanner input) {
        while (true) {
            input.nextLine();
            if(doctors[doctors.length-1][0]!= null){
                System.out.println(red+"Data is Full !!"+resetclr);
            }
            outer1:for (int p = 0; p < doctors.length; p++) {
                inner1:for (int q = 0; q < doctors[p].length; q++) {
                    if (doctors[p][q] == null) {
                        System.out.println("Enter Doctor ID :");
                        doctors[p][0] = input.nextLine();
                        System.out.println("Enter Doctor Name :");
                        doctors[p][1] = input.nextLine();
                        System.out.println("Enter Medical Specialty :");
                        doctors[p][2] = input.nextLine();
                        break outer1;
                    }
                }
            }
            System.out.println("Do You want to Continue ?");
            System.out.println("1) Yes");
            System.out.println("2) No");
            int insertno7 = input.nextInt();
            if (insertno7 != 1) {
                doctorQuestion(input);
            }
        }
    }
    //read doctor
    public static void readdoctor(Scanner input){

        while(true) {
            input.nextLine();
            System.out.println("Please Enter Doctor ID :");
            String rd_id = input.nextLine();

            if (null != rd_id) {
                boolean check_id = idverification_doctor(rd_id);
                if (check_id) {
                    for (int r = 0; r < doctors.length; r++) {
                        if (doctors[r][0].equals(rd_id)) {
                            System.out.println(Lightblue+Arrays.deepToString(doctors[r])+resetclr);
                            break;
                        }
                    }
                }else{
                    System.out.println(red+"ID Not Found"+resetclr);
                }
            } else {
                System.out.println(red+"Invalid ID"+resetclr);
            }
            System.out.println("Are you want to continue ?");
            System.out.println("1) Yes");
            System.out.println("2) No");
            int insertno8 = input.nextInt();
            if (insertno8 != 1) {
                doctorQuestion(input);
            }
        }
    }
    //update doctor
    public static void updatedoctor(Scanner input){
        while(true) {
            input.nextLine();
            System.out.println("Please Enter Doctor ID :");
            String getup_id = input.nextLine();

            if (null != getup_id) {
                boolean checkup_id = idverification_doctor(getup_id);
                if (checkup_id) {
                    outer3:for (int s = 0; s < doctors.length; s++) {
                        for (int t = 0; t < doctors[s].length; t++) {
                            if (doctors[s][0].equals(getup_id)) {
                                System.out.println("Change the doctor's name :");
                                doctors[s][1] = input.nextLine();
                                System.out.println("Change the doctor's specialty :");
                                doctors[s][2] = input.nextLine();
                                break outer3;
                            }
                        }
                    }
                } else{
                    System.out.println(red+"ID Not Found "+resetclr);}
            }
            System.out.println("Do you want to continue ?");
            System.out.println("1) Yes");
            System.out.println("2) No");
            int insertno9 = input.nextInt();
            if (insertno9 != 1) {
                System.out.println(lightGreen+"Updated !"+resetclr);
                doctorQuestion(input);
            }
        }
    }
    //delete doctor
    public static void deletedoctor(Scanner input){
        while(true) {
            input.nextLine();
            System.out.println("Please Enter Doctor ID :");
            String dt_id = input.nextLine();

            if (null != dt_id) {
                boolean dtid = idverification_doctor(dt_id);
                if (dtid) {
                    outer4:for (int w = 0; w < doctors.length; w++) {
                        inner4:for (int x = 0; x < doctors[w].length; x++) {
                            if ((doctors[w][0] != null) && (doctors[w][0].equals(dt_id))) {

                                System.out.println("Are you sure ?");
                                System.out.println("1) Yes");
                                System.out.println("2) No");
                                int insertno10 = input.nextInt();
                                if (insertno10 == 1) {
                                    doctors[w][0] = null;
                                    doctors[w][1] = null;
                                    doctors[w][2] = null;
                                    System.out.println(lightGreen+"Successfully Deleted"+resetclr);
                                    doctorQuestion(input);
                                }
                                else{
                                    deletedoctor(input);
                                    break outer4;
                                }
                            }
                        }
                    }
                }else{
                    System.out.println(red+"ID Not Found"+resetclr);
                    System.out.println("Do you want to continue ?");
                    System.out.println("1) Yes");
                    System.out.println("2) No");
                    int insertno11 = input.nextInt();
                    if (insertno11 != 1) {
                        doctorQuestion(input);
                    }
                }
            }
        }
    }
    //all doctors
    public static void alldoctors(Scanner input){
        if(doctors[0][0]==null){
            System.out.println(red+"please create doctors"+resetclr);
            doctorQuestion(input);
        }
        while(true) {
            System.out.println(" ");
            System.out.println("        All Doctors  ");
            System.out.printf(red+"  "+"%-6S %-11S %-3S\n" , "Id ", "Name ","Specialization"+resetclr);

            for (int y = 0; y < doctors.length; y++) {
                if(doctors[y][0]!=null) {
                    System.out.printf(resetclr+count2+" "+yellow+"%-6S %-11S %-4S\n", doctors[y][0], doctors[y][1],doctors[y][2]);
                    count2++;
                }
            }
            System.out.println(resetclr);
            System.out.println("Do you want to continue ?");
            System.out.println("1) Yes");
            System.out.println("2) No");
            int insertno12 = input.nextInt();
            if (insertno12 != 1) {
                doctorQuestion(input);
            }
        }
    }

    //Appointment Management

    //create appointment
    public static void create_appointment(Scanner input) {
        if((patients[0][0]==null)&&(doctors[0][0]==null)){
            System.out.println(red+"Please Create Patients & Doctors "+resetclr);
            main(questions);
        }
        while(true) {
            input.nextLine();
            System.out.println(BRIGHT_CYAN+"Appointment Management"+resetclr);
            System.out.println(" ");
            appointmentgenerateid();
            System.out.println("Enter Doctor ID :");
            String Dct_id = input.nextLine();
            finddoc_appointment(Dct_id);
            System.out.println("Enter Patient ID :");
            String pat_id = input.nextLine();
            findpatient_appointment(pat_id);

            for( int y=0;y<appointment.length;y++){
                if(appointment[y][1]==null){
                    appointment[y][1]=Dct_id;
                    appointment[y][2]=pat_id;
                    System.out.println("Enter Appointment Time :");
                    appointment[y][3]=input.nextLine();
                    System.out.println("Enter Appointment Date :");
                    appointment[y][4]=input.nextLine();
                    break;
                }
            }
            System.out.println("Do you want to continue ?");
            System.out.println("1) Yes");
            System.out.println("2) No");
            int insertno13 = input.nextInt();
            if(insertno13!=1){
                System.out.println(lightGreen+"The Appointments Are Successful !"+resetclr);
                main(questions);
            }
        }
    }
    //appointment id (random)
    public static void appointmentgenerateid() {
        Random rand = new Random();
        int apmnt;
        for (apmnt = 0; apmnt < appointment.length; apmnt++) {
            if (appointment[apmnt][0] == null) {
                break;
            }
        }
        if (apmnt < appointment.length) {
            System.out.print("Appointment ID : "+resetclr);
            String appoinmentId =light_purple+ "#" + ((rand.nextInt(1001)*2) + (rand.nextInt(1001)*2)+resetclr);
            System.out.println(appoinmentId);
            appointment[apmnt][0] = appoinmentId;
        }
    }
    //find doctor, appointment
    public static void finddoc_appointment(String doctid){
        boolean check_doctid = idverification_doctor(doctid);
        if(check_doctid){
            for(int h=0;h<doctors.length;h++){
                if(doctors[h][0]==null){
                  break;
                }
                if(doctors[h][0].equals(doctid)){
                    System.out.println(lightGreen+doctors[h][1]+resetclr);
                }
            }
        }else{
            System.out.println(red+"Can't find a doctor"+resetclr);
            main(questions);
        }
    }
    //find patient, appointment
    public static void findpatient_appointment(String pat_id){
        boolean check_id = idverification_paatient(pat_id);
        if(check_id){
            int z;
            for(z=0;z<patients.length;z++){
                if(patients[z][0]==null) {
                    break;
                }
                if(patients[z][0].equals(pat_id)){
                    System.out.println(lightGreen+patients[z][1]+resetclr);
                    z++;
                }
            }
        }else{
            System.out.println(red+"Can't find a patient"+resetclr);
            main(questions);
        }
    }


    //View All Appointments by Doctor ID
    public static void viewall_doc(Scanner input) {
        while (true) {
            input.nextLine();
            System.out.println("Please Enter Doctor ID :");
            String viewid = input.nextLine();
            boolean check_viewid = idverification_doctor(viewid);
            if (check_viewid) {
                doctorname_view(viewid);
                System.out.printf(purple+"  "+"%-18S %-15S %-13S %S\n", "Appointment ID", "Patient", "Time", "Date"+resetclr);
                for (int w = 0; w < appointment.length; w++) {
                    if((appointment[w][0]!=null)&&(appointment[w][1].equals(viewid))) {
                        String patient_name = patientname_view(appointment[w][2]);
                        System.out.printf(yellow +count3+" "+ "%-27s %-15s %-13s %s\n", appointment[w][0], patient_name, appointment[w][3], appointment[w][4] + resetclr);
                        count3++;
                        System.out.println(resetclr);
                    }
                }
            } else {
                System.out.println(red+"Can't find a Doctor"+resetclr);
                main(questions);
            }
            System.out.println(resetclr+"Do you want to continue ?");
            System.out.println("1) Yes");
            System.out.println("2) No");
            int insertno14 = input.nextInt();
            if(insertno14!=1){
                main(questions);
            }
        }
    }
    public static void doctorname_view(String docid){
        int docfind;
        for (docfind = 0; docfind < doctors.length; docfind++) {
            if (doctors[docfind][1] == null) {
                break;
            }
        }
        if (docfind < doctors.length) {
            for(int k=0;k<doctors.length;k++) {
                if(doctors[k][0]==null){
                    break;
                }
                if (doctors[k][0].equals(docid)) {
                    System.out.println(" ");
                    System.out.println(lightGreen+"  Dr."+BOLD+doctors[k][1]+resetclr);
                }
            }
        }
    }
    public static String patientname_view(String patid){
        for(int p=0;p<patients.length;p++){
            if(patients[p][0].equals(patid)){
               return patients[p][1];
            }
        }
      return "patient not found";
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

      while(true) {
          int number1 = mainqts(questions, input);
          switch (number1 - 1) {
              case (0):
                  patientQuestion(input);
                  break;
              case (1):
                  doctorQuestion(input);
                  break;
              case (2):
                  create_appointment(input);
                  break;
              case (3):
                  viewall_doc(input);
                  break;
              case (4):
                  System.out.println(red+"__SYSTEM EXIT__"+resetclr);
                  System.exit(404);
                  break;
              default:
                  System.out.println(red + "Wrong number!! try again" + resetclr);
          }
      }
    }
}
