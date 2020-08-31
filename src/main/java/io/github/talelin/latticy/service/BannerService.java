package io.github.talelin.latticy.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.dto.BannerDTO;
import io.github.talelin.latticy.mapper.BannerMapper;
import io.github.talelin.latticy.model.BannerDO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerService extends ServiceImpl<BannerMapper, BannerDO> {
    @Autowired
    private BannerMapper bannerMapper;

    public void delete(Long id){
        BannerDO bannerDO = this.getById(id);
        if (bannerDO == null){
            throw new NotFoundException();
        }
        this.bannerMapper.deleteById(id);
    }


    public void update(BannerDTO dto, Long id){
        BannerDO bannerDO = this.getById(id);
        if (bannerDO == null){
            throw new NotFoundException();
        }
        BeanUtils.copyProperties(dto, bannerDO);
        this.updateById(bannerDO);
    }

    public List<BannerDO> findAllBanners(){
        return bannerMapper.getAllBanners();
    }

    public long insertBanner(){
        BannerDO bannerDO = new BannerDO();
        bannerDO.setName("newBanner");
        bannerDO.setTitle("newBannerTtile");

        bannerMapper.insertBanner(bannerDO);
        return bannerDO.getId();

    }
}
