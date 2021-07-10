package kodlamaio.HumanResourceManagementSystem.validation;


public class FakeMernis {
	public static boolean validate(String tcNo) {

		if(tcNo.length() != 11) {
			return false;
		}
		else if(!tcNo.startsWith("0")) {
			return true;
		}
		else {
			return false;
		}
		
	}
}
