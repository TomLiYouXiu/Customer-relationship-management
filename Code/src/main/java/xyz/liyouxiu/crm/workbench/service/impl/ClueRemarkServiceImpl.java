package xyz.liyouxiu.crm.workbench.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.liyouxiu.crm.workbench.domian.ClueRemark;
import xyz.liyouxiu.crm.workbench.mapper.ClueRemarkMapper;
import xyz.liyouxiu.crm.workbench.service.ClueRemarkService;

import java.util.List;

/**
 * @author liyouxiu
 * @date 2022/11/2 14:56
 */
@Service
public class ClueRemarkServiceImpl implements ClueRemarkService {
    @Autowired
    private ClueRemarkMapper clueRemarkMapper;
    @Override
    public List<ClueRemark> queryClueRemarkForDetailByClueId(String clueId) {
        return clueRemarkMapper.selectClueRemarkForDetailByClueId(clueId);
    }
}
