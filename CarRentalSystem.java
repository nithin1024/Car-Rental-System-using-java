import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

interface LoginDetails {
    void signup();
    void login();

}

class AllDetails implements LoginDetails {
    static final String CarID = null;
    String name;
    long phonenumber;
    String emailid;
    String password;

public void setname() {
        name = JOptionPane.showInputDialog("Enter your name:");
        if(name != null && name.length() >= 3 && name.length() <= 20) {
            if(!(name.contains("1" + "2" + "3" + "4" + "5" + "6"+ "7" + "8" +"9" + "0" + "@" + "#"+"$"+"%" + "^" + "&"+"*" +"(" + ")" + "-" + "_" + "="))) {
                JOptionPane.showMessageDialog(null, "Name is valid");
            } else {
                JOptionPane.showMessageDialog(null, "You are trying to enter an integer or character..");              
            } 
        }else {
            JOptionPane.showMessageDialog(null,"Name is Invalid...");
        }

    }

public long getphonenumber() {
    return phonenumber;
}

public void setphonenumber() {
    try {
        phonenumber = Long.parseLong(JOptionPane.showInputDialog("Enter your mobile number:"));
        if(phonenumber >999999999 && phonenumber < 10000000000l) {
            JOptionPane.showMessageDialog(null,"The number is valid..");
        } else {
            JOptionPane.showMessageDialog(null,"please enter the correct 10 digit number.. ");
            setphonenumber();
        }

    }catch(Exception e) {
        JOptionPane.showMessageDialog(null,"Please enter an integer..");
        setphonenumber();
    }   
}

public String getmail() {
    return emailid;
}

public void setemail() {
    emailid = JOptionPane.showInputDialog("Enter your emailid:");
    if(emailid != null && emailid.length() > 3 && emailid.length() <= 40 && (emailid.contains("@gmail.com"))) {
    if(!(emailid.contains("!") || emailid.contains("#") || emailid.contains("$") || emailid.contains("^") || emailid.contains("&") || emailid.contains("*") || emailid.contains("(") || emailid.contains(")"))) {
        JOptionPane.showMessageDialog(null,"The email id is valid...");
    }
    else  {
        JOptionPane.showMessageDialog(null,"You are trying to enter a special character..");
        setemail();
    } 
}else {
       JOptionPane.showMessageDialog(null,"Email id is invalid.."); 
       setemail();
}
}

public void getpassword() {
    password = JOptionPane.showInputDialog("Create your password:");
    if(password != null && password.length() > 3 && password.length() <= 20){
        JOptionPane.showMessageDialog(null,"Your password is valid..");
    } else  {
        JOptionPane.showMessageDialog(null,"Your password must contain at least 5 characters and maximum of 10 characters");
        getpassword();
    }
}

public void signup() {
    setname();
    setphonenumber();
    setemail();
    getpassword();
    verifyotp();
    JOptionPane.showMessageDialog(null,"Registration is successfull.. ");
    int choice= JOptionPane.showConfirmDialog(null,"Proceed with Login?");
    if(choice == JOptionPane.YES_OPTION) {
        login();
    } else {
        System.exit(0);
    }
}

int otp;

public void GenerateOTP() {
    Random rand = new Random();
    int Generatedotp = rand.nextInt(10000);
    if(Generatedotp > 999) {
        otp = Generatedotp;
        JOptionPane.showMessageDialog(null,"Generated otp:" + otp);
        JOptionPane.showMessageDialog(null,"Please remember this otp");
    } else  {
        GenerateOTP();
    }
}

public void verifyotp() {
    GenerateOTP();
    int userOTP = Integer.parseInt(JOptionPane.showInputDialog("Enter the otp same as above:"));
    if(userOTP == otp) {
        JOptionPane.showMessageDialog(null,"OTP is verified...");
        login();      
    } else {
        JOptionPane.showMessageDialog(null,"OTP is invalid..");
        verifyotp();
    }
}

public void renting_a_car() {
    Rental renting = new Rental();
    renting.rent_a_car();
}

public  void returning_a_car() {
    String CarId = JOptionPane.showInputDialog("please enter the car id that you want to return..");
    if(CarId.equals(CarId)) {
        JOptionPane.showMessageDialog(null,"Car Id Matches..");
        int choice= JOptionPane.showConfirmDialog(null,"Are you sure to return the car?");
    if(choice == JOptionPane.YES_OPTION) {
        JOptionPane.showMessageDialog(null,"Car returned succesfully...");
    } else {
        returning_a_car();
    }
    } else {
        JOptionPane.showMessageDialog(null,"Invalid car ID . please enter a valid car ID");
    } 
    JOptionPane.showMessageDialog(null,"Thank you.. Visit again!");
}

public void exitProgram() {
    JOptionPane.showMessageDialog(null,"Thank you for usingg our services..");
    System.exit(0);

}

public void login() {
    try {
        int n = Integer.parseInt(JOptionPane.showInputDialog("Press 1 to use contact for login \n press 2 to use mail for login \n press 3 to Exit"));
        if(n == 1) {
            long mobilenumber = Long.parseLong(JOptionPane.showInputDialog("Enter your phone number:"));
            String pass = JOptionPane.showInputDialog("Enter your password:");
            if(this.phonenumber == mobilenumber && this.password.equals(pass)) {
                JOptionPane.showMessageDialog(null,"You have Logged in successfully..!");
                int choice = Integer.parseInt(JOptionPane.showInputDialog("1. Rent a car \n 2. Return a car \n 3. Exit"));
                switch(choice) {
                    case 1:
                    Rental renting = new Rental();
                    renting.rent_a_car();
                    break;
                    case 2:
                    returning_a_car();
                    break;
                    case 3:
                    exitProgram();
                    break;
                    default:
                    JOptionPane.showMessageDialog(null,"Input choice..");
                    break;
                }

            } else {
                JOptionPane.showMessageDialog(null,"Incorrect username or password..");
                login();
            }
        }

        if(n == 2 ){
            String email = JOptionPane.showInputDialog(null,"Enter your email id:");
            String pass = JOptionPane.showInputDialog(null,"Enter your password:");
            if(this.emailid.equals(email) && this.password.equals(pass)) {
                JOptionPane.showMessageDialog(null,"You have Logged in successfully..");
                int m = Integer.parseInt(JOptionPane.showInputDialog("1.Rent a car \n 2. Retun a car \n 3.Exit"));
                switch(m) {
                    case 1: 
                    renting_a_car();
                    break;
                    case 2:
                    returning_a_car();
                    break;
                    case 3:
                    exitProgram();
                    break;
                    default:
                    JOptionPane.showMessageDialog(null,"Invalid choice..");
                    break;
                }
            }
        }

        if(n == 3) {
            System.exit(0);
        }

    }catch(Exception e) {
        JOptionPane.showMessageDialog(null, "Wrong choice! please try again..");
        login();

    }
}

}


interface Rentable {
    int getRentalCostPerDay();
    String getCarName();
    String getCarId();
}

abstract class Car implements Rentable {
    private String name;
    private String carId;
    private int rentalCostPerDay;

    public Car(String name, String carId, int rentalCostPerDay) {
        this.name = name;
        this.carId = carId;
        this.rentalCostPerDay = rentalCostPerDay;
    }

    @Override
    public int getRentalCostPerDay() {
        return rentalCostPerDay;
    }

    @Override
    public String getCarName() {
        return name;
    }

    @Override
    public String getCarId() {
        return carId;
    }
}

class MarutiAlto extends Car {
    public MarutiAlto() {
        super("Maruti Alto", "COO1", 10000);
    }
}

class TataNexon extends Car {
    public TataNexon() {
        super("Tata Nexon", "COO2", 10000);
    }
}

class HyundaiI20 extends Car {
    public HyundaiI20() {
        super("Hyundai i20", "COO3", 15000);
    }
}

class MahindraThar extends Car {
    public MahindraThar() {
        super("Mahindra Thar", "COO4", 60000);
    }
}

class AudiQ7 extends Car {
    public AudiQ7() {
        super("Audi Q7", "COO5", 30000);
    }
}

class Rental {
    private Map<String, ImageIcon> carImages;

    public Rental() {
        carImages = new HashMap<>();
        carImages.put("Maruti Alto", new ImageIcon("maruti_alto.jpg")); 
        carImages.put("Tata Nexon", new ImageIcon("tata_nexon.jpg")); 
        carImages.put("Hyundai i20", new ImageIcon("hyundai_i20.jpg")); 
        carImages.put("Mahindra Thar", new ImageIcon("mahindra_thar.jpg")); 
        carImages.put("Audi Q7", new ImageIcon("audi_q7.jpg")); 
    }

    void rent_a_car() {
        StringBuilder carList = new StringBuilder();
        carList.append("Here are the details of the cars that you can rent:\n");
        carList.append("1. Maruti Alto\n");
        carList.append("2. Tata Nexon\n");
        carList.append("3. Hyundai i20\n");
        carList.append("4. Mahindra Thar\n");
        carList.append("5. Audi Q7\n");
        int choice = Integer.parseInt(JOptionPane.showInputDialog(carList + "Enter your choice of the car that you want to rent:"));
        int m = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of days you want to rent the car:"));
        Rentable car = null;
        switch (choice) {
            case 1:
                car = new MarutiAlto();
                break;
            case 2:
                car = new TataNexon();
                break;
            case 3:
                car = new HyundaiI20();
                break;
            case 4:
                car = new MahindraThar();
                break;
            case 5:
                car = new AudiQ7();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid choice.");
                return;
        }
        JOptionPane.showMessageDialog(null, "You are renting the " + car.getCarName() + " car.\n" +
                "The cost of the car per day is: " + car.getRentalCostPerDay() + " only.\n" +
                "The total cost of the car is: " + car.getRentalCostPerDay() * m + " only." + 
                "your car Id is :" + car.getCarId());

        
        ImageIcon selectedCarImage = carImages.get(car.getCarName());
        if (selectedCarImage != null) {
            JLabel selectedCarLabel = new JLabel(selectedCarImage);
            JOptionPane.showMessageDialog(null, selectedCarLabel, "Selected Car", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Image not found for the selected car.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

public class CarRentalSystem {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Car Rental System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(500,500));

        UIManager.put("OptionPane.minimumSize", new Dimension(400,400));
        UIManager.put("OptionPane.buttuonFont", new Font("calligraphy",Font.BOLD,30));
        UIManager.put("OptionPane.messageFont", new Font("calligraphy",Font.BOLD,30));
        UIManager.put("TextField.font", new Font("calligraphy",Font.BOLD,30));

        ImageIcon background = new ImageIcon("lamboo.jpg");
        JLabel backgroundLabel = new JLabel(background);
        panel.add(backgroundLabel,BorderLayout.CENTER);
        backgroundLabel.setLayout(new FlowLayout());



        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        AllDetails loggedInUser = null;
        int choice;
        do {
            String input = JOptionPane.showInputDialog("WELCOME TO THE CAR RENTAL SYSTEM! \n 1.Sign Up \n 2. Log in \n 3. Exit \n Enter Your Choice:");
            choice = Integer.parseInt(input);
            switch(choice) {
                case 1:
                loggedInUser = new AllDetails();
                    loggedInUser.signup();
                    break;
                    case 2:
                    if (loggedInUser == null) {
                        JOptionPane.showMessageDialog(null, "Please sign up first!");
                        break;
                    }
                    loggedInUser.login();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Thanks for using our services..");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid Choice! Please enter a valid option. ");

            }
        }while(choice != 3);

    }

    
}

