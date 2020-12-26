package kr.co.softcampus.beans;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

/**
 * Created by 김홍준
 * Date: 2020-12-26
 * Time: 오전 9:48
 */
@Setter @Getter
public class DataBean1 {
    /*
    * @AssertTrue : true가 아닌 값이 들어오면 오류
    * @AssertFalse : false가 아닌 값이 들어오면 오류
    * @Max(값) : 값보다 큰 값이 들어오면 오류
    * @Min(값) : 값보다 작은 값이 들어오면 오류
    *
    * @DecimalMax(value=값, inclusive=true/false) : 값보다 작거나 같은 값이 들어와야 합니다.
    * Inclusive가 false면 값은 포함하지 않기 때문에 작은 값이 들어와야 합니다. 생략하면 true
    *
    * @DecimalMin(value=값, inclusive=true/false) : 값보다 크거나 같은 값이 들어와야 합니다.
    * Inclusive가 false면 값은 포함하지 않기 때문에 큰 값이 들어와야 합니다. 생략하면 true
    *
    * @Null : 값이 들어오면 오류가 발생.
    * @NotNull : 값이 들어오지 않으면 오류가 발생.
    * @Digits(integer=자릿수,fraction=자릿수) : 지정된 자릿수의 숫자가 아닐 경우 오류가 발생.
    * Integer – 정수 자릿수, fraction – 실수 자릿수
    * @Size(min=글자수,max=글자수) : 지정된 글자수 보다 짧거나 길면 오류가 발생
    *
    * @Pattern(regexp=정규식) : 주어진 정규식에 위배되면 오류 발생
    * */
    @AssertTrue
    private boolean data1 = true;

    @AssertFalse
    private boolean data2 = false;

    @Max(100)
    @Min(10)
    private String data3 = "50";

    @DecimalMax(value = "100", inclusive = false)
    @DecimalMin(value = "10", inclusive = false)
    private String data4 = "50";

    //-- @NULL : 빈값으로 넘어오는 파라미터는 NULL 이 아니다. 아예 넘어오는 파라미터가 없어야 의미가 있다.
    @Null
    private String data5 = null;

    @NotNull
    private String data6 = "check2";

    @Digits(integer = 3, fraction = 3)
    private String data7 = "111.111";

    @Size(min = 3, max = 10)
    private String data8 = "abcd";

    @Pattern(regexp = "[a-zA-Z]*")
    private String data9;

}
