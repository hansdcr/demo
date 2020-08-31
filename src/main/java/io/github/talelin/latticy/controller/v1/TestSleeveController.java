package io.github.talelin.latticy.controller.v1;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.talelin.latticy.mapper.BannerMapper;
import io.github.talelin.latticy.model.BannerDO;
import io.github.talelin.latticy.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/banner")
public class TestSleeveController {
    @Autowired
    private BannerService bannerService;

    @Autowired
    private BannerMapper bannerMapper;

    @GetMapping("/test/test1")
    public List<BannerDO> test(){
        return bannerService.findAllBanners();
    }

    @GetMapping("/test/test2")
    public long test2(){
        return bannerService.insertBanner();
    }

    @GetMapping("/test/test3")
    public List<BannerDO> test3(){
        bannerMapper.selectList(null);
        return bannerService.findAllBanners();
    }
}
