package kr.co.softcampus.beans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

/**
 * Created by 김홍준
 * Date: 2020-12-21
 * Time: 오후 11:37
 */
@Component(value = "requestBean4")
@RequestScope
@Setter @Getter
public class DataBean4 {
    private String data7;
    private String data8;
}
