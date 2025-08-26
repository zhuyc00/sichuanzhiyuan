package shichuan.zhiyuan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shichuan.zhiyuan.entity.vo.ResponseVO;
import shichuan.zhiyuan.service.HelpRequestService;
import shichuan.zhiyuan.entity.query.HelpRequest;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/help")
public class HelpRequestController extends ABaseController{

    @Resource
    private HelpRequestService helpRequestService;

    // 发布求助信息
    @PostMapping("/add")
    public ResponseVO addHelpRequest(@RequestBody HelpRequest helpRequest) {
        helpRequestService.addHelpRequest(helpRequest);
        return getSuccessResponseVO("发布成功");
    }

    // 查看所有求助信息
    @GetMapping("/list")
    public ResponseVO listHelpRequests() {
        List<HelpRequest> list = helpRequestService.listHelpRequests();
        return getSuccessResponseVO(list);
    }

    // 根据ID查看单条求助信息
    @GetMapping("/{id}")
    public ResponseVO getHelpRequest(@PathVariable Integer id) {
        HelpRequest helpRequest = helpRequestService.getHelpRequestById(id);
        if (helpRequest != null) {
            return getSuccessResponseVO(helpRequest);
        }

        return getSuccessResponseVO("查看求助信息失败");
    }
}
