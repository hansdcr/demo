package io.github.talelin.latticy.controller.v1;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.latticy.common.mybatis.Page;
import io.github.talelin.latticy.dto.BannerDTO;
import io.github.talelin.latticy.model.BannerDO;
import io.github.talelin.latticy.service.BannerService;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.PageResponseVO;
import io.github.talelin.latticy.vo.UpdatedVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping("/v1/banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @DeleteMapping("/{id}")
    public DeletedVO delete(@PathVariable @Positive Long id){
        bannerService.delete(id);
        return new DeletedVO();
    }

    @PutMapping("/{id}")
    public UpdatedVO update(@RequestBody @Validated BannerDTO dto,
                       @PathVariable @Positive Long id){
        BannerDTO bannerDTO = dto;
        bannerService.update(bannerDTO, id);
        return new UpdatedVO();
    }

    @GetMapping("/page")
    public PageResponseVO<BannerDO> getBanners(@RequestParam(required = false, defaultValue = "0") @Min(value = 0) Integer page,
                           @RequestParam(required = false, defaultValue = "10") @Max(value = 20) Integer count){

        Page<BannerDO> pager = new Page<>(page, count);
        IPage<BannerDO> paging = bannerService.getBaseMapper().selectPage(pager, null);

        return new PageResponseVO<BannerDO>(
                paging.getTotal(),
                paging.getRecords(),
                paging.getCurrent(),
                paging.getSize());
    }
}
