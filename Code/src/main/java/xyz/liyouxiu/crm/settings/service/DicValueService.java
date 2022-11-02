package xyz.liyouxiu.crm.settings.service;

import xyz.liyouxiu.crm.settings.domian.DicValue;

import java.util.List;

/**
 * @author liyouxiu
 * @date 2022/11/2 10:14
 */
public interface DicValueService {
    List<DicValue> queryDicValueByTypeCode(String typeCode);
}
