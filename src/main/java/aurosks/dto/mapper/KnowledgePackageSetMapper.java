package aurosks.dto.mapper;

import aurosks.dao.KnowledgePackageDao;
import aurosks.dto.request.KnowledgePackageSetRequestDto;
import aurosks.dto.responce.KnowledgePackageSetResponseDto;
import aurosks.model.KnowledgePackage;
import aurosks.model.KnowledgePackageSet;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class KnowledgePackageSetMapper {
    private final KnowledgePackageDao knowledgePackageDao;

    public KnowledgePackageSetMapper(KnowledgePackageDao knowledgePackageDao) {
        this.knowledgePackageDao = knowledgePackageDao;
    }

    public KnowledgePackageSetResponseDto toResponseDto(KnowledgePackageSet knowledgePackageSet) {
        KnowledgePackageSetResponseDto responseDto = new KnowledgePackageSetResponseDto();
        responseDto.setId(knowledgePackageSet.getId());
        responseDto.setTitle(knowledgePackageSet.getTitle());
        responseDto.setKnowledgePackageIdList(
                knowledgePackageSet.getKnowledgePackageList()
                        .stream()
                        .map(KnowledgePackage::getId)
                        .collect(Collectors.toList()));
        return responseDto;
    }

    public KnowledgePackageSet toModel(KnowledgePackageSetRequestDto requestDto) {
        KnowledgePackageSet knowledgePackageSet = new KnowledgePackageSet();
        knowledgePackageSet.setTitle(requestDto.getTitle());
        knowledgePackageSet.setKnowledgePackageList(requestDto.getKnowledgePackageIdList()
                .stream()
                .map(knowledgePackageDao::get).collect(Collectors.toList()));
        return knowledgePackageSet;
    }
}
