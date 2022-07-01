
import java.util.Date;
import java.util.Locale;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

	public static void main(String[] args) {
		
		System.out.println(checkCoupon("123","123","July 9, 2015","August 9, 2015"));
		System.out.println(checkCoupon("123","123","July 9, 2015","July 12, 2015"));
		System.out.println(checkCoupon("123","123","July 9, 2015","July 1, 2015"));
		System.out.println(checkCoupon("123","123","July 9, 2015","July 9, 2015"));
		System.out.println(checkCoupon("123","123","July 9, 2015","April 12, 2015"));
		System.out.println(checkCoupon("123","223","July 9, 2015","July 12, 2015"));
	}

	public static boolean checkCoupon(String enteredCode, String correctCode, String currentDate, String expirationDate){
		  
		Date cd=null;
		Date ed=null;
		SimpleDateFormat format=new SimpleDateFormat("MMMM dd, yyyy", Locale.UK);

		try {
			
			cd = format.parse(currentDate);
			ed=format.parse(expirationDate);
			
		} catch (ParseException e) {

			e.printStackTrace();
		}

		return (enteredCode.equalsIgnoreCase(correctCode)&&(cd.before(ed)||cd.equals(ed)));
	}
}
