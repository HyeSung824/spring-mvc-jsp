package kr.co.softcampus.beans;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;

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

    @NotBlank
    private String content_subject;

    @NotBlank
    private String content_text;

    private MultipartFile upload_file;

    private String content_file;
    private int content_writer_idx;
    private int content_board_idx;
    private String content_date;
    private String content_writer_name;
}
