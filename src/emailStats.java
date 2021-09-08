public class emailStats{
  public static void main(String[] args){
    String[] emailAddresses = produceRandomEmails();
    String[]  domains = new String[emailAddresses.length];
    for(int i=0; i<emailAddresses.length; i++) {
      domains[i] = getDomain(emailAddresses[i]);
    }
      
    boolean[] first = getUnique(domains);
      
    // What is this test doing? What should the output look like? 
    for(int i=0; i<emailAddresses.length; i++) {
      System.out.println(emailAddresses[i] + " --> " + domains[i] + " ("+first[i]+")");
    }
      
    // testing find full domain method
    
    // should return 1, which is the start of the substring excluding first dot
    System.out.println(findStartOfFullDomain("..") == 1);
    // testing the case with no subdomain
    System.out.println(findStartOfFullDomain("utep.edu") == 0);
    // the standard valid subdomain
    System.out.println(findStartOfFullDomain("miners.utep.edu") == 7);
    
    //testing matching domains
    // subdomains
    System.out.println(compareDomains("local.utep.edu","utep.edu")==true);
    // capitals
    System.out.println(compareDomains("uTep.edu","utep.edU")==true);
    // negation
    System.out.println(compareDomains("uTep.edu","gmail.com")==false);
    // two subdomains
    System.out.println(compareDomains("miners.uTep.edu","local.utep.edu")==true);
    
    // count number of unique domains
    int numUniqDomains = 0;
    for(int i=0; i<first.length; i++) {
      if(first[i]) numUniqDomains++;

    }
	  
    String[][] splitEmailAddresses = new String[emailAddresses.length][];
    for(int i=0; i<emailAddresses.length; i++) {
	    
    }
    // construct the unique array
      
    // count domains
  }
  
  // Input: a single string containing the email address of one user
  // Output: an array with the username part in index 0, then the domain split on "."s
  // This method will produce a 1D array splitting on "@" and "." (other than those in the username)
  public static String[] splitEmailAddress(String emailAddress){
  
    return new String[1];
  }
	
	
  // Input: a single String containing the email address of one user
  // Output: a single string with just the domain part of the address
  // Description: finds `@` and returns the remainder of the input
  public static String getDomain(String emailAddress) {
	  String rtn = "";
	  int index = -1;
	  for(int i=0; i<emailAddress.length(); i++) {
		  if(emailAddress.charAt(i)=='@') {
			  if(index >= 0) {
				  return "Failure (more than one @)";
			  }
			  index=i;
		  }
	  }
	  if(index == -1){
		  return "Failure (no @s)";
	  }
	  for(int i=index+1; i<emailAddress.length(); i++) {
		  rtn += emailAddress.charAt(i);
	  }
	  return rtn;
  }
  
  // Input: an array of domain names as strings
  // Output: an array marking the first instance of each domain
  // Description: for each entry, mark true if not matching previous entries
  public static boolean[] getUnique(String[] domains) {
	  boolean[] first = new boolean[domains.length];
	  for(int i=0; i<domains.length; i++) {
		  first[i] = true;
		  for(int j=0; j<i; j++) {
			  if(compareDomains(domains[i],domains[j])) {
				  first[i] = false;
			  }
		  }
	  }
	  return first;
  }
    
  // Input: two domain names as strings
  // Output: decision if they would be interpreted as the same domain name
  // Description: Some providers allow you to add subdomains (or prefixes) 
  //              to domains and still be delivered
  //              in addition domain names naturally are 
  //              case insensitive 
  public static boolean compareDomains(String domain1, String domain2) {
    int start1 = findStartOfFullDomain(domain1);
    int start2 = findStartOfFullDomain(domain2);
    
    // match from both starts using charAt()

    // first check that the lengths are the same
    if((domain1.length()-start1) != (domain2.length()-start2)) {
      return false;
    }
    
    while(start1 < domain1.length()) {
      char c1 = domain1.charAt(start1);
      char c2 = domain2.charAt(start2);
      if(c1 >= 'A' && c1 <= 'Z') {
        int index = c1 - 'A';
        c1 = (char)(index + 'a');
      }
      if(c2 >= 'A' && c2 <= 'Z') {
        int index = c2 - 'A';
        c2 = (char)(index + 'a');
      }
      if(c1 != c2) return false;
      start1++;
      start2++;
    }
    
    return true;
  }
  // Input: a domain (possibly subdomain)
  // Output: starting index of full domain
  // Description: finding the index of either the second dot or the start of the string
  public static int findStartOfFullDomain(String domain) {
    // find the start of the full domain in both domains:
    //  * start at end
    //  * move left till (1) second dot or (2) start of string
    boolean found_dot = false;
    for(int i=domain.length()-1; i>=0; i-- ) {
      if(domain.charAt(i)=='.') {
        if(!found_dot) found_dot = true;
        else return i+1;
      }
    }
    return 0;
  }
  public static String[] produceRandomEmails() {
    return new String[] {"kramulous@optonline.net","rhavyn@iCloud.com","jgwang@gmail.com","xtang@outlook.com","tubesteak@outlook.com","airship@att.net","pgolle@live.com","staffelb@local.comcast.net","techie@verizon.net","tedrlord@Hotmail.com","osaru@hotmail.com","nwiger@something.verizon.net","bahwi@att.net","enintend@outlook.com","webteam@outlook.com","martink@mac.com","paley@yahoo.com","heine@gmail.com","podmaster@aol.com","kdawson@me.com","cyrus@mac.com","mleary@verizon.net","philen@att.net","neuffer@hotmail.com","elflord@yahoo.ca","jesse@Icloud.com","ramollin@msn.com","thaljef@me.com","osrin@me.com","sacraver@hotmail.com","spadkins@att.net","pereinar@verizon.net","jguyer@icloud.com","sethbrown@icloud.com","calin@hotmail.com","kdawson@comcast.net","jfriedl@live.com","miami@live.com","sacraver@mac.com","fukuchi@outlook.com","hstiles@comcast.net","chrwin@icloud.com","osrin@yahoo.ca","daveed@live.com","itstatus@yahoo.com","pkplex@yahoo.com","johndo@sbcglobal.net","munjal@aol.com","mdielmann@msn.com","sriha@icloud.com", "mdielmann@google.co.uk", "mdielmann@something.domain.co.uk","student@miners.utep.edu"};
  }
	
  public static void printArray(String[] array) {
    System.out.print("[");
    for(int i=0; i<array.length; i++) {
      if(i>0) System.out.print(",");
      System.out.print(array[i]);
    }
    System.out.println("]");
  }
	
}
