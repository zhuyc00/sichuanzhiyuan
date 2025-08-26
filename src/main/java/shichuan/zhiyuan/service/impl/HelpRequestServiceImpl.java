package shichuan.zhiyuan.service.impl;

import org.springframework.stereotype.Service;
import shichuan.zhiyuan.entity.query.HelpRequest;
import shichuan.zhiyuan.mappers.HelpRequestMapper;
import shichuan.zhiyuan.service.HelpRequestService;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class HelpRequestServiceImpl implements HelpRequestService {

    @Resource
    private HelpRequestMapper helpRequestMapper;

    @Override
    public void addHelpRequest(HelpRequest helpRequest) {
        helpRequestMapper.insert(helpRequest);
    }

    @Override
    public List<HelpRequest> listHelpRequests() {

        return helpRequestMapper.selectAll();
    }

    @Override
    public HelpRequest getHelpRequestById(Integer id) {
        return helpRequestMapper.selectById(id);
    }
}
