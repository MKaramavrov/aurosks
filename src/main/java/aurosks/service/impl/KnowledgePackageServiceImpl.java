package aurosks.service.impl;

import aurosks.dao.KnowledgePackageDao;
import aurosks.model.KnowledgePackage;
import aurosks.service.KnowledgePackageService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class KnowledgePackageServiceImpl implements KnowledgePackageService {
    private final KnowledgePackageDao knowledgePackageDao;

    public KnowledgePackageServiceImpl(KnowledgePackageDao knowledgePackageDao) {
        this.knowledgePackageDao = knowledgePackageDao;
    }

    @Override
    public KnowledgePackage create(KnowledgePackage knowledgePackage) {
        return knowledgePackageDao.create(knowledgePackage);
    }

    @Override
    public void delete(Long id) {
        knowledgePackageDao.delete(id);

    }

    @Override
    public List<KnowledgePackage> getAll() {
        return knowledgePackageDao.getAll();
    }
}
