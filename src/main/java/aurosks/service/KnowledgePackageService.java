package aurosks.service;

import aurosks.model.KnowledgePackage;
import java.util.List;

public interface KnowledgePackageService {
    KnowledgePackage create(KnowledgePackage knowledgePackage);

    void delete(Long id);

    List<KnowledgePackage> getAll();
}
