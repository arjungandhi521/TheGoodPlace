/* This program simulates the formula to calcluate where you go in the afterlife from the NBC show 
  "The Good Place". You need about 1 million points to get there. Doug Forcett is the
  ideal person and so we compare all people to him here. The actions below are from the first episode of season one. 
  Source: https://medium.com/@howard24/a-look-at-the-moral-point-system-of-the-good-place-7858215fd9dc
  */

class Main {

  // Main method calls results on people 
  public static void main(String[] args) { 
    double arjunVal = arjunGandhisLife();
    double poojaVal = poojaGandhisLife();

    // names of ppl call results on
    String a = "Arjun Gandhi";
    String p = "Pooja Gandhi";

    // print results
    results(a, arjunVal); 
    results(p, poojaVal); 

    // Create parallel arrays of ppl names and moral values.
    // Then find the best person and output them.
    String names[] = {a, p};
    double values[] = {arjunVal, poojaVal};
    findBestPerson(names, values);
  }

  // Only those with a score greater than or equal to a million get into the Good Place
  static boolean goingToTheGoodPlace(double score) {
    if (score >= 1000000.0) return true; // if you are a good person
    else return false; 
  }

  // How close were you to being as good as Doug Forcett (the ideal human, # of points off) or how much
  // better were you if you had more than 520K points or are you a Doug?
  static void howDoYouCompareToDoug(double you) {
    if (you > 520000) {
      System.out.println("Wow! You must have been at least a little good. You were a better person than Doug Forcett!");
    }
    else if (you == 520000.0) System.out.println("You have equal value as person as Doug.");
    else System.out.println("Doug had " + (520000.0 - you) + " more points than you.");
  }
  
  // Prints where you are going and how you score relative to the minimum to get into the Good Place
  // and a human thought of as ideal.
  public static void results(String name, double value) {
    System.out.println(name + ", your score was: " + value);
    howDoYouCompareToDoug(value);
    if (goingToTheGoodPlace(value)) System.out.println("Congrats, " + name + " you're going to the Good Place!");
    else { 
      System.out.println(name + ", enjoy eternal suffering in the Bad Place!");
      double d = 1000000.0 - value; // calculate how off you were
      System.out.println("You were " + d + " points off from making it into the Good Place.");
      System.out.println();
    }
  }

  // Simulation of Pooja Gandhi's life
  static double poojaGandhisLife() {
    int points = 0;
    points += letSomeoneMergeInTrafficOnce() * 1000.0;
    points += holdDoorForSomeoneBehindYou() * 30000.0;
    points += broughtOwnBagsToGroceryStore(); 
    points += ignoreTextDuringHumanConvo();
    points += donatedBlood() * 10.0;
    points += gracefullyEndConvoOnWeather() * 94.0;
    points += helpMomWithPrinter() * 100.0;
    points += rememberSistersBirthday() * 70.0;
    points += hugSadFriend() * 50.0;
    points += scratchElbow() * 100.0;
    points += eatSandwich() * 6000.0;
    points += buyTrashyMag(); 
    points += blowNoseOdd();
    points += sayFB() * 200.0;
    return points;
  }
  
  // A simulation of Arjun Gandhi's life
  static double arjunGandhisLife() {
    double points = 0;
    points += letSomeoneMergeInTrafficOnce() * 50.0;
    points += holdDoorForSomeoneBehindYou() * 30000.0;
    points += installSolarPanelsOnHouse();
    points += broughtOwnBagsToGroceryStore();
    points += ignoreTextDuringHumanConvo()  * 100.0;
    points += donatedBlood() * 10.0;
    points += ateVegan();
    points += helpMomWithPrinter() * 100.0;
    points += rememberSistersBirthday() * 150.0;
    points += hugSadFriend() * 5.0;
    points += scratchElbow() * 100.0;
    points += eatSandwich() * 5000.0; 
    points += petLamb();
    points += blowNoseOdd() * 100.0;
    points += sayFB() * 200.0;
    points += sayBroCode() * 10.0;
    points += overstatPersonalConnectionsToTragedyThatHasNothingToDoWithYou() * 5.0;
    points += ruinOpera();
    return points;
  }

  // an example of an ideal life to get into the good place
  // not simulating anyone in particular, just to test good place code
  static double goodPersonLife() {
    double points = 0;
    points += endSlavery();
    points += letSomeoneMergeInTrafficOnce() * 50.0;
    points += holdDoorForSomeoneBehindYou() * 30000.0;
    points += installSolarPanelsOnHouse();
    points += broughtOwnBagsToGroceryStore();
    points += ignoreTextDuringHumanConvo()  * 100.0;
    points += donatedBlood() * 10.0;
    points += ateVegan();
    points += helpMomWithPrinter() * 100.0;
    points += rememberSistersBirthday() * 150.0;
    points += hugSadFriend() * 5.0;
    points += scratchElbow() * 100.0;
    points += eatSandwich() * 5000.0; 
    points += petLamb();
    return points;
  }

// find the best person
static void findBestPerson(String names[], double points[]) {
  double max = points[0];
  int index = 0; // local of best person

  // iterate over the scores
  // assume no two ppl have the same value
  for (int i = 1; i < points.length; i++) {
    if (max < points[i]) {
      max = points[i];
      index = i;
    }
  }

  System.out.print("Of these " + names.length + " people, " + names[index] + " had the most ");
  System.out.print("points with " + max + " points.");
}

// Actions with a moral value below, 1 per function

// Actions that are morally good 

// End slavery: +814292.09
static double endSlavery() { return 814292.09; }

// Hosted refugee family (5 people/Syria/Three years): +282803.09
static double hostRefugeeFamily() { return 282803.09; }

// Drove to out-of-state disaster site, helped with relief effort (x3): +147412.73
static double leaveStateToHelpInDisasterOnce() { return 49137.5766666667; }

// Donated 16.38% of lifetime income, anonymously, to charities: +87434.89
static double donateAbout16PercentOfLifeTimeIncomeAnonymously() { return 87434.89; }

// Let someone merge in traffic (x7329): +12118.13
static double letSomeoneMergeInTrafficOnce() { return 1.653449311; }

// Never discussed veganism unprompted: +9885.55
static double neverDiscussVeganismUnpromted() { return 9885.55; }

// Hold door for person behind you (x4090): +8882.31
static double holdDoorForSomeoneBehindYou() { return 2.1717139364; }

// Installed solar panels (house, arid environment): +1994.49
static double installSolarPanelsOnHouse() { return 1994.49; }

// Self-monitored potentially nauseating mouth sounds while chewing (x2.6m): +1982.05
static double selfMonitoredMouthSoundsWhileChewing() { return 0.00076232692; }

// Brought own bags to grocery store: +1980.43
static double broughtOwnBagsToGroceryStore() { return 1980.43; }

// Saved a person from house fire: +1909.47
static double saveHumanFromHouseFire() { return 1909.47; }

// Save a child from driving: +1202.33
static double saveLittleHumanFromDriving() { return 1202.33; }

// Ignored text message during in-person conversation: +1094.07
static double ignoreTextDuringHumanConvo() { return 1094.07; }

// Donated blood (x52): +911.72
static double donatedBlood() { return 17.5330769231; }

// Gave out full-size candy bars at Halloween: +633.59
static double gaveOutFullSizeCandyBarsOnHalloween() { return 633.59; }

// Rehabilitated pitbull (x16): +491.34
static double rehabilitatedPitbull() { return 30.70875; }

// Ate vegan: +432.04
static double ateVegan() { return 432.04; }

// Purify water source (village): Pop.>150): +295.98
static double purifyVillageWaterSource() { return 295.98; }

// Began to compose social media post about David Bowie dying then thought “the world doesn’t need to hear my thoughts on David Bowie dying”: +224.19
static double reverseDBPostDecesion() { return 224.19; }

// Researched West Indies text cricket tournament results to facilitate conversation with father-in-law (x14): +100.02
static double facilitateFatherInLawConversation() { return 7.1571428571; }

// Gracefully end conversation about the weather (x94): +99.31
static double gracefullyEndConvoOnWeather() { return 1.0564893617; }

// Maintain composure in line at water park in Houston: +61.14
static double keepCalmInLineAtTXWaterPark() { return 61.14;}

// Helped mom with her printer (x339): +60.09
static double helpMomWithPrinter() { return 0.1772566372; }

// Remain loyal to the Cleveland Browns: +53.83
static double stayLoyalToBrowns() { return 53.83; }

// Carefully put spider outside (x28): +40.02
static double putSpiderOutside() { return 1.4292857143; }

// Attend cousin’s friend’s child’s jazz dance recital: +31.57
static double attendRecitalJazz() { return 31.57; }

// Helped a hermit crab find a new shell: +18.05
static double helpHermit() { return 18.05; }

// Remember sister’s birthday: +15.02
static double rememberSistersBirthday() { return 15.02; }

// Politely tolerating stranger recounting New Yorker article at cocktail party: +12.23
static double tolerateNYerFan() { return 12.23; }

// Plant baobob tree in Madagascar: +9.40
static double plantTree() { return 9.4; }

// Fixed broken tricycle for child that loves tricycles: +6.60
static double fixTricForTricLover() { return 6.6; }

// Hug sad friend: +4.98
static double hugSadFriend() { return 4.98; }

// Carefully stepped over flower bed: +2.09
static double stepCarefullyOverFlowerBed() {return 2.09;}

// Scratch elbow: +1.06
static double scratchElbow() {return 1.06;}

// Eat a sandwich: +1.04
static double eatSandwich() {return 1.04;}

// Pet a lamb: +0.89
static double petLamb() { return .89; }

// Sing to a child: +0.69
static double singToChild() { return .69; }

// Fixed broken tricycle for child who is indifferent to tricycles: +0.04
static double fixTricForTricUserNeutral() {return .04;}

// Actions that are morally corrupt

// Buy a trashy magazine: -0.75
static double buyTrashyMag() {return -.75;}

// Blow nose by pressing down on one nostril and exhaling: -1.44
static double blowNoseOdd() { return -1.44; }

// Use “Facebook” as a verb: -5.55
static double sayFB() {return -5.55;}

// Stiff a waitress: -6.83
static double stiffWaitress() {return -6.83;}

// Use the term “bro-code”: -8.20
static double sayBroCode() {return -8.2;}

// Steal copper wiring from decommissioned military base: -16.00
static double stealCopperWiringFromDecommissionedMilitaryBase() { return -16; }

// Fail to disclose camel-illness when selling camel: -22.22
static double failsToDiscloseCamelSickWhenSellCamel() { return -22.22; }

// Overstate personal connection to tragedy that has nothing to do with you: -40.57
static double overstatPersonalConnectionsToTragedyThatHasNothingToDoWithYou() { return -40.57; }

// Tell a woman to smile: -53.83
static double tellWomanToSmile() { return -53.83; }

// Disturb coral reef with flipper: -53.83
static double disturbcoralReefWithFlipper() { return -53.83; }

// Rev a motorcycle: -64.42
static double revMotorcycle() { return -64.42; }

// Ruin opera with boorish behavior: -90.90
static double ruinOpera() { return -90.9; }

// Root for New York Yankees: -99.15
static double rootForNYYankees() { return -99.15; }

// Harassment (sexual): -731.26
static double sexuallyHarass() { return -731.26; }

// Be commissioner of professional football league (American): -824.55
static double commisionProAmericanFootballLeauge() { return -824.55; }

// Poison a river: -4015.55
static double poisonARiver() { return -4015.55; }

// Commit genocide: -433115.25
static double commitGenocide() { return -433115.25; }

}
