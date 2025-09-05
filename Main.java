import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;
import java.util.Random;

public class Main extends JFrame {
  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Main frame = new Main();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  private JPanel contentPane;
  private JTextField txtField_M;
  private JTextField txtField_PG;
  private JTextField txtField_WdC;
  private JTextField txtField_WeC;
  private JTextField txtField_CW;
  private JTextField txtField_S1;
  private JTextField txtField_E1;
  private JTextField txtField_B1;
  private JTextField txtField_S2;
  private JTextField txtField_E2;
  private JTextField txtField_B2;
  private JTextField txtField_S3;
  private JTextField txtField_E3;
  private JTextField txtField_B3;
  private JTextField txtField_S4;
  private JTextField txtField_E4;
  private JTextField txtField_B4;

  private final ButtonGroup buttonGroup = new ButtonGroup();

  String month = "";
  double goal = 0.00;
  double carwash = 0.00;
  int weekday = 0;
  int weekend = 0;
  int cdate = 0;
  int ccost = 0;
  String d3day = "";
  String d7day = "";
  String d14day = "";
  String earlyb = "";
  int r1start = 0;
  int r1end = 0;
  int r2start = 0;
  int r2end = 0;
  int r3start = 0;
  int r3end = 0;
  int r4start = 0;
  int r4end = 0;
  int randint1 = 0;
  int randint2 = 0;
  int randint3 = 0;
  int randint4 = 0;

  /**
   * Create the frame.
   */
  public Main() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 950, 630);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    contentPane.setBackground(new Color(176, 224, 230));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    Calculate commonR = new Calculate();
    Calculate R1 = new Calculate();
    Calculate R2 = new Calculate();
    Calculate R3 = new Calculate();
    Calculate R4 = new Calculate();
    Random rand = new Random();

    JLabel lblTitle = new JLabel("CAR RENTALS");
    lblTitle.setBounds(400, 30, 200, 34);
    lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
    contentPane.add(lblTitle);

    // User enters month
    JLabel lblMonth = new JLabel("Month: ");
    lblMonth.setBounds(50, 102, 200, 34);
    lblMonth.setFont(new Font("Arial", Font.BOLD, 13));
    contentPane.add(lblMonth);
    txtField_M = new JTextField();
    txtField_M.setBounds(107, 110, 86, 20);
    contentPane.add(txtField_M);
    txtField_M.setColumns(10);

    // User enters Profit goal
    JLabel lblProfitGoal = new JLabel("Profit Goal: ");
    lblProfitGoal.setBounds(25, 212, 200, 34);
    lblProfitGoal.setFont(new Font("Arial", Font.BOLD, 13));
    contentPane.add(lblProfitGoal);
    txtField_PG = new JTextField();
    txtField_PG.setBounds(155, 220, 86, 20);
    contentPane.add(txtField_PG);
    txtField_PG.setColumns(10);

    // User enters Car Wash cost
    JLabel lblCarWash = new JLabel("Car Wash Cost: ");
    lblCarWash.setBounds(25, 242, 200, 34);
    lblCarWash.setFont(new Font("Arial", Font.BOLD, 13));
    contentPane.add(lblCarWash);
    txtField_CW = new JTextField();
    txtField_CW.setBounds(155, 250, 86, 20);
    contentPane.add(txtField_CW);
    txtField_CW.setColumns(10);

    // User enters cost for weekdays& weekends
    JLabel lblStandardC = new JLabel("Standard Costs ");
    lblStandardC.setBounds(350, 85, 200, 34);
    lblStandardC.setFont(new Font("Arial", Font.BOLD, 13));
    contentPane.add(lblStandardC);

    JLabel lblWeekdayC = new JLabel("Weekday Cost: ");
    lblWeekdayC.setBounds(350, 112, 200, 34);
    lblWeekdayC.setFont(new Font("Arial", Font.PLAIN, 12));
    contentPane.add(lblWeekdayC);
    txtField_WdC = new JTextField();
    txtField_WdC.setBounds(450, 120, 86, 20);
    contentPane.add(txtField_WdC);
    txtField_WdC.setColumns(10);

    JLabel lblWeekendC = new JLabel("Weekend Cost: ");
    lblWeekendC.setBounds(350, 142, 200, 34);
    lblWeekendC.setFont(new Font("Arial", Font.PLAIN, 12));
    contentPane.add(lblWeekendC);
    txtField_WeC = new JTextField();
    txtField_WeC.setBounds(450, 150, 86, 20);
    contentPane.add(txtField_WeC);
    txtField_WeC.setColumns(10);

    // User selects discount amounts
    JLabel lblDiscounts = new JLabel("Discounts ");
    lblDiscounts.setBounds(650, 85, 200, 34);
    lblDiscounts.setFont(new Font("Arial", Font.BOLD, 13));
    contentPane.add(lblDiscounts);

    JLabel lblDisc3 = new JLabel("3+ Days: ");
    lblDisc3.setBounds(650, 112, 200, 34);
    lblDisc3.setFont(new Font("Arial", Font.PLAIN, 12));
    contentPane.add(lblDisc3);
    JComboBox comboBox3D = new JComboBox();
    comboBox3D.setBounds(720, 120, 86, 20);
    comboBox3D.setModel(new DefaultComboBoxModel(new String[] { "    ", "-05%", "-10%", "-15%" }));
    contentPane.add(comboBox3D);

    JLabel lblDisc7 = new JLabel("7+ Days: ");
    lblDisc7.setBounds(650, 142, 200, 34);
    lblDisc7.setFont(new Font("Arial", Font.PLAIN, 12));
    contentPane.add(lblDisc7);
    JComboBox comboBox7D = new JComboBox();
    comboBox7D.setBounds(720, 150, 86, 20);
    comboBox7D.setModel(new DefaultComboBoxModel(new String[] { "    ", "-05%", "-10%", "-15%" }));
    contentPane.add(comboBox7D);

    JLabel lblDisc14 = new JLabel("14+ Days: ");
    lblDisc14.setBounds(650, 172, 200, 34);
    lblDisc14.setFont(new Font("Arial", Font.PLAIN, 12));
    contentPane.add(lblDisc14);
    JComboBox comboBox14D = new JComboBox();
    comboBox14D.setBounds(720, 180, 86, 20);
    comboBox14D.setModel(new DefaultComboBoxModel(new String[] { "    ", "-05%", "-10%", "-15%" }));
    contentPane.add(comboBox14D);

    JLabel lblEarlyBird = new JLabel("Early Bird: ");
    lblEarlyBird.setBounds(650, 202, 200, 34);
    lblEarlyBird.setFont(new Font("Arial", Font.PLAIN, 12));
    contentPane.add(lblEarlyBird);
    JComboBox comboBoxEB = new JComboBox();
    comboBoxEB.setBounds(720, 210, 86, 20);
    comboBoxEB.setModel(new DefaultComboBoxModel(new String[] { "    ", "-05%", "-10%", "-15%" }));
    contentPane.add(comboBoxEB);

    // RENTAL 1
    JLabel lblRent1 = new JLabel("Rental 1: ");
    lblRent1.setBounds(25, 300, 200, 34);
    lblRent1.setFont(new Font("Arial", Font.BOLD, 13));
    contentPane.add(lblRent1);
    //user enters start date
    JLabel lblstart1 = new JLabel("Start Date: ");
    lblstart1.setBounds(25, 322, 200, 34);
    lblstart1.setFont(new Font("Arial", Font.PLAIN, 13));
    contentPane.add(lblstart1);
    txtField_S1 = new JTextField();
    txtField_S1.setBounds(125, 330, 86, 20);
    contentPane.add(txtField_S1);
    txtField_S1.setColumns(10);
    //user enters end date
    JLabel lblend1 = new JLabel("End Date: ");
    lblend1.setBounds(25, 352, 200, 34);
    lblend1.setFont(new Font("Arial", Font.PLAIN, 13));
    contentPane.add(lblend1);
    txtField_E1 = new JTextField();
    txtField_E1.setBounds(125, 360, 86, 20);
    contentPane.add(txtField_E1);
    txtField_E1.setColumns(10);
    //booking info
    JLabel lblbook1 = new JLabel("Booked: ");
    lblbook1.setBounds(25, 382, 200, 34);
    lblbook1.setFont(new Font("Arial", Font.PLAIN, 13));
    contentPane.add(lblbook1);
    txtField_B1 = new JTextField();
    txtField_B1.setBounds(125, 390, 86, 20);
    contentPane.add(txtField_B1);
    txtField_B1.setEditable(false);
    txtField_B1.setColumns(10);

    // RENT 2
    JLabel lblRent2 = new JLabel("Rental 2: ");
    lblRent2.setBounds(250, 300, 200, 34);
    lblRent2.setFont(new Font("Arial", Font.BOLD, 13));
    contentPane.add(lblRent2);
    JLabel lblstart2 = new JLabel("Start Date: ");
    lblstart2.setBounds(250, 322, 200, 34);
    lblstart2.setFont(new Font("Arial", Font.PLAIN, 13));
    contentPane.add(lblstart2);
    //user enters start date
    txtField_S2 = new JTextField();
    txtField_S2.setBounds(350, 330, 86, 20);
    contentPane.add(txtField_S2);
    txtField_S2.setColumns(10);
    //user enters end date
    JLabel lblend2 = new JLabel("End Date: ");
    lblend2.setBounds(250, 352, 200, 34);
    lblend2.setFont(new Font("Arial", Font.PLAIN, 13));
    contentPane.add(lblend2);
    txtField_E2 = new JTextField();
    txtField_E2.setBounds(350, 360, 86, 20);
    contentPane.add(txtField_E2);
    txtField_E2.setColumns(10);
    //booking info
    JLabel lblbook2 = new JLabel("Booked: ");
    lblbook2.setBounds(250, 382, 200, 34);
    lblbook2.setFont(new Font("Arial", Font.PLAIN, 13));
    contentPane.add(lblbook2);
    txtField_B2 = new JTextField();
    txtField_B2.setBounds(350, 390, 86, 20);
    contentPane.add(txtField_B2);
    txtField_B2.setEditable(false);
    txtField_B2.setColumns(10);

    // RENT 3
    JLabel lblRent3 = new JLabel("Rental 3: ");
    lblRent3.setBounds(475, 300, 200, 34);
    lblRent3.setFont(new Font("Arial", Font.BOLD, 13));
    contentPane.add(lblRent3);
    //user enters start date
    JLabel lblstart3 = new JLabel("Start Date: ");
    lblstart3.setBounds(475, 322, 200, 34);
    lblstart3.setFont(new Font("Arial", Font.PLAIN, 13));
    contentPane.add(lblstart3);
    txtField_S3 = new JTextField();
    txtField_S3.setBounds(575, 330, 86, 20);
    contentPane.add(txtField_S3);
    txtField_S3.setColumns(10);
    //user enters end date
    JLabel lblend3 = new JLabel("End Date: ");
    lblend3.setBounds(475, 352, 200, 34);
    lblend3.setFont(new Font("Arial", Font.PLAIN, 13));
    contentPane.add(lblend3);
    txtField_E3 = new JTextField();
    txtField_E3.setBounds(575, 360, 86, 20);
    contentPane.add(txtField_E3);
    txtField_E3.setColumns(10);
    //booking info
    JLabel lblbook3 = new JLabel("Booked: ");
    lblbook3.setBounds(475, 382, 200, 34);
    lblbook3.setFont(new Font("Arial", Font.PLAIN, 13));
    contentPane.add(lblbook3);
    txtField_B3 = new JTextField();
    txtField_B3.setBounds(575, 390, 86, 20);
    contentPane.add(txtField_B3);
    txtField_B3.setEditable(false);
    txtField_B3.setColumns(10);

    // RENT 4
    JLabel lblRent4 = new JLabel("Rental 4: ");
    lblRent4.setBounds(700, 300, 200, 34);
    lblRent4.setFont(new Font("Arial", Font.BOLD, 13));
    contentPane.add(lblRent4);
    //user enters start date
    JLabel lblstart4 = new JLabel("Start Date: ");
    lblstart4.setBounds(700, 322, 200, 34);
    lblstart4.setFont(new Font("Arial", Font.PLAIN, 13));
    contentPane.add(lblstart4);
    txtField_S4 = new JTextField();
    txtField_S4.setBounds(800, 330, 86, 20);
    contentPane.add(txtField_S4);
    txtField_S4.setColumns(10);
    //user enters end date
    JLabel lblend4 = new JLabel("End Date: ");
    lblend4.setBounds(700, 352, 200, 34);
    lblend4.setFont(new Font("Arial", Font.PLAIN, 13));
    contentPane.add(lblend4);
    txtField_E4 = new JTextField();
    txtField_E4.setBounds(800, 360, 86, 20);
    contentPane.add(txtField_E4);
    txtField_E4.setColumns(10);
    //booking info
    JLabel lblbook4 = new JLabel("Booked: ");
    lblbook4.setBounds(700, 382, 200, 34);
    lblbook4.setFont(new Font("Arial", Font.PLAIN, 13));
    contentPane.add(lblbook4);
    txtField_B4 = new JTextField();
    txtField_B4.setBounds(800, 390, 86, 20);
    contentPane.add(txtField_B4);
    txtField_B4.setEditable(false);
    txtField_B4.setColumns(10);

 //BUTTONS
    //Calendar
    JButton btnMonth = new JButton("Calendar");
    btnMonth.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        JOptionPane pane = new JOptionPane();
        pane.setBounds(600, 300, 150, 150);
        //check input for month& display its calendar
        month = "" + txtField_M.getText();
        switch (month) {
          case "January":
          case "February":
          case "March":
          case "April":
          case "May":
          case "June":
          case "July":
          case "August":
          case "September":
          case "October":
          case "November":
          case "December":
            commonR.makeCalendar(month);
            JOptionPane.showMessageDialog(null, commonR.displayCalendar(), month, JOptionPane.PLAIN_MESSAGE);
            break;
          default:
            JOptionPane.showMessageDialog(null, "ERROR: check spelling and capitalization", "ERROR", JOptionPane.PLAIN_MESSAGE);
        }
      }
    });
    btnMonth.setBounds(102, 140, 100, 23);
    contentPane.add(btnMonth);

    //Cost Update
    JButton btnUpdate = new JButton("Update");
    btnUpdate.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        //check input is integer
        String confirm = "";
        try{
          weekday = Integer.parseInt(txtField_WdC.getText());
          weekend = Integer.parseInt(txtField_WeC.getText());
          commonR.setCosts(weekday, weekend);
          confirm = "The costs for weekdays and weekends have been updated.";
        }
        catch(NumberFormatException e){
          confirm = "ERROR: please enter integer values";
        } 
        //confirm or show error
        JOptionPane.showMessageDialog(null, confirm, "Confirmation",
            JOptionPane.PLAIN_MESSAGE);
      } 
    });
    btnUpdate.setBounds(445, 180, 100, 23);
    contentPane.add(btnUpdate);

    //Randomize1
    JButton btnRand1 = new JButton("Randomize");
    btnRand1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        randint1 = rand.nextInt(3);
        //assign values to when booked
        if (randint1 == 0) {
          txtField_B1.setText("Early");
        } else if (randint1 == 1) {
          txtField_B1.setText("On time");
        } else if (randint1 == 2) {
          txtField_B1.setText("Late");
        }
      }
    });
    btnRand1.setBounds(115, 415, 112, 20);
    contentPane.add(btnRand1);

    //Update rental1
    JButton btnReceipt1 = new JButton("Update");
    btnReceipt1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        try{
          r1start = Integer.parseInt(txtField_S1.getText());
          r1end = Integer.parseInt(txtField_E1.getText());
          R1.countDays(r1start, r1end);

          d3day = (String) comboBox3D.getSelectedItem();
          d7day = (String) comboBox7D.getSelectedItem();
          d14day = (String) comboBox14D.getSelectedItem();
          earlyb = (String) comboBoxEB.getSelectedItem();

          R1.getInitialRentCost(r1start, r1end);
          R1.findDayDiscounts(d3day, d7day, d14day);
          R1.findEBDiscounts(randint1, earlyb);
          R1.getTotalRent();

          R1.getRentalReceipt(d3day, d7day, d14day, randint1, earlyb);
          //error if end is less than start
          if(r1end<r1start){
            JOptionPane.showMessageDialog(null, "ERROR: end date cannot be before start date", "Rental 1 Receipt", JOptionPane.PLAIN_MESSAGE);
          }
          //error if empty textbox
          else if(txtField_B1.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "ERROR: please click 'Randomize'", "Rental 1 Receipt", JOptionPane.PLAIN_MESSAGE);
          }
          else{
            JOptionPane.showMessageDialog(null, R1.rentalSummary, "Rental 1 Receipt", JOptionPane.PLAIN_MESSAGE);
          }
        }
        //error if not integer
        catch(NumberFormatException e){
          JOptionPane.showMessageDialog(null, "ERROR: please enter integer values", "Rental 1 Receipt", JOptionPane.PLAIN_MESSAGE);
        }
        //error if date doesn't exist
        catch(IndexOutOfBoundsException e){
          JOptionPane.showMessageDialog(null, "ERROR: please enter dates that are in the month", "Rental 1 Receipt", JOptionPane.PLAIN_MESSAGE);
        }
      }
    });
    btnReceipt1.setBounds(115, 440, 112, 20);
    contentPane.add(btnReceipt1);

    //Randomize2
    JButton btnRand2 = new JButton("Randomize");
    btnRand2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        randint2 = rand.nextInt(3);
        //assign values to when booked
        if (randint2 == 0) {
          txtField_B2.setText("Early");
        } else if (randint2 == 1) {
          txtField_B2.setText("On time");
        } else if (randint2 == 2) {
          txtField_B2.setText("Late");
        }
      }
    });
    btnRand2.setBounds(340, 415, 112, 20);
    contentPane.add(btnRand2);

    //Update rental2
    JButton btnReceipt2 = new JButton("Update");
    btnReceipt2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        try{
          r2start = Integer.parseInt(txtField_S2.getText());
          r2end = Integer.parseInt(txtField_E2.getText());
          R2.countDays(r2start, r2end);

          d3day = (String) comboBox3D.getSelectedItem();
          d7day = (String) comboBox7D.getSelectedItem();
          d14day = (String) comboBox14D.getSelectedItem();
          earlyb = (String) comboBoxEB.getSelectedItem();

          R2.getInitialRentCost(r2start, r2end);
          R2.findDayDiscounts(d3day, d7day, d14day);
          R2.findEBDiscounts(randint2, earlyb);
          R2.getTotalRent();

          R2.getRentalReceipt(d3day, d7day, d14day, randint2, earlyb);
          //error if end is less than start
          if(r2end<r2start){
            JOptionPane.showMessageDialog(null, "ERROR: end date cannot be before start date", "Rental 2 Receipt", JOptionPane.PLAIN_MESSAGE);
          }
          //error if empty textbox
          else if(txtField_B2.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "ERROR: please click 'Randomize'", "Rental 2 Receipt", JOptionPane.PLAIN_MESSAGE);
          }
          else{
            JOptionPane.showMessageDialog(null, R2.rentalSummary, "Rental 2 Receipt", JOptionPane.PLAIN_MESSAGE);
          }
        }
        //error if not integer
        catch(NumberFormatException e){
          JOptionPane.showMessageDialog(null, "ERROR: please enter integer values", "Rental 2 Receipt", JOptionPane.PLAIN_MESSAGE);
        }
        //error if date doesn't exist
        catch(IndexOutOfBoundsException e){
          JOptionPane.showMessageDialog(null, "ERROR: please enter dates that are in the month", "Rental 2 Receipt", JOptionPane.PLAIN_MESSAGE);
        }
      }
    });
    btnReceipt2.setBounds(340, 440, 112, 20);
    contentPane.add(btnReceipt2);

    //Randomize3
    JButton btnRand3 = new JButton("Randomize");
    btnRand3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        randint3 = rand.nextInt(3);
        //assign values to when booked
        if (randint3 == 0) {
          txtField_B3.setText("Early");
        } else if (randint3 == 1) {
          txtField_B3.setText("On time");
        } else if (randint3 == 2) {
          txtField_B3.setText("Late");
        }
      }
    });
    btnRand3.setBounds(565, 415, 112, 20);
    contentPane.add(btnRand3);

    //Update rental3
    JButton btnReceipt3 = new JButton("Update");
    btnReceipt3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        try{
          r3start = Integer.parseInt(txtField_S3.getText());
          r3end = Integer.parseInt(txtField_E3.getText());
          R3.countDays(r3start, r3end);

          d3day = (String) comboBox3D.getSelectedItem();
          d7day = (String) comboBox7D.getSelectedItem();
          d14day = (String) comboBox14D.getSelectedItem();
          earlyb = (String) comboBoxEB.getSelectedItem();

          R3.getInitialRentCost(r3start, r3end);
          R3.findDayDiscounts(d3day, d7day, d14day);
          R3.findEBDiscounts(randint3, earlyb);
          R3.getTotalRent();

          R3.getRentalReceipt(d3day, d7day, d14day, randint3, earlyb);
          //error if end is less than start
          if(r3end<r3start){
            JOptionPane.showMessageDialog(null, "ERROR: end date cannot be before start date", "Rental 3 Receipt", JOptionPane.PLAIN_MESSAGE);
          }
          //error if empty textbox
          else if(txtField_B3.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "ERROR: please click 'Randomize'", "Rental 3 Receipt", JOptionPane.PLAIN_MESSAGE);
          }
          else{
            JOptionPane.showMessageDialog(null, R3.rentalSummary, "Rental 3 Receipt", JOptionPane.PLAIN_MESSAGE);
          }
        }
        //error if not integer
        catch(NumberFormatException e){
          JOptionPane.showMessageDialog(null, "ERROR: please enter integer values", "Rental 3 Receipt", JOptionPane.PLAIN_MESSAGE);
        }
        //error if date doesn't exist
        catch(IndexOutOfBoundsException e){
          JOptionPane.showMessageDialog(null, "ERROR: please enter dates that are in the month", "Rental 3 Receipt", JOptionPane.PLAIN_MESSAGE);
        }
      }
    });
    btnReceipt3.setBounds(565, 440, 112, 20);
    contentPane.add(btnReceipt3);

    //Randomize4
    JButton btnRand4 = new JButton("Randomize");
    btnRand4.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        randint4 = rand.nextInt(3);
        //assign values to when booked
        if (randint4 == 0) {
          txtField_B4.setText("Early");
        } else if (randint4 == 1) {
          txtField_B4.setText("On time");
        } else if (randint4 == 2) {
          txtField_B4.setText("Late");
        }
      }
    });
    btnRand4.setBounds(790, 415, 112, 20);
    contentPane.add(btnRand4);

    //Update rental4
    JButton btnReceipt4 = new JButton("Update");
    btnReceipt4.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        try{
          r4start = Integer.parseInt(txtField_S4.getText());
          r4end = Integer.parseInt(txtField_E4.getText());
          R4.countDays(r4start, r4end);

          d3day = (String) comboBox3D.getSelectedItem();
          d7day = (String) comboBox7D.getSelectedItem();
          d14day = (String) comboBox14D.getSelectedItem();
          earlyb = (String) comboBoxEB.getSelectedItem();

          R4.getInitialRentCost(r4start, r4end);
          R4.findDayDiscounts(d3day, d7day, d14day);
          R4.findEBDiscounts(randint4, earlyb);
          R4.getTotalRent();

          R4.getRentalReceipt(d3day, d7day, d14day, randint4, earlyb);
          //error if end is less than start
          if(r4end<r4start){
            JOptionPane.showMessageDialog(null, "ERROR: end date cannot be before start date", "Rental 4 Receipt", JOptionPane.PLAIN_MESSAGE);
          }
          //error if empty textbox
          else if(txtField_B4.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "ERROR: please click 'Randomize'", "Rental 4 Receipt", JOptionPane.PLAIN_MESSAGE);
          }
          else{
            JOptionPane.showMessageDialog(null, R4.rentalSummary, "Rental 4 Receipt", JOptionPane.PLAIN_MESSAGE);
          }
        }
        //error if not integer
        catch(NumberFormatException e){
          JOptionPane.showMessageDialog(null, "ERROR: please enter integer values", "Rental 4 Receipt", JOptionPane.PLAIN_MESSAGE);
        }
        //error if date doesn't exist
        catch(IndexOutOfBoundsException e){
          JOptionPane.showMessageDialog(null, "ERROR: please enter dates that are in the month", "Rental 4 Receipt", JOptionPane.PLAIN_MESSAGE);
        }
      }
    });
    btnReceipt4.setBounds(790, 440, 112, 20);
    contentPane.add(btnReceipt4);

    //Full Summary
    JButton btnSum = new JButton("Profit Summary");
    btnSum.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        carwash = Double.parseDouble(txtField_CW.getText());
        goal = Double.parseDouble(txtField_PG.getText());
        
        Calculate.getAllRents(R1, R2, R3, R4);
        Calculate.subtractFee();
        Calculate.subtractCarWash(carwash);
        Calculate.compareGoal(goal);

        Calculate.getProfitSummary(R1, R2, R3, R4, carwash);
        JOptionPane.showMessageDialog(null, Calculate.profitSummary, "Profit Summary", JOptionPane.PLAIN_MESSAGE);
      }
    });
    btnSum.setBounds(300, 500, 150, 50);
    contentPane.add(btnSum);

    //Clear everything
    JButton btnClear = new JButton("Clear All");
    btnClear.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        //Clear textboxes& dropdowns
        txtField_M.setText("");
        txtField_PG.setText("");
        txtField_WdC.setText("");
        txtField_WeC.setText("");
        txtField_CW.setText("");
        txtField_S1.setText("");
        txtField_E1.setText("");
        txtField_B1.setText("");
        txtField_S2.setText("");
        txtField_E2.setText("");
        txtField_B2.setText("");
        txtField_S3.setText("");
        txtField_E3.setText("");
        txtField_B3.setText("");
        txtField_S4.setText("");
        txtField_E4.setText("");
        txtField_B4.setText("");
				comboBox3D.setSelectedIndex(0);
				comboBox7D.setSelectedIndex(0);
				comboBox14D.setSelectedIndex(0);
				comboBoxEB.setSelectedIndex(0);

        //Clear stored values
        Calculate.ClearAll();
        R1.ClearRental();
        R2.ClearRental();
        R3.ClearRental();
        R4.ClearRental();
      }
    });
    btnClear.setBounds(500, 500, 150, 50);
    contentPane.add(btnClear);
  }
}

