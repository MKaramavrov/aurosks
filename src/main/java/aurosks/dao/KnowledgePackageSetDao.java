package aurosks.dao;

import aurosks.model.KnowledgePackage;
import aurosks.model.KnowledgePackageSet;
import java.util.List;

public interface KnowledgePackageSetDao {
    KnowledgePackageSet create(KnowledgePackageSet knowledgePackageSet);

    void delete(Long id);

    List<KnowledgePackageSet> getAll();

    List<KnowledgePackage> getAllKPacsByKPacSetId(Long id);
}
