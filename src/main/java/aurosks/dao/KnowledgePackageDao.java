package aurosks.dao;

import aurosks.model.KnowledgePackage;
import java.sql.ResultSet;
import java.util.List;

public interface KnowledgePackageDao {
    KnowledgePackage create(KnowledgePackage knowledgePackage);

    void delete(Long id);

    KnowledgePackage get(Long id);

    List<KnowledgePackage> getAll();

    KnowledgePackage parseKPacFromResultSet(ResultSet resultSet);
}
