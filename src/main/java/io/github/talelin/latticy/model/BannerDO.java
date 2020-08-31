package io.github.talelin.latticy.model;


import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@TableName("banner")
public class BannerDO implements Serializable {
        private Long id;
        private String name;
        private String title;
        private String img;
        // private String type;
        private Date createTime;
        private Date updateTime;
        private Date deleteTime;


//        @OneToMany(fetch = FetchType.LAZY)
//        @JoinColumn(name="bannerId")
//        private List<BannerItem> items;
}
