public class emailStats{
  public static void main(String[] args){
      String[] emailAddresses = produceRandomEmails();
      String[]  domains = new String[emailAddresses.length];
      for(int i=0; i<emailAddresses.length; i++) {
    	  domains[i] = getDomain(emailAddresses[i]);
      }
      
      boolean[] first = getUnique(domains);
      for(int i=0; i<emailAddresses.length; i++) {
    	  System.out.println(emailAddresses[i] + " --> " + domains[i] + " ("+first[i]+")");
          
      }
      
      // count number of uniques
      
      // construct the unique array
      
      // count domains
  }
  
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
  
  public static boolean[] getUnique(String[] domains) {
	  boolean[] first = new boolean[domains.length];
	  for(int i=0; i<domains.length; i++) {
		  first[i] = true;
		  for(int j=0; j<i; j++) {
			  if(domains[i].equalsIgnoreCase(domains[j].toLowerCase())) {
				  first[i] = false;
			  }
		  }
	  }
	  return first;
  }
    
  public static String[] produceRandomEmails() {
    return new String[] {"kramulous@optonline.net","rhavyn@iCloud.com","jgwang@gmail.com","xtang@outlook.com","tubesteak@outlook.com","airship@att.net","pgolle@live.com","staffelb@comcast.net","techie@verizon.net","tedrlord@Hotmail.com","osaru@hotmail.com","nwiger@verizon.net","bahwi@att.net","enintend@outlook.com","webteam@outlook.com","martink@mac.com","paley@yahoo.com","heine@gmail.com","podmaster@aol.com","kdawson@me.com","cyrus@mac.com","mleary@verizon.net","philen@att.net","neuffer@hotmail.com","elflord@yahoo.ca","jesse@Icloud.com","ramollin@msn.com","thaljef@me.com","osrin@me.com","sacraver@hotmail.com","spadkins@att.net","pereinar@verizon.net","jguyer@icloud.com","sethbrown@icloud.com","calin@hotmail.com","kdawson@comcast.net","jfriedl@live.com","miami@live.com","sacraver@mac.com","fukuchi@outlook.com","hstiles@comcast.net","chrwin@icloud.com","osrin@yahoo.ca","daveed@live.com","itstatus@yahoo.com","pkplex@yahoo.com","johndo@sbcglobal.net","munjal@aol.com","mdielmann@msn.com","sriha@icloud.com"};
  }
}
