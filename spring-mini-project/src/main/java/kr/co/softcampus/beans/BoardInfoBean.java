package kr.co.softcampus.beans;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by 김홍준
 * Date: 2020-12-27
 * Time: 오후 11:16
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
public class BoardInfoBean {

    private int board_info_idx;
    private String board_info_name;
}
