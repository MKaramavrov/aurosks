package aurosks.dao.impl;

import aurosks.dao.KnowledgePackageDao;
import aurosks.exception.DataProcessingException;
import aurosks.model.KnowledgePackage;
import aurosks.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class KnowledgePackageDaoImpl implements KnowledgePackageDao {
    @Override
    public KnowledgePackage create(KnowledgePackage knowledgePackage) {
        String query = "INSERT INTO knowledge_packages (title, description, date) VALUES(?, ?, ?)";
        try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement statement =
                         connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, knowledgePackage.getTitle());
            statement.setString(2, knowledgePackage.getDescription());
            statement.setString(3, knowledgePackage.getDate());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                knowledgePackage.setId(resultSet.getObject(1, Long.class));
            }
            return knowledgePackage;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't create K-PAC " + knowledgePackage, e);
        }
    }

    @Override
    public KnowledgePackage get(Long id) {
        String query = "SELECT title, description, date FROM knowledge_packages WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement statement = connection.prepareStatement(query)) {
            KnowledgePackage knowledgePackage = null;
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                knowledgePackage = parseKPacFromResultSet(resultSet);
            }
            return knowledgePackage;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get K-Pac by id " + id, e);
        }
    }

    @Override
    public void delete(Long id) {
        String query = "UPDATE knowledge_packages SET is_deleted = TRUE where id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete K-PAC by id " + id, e);
        }
    }

    @Override
    public List<KnowledgePackage> getAll() {
        String query = "SELECT * FROM knowledge_packages WHERE is_deleted = FALSE";
        List<KnowledgePackage> list = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(parseKPacFromResultSet(resultSet));
            }
            return list;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get all K-PACs", e);
        }
    }

    public KnowledgePackage parseKPacFromResultSet(ResultSet resultSet) {
        KnowledgePackage kpac = new KnowledgePackage();
        try {
            Long id = resultSet.getObject("id", Long.class);
            String title = resultSet.getString("title");
            String description = resultSet.getString("description");
            String date = resultSet.getString("date");
            kpac.setId(id);
            kpac.setTitle(title);
            kpac.setDescription(description);
            kpac.setDate(date);
        } catch (SQLException e) {
            throw new DataProcessingException("Can't parse K-Pac from result set " + resultSet, e);
        }
        return kpac;
    }
}
