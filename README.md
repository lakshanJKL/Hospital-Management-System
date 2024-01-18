# HOSPITAL MANAGEMENT SYSTEM 

### This is a terminal-based hospital management system that facilitates efficient patient and staff management through command-line interaction.
#### Follow the steps below to use this system

## Step 1 
Clone this project to your local system

    https://github.com/lakshanJKL/Hospital-Management-System.git

 Or Download and extract the zip file.  

 #### Running - Open the HMS.java file with IDE or CMD 

## Step 2 
Select number 1, Patient Management

![Screenshot 2024-01-18 151234](https://github.com/lakshanJKL/Hospital-Management-System/assets/141350033/3d7e6d23-82ad-4f23-9978-dc095ac7ac39)

#### You can perform CRUD (Create, Read, Update, Delete) operation on patients
![Screenshot 2024-01-18 154821](https://github.com/lakshanJKL/Hospital-Management-System/assets/141350033/5fbc6d1e-eada-47c8-ade9-190a205c4e54)

## Step 3 
Select number 2, Doctor Management 
##### you can perform CRUD (Create, Read, Update, Delete) operation on doctors
![image](https://github.com/lakshanJKL/Hospital-Management-System/assets/141350033/28a4f2de-6a2e-4019-89ee-d1c19ce3bd77)

## Step 4 
Select number 3, Appointment Management 
##### In this step, appointment ID will be automatically generated and you can proceed by providing Doctor and Patient ID
![image](https://github.com/lakshanJKL/Hospital-Management-System/assets/141350033/324b1bae-3c81-41a0-ac01-0618697dc456)

##### The following Java method is used to generate the id automatically
~~~java
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
~~~
## Step 5 
Select number 4, All appointments by doctor id
##### Enter the doctor's ID and you will get a list of appointments
![image](https://github.com/lakshanJKL/Hospital-Management-System/assets/141350033/0c9b6770-66b2-4488-b2bc-4eb6a9b7ec1f)

## Step 6 
Select number 5, Exit
##### Stop running this program
