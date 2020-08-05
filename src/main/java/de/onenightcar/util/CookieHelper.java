package de.onenightcar.util;

import javax.servlet.http.Cookie;

public class CookieHelper {

    static public boolean proveCookieExistence(Cookie[] cookieList, String cookieName) {
        if(cookieList == null) {
            return false;
        }
        for (int i = 0; i < cookieList.length; i++) {
            Cookie cookie = cookieList[i];
            if (cookieName.equals(cookie.getName())){
                return true;
            }
        }
        return false;
    }

    static public Long getUserCookieId(Cookie[] cookieList, String cookieName){
        for (int i = 0; i < cookieList.length; i++) {
            Cookie cookieHelper = cookieList[i];
            if (cookieName.equals(cookieHelper.getName())){
                cookieHelper.getValue();
            }
        }
        return 0L;
    }
}
