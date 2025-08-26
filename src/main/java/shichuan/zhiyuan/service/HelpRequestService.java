
package shichuan.zhiyuan.service;
import shichuan.zhiyuan.entity.query.HelpRequest;

import java.util.List;

public interface HelpRequestService {
    void addHelpRequest(HelpRequest helpRequest);             // 发布求助
    List<HelpRequest> listHelpRequests();                     // 查询求助列表
    HelpRequest getHelpRequestById(Integer id);               // 根据ID查询
}
