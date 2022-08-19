package aurosks.dto.mapper;

import aurosks.dto.request.KnowledgePackageRequestDto;
import aurosks.dto.responce.KnowledgePackageResponseDto;
import aurosks.model.KnowledgePackage;
import org.springframework.stereotype.Component;

@Component
public class KnowledgePackageMapper {
    public KnowledgePackageResponseDto toResponseDto(KnowledgePackage knowledgePackage) {
        KnowledgePackageResponseDto responseDto = new KnowledgePackageResponseDto();
        responseDto.setDate(knowledgePackage.getDate());
        responseDto.setTitle(knowledgePackage.getTitle());
        responseDto.setDescription(knowledgePackage.getDescription());
        responseDto.setId(knowledgePackage.getId());
        return responseDto;
    }

    public KnowledgePackage toModel(KnowledgePackageRequestDto requestDto) {
        KnowledgePackage knowledgePackage = new KnowledgePackage();
        knowledgePackage.setTitle(requestDto.getTitle());
        knowledgePackage.setDescription(requestDto.getDescription());
        knowledgePackage.setDate(requestDto.getDate());
        return knowledgePackage;
    }
}
