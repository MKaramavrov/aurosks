package aurosks.dao.impl;

import aurosks.dao.KnowledgePackageDao;
import aurosks.dao.KnowledgePackageSetDao;
import aurosks.exception.DataProcessingException;
import aurosks.model.KnowledgePackage;
import aurosks.model.KnowledgePackageSet;
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
public class KnowledgePackageSetDaoImpl implements KnowledgePackageSetDao {
    private final KnowledgePackageDao knowledgePackageDao;

    public KnowledgePackageSetDaoImpl(KnowledgePackageDao knowledgePackageDao) {
        this.knowledgePackageDao = knowledgePackageDao;
    }

    @Override
    public KnowledgePackageSet create(KnowledgePackageSet knowledgePackageSet) {
        String query = "INSERT INTO knowledge_package_sets (title) VALUES(?)";
        try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement statement =
                         connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, knowledgePackageSet.getTitle());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                knowledgePackageSet.setId(resultSet.getObject(1, Long.class));
            }
            return knowledgePackageSet;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't create K-PAC set " + knowledgePackageSet, e);
        }
    }

    @Override
    public void delete(Long id) {
        String query = "UPDATE knowledge_package_sets SET is_deleted = TRUE where id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete K-PAC set by id " + id, e);
        }

    }

    @Override
    public List<KnowledgePackageSet> getAll() {
        String query = "SELECT * FROM knowledge_package_sets WHERE is_deleted = FALSE";
        List<KnowledgePackageSet> list = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                list.add(parseKPacSetByResultSet(resultSet));
            }
            return list;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get all K-PAC sets", e);
        }
    }

    @Override
    public List<KnowledgePackage> getAllKPacsByKPacSetId(Long id) {
        List<KnowledgePackage> knowledgePackageList = new ArrayList<>();
        String query = "SELECT kp.id, kp.title, kp.description, kp.date "
                + "FROM kpacs_kpacsets kk "
                + "JOIN knowledge_packages kp ON kk.knowledge_package_id = kp.id "
                + "WHERE knowledge_package_set_id = ? AND is_deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                knowledgePackageList.add(knowledgePackageDao.parseKPacFromResultSet(resultSet));
            }
            return knowledgePackageList;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get all K-PACs by id " + id, e);
        }
    }

    private KnowledgePackageSet parseKPacSetByResultSet(ResultSet resultSet) throws SQLException {
        KnowledgePackageSet packageSet = new KnowledgePackageSet();
        packageSet.setId(resultSet.getLong("id"));
        packageSet.setTitle(resultSet.getString("title"));
        return packageSet;
    }
}
