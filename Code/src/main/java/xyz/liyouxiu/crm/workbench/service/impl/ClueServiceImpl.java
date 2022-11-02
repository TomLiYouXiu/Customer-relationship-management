package xyz.liyouxiu.crm.workbench.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.liyouxiu.crm.workbench.domian.Clue;
import xyz.liyouxiu.crm.workbench.mapper.ClueMapper;
import xyz.liyouxiu.crm.workbench.service.ClueService;

/**
 * @author liyouxiu
 * @date 2022/10/26 10:51
 */
@Service("clueService")
public class ClueServiceImpl implements ClueService {
    @Autowired
    ClueMapper clueMapper;
    @Override
    public int saveCreateClue(Clue Clue) {
        return clueMapper.insertClue(Clue);
    }

    @Override
    public Clue queryClueForDetailById(String id) {
        return clueMapper.selectClueForDetailById(id);
    }
}
