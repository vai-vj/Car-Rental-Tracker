import java.util.ArrayList;

public class Calculate {
  public static String month;
  public static ArrayList<Integer> calendar = new ArrayList<Integer>();
  public static ArrayList<Integer> dailyCosts = new ArrayList<Integer>();
  public static int numDays;
  public static int emptyDates;
  public static String displayMonth;
  public int rentDays;
  public static double disc3;
  public static double disc7;
  public static double disc14;
  public static double disceb;
  public double initialRental;
  public double rentTotal;
  public double earlyBirdCost;
  public double discountRental;
  public String percent1;
  public String percent2;
  public static String rentalSummary;
  public static double combinedTotal;
  public static double finalProfit;
  public static double afterCarWash;
  public static String lowest;
  public static String feedback;
  public static String profitSummary;

  public Calculate() {
    month = "";
    calendar = new ArrayList<Integer>(0);
    dailyCosts = new ArrayList<Integer>(0);
    emptyDates = 0;
    numDays = 0;
    displayMonth = "";
    rentDays = 0;
    initialRental = 0.00;
    rentTotal = 0.00;
    disc3 = 0.00;
    disc7 = 0.00;
    disc14 = 0.00;
    disceb = 0.00;
    earlyBirdCost = 0.00;
    discountRental = 0.00;
    percent1 = "";
    percent2 = "";
    rentalSummary = "";
    combinedTotal = 0.00;
    finalProfit = 0.00;
    afterCarWash = 0.00;
    lowest = "";
    feedback = "";
    profitSummary = "";
  }

  //create calendar arraylist
  public ArrayList<Integer> makeCalendar(String m) {
    calendar.clear();
    //Set num of days in each month
    //empty days for place holders
    if (m.equals("January") || m.equals("October")) {
      emptyDates = 0;
      numDays = 31;} 
    else if (m.equals("February")) {
      emptyDates = 3;
      numDays = 28;} 
    else if (m.equals("March")) {
      emptyDates = 3;
      numDays = 31;} 
    else if (m.equals("April")) {
      emptyDates = 6;
      numDays = 30;} 
    else if (m.equals("May")) {
      emptyDates = 1;
      numDays = 31;} 
    else if (m.equals("June")) {
      emptyDates = 4;
      numDays = 30;} 
    else if (m.equals("July")) {
      emptyDates = 6;
      numDays = 31;} 
    else if (m.equals("August")) {
      emptyDates = 2;
      numDays = 31;} 
    else if (m.equals("September")) {
      emptyDates = 5;
      numDays = 30;} 
    else if (m.equals("November")) {
      emptyDates = 3;
      numDays = 30;} 
    else if (m.equals("December")) {
      emptyDates = 5;
      numDays = 31;}

    //make arraylist for month
    for (int i = 1; i <= emptyDates; i++) {
      calendar.add(0);}
    for (int i = 1; i <= numDays; i++) {
      calendar.add(i);}
    return calendar;
  }

  //output for calendar pop-up message
  public String displayCalendar(){
    displayMonth = "S     M     T    W   TH    F    ST\n\n";
    for(int i=0; i<numDays+emptyDates; i++){
      //add 0 for 0-10 for formatting
      if(calendar.get(i) < 10){
        displayMonth += "0";
      } 
      displayMonth += calendar.get(i) + "   ";
      //new line for new week
      if(i%7==6){
        displayMonth += "\n";
      }
    }
    return displayMonth;
  }

  //set weekend& weekday costs
  public void setCosts(int wday, int wend) {
    dailyCosts.clear();
    for (int i = 0; i < numDays + emptyDates; i++) {
      //weekends
      if ((i % 7 == 0) || (i % 7 == 6)) {
        dailyCosts.add(wend);
      } 
      //weekdays
      else {
        dailyCosts.add(wday);
      }
    }

    for (int i = 0; i < emptyDates; i++) {
      dailyCosts.remove(0);
    }
    //System.out.println(dailyCosts); //remove when finished!!!!!!!!!!!!
  }

  //num of days rented
  public int countDays(int start, int end) {
    rentDays = 0;
    rentDays = end - start + 1;
    return rentDays;
  }

  //total using dates and costs
  public double getInitialRentCost(int start, int end) {
    initialRental = 0.00;
    for (int i = start - 1; i < end; i++) {
      initialRental += dailyCosts.get(i);
    }
    initialRental = Math.round(initialRental * 100) / 100;
    return initialRental;
  }

  //Discounts on num of days booked
  public double findDayDiscounts(String d3, String d7, String d14) {
    //convert to user's choice to decimals
    if (!(d3.equals("    "))) {
      disc3 = (Integer.parseInt(d3.substring(1, 3))) / 100.0;
    }
    if (!(d7.equals("    "))) {
      disc7 = (Integer.parseInt(d7.substring(1, 3))) / 100.0;
    }
    if (!(d14.equals("    "))) {
      disc14 = (Integer.parseInt(d14.substring(1, 3))) / 100.0;
    }

    //find which discount applies
    if (rentDays >= 14) {
      discountRental = initialRental - (initialRental * disc14);
    } 
    else if (rentDays >= 7) {
      discountRental = initialRental - (initialRental * disc7);
    } 
    else if (rentDays >= 3) {
      discountRental = initialRental - (initialRental * disc3);
    } 
    else {
      discountRental = initialRental;
    }
    discountRental = Math.round(discountRental * 100) / 100;
    //return remaining amount after discount
    return discountRental;
  }

  //Early bird discount
  public double findEBDiscounts(int r, String eb) {
    if (!(eb.equals("    "))) {
      disceb = (Integer.parseInt(eb.substring(1, 3))) / 100.0;
    }
    
    // System.out.println(disceb);
    if (r == 0) { // early
      earlyBirdCost = 0 - (initialRental * disceb);
    } else if (r == 1) { // on time
      earlyBirdCost = 0;
    } else if (r == 2) { // late
      earlyBirdCost = initialRental * 0.10;
    }
    // System.out.println("Early bird: " + earlyBirdCost * 1.00);
    earlyBirdCost = Math.round(earlyBirdCost * 100) / 100;
    return earlyBirdCost;
  }

  //get total for one rental
  public double getTotalRent() {
    rentTotal = (discountRental + earlyBirdCost);
    return rentTotal;
  }

  //pop-up for rentals
  public String getRentalReceipt(String d3, String d7, String d14, int r, String eb) {
    rentalSummary = "";
    //num of day discounts
    if (rentDays >= 14) {
      percent1 = d14;
    } else if (rentDays >= 7) {
      percent1 = d7;
    } else if (rentDays >= 3) {
      percent1 = d3;
    }

    //early bird value
    percent2 = " ";
    if (r == 2) {
      percent2 = "+10%";
    } else if (r == 1) {
      percent2 = " ";
    } else if (r == 0) {
      percent2 = eb;
    }
    //output
    rentalSummary = "Number of Days Booked:   " + rentDays + "\n\n";
    rentalSummary += "Initial Cost of Rental:          " + initialRental + "\n";
    rentalSummary += "Number of Days Discount: " + (discountRental - initialRental) + "   " + percent1 + "\n";
    rentalSummary += "Early Bird Discount:             " + earlyBirdCost + "   " + percent2 + "\n";
    rentalSummary += "--------------------------------------------------\n";
    rentalSummary += "Total Rent Profit:                 " + rentTotal;
    return rentalSummary;
  }

  //sum of all rentals
  public static double getAllRents(Calculate r1, Calculate r2, Calculate r3, Calculate r4) {
    combinedTotal = 0;
    combinedTotal = r1.rentTotal + r2.rentTotal + r3.rentTotal + r4.rentTotal;
    return combinedTotal;
  }

  //detract company's fee
  public static double subtractFee() {
    finalProfit = 0;
    finalProfit = combinedTotal * .85;
    finalProfit= Math.round(finalProfit * 100) / 100;
    return finalProfit;
  }

  //subtract monthly car wash
  public static double subtractCarWash(double carWashCost) {
    afterCarWash = 0;
    afterCarWash = finalProfit - carWashCost;
    return afterCarWash;
  }

  //feedback on reaching goal
  public static String compareGoal(double goal) {
    if (goal > afterCarWash) {
      feedback = "Your profit goal (" + goal + ") is not met. \nYou need to make more adjustments.";
    } else if (goal <= afterCarWash) {
      feedback = "Your profit goal (" + goal + ") is met!";
    }
    return feedback;
  }

  //Final summary
  public static String getProfitSummary(Calculate r1, Calculate r2, Calculate r3, Calculate r4, double carWashCost) {
    profitSummary = "Rental 1: " + r1.rentTotal + "\n";
    profitSummary += "Rental 2: " + r2.rentTotal + "\n";
    profitSummary += "Rental 3: " + r3.rentTotal + "\n";
    profitSummary += "Rental 4: " + r4.rentTotal + "\n";
    profitSummary += "----------------------------\n";
    profitSummary += "Subtotal: " + combinedTotal + "\n";
    profitSummary += "Fees:          -" + (Math.round(combinedTotal *.15 * 100) / 100) + "  (-15%)\n";
    profitSummary += "----------------------------\n";
    profitSummary += "Income:   " + finalProfit + "\n";
    profitSummary += "Car Wash: -" + carWashCost + "\n";
    profitSummary += "----------------------------\n";
    profitSummary += "Profit:   " + afterCarWash + "\n\n";
    profitSummary += "Feedback: " + feedback;
    return profitSummary;
  }

  //Clear shared values
  public static void ClearAll(){
    month = "";
    calendar = new ArrayList<Integer>(0);
    dailyCosts = new ArrayList<Integer>(0);
    emptyDates = 0;
    numDays = 0;
    displayMonth = "";
    disc3 = 0.00;
    disc7 = 0.00;
    disc14 = 0.00;
    disceb = 0.00;
    rentalSummary = "";
    combinedTotal = 0.00;
    finalProfit = 0.00;
    afterCarWash = 0.00;
    feedback = "";
    profitSummary = "";
  }

  //clear values for each rental
  public void ClearRental(){  
    rentDays = 0;
    initialRental = 0.00;
    rentTotal = 0.00;
    earlyBirdCost = 0.00;
    discountRental = 0.00;
    percent1 = "";
    percent2 = "";
  }
}
