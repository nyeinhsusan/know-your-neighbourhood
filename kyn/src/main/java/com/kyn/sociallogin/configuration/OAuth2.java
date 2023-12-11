package com.kyn.sociallogin.configuration;

import java.util.ArrayList;

public class OAuth2 {
	private ArrayList<String> authorizedRedirectUris;

	public ArrayList<String> getAuthorizedRedirectUris() {
		return authorizedRedirectUris;
	}

	public void setAuthorizedRedirectUris(ArrayList<String> authorizedRedirectUris) {
		this.authorizedRedirectUris = authorizedRedirectUris;
	}
	
}