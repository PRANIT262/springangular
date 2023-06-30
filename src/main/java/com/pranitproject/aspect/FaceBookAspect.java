package com.pranitproject.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import java.time.Duration;

import com.pranitproject.entity.FacebookUser;

import java.time.LocalTime;
import java.util.logging.Logger;

@Aspect
@Component
public class FaceBookAspect {

	Logger log = Logger.getLogger("FacebookController");

	LocalTime t1;
	LocalTime t2;

	@Before(value = "execution(* com.pranitproject.service.FacebookService.*(..)) and args(fuser)")
	public void beforeAdvice(JoinPoint jj, FacebookUser fuser) {
		t1 = LocalTime.now();
		log.info("before starting method execution of " + jj.getSignature() + "  and entered inside method at " + t1);
		log.info("for user name is " + fuser.getName() + " and email is " + fuser.getEmail());
	}

	@After(value = "execution(* com.pranitproject.service.FacebookService.*(..)) and args(fuser)")
	public void afterAdvice(JoinPoint jj, FacebookUser fuser) {
		t2 = LocalTime.now();

		log.info("after executing method  of " + jj.getSignature() + "     and  it have taken "
				+ Duration.between(t2, t1) + "  second");
		log.info("for user name is " + fuser.getName() + " and email is " + fuser.getEmail());
	}
}