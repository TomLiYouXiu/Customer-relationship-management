package xyz.liyouxiu.crm.workbench.service;

import xyz.liyouxiu.crm.workbench.domian.ClueRemark;

import java.util.List;

/**
 * @author liyouxiu
 * @date 2022/11/2 14:54
 */
public interface ClueRemarkService {
    List<ClueRemark> queryClueRemarkForDetailByClueId(String clueId);
}
