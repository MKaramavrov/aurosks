package aurosks.model;

import java.util.List;

public class KnowledgePackageSet {
    private Long id;
    private String title;
    private List<KnowledgePackage> knowledgePackageList;

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

    public List<KnowledgePackage> getKnowledgePackageList() {
        return knowledgePackageList;
    }

    public void setKnowledgePackageList(List<KnowledgePackage> knowledgePackageList) {
        this.knowledgePackageList = knowledgePackageList;
    }
}
