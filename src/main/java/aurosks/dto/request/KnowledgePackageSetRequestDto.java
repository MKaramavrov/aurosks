package aurosks.dto.request;

import java.util.List;

public class KnowledgePackageSetRequestDto {
    private String title;
    private List<Long> knowledgePackageIdList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Long> getKnowledgePackageIdList() {
        return knowledgePackageIdList;
    }

    public void setKnowledgePackageIdList(List<Long> knowledgePackageIdList) {
        this.knowledgePackageIdList = knowledgePackageIdList;
    }
}
