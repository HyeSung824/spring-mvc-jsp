package kr.co.softcampus.beans;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
    @Size(min =2, max = 4)
    @Pattern(regexp = "[가-힣]*")
    private String user_name;
    @Size(min = 4, max = 20)
    @Pattern(regexp = "[a-zA-Z0-9]*")
    private String user_id;
    @Size(min = 4, max = 20)
    @Pattern(regexp = "[a-zA-Z0-9]*")
    private String user_pw;
    @Size(min = 4, max = 20)
    @Pattern(regexp = "[a-zA-Z0-9]*")
    private String user_pw2;

    private boolean userIdExist = false;
}
