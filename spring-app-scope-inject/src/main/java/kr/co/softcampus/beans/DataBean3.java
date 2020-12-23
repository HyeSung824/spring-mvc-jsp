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
@Component
@ApplicationScope
@Setter @Getter
public class DataBean3 {
    private String data5;
    private String data6;
}
