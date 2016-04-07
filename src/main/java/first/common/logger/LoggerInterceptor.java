/**
 * 
 */
package first.common.logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author kimBR
 *
 */
public class LoggerInterceptor extends HandlerInterceptorAdapter {

	protected Log log = LogFactory.getLog(LoggerInterceptor.class);

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		response.setHeader("Pragma", "No-Cache");
	    response.setHeader("Cache-Control", "No-Cache");
	    response.setDateHeader("Expires", 0);
	    
		if (log.isDebugEnabled()) {
			log.debug("======================================           END          ======================================\n");
        }
		
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if (log.isDebugEnabled()) {
            log.debug("======================================          START         ======================================");
            log.debug(" Request URI \t:  " + request.getRequestURI());
        }
		return super.preHandle(request, response, handler);
	}
}
