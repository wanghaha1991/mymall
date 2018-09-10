package cn.study.service.impl;

import cn.study.mapper.ClassifyMapper;
import cn.study.pojo.Classify;
import cn.study.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author asus
 * @date 2018/9/6 9:24
 */
@Service
public class ClassifyServiceImpl implements ClassifyService {
    @Autowired
    private ClassifyMapper classifyMapper;
    @Override
    public List<Classify> getAll() {
        return classifyMapper.getAllClassifies();
    }

    @Override
    public Classify getClassifyById(int id) {
        return classifyMapper.queryClassifyByid(id);
    }

    @Override
    public List<Classify> getRoot(int parentId) {
        return classifyMapper.getRoot(parentId);
    }

    @Override
    public List<Classify> getChildren(int parentId) {
        return classifyMapper.getChildren(parentId);
    }

    @Override
    public void updateClassify(Classify classify) {
        classifyMapper.updateClassify(classify);
    }

    @Override
    public void addClassify(Classify classify) {
        classifyMapper.addClassify(classify);
    }

    @Override
    public void delClassify(int id) {
        classifyMapper.del(id);
    }
}
