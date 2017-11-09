package com.qhx.finish.myshop.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;
import javax.persistence.*;

/**
 * Created by QIUHX on 2017/11/8.
 */
@Table(name = "user")
@Entity
@ToString
public class User{
    /**
     * 用户id
     */
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private @Setter @Getter Integer userId = Integer.valueOf(0);

    /**
     * 用户名
     */
    private @Setter @Getter String username = "";

    /**
     * 用户密码
     */
    private @Setter @Getter String password = "";

    /**
     * 用户邮箱
     */
    @Email(message = "邮件格式错误")
    private @Setter @Getter String email = "";

    /**
     * 真实姓名
     */
    private @Setter @Getter String nickname = "";

    /**
     * 用户性别
     */
    private @Setter @Getter Integer gender = Integer.valueOf(0);

    /**
     * 用户电话
     */
    private @Setter @Getter Integer telephone = Integer.valueOf(0);

    /**
     * 用户年龄
     */
    private @Setter @Getter Integer age = Integer.valueOf(0);

    /**
     * 用户地址
     */
    private @Setter @Getter String address = "";

    /**
     * 激活状态
     */
    private @Setter @Getter Integer state = Integer.valueOf(0);

    /**
     * 激活码
     */
    private @Setter @Getter String code = "";

//    private @Setter @Getter
}
