package net.ssm.system.web.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUser {
    private Long userid;
    private String username;
    private String password;
    private String email;
    private String mobile;
}