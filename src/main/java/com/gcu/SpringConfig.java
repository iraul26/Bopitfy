package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gcu.Business.LoginBusinessService;
import com.gcu.Business.LoginBusinessServiceInterface;
import com.gcu.Business.PlaylistBusinessService;
import com.gcu.Business.PlaylistBusinessServiceInterface;
import com.gcu.Business.RegisterBusinessService;
import com.gcu.Business.RegisterBusinessServiceInterface;

/**
 * Configuartion class for Spring Boot project
 */
@Configuration
public class SpringConfig {
	/**
	 * Spring Bean for RegisterBusinessService
	 * @return RegisterBusinessService
	 */
	@Bean(name="registerBusinessService", initMethod="init", destroyMethod="destroy")
	public RegisterBusinessServiceInterface getRegisterBusiness() {
		return new RegisterBusinessService();
	}
	
	/**
	 * Spring Bean for LoginBusinessService
	 * @return LoginBusinessService
	 */
	@Bean(name="loginBusinessService", initMethod="init", destroyMethod="destroy")
	public LoginBusinessServiceInterface getLoginBusiness()
	{
		return new LoginBusinessService();
	}
	
	/**
	 * Spring Bean for PlaylistBusinessService
	 * @return PlaylistBusinessService
	 */
	@Bean(name="playlistBusinessService", initMethod="init", destroyMethod="destroy")
	public PlaylistBusinessServiceInterface getPlaylistBusiness() {
		return new PlaylistBusinessService();
	}
}