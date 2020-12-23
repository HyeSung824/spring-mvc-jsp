package kr.co.softcampus.beans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

/**
 * Created by 김홍준
 * Date: 2020-12-22
 * Time: 오후 10:35
 */
@Component("applicationBean4")
@ApplicationScope
@Setter @Getter
public class DataBean4 {
    private String data7;
    private String data8;
}
