package aurosks.dto.responce;

import java.util.List;

public class KnowledgePackageSetResponseDto {
    private Long id;
    private String title;
    private List<Long> knowledgePackageIdList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
