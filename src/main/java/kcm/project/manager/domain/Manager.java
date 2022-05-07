package kcm.project.manager.domain;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter @Setter
public class Manager {

    private Long id;
    private String email; // 이메일
    private String password; // 비밀번호
    private String admin_yn; // 관리자 여부
    private String join_dt; // 가입일자
    private String reg_dt;  // 등록일자
    private String reg_dt_uuid; // 등록일 UUID
    private Date last_login_dt; // 최종 로그인 시간
    private Date pw_chg_dt; // 비밀번호 수정 일시
    private int login_fail_count; // 로그인 실패횟수
    private String del_yn; // 삭제여부
    private String dormant_yn; // 휴면여부
    private Date last_mod_dt; // 최종수정일자
    private String last_mod_dt_uuid; // 최종수정일 UUID

}
