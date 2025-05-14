/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.cafe.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@ToString

/**
 *
 * @author admin
 */
public class User {

    private String username;
    private String password;
    private boolean enabled;
    private String fullname;

    @Builder.Default
    private String photo = "photo.png"; // Giá trị mặc định cho ảnh
    private boolean manager;

}
