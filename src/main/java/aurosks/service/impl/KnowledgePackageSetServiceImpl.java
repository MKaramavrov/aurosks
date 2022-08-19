package aurosks.service.impl;

import aurosks.dao.KnowledgePackageSetDao;
import aurosks.model.KnowledgePackage;
import aurosks.model.KnowledgePackageSet;
import aurosks.service.KnowledgePackageSetService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class KnowledgePackageSetServiceImpl implements KnowledgePackageSetService {
    private final KnowledgePackageSetDao knowledgePackageSetDao;

    public KnowledgePackageSetServiceImpl(KnowledgePackageSetDao knowledgePackageSetDao) {
        this.knowledgePackageSetDao = knowledgePackageSetDao;
    }

    @Override
    public KnowledgePackageSet create(KnowledgePackageSet knowledgePackageSet) {
        return knowledgePackageSetDao.create(knowledgePackageSet);
    }

    @Override
    public void delete(Long id) {
        knowledgePackageSetDao.delete(id);
    }

    @Override
    public List<KnowledgePackageSet> getAll() {
        return knowledgePackageSetDao.getAll();
    }

    @Override
    public List<KnowledgePackage> getAllKPacsByKPacSetId(Long id) {
        return knowledgePackageSetDao.getAllKPacsByKPacSetId(id);
    }
}
