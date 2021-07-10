package kodlamaio.HumanResourceManagementSystem.core.utilities;

import kodlamaio.HumanResourceManagementSystem.validation.FakeMernis;

public class IdentityValidation {
	public static boolean isRealPerson(String tcno) {
		FakeMernis mernis = new FakeMernis();
		return FakeMernis.validate(tcno);
	}
}
