package kr.co.softcampus.beans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.*;

/**
 * Created by 김홍준
 * Date: 2020-12-26
 * Time: 오후 12:54
 */
@Setter @Getter @ToString
public class DataBean1 {
    /*
    * @NotEmpty : 주입된 값의 길이가 0이면 오류 발생. 공백도 글자로 인식합니다.
    * @NotBlank : 주입된 값이 공백을 제거하고 길이가 0이면 오류 발생.
    * @Positive : 양수가 아니라면 오류 발생
    * @PositiveOrZero : 0 또는 양수가 아니라면 오류 발생
    * @Negative : 음수가 아니라면 오류 발생.
    * @NegativeOrZero : 0 또는 음수가 아니라면 오류 발생.
    * @Email : 이메일 형식이 아니라면 오류 발생. 중간에 @가 있는지 정도만 확인한다.
    * */
    @NotEmpty
    private String data1 = "abcd";
    @NotBlank
    private String data2 = "abcd";

    //-- 하이버네이트 6.14 버전 부터는 String 객체에도 가능하다.
    @Positive
    private Integer data3 = 1;

    //-- 하이버네이트 6.14 버전 부터는 String 객체에도 가능하다.
    @PositiveOrZero
    private Integer data4 = 1;

    //-- 하이버네이트 6.14 버전 부터는 String 객체에도 가능하다.
    @Negative
    private Integer data5 = -1;

    //-- 하이버네이트 6.14 버전 부터는 String 객체에도 가능하다.
    @NegativeOrZero
    private Integer data6 = -1;

    //-- 단순히 문자열 중간에 @ 존재여부만 체크한다.
    @Email
    private String data7;
}
