package cn.study.service.impl;

import cn.study.mapper.GoodMapper;
import cn.study.pojo.Classify;
import cn.study.pojo.Good;
import cn.study.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author asus
 * @Title: GoodServiceImpl
 * @ProjectName mymall
 * @Description: TODO
 * @date 2018/9/3 17:04
 */
@Service
public class GoodServiceImpl implements GoodService {
    @Autowired
    private GoodMapper goodMapper;
    @Override
    public List<Good> getList() {
        return goodMapper.getAllGoods();
    }

    @Override
    public Good getGoodById(int id) {
        return goodMapper.queryGoodById(id);
    }

    @Override
    public List<Classify> getAllGroups() {
        return goodMapper.queryAllGroups();
    }

    @Override
    public void updateGood(Good good) {
        goodMapper.updateGood(good);
    }

    @Override
    public void delGood(Integer id) {
        goodMapper.deleteGood(id);
    }

    @Override
    public void addGood(Good good) {
        goodMapper.addGood(good);
    }

    @Override
    public List<Good> getGoodsBySale(int isSale) {
        return goodMapper.getAllGoodsBySale(isSale);
    }

    @Override
    public void updateSale(int id, int sale) {
        goodMapper.updateSale(id,sale);
    }
}
