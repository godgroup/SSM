package net.ssm.system.web.pojo.common;

/**
 * author yalunwnag
 * 统一的搜索model
 */
public class SearchVo {
    private Integer PageNo;
    private Integer PageSize;

    public Integer getPageNo() {
        if(PageNo==null){
            this.PageNo=1;
        }
        return PageNo;
    }

    public void setPageNo(Integer pageNo) {
        PageNo = pageNo;
    }

    public Integer getPageSize() {
        if(PageSize==null){
            this.PageSize=10;
        }
        return PageSize;
    }

    public void setPageSize(Integer pageSize) {
        PageSize = pageSize;
    }

    public String getKeyWords() {
        return KeyWords;
    }

    public void setKeyWords(String keyWords) {
        KeyWords = keyWords;
    }

    private String KeyWords;
}
