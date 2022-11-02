package xyz.liyouxiu.crm.settings.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.liyouxiu.crm.settings.domian.DicValue;
import xyz.liyouxiu.crm.settings.mapper.DicValueMapper;
import xyz.liyouxiu.crm.settings.service.DicValueService;

import java.util.List;

/**
 * @author liyouxiu
 * @date 2022/11/2 10:15
 */
@Service
public class DicValueServiceImpl implements DicValueService {
    @Autowired
    private DicValueMapper dicValueMapper;
    @Override
    public List<DicValue> queryDicValueByTypeCode(String typeCode) {
        return dicValueMapper.selectDicValueByTypeCode(typeCode);
    }
}
