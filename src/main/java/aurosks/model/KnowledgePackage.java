package aurosks.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class KnowledgePackage {
    private Long id;
    private String title;
    private String description;
    private String date;

    public KnowledgePackage() {
        date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
