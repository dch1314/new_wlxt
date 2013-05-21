/**
 * 
 */
package org.thcic.xapx.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 根据用户角色决定用户登录后的URL。
 * 
 * @author ZY
 */
@Component
public class AuthorityBasedAuthenticationSuccessHandler extends
		SimpleUrlAuthenticationSuccessHandler {
	protected final Log log = LogFactory.getLog(this.getClass());

	public AuthorityBasedAuthenticationSuccessHandler() {
		((DefaultRedirectStrategy) getRedirectStrategy())
				.setContextRelative(true);
		setDefaultTargetUrl("/u/equipment");
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		String targetUrl = determineTargetUrl(authentication);

		if (!StringUtils.hasText(targetUrl)) {
			targetUrl = getDefaultTargetUrl();
		}

		getRedirectStrategy().sendRedirect(request, response, targetUrl);

		clearAuthenticationAttributes(request);
	}

	private String determineTargetUrl(Authentication authentication) {
		Map<String, String> authorityUrlMap = new HashMap<String, String>();
		authorityUrlMap.put("admin", "/u/equipment");
		authorityUrlMap.put("user", "/u/equipment");
		try {
			for (GrantedAuthority authority : authentication.getAuthorities()) {
				for (Map.Entry<String, String> entry : authorityUrlMap
						.entrySet()) {
					if (authority.getAuthority().equals(entry.getKey())) {
						return entry.getValue();
					}
				}
			}
		} catch (Exception e) {
			log.warn(e, e);
		}
		return null;
	}

}
