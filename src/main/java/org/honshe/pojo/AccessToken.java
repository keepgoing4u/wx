package org.honshe.pojo;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
public class AccessToken {
    private String access_token = null;
    private Long expires_in;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Long expires_in) {
        this.expires_in = expires_in;
    }

    @Override
    public String toString() {
        return "AccessToken{" +
                "expires_in=" + expires_in +
                ", access_token='" + access_token + '\'' +
                '}';
    }
}
