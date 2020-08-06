package de.onenightcar.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.servlet.http.Cookie;

import static org.assertj.core.api.Assertions.assertThat;

public class CookieHelperTest {

    private Cookie cookie1 = new Cookie("userId", "1");
    private Cookie cookie2 = new Cookie("test", "nur ein Test");

    private Cookie[] cookieList = {cookie1, cookie2};
    private String cookieName = "userId";

    @Test
    void the_cookie_existence_should_be_proven() {
        assertThat(CookieHelper.proveCookieExistence(cookieList, cookieName) == true);
    }

    @Test
    void the_right_cookie_value_should_be_fetched_from_list() {
        Long id;
        id = CookieHelper.getUserCookieId(cookieList, cookieName);
        assertThat(id == 1);
    }
}
