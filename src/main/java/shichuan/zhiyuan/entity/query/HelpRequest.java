package shichuan.zhiyuan.entity.query;

import java.time.LocalDateTime;

public class HelpRequest {

    private Integer id;               // 求助信息ID
    private String title;             // 求助标题
    private String description;       // 求助详情
    private LocalDateTime createTime; // 发布时间
    private Integer userId;           // 发布用户ID

    // 无参构造
    public HelpRequest() {
    }

    // 全参构造
    public HelpRequest(Integer id, String title, String description, Integer userId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createTime = LocalDateTime.now();
        this.userId = userId;
    }

    // Getter 和 Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
