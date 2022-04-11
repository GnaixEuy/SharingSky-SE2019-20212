package cn.limitless.thymeleafhomework.entity;

import lombok.*;

import javax.persistence.*;

/**
 * <img src="https://c-ssl.duitang.com/uploads/blog/202008/30/20200830183701_3ZzSR.thumb.1000_0.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/4/10
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "customer")
public class Customer {
    @ToString.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cid", nullable = false)
    private Integer id;

    @ToString.Include
    @Column(name = "cname", nullable = false, length = 20)
    private String cname;

    @ToString.Include
    @Column(name = "mobile", length = 20)
    private String mobile;

    @ToString.Include
    @Column(name = "status", length = 20)
    private String status;

}