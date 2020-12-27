package kr.co.softcampus.beans;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by 김홍준
 * Date: 2020-12-27
 * Time: 오후 11:20
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
public class ContentBean {

    private int content_idx;
    private String content_subject;
    private String content_text;
    private String content_file;
    private int content_writer_idx;
    private int content_board_idx;
    private String content_date;
}
