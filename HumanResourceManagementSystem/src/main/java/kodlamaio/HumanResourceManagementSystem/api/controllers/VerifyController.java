package kodlamaio.HumanResourceManagementSystem.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.VerificationService;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;

@RestController
@RequestMapping("/api/verify")
public class VerifyController {
	private VerificationService verificationService;
	
	
	@Autowired
	public VerifyController(VerificationService emailVerificationService) {
		super();
		this.verificationService = emailVerificationService;
	}



	@PostMapping("/update/{verificationCode}/{id}")
	public Result setVerify(@RequestParam String verificationCode,@RequestParam Integer id) {
			return verificationService.verify(verificationCode,id);
	}
}

