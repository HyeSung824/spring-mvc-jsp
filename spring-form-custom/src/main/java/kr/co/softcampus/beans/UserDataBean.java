package kr.co.softcampus.beans;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by 김홍준
 * Date: 2020-12-21
 * Time: 오후 2:00
 */
@Setter @Getter
public class UserDataBean {
    private String user_name;
    private String user_id;
    private String user_pw;
    private String user_postcode;
    private String user_address1;
    private String user_address2;
}
