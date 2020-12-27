package kr.co.softcampus.beans;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by 김홍준
 * Date: 2020-12-27
 * Time: 오후 11:18
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
public class UserBean {

    private int user_idx;
    private String user_name;
    private String user_id;
    private String user_pw;
}
