package kr.co.softcampus.beans;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

/**
 * Created by 김홍준
 * Date: 2020-12-23
 * Time: 오후 10:57
 */
@Setter @Getter
public class DataBean1 {
    @Size(min = 2, max = 10)
    private String data1;
    @Max(100)
    private String data2;
}
