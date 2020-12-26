package kr.co.softcampus.beans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Size;

/**
 * Created by 김홍준
 * Date: 2020-12-26
 * Time: 오후 12:54
 */
@Setter @Getter @ToString
public class DataBean1 {
    @Size(min = 2, max = 10)
    private String data1;
    private String data2;
    private String data3;
}
